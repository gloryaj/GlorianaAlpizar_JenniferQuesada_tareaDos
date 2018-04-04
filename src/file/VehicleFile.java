package file;

import domain.vehicle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.imageio.IIOException;

public class VehicleFile {

    public RandomAccessFile randomAccessFile;
    private int regsQuantity; //cantidad de registros que tiene mi archivo
    private int regSize; //Tama;o en bytes de mis registros
    private String myFilePath; //Ruta del archivoden

    //constructor
    public VehicleFile(File file) throws IIOException, FileNotFoundException, IOException {
        //guardar la ruta del archivo
        this.myFilePath = file.getPath();

        //tama;o maximo de cada registro en el archivo
        this.regSize = 53;//sale del programador yo decido de que tama;o

        //una validacion basica de file
        if (file.exists() && !file.isFile()) {
            throw new IIOException(file.getName() + "is an invalid file");
        } else {
            //crear una nueva instancia de RAF
            randomAccessFile = new RandomAccessFile(file, "rw");
            //necesitamos indicar cuantos registros tiene el archivo
            this.regsQuantity = (int) Math.ceil((double) randomAccessFile.length() / (double) this.regSize);
        }
    }//end method

    //metodo para insertar un vehiculo en una posicion especifica
    public boolean putValue(int position, vehicle vehicleToInsert) throws IOException {
        //vamos hacer una peque;a va;idacion de position
        if (position >= 0 && position <= this.regsQuantity) {
            //verificar el tama;o sea el adecuado
            if (vehicleToInsert.sizeIntBytes() > this.regSize) {
                System.err.println("1002-records size is too large");
                return false;
            } else {
                //escribir archivo
                randomAccessFile.seek(position * this.regSize);//seek es el brazo
                randomAccessFile.writeUTF(vehicleToInsert.getName());
                randomAccessFile.writeInt((int) vehicleToInsert.getMileage());
                randomAccessFile.writeInt((int) vehicleToInsert.getSeries());
                randomAccessFile.writeBoolean(vehicleToInsert.isAmerican());
                randomAccessFile.writeFloat(vehicleToInsert.getMileage());
                return true;
            }
        } else {
            System.err.println("1001-position is out bounds"); //codigo para saber cual error es exactamente
            return false;
        }
    }//end method

//metodo para insertar al final del archivo
    public boolean addEndRecord(vehicle vehicle) throws IOException {
        boolean success = putValue(this.regsQuantity, vehicle);
        if (success) {
            ++this.regsQuantity;
        }
        return success;
    }

    public vehicle getVehicle(int position) throws IOException {
        //validar position
        if (position >= 0 && position <= this.regsQuantity) {
            //colocar el brazo en el lugar adecuado
            randomAccessFile.seek(position * this.regSize);
            //leer
            vehicle vehicleTemp = new vehicle();
            vehicleTemp.setName(randomAccessFile.readUTF());
            vehicleTemp.setYear(randomAccessFile.readInt());
            vehicleTemp.setAmerican(randomAccessFile.readBoolean());
            vehicleTemp.setSeries(randomAccessFile.readInt());
            vehicleTemp.setMileage(randomAccessFile.readFloat());

            if (vehicleTemp.getSeries()== -1) {
                return null;
            } else {
                return vehicleTemp;
            }
        } else {
            System.err.println("1003-position is out bounds");
            return null;
        }
    }//end method

    //metodo para retornar todos los vehiculos que estan dentro del archivo
    public ArrayList<vehicle> getVehicle() throws IOException {

        //crear una instancia de una array list
        ArrayList<vehicle> arrayListOfStudents = new ArrayList<>();

        //recorrer el arreglo para insertar en la lista
        for (int i = 0; i < this.regsQuantity; i++) {
            vehicle vehicleTemp = this.getVehicle(i);

            //insertar ese vehiculo en la lista
            if (vehicleTemp != null) {
                arrayListOfStudents.add(vehicleTemp);
            }
        }
        return arrayListOfStudents;
    }

//                vehicleTemp.setName("delete"); 
    public boolean deleteVehicleSeries(int serie) throws IOException {
        vehicle vehicleTemp;
        for (int i = 0; i < this.regsQuantity; i++) {
            vehicleTemp = getVehicle(i);
            if (vehicleTemp.getSeries() == serie) {
                vehicleTemp.setSeries(-1);
                return this.putValue(i, vehicleTemp);
            }
        }
        return false;
    }
     public boolean updateVehicleSeries(int serie) throws IOException {
        vehicle vehicleTemp;
        for (int i = 0; i < this.regsQuantity; i++) {
            vehicleTemp = getVehicle(i);
            if (vehicleTemp.getSeries() == serie) {
                return true;
            }
        }
        return false;
    }
    //          public boolean verify(String id) throws IOException {
//        Student studentTemp;
//        for (int i = 0; i < this.regsQuantity; i++) {
//            studentTemp = this.getStudent(i);
//            if (studentTemp.getId().equals(id)) {
//                return true;
//            }
//        }
//        return false;
//    }
}

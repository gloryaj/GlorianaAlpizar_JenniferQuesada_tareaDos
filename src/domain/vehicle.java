package domain;

public class vehicle {
    
    private String name;
    private int year;
    private float mileage;
    private boolean american;
    private int series;

    public vehicle(String name, int year, float mileage, boolean american, int series) {
        this.name = name;
        this.year = year;
        this.mileage = mileage;
        this.american = american;
        this.series = series;
    }

    public vehicle() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the ano
     */
    public int getYear() {
        return year;
    }

    /**
     * @param ano the ano to set
     */
    public void setYear(int ano) {
        this.year = ano;
    }

    /**
     * @return the mileje
     */
    public float getMileage() {
        return mileage;
    }

    /**
     * @param mileage the mileje to set
     */
    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    /**
     * @return the american
     */
    public boolean isAmerican() {
        return american;
    }

    /**
     * @param american the american to set
     */
    public void setAmerican(boolean american) {
        this.american = american;
    }

    /**
     * @return the series
     */
    public int getSeries() {
        return series;
    }

    /**
     * @param series the series to set
     */
    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "vehicle{" + "name=" + name + ", year=" + year + ", mileage=" + mileage + ", american=" + american + ", series=" + series + '}';
    }

    //metodo para indicar el tama;o en bits de los atributos 
    public int sizeIntBytes(){
      //retornar la suma de todos los atributos
      
      return 4 + this.getName().length()*2 + 4+ 4 + 1;
                     //cuantos bytes para un string? 2 por cada caracter
    }
}

package Models;
public class Car{
    private String name = null; //Поле может быть null
    private boolean cool;

    public Car (String name, boolean cool){
        this.name = name;
        this.cool = cool;
    }
    public Car (boolean cool){
        this(null, cool);
    }
    @Override 
    public boolean equals(Object o){
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (o.getClass() != getClass())
            return false;
        Car e = (Car) o;
        return (e.cool == cool && e.name == name);
    }
    @Override 
    public String toString(){
        return String.format("\t name = %s, cool = %s;", 
                        this.name, this.cool);
    }
}
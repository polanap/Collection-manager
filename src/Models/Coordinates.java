package Models;
public class Coordinates {
    private Double x; //Значение поля должно быть больше -781, Поле не может быть null
    private float y;

    public Coordinates(Double x, float y){
        this.x = x;
        this.y = y;
    }

    /**
   * Проверяет поля на правильность.
   * @return true, если все верно, иначе false
   */
  
   public boolean validate() {
    if (x == null || x <= -781) return false;
    return true;
    }

    @Override 
    public String toString(){
        return String.format("\t x = %s, y = %s;", 
                        this.x, this.y);
    }
}
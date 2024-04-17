package Models;
import java.time.LocalDateTime;

public class HumanBeing implements Comparable<HumanBeing>{
    private static int nextId = 1;
    
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private boolean realHero;
    private boolean hasToothpick;
    private double impactSpeed;
    private long minutesOfWaiting;
    private WeaponType weaponType; //Поле не может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле не может быть null

    public HumanBeing (String name, Coordinates coordinates, boolean realHero, boolean hasToothpick, 
            double impactSpeed, long minutesOfWaiting, WeaponType weaponType, Mood mood, Car car){
        this.id = nextId++; 
        this.creationDate = LocalDateTime.now();
        this.name = name;
        this.coordinates = coordinates;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick; 
        this.impactSpeed = impactSpeed;
        this.minutesOfWaiting = minutesOfWaiting;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }

    /**
   * Проверяет поля на правильность.
   * @return true, если все верно, иначе false
   */
  
    public boolean validate() {
        if (id == null || id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null) return false;
        if (creationDate == null) return false;
        if (weaponType == null) return false;
        if (mood == null) return false;
        if (car == null) return false;
        return true;
        
    }

    static public void setNextId(int x){
        nextId = x;
    }
    static public int getNextId(){
        return nextId;
    }

    public Integer getId(){ return this.id; }
    public String getName(){ return this.name; }
    public Coordinates getCoordinates(){ return this.coordinates; }
    public LocalDateTime getCreationDate(){ return this.creationDate; }
    public boolean getRealHero(){ return this.realHero; }
    public boolean getHasToothpick(){ return this.hasToothpick; }
    public double getImpactSpeed(){ return this.impactSpeed; }
    public long getMinutesOfWaiting(){ return this.minutesOfWaiting; }
    public WeaponType getWeaponType(){ return this.weaponType; }
    public Mood getMood(){ return this.mood; }
    public Car getCar(){return this.car;}

    @Override
    public int compareTo(HumanBeing hb) {
        return this.name.compareTo(hb.name);
    }

    @Override 
    public String toString(){
        return String.format("\t id = %s;\n" + // 
                            "\t creation date = %s;\n" + //
                            "\t name = %s;\n" + //
                            "\t coordinates:\n" + //
                            "\t %s;" + //
                            "\t real hero = %s;\n" + //
                            "\t has toothpick = %s;\n" + //
                            "\t impact speed = %s;\n" + //
                            "\t minutes of waiting = %s;\n" + //
                            "\t weapon type = %s;\n" + //
                            "\t mood = %s;\n" + //
                            "\t car: \n" + //
                            "\t %s.", 
                        this.id,
                        this.creationDate,
                        this.name,
                        this.coordinates.toString(),
                        this.realHero,
                        this.hasToothpick,
                        this.impactSpeed,
                        this.minutesOfWaiting,
                        this.weaponType,
                        this.mood,
                        this.car.toString());
    }

}


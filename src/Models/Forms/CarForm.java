package Models.Forms;

import Consoles.Console;
import Models.Car;

/**
 * Класс, отвечающий за интерактивное создание объекста класса Car
 */
public class CarForm extends Form<Car>{

    public CarForm(Console console){
        super(console);
    }

    @Override
    public Car build(){
        console.print("Создание нового объекта класса Car...");
        Car car = new Car(
            askString("name", "", x -> true),
            askBoolean("cool", "Поле принимает значения true/false", x -> x.equals("true") || x.equals("false"))
        );
        console.print("Объект класса Car успешно создан");
        return car;
    }

}


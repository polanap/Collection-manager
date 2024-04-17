package Models.Forms;

import java.util.Objects;

import Consoles.Console;
import Models.Coordinates;


/**
 * Класс, отвечающий за интерактивное создание объекста класса Coordinates
 */
public class CoordinatesForm extends Form<Coordinates>{

    public CoordinatesForm(Console console){
        super(console);
    }

    @Override
    public Coordinates build(){
        console.print("Создание нового объекта класса Coordinates...");
        Coordinates coord = new Coordinates(
            askDouble("x", "Значение поля должно быть больше -781, Поле не может быть null", x -> (x > -781 && x != null)),
            askFloat("y", "", Objects::nonNull));
        console.print("Объект класса Coordinates успешно создан");
        return coord;
    }

}

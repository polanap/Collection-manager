package Models.Forms;
import java.util.Objects;
import Consoles.Console;
import Models.HumanBeing;
import Models.Mood;
import Models.WeaponType;

/**
 * Класс, отвечающий за интерактивное создание объекста класса HumanBeing
 */
public class HumanBeingForm extends Form<HumanBeing>{

    public HumanBeingForm(Console console){
        super(console);
    }

    @Override
    public HumanBeing build(){
        return new HumanBeing(
            askString("name", "Поле не может быть null, Строка не может быть пустой", x -> x!=null && !x.isEmpty()),
            new CoordinatesForm(console).build(), 
            askBoolean("realHero", "Поле принимает значения true/false", x -> x.equals("true") || x.equals("false")).booleanValue(), 
            askBoolean("hasToothpick", "Поле принимает значения true/false", x -> x.equals("true") || x.equals("false")).booleanValue(), 
            askDouble ("impactSpeed", "", Objects::nonNull).doubleValue(), 
            askLong("minutesOfWaiting", "", Objects::nonNull).longValue(), 
            (WeaponType)askEnum(WeaponType.values(), "weaponType"),
            (Mood)askEnum(Mood.values(), "mood"),
            new CarForm(console).build());
    }
}



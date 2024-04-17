package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;
import Models.Car;
import Models.Forms.CarForm;

  /**
 * Команда count_by_car, выводит количество элементов, значение поля car которых равно заданному
 */

public class CountByCarCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public CountByCarCommand(Console console, CollectionManager collectionManager){
        super("count_by_car", "вывести количество элементов, значение поля car которых равно заданному");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    
    @Override
    public void execute(String[] args){
        if (args.length!=1){
            console.printError("Команда не требует аргументов в этой строке!");
            return;
        }
        Car car = new CarForm(console).build();
        double counter = 0;
        for(Integer key : collectionManager.getCollection().keySet()){
            if (collectionManager.getCollection().get(key).getCar().equals(car)){
                counter += 1;
            }
        }
        console.print(counter);
        return;
    }
}
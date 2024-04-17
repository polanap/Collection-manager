package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;
import Models.HumanBeing;
import Models.Forms.HumanBeingForm;

  /**
 * Команда remove_lower, удаляет из коллекции все 
 * элементы, меньшие, чем заданный
 */
public class RemoveLowerCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public RemoveLowerCommand(Console console, CollectionManager collectionManager){
        super("remove_lower", "удалить из коллекции все элементы, меньшие, чем заданный: > remove_lower {element}");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        if (args.length!=1){
            console.printError("Команда не требует аргументов в этой строке!");
            return;
        }
        console.print("Создание элемента класса Human Being...");
        HumanBeing hb = new HumanBeingForm(console).build();
        console.print("Удаление элементов коллекции, меньших, чем заданный...");
        int counter = 0;
        for(Integer key : collectionManager.getCollection().keySet()){
            if (collectionManager.getCollection().get(key).compareTo(hb) < 0){
                collectionManager.removeKey(key);
                counter++;
                console.print(String.format("Элемент с id = %s успешно удален", collectionManager.getCollection().get(key).getId()));
            }
        }
        if (counter>0) console.print("Все элементы коллекции, меньшие, чем заданный удалены.");
        else console.print("В коллекции нет элементов, меньших, чем заданный");
        return;
    }
}
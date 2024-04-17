package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;

  /**
 * Команда remove_lower_key удаляет из коллекции все элементы, 
 * ключ которых меньше, чем заданный
 */
public class RemoveLowerKeyCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public RemoveLowerKeyCommand(Console console, CollectionManager collectionManager){
        super("remove_lower_key", "Удалить из коллекции все элементы, ключ которых меньше, чем заданный: > remove_lower_key null");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        if (args.length!=2){
            console.printError("Команда требует 1 аргумент -- значение ключа элемента!");
            return;
        }
        Integer arg;
        try{
            arg = Integer.parseInt(args[1]);
        }catch(NumberFormatException e){
            console.printError("Значение аргумента должно быть тиипа Integer!");
            return;
        }
        console.print("Удаление элементов коллекции с ключом, меньшим, чем заданный...");
        int counter = 0;
        for(Integer key : collectionManager.getCollection().keySet()){
            if (key < arg){
                collectionManager.removeKey(key);
                counter++;
                console.print(String.format("Элемент с id = %s успешно удален", collectionManager.getCollection().get(key).getId()));
            }
        }
        if (counter>0) console.print("Все элементы коллекции с ключом, меньшим, чем заданный удалены.");
        else console.print("В коллекции нет элементов с ключом, меньшим, чем заданный");
        return;
    }
}
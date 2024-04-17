package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;


  /**
 * Команда remove_key, удаляет элемент из коллекции по его ключу
 */
public class RemoveKeyCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public RemoveKeyCommand(Console console, CollectionManager collectionManager){
        super("remove_key", "удалить элемент из коллекции по его ключу: > remove_key id");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        if (args.length!=2){
            console.printError("команда требует 1 аргумент -- значение ключа элемента");
            return;
        }
        Integer arg;
        try{
            arg = Integer.parseInt(args[1]);
        }catch(NumberFormatException e){
            console.printError("Значение аргумента должно быть типа Integer!");
            return;
        }
        if (!collectionManager.getKeys().contains(arg)){
            console.printError("Элемента с таким ключом нет в коллекции");
            return;
        }
        collectionManager.removeKey(arg);
        console.print(String.format("Элемент с ключом '%s' успешно удален!", args[1] ));
        return;
    }
}

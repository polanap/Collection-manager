package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;

  /**
   * Команда show, выводит в стандартный поток вывода 
   * все элементы коллекции в строковом представлении
 */
public class ShowCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public ShowCommand(Console console, CollectionManager collectionManager){
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        if (args.length!=1){
            console.printError("команде не требуются аргументы");
            return;
        }
        if (collectionManager.getCollection().isEmpty()){
            console.print("Коллекция пуста");
        }
        else{
            for(Integer i : collectionManager.getCollection().keySet()){
                console.print(String.format("key: %s", i));
                console.print(collectionManager.getCollection().get(i).toString());
            }
        }
        return;

    }
    
}

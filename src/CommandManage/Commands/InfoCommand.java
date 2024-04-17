package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;

  /**
 * Команда info, выводитв стандартный поток вывода информацию о коллекции
 */
public class InfoCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public InfoCommand(Console console, CollectionManager collectionManager){
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        if (args.length!=1){
            console.printError("команде не требуются аргументы");
            return;
        }
        
        console.print(collectionManager.getInfo());

        return;

    }
}

package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;

/**
 * Команда clear, очищает коллекцию
 */

public class ClearCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public ClearCommand(Console console, CollectionManager collectionManager){
        super("clear", "очистить коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    
    @Override
    public void execute(String[] args){
        if (args.length!=1){
            console.printError("команда не требует аргументы!");
            return;
        }
        collectionManager.clearCollection();
        console.print("Коллекция была успешно очищена");
        return;
    }
}

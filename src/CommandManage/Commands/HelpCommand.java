package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CommandManager;

  /**
 * Команда help, выводит справку по доступным командам
 */
public class HelpCommand extends Command{
    private Console console;
    private CommandManager commandManager;

    public HelpCommand(Console console, CommandManager commandManager){
        super("help", "вывести справку по доступным командам");
        this.console = console;
        this.commandManager=  commandManager;
    }
    @Override
    public void execute(String[] args){
        if (args.length!=1){
            console.printError("команде не требуются аргументы");
            return;
        }
        for(Command command : commandManager.getCommands().values()){
            console.print(command.toString());
        }
        return;

    }
}

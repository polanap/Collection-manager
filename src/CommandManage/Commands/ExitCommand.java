package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
  /**
 * Команда exit, завершает программу без сохранения в файл
 */
public class ExitCommand extends Command {
    private Console console;

    public ExitCommand(Console console){
        super("exit", "завершить программу (без сохранения в файл)");
        this.console = console;
    }
    @Override
    public void execute(String[] args){
        if (args.length!=1){
            console.printError("команде не требуются аргументы");
            return;
        }
        console.print("Выход...");
        System.exit(0);
        return;

    }
}

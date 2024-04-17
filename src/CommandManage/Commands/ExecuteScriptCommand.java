package CommandManage.Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import CommandManage.Command;

import java.lang.SecurityException;
import Consoles.Console;
import Consoles.FileConsole;
import Exeptions.RecursionFoundExeption;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.FileManager;
import Managers.RuntimeManager;

  /**
 * Команда execute_script, считывает и исполняет скрипт из указанного файла
 */
public class ExecuteScriptCommand extends Command {

    private Console console;
    private CollectionManager collectionManager;
    private CommandManager commandManager;
    private FileManager fileManager;
    /**
     * Переменная, хранящая стек вызовов комманды execute_script
     */
    ArrayList<String> callStack;

    public ExecuteScriptCommand(CollectionManager collectionManager, CommandManager commandManager, Console console, FileManager fileManager, ArrayList<String> callStack){
        super("execute_script", "считать и исполнить скрипт из указанного файла. В скрипте содержатся" +//
                        "команды в таком же виде, в котором их вводит пользователь в интерактивном режиме: > execute_script file_name ");
        this.commandManager = commandManager;
        this.collectionManager = collectionManager;
        this.console = console;
        this.fileManager = fileManager;
        this.callStack = callStack;
    }
    @Override
    public void execute (String[] args){
        if (args.length < 2){
            console.printError("команда использует 1 аргумент -- имя исполняемого файла");
            return;
        }
        try{
        String path = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
        File file = new File(path);
        if(!file.canRead() && file.exists()) throw new SecurityException();
        this.console = new FileConsole(file);
        if (callStack.contains(file.getAbsolutePath())) throw new RecursionFoundExeption();
        console.print("Идет выполнение инструкций из файла...");
        callStack.add(file.getAbsolutePath());
        RuntimeManager rm = new RuntimeManager(collectionManager, commandManager, console, fileManager, callStack);
        rm.fileMode(file);
        console.print(String.format("инструкции из файла %s успешно выполнены", path));
        return;
        }
        catch(FileNotFoundException e){
            console.printError("файл не найден");
            return;
        }
        catch (SecurityException e){
            console.printError("Отсутствуют права доступа к файлу");
            return;
        }
        catch (RecursionFoundExeption e){
            console.printError(e.getMessage());
        }

    }
}

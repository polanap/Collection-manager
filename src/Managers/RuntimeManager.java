package Managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import CommandManage.Commands.ClearCommand;
import CommandManage.Commands.CountByCarCommand;
import CommandManage.Commands.CountLessThanImpactSpeedCommand;
import CommandManage.Commands.ExecuteScriptCommand;
import CommandManage.Commands.ExitCommand;
import CommandManage.Commands.HelpCommand;
import CommandManage.Commands.InfoCommand;
import CommandManage.Commands.InsertCommand;
import CommandManage.Commands.RemoveKeyCommand;
import CommandManage.Commands.RemoveLowerCommand;
import CommandManage.Commands.RemoveLowerKeyCommand;
import CommandManage.Commands.ReplaceIfLowerCommand;
import CommandManage.Commands.SaveCommand;
import CommandManage.Commands.ShowCommand;
import CommandManage.Commands.SumOfImpactSpeedCommand;
import CommandManage.Commands.UpdateCommand;
import Consoles.Console;
import Consoles.FileConsole;

/**
 * Класс, отвечающий за процесс исполнения команд
 */
public class RuntimeManager {
    private CollectionManager collectionManager;
    private CommandManager commandManager;
    private Console console;
    private FileManager fileManager;

    /**
     * Переменная, хранящая стек вызовов комманды execute_script
     */
    ArrayList<String> callStack;

    public RuntimeManager(CollectionManager collectionManager, CommandManager commandManager, Console console, FileManager fileManager){
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
        this.console = console;
        this.fileManager = fileManager;
        this.callStack = new ArrayList<String>();
    }

    public RuntimeManager(CollectionManager collectionManager, CommandManager commandManager, Console console, FileManager fileManager, ArrayList<String> callStack){
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
        this.console = console;
        this.fileManager = fileManager;
        this.callStack = callStack;
    }

    /**
     * Исполнение команд в интеративном режиме
     */
    public void interactiveMode(){
        this.setCommands(collectionManager, commandManager, console, fileManager, callStack);
        while(true){
            console.invitationLine();
            String[] nextCommand = console.read().trim().split(" ");
            try
            {
                commandManager.getCommands().get(nextCommand[0]).execute(nextCommand);
            }
            catch(NullPointerException ex)
            {
                console.printError("Команда не найдена!");
            }
        }
    }
    /**
     * Исполнение команд из файла
     * @param file исполняемый файл
     * @throws FileNotFoundException выбрасывается, когда исполняемый файл не найден
     */
    public void fileMode(File file) throws FileNotFoundException{
        FileConsole fconsole = new FileConsole(file);
        this.setCommands(collectionManager, commandManager, fconsole, fileManager, callStack);
        while(fconsole.checkNext()){
            fconsole.invitationLine();
            String[] nextCommand = fconsole.read().trim().split(" ");
            try
            {
                commandManager.getCommands().get(nextCommand[0]).execute(nextCommand);
            }
            catch(NullPointerException ex)
            {
                fconsole.printError("Команда не найдена!");
            }
        }
    }
    /**
     * Устанавливает команды
     * @param collectionManager
     * @param commandManager
     * @param console
     * @param fileManager
     * @param callStack
     */
    private void setCommands(CollectionManager collectionManager, CommandManager commandManager, Console console, FileManager fileManager, ArrayList<String> callStack){

        commandManager.addNewCommand(new ExitCommand(console));
        commandManager.addNewCommand(new ShowCommand(console, collectionManager));
        commandManager.addNewCommand(new HelpCommand(console, commandManager));
        commandManager.addNewCommand(new InsertCommand(console, collectionManager));
        commandManager.addNewCommand(new UpdateCommand(console, collectionManager));
        commandManager.addNewCommand(new RemoveKeyCommand(console, collectionManager));
        commandManager.addNewCommand(new ClearCommand(console, collectionManager));
        commandManager.addNewCommand(new SaveCommand(console, collectionManager, fileManager));
        commandManager.addNewCommand(new ExecuteScriptCommand(collectionManager, commandManager, console, fileManager, callStack));
        commandManager.addNewCommand(new ExitCommand(console));
        commandManager.addNewCommand(new RemoveLowerCommand(console, collectionManager));
        commandManager.addNewCommand(new ReplaceIfLowerCommand(console, collectionManager));
        commandManager.addNewCommand(new RemoveLowerKeyCommand(console, collectionManager));
        commandManager.addNewCommand(new SumOfImpactSpeedCommand(console, collectionManager));
        commandManager.addNewCommand(new CountByCarCommand(console, collectionManager));
        commandManager.addNewCommand(new CountLessThanImpactSpeedCommand(console, collectionManager));
        commandManager.addNewCommand(new InfoCommand(console, collectionManager));
    }
    
}

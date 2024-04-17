package CommandManage.Commands;

import java.io.IOException;

import CommandManage.Command;
import Consoles.Console;
import Exeptions.FilePathNotFoundExeption;
import Managers.CollectionManager;
import Managers.FileManager;

  /**
   * Команда save, сохраняет коллекцию в файл
 */
public class SaveCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;
    private FileManager fileManager;
    public SaveCommand(Console console, CollectionManager collectionManager, FileManager fileManager){
        super("save", "сохранить коллекцию в файл");
        this.console = console;
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
    }
    
    @Override
    public void execute(String[] args){
        if (args.length!=1){
            console.printError("команде не требуются аргументы");
            return;
        }
        try{
        fileManager.collectionToJson(collectionManager.getCollection());
        console.print("Коллекция успешно сохранена в файл.");
        return;
        }
        catch(FilePathNotFoundExeption e){
            console.print(e.getMessage());
            return;
        }
        catch(IOException e){
            console.printError("Не удалось загрузить коллекцию в файл.");
            return;
        }

    }
}

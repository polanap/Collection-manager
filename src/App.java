import Consoles.Console;
import Managers.*;

public class App {
    public static void main(String[] args) throws Exception {
        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager();
        Console console = new Console();
        FileManager fileManager = new FileManager();

        try {
            collectionManager.setCollection(fileManager.jsonToCollection());
        }
        catch(Exception e){
            console.printError(e.getMessage());
        }
  
        RuntimeManager rm = new RuntimeManager(collectionManager, commandManager, console, fileManager);
        rm.interactiveMode();
    }
}

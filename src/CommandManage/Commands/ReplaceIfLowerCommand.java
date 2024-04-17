package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;
import Models.HumanBeing;
import Models.Forms.HumanBeingForm;

  /**
 * Команда replace_if_lower, заменяет значение по ключу, 
 * если новое значение меньше старого
 */
public class ReplaceIfLowerCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public ReplaceIfLowerCommand(Console console, CollectionManager collectionManager){
        super("replace_if_lower", "Заменить значение по ключу, если новое значение меньше старого: > replace_if_lower null {element}");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        if (args.length!=2){
            console.printError("Команда требует 1 аргумент в этой строке -- ключ элемента!");
            return;
        }
        Integer arg;
        try{ 
            arg = Integer.parseInt(args[1]);
        }catch (NumberFormatException e){
            console.printError("значение ключа должно быть типа Integer!");
            return;
        }
        console.print("Задайте элемент класса Human Being для сравнения:");
        HumanBeing hb = new HumanBeingForm(console).build();
        if (collectionManager.getCollection().get(arg).compareTo(hb) < 0){
            collectionManager.removeKey(arg);
            console.print(String.format("Элемент с id = %s оказался меньше заданного и был успешно удален", collectionManager.getCollection().get(arg).getId()));
        }
        else{
            console.print(String.format("Элемент с id = %s оказался больше заданного и не был удален", collectionManager.getCollection().get(arg).getId()));
        }
        return;
    }
}

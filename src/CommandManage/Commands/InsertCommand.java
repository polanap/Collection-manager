package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;
import Models.HumanBeing;
import Models.Forms.HumanBeingForm;

  /**
 * Команда insert, добавляет новый элемент c заданным ключом
 */
public class InsertCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public InsertCommand(Console console, CollectionManager collectionManager){
        super("insert", "добавить новый элемент c заданным ключом: > insert key {element}");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args){
        if (args.length!=2){
            console.printError("команда требует 1 аргумент -- значение ключа элемента");
            return;
        }
        Integer arg;
        try{ 
            arg = Integer.parseInt(args[1]);
        }catch (NumberFormatException e){
            console.printError("значение ключа должно быть типа Integer!");
            return;
        }
        if (collectionManager.getKeys().contains(arg)){
            console.printError("Элемент с таким ключом уже существует в коллекции");
            return;
        }
        console.print(String.format("Добавление элемента c ключом '%s' в коллекцию...", args[1]));
        HumanBeing hb = new HumanBeingForm(console).build();
        try{collectionManager.setKeyValue(arg, hb);}catch(IllegalArgumentException e){return;};
        console.print(String.format("Элемент с ключом '%s' успешно добавлен в коллекцию", args[1]));
        return;

    }
}

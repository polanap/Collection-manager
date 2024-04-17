package CommandManage.Commands;

import java.util.NoSuchElementException;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;
import Models.HumanBeing;
import Models.Forms.HumanBeingForm;

 /**
   * Команда update, обновляет значение элемента 
   * коллекции, id которого равен заданному
 */
public class UpdateCommand extends Command{
        private Console console;
    private CollectionManager collectionManager;
    public UpdateCommand(Console console, CollectionManager collectionManager){
        super("update", "обновить значение элемента коллекции, id которого равен заданному: > update id {element}");
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
            console.printError("значение id должно быть типа Integer!");
            return;
        }
        Integer key = null;
        for (Integer i: collectionManager.getKeys()){
            if (collectionManager.getCollection().get(i).getId()==arg){
                key = i;
            }     
        }
        if (key == null){
            console.printError("Элемента с таким ключом нет в коллекции");
            return;
        }
        console.print(String.format("Обновление значения элемента c id '%s'", args[1]));
        HumanBeing hb = new HumanBeingForm(console).build();
        try{collectionManager.updateKeyValue(arg, hb);}catch(NoSuchElementException e){return;};
        console.print(String.format("Значение элемента с id '%s' успешно обновлено", args[1]));
        return;
    }
}

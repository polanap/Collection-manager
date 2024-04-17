package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;

  /**
 * Команда count_less_than_impact_speed, выводит количество 
 * элементов, значение поля impactSpeed которых меньше заданного
 */
public class CountLessThanImpactSpeedCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public CountLessThanImpactSpeedCommand(Console console, CollectionManager collectionManager){
        super("count_less_than_impact_speed", "вывести количество элементов, значение поля impactSpeed которых меньше заданного");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        if (args.length!=2){
            console.printError("Команда требует 1 аргумент -- значение поля impactSpeed (Double)!");
            return;
        }
        Double arg;
        try{
            arg = Double.parseDouble(args[1]);
        }catch(NumberFormatException e){
            console.printError("значение аргумента должно быть типа Double!");
            return;
        }
        double counter = 0;
        for(Integer key : collectionManager.getCollection().keySet()){
            if (collectionManager.getCollection().get(key).getImpactSpeed() < arg){
                counter += 1;
            }
        }
        console.print(counter);
        return;
    }
}
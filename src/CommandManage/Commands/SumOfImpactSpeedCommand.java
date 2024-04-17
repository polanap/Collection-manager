package CommandManage.Commands;

import CommandManage.Command;
import Consoles.Console;
import Managers.CollectionManager;

 /**
   * Команда sum_of_impact_speed, выводит сумму 
   * значений поля impactSpeed для всех элементов коллекции
 */
public class SumOfImpactSpeedCommand extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public SumOfImpactSpeedCommand(Console console, CollectionManager collectionManager){
        super("sum_of_impact_speed", "вывести сумму значений поля impactSpeed для всех элементов коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        if (args.length!=1){
            console.printError("Команда не требует аргументов!");
            return;
        }
        double summator = 0;
        for(Integer key : collectionManager.getCollection().keySet()){
            summator += collectionManager.getCollection().get(key).getImpactSpeed();
        }
        console.print(summator);
        return;
    }
}

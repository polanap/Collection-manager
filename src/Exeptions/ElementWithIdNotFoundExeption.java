package Exeptions;

/**
 * Ошибка, возникающая, когда элемент с заданным Id не найден
 */
public class ElementWithIdNotFoundExeption extends Exception{
    @Override
    public String getMessage(){
        return "Элемент с заданным Id не найден";
    }
}

package Exeptions;

/**
 * Ошибка, возникающая, когда в исполняемом файле обнаружена рекурсия
 */
public class RecursionFoundExeption extends Exception {
    @Override
    public String getMessage(){
        return "Обнаружена рекурсия. Команда не может быть выполнена";
    }
    
}

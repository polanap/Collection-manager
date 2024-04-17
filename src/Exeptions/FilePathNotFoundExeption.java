package Exeptions;

/**
 * Ошибка, возникающая, когда не найдена переменная окружения, хранящая путь к файлу
 */
public class FilePathNotFoundExeption extends Exception{
    @Override
    public String getMessage(){
        return "Не найдена переменная окружения, хранящая путь к файлу";
    }
}

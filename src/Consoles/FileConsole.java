package Consoles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Класс для вывода в стандартную консоль результата 
 * выполнения комманд, прочитанных из файла
 */
public class FileConsole extends Console{

    /**
     * Файл, из которого будет выполняться чтение команд
     */
    File file;

    public FileConsole(File file) throws FileNotFoundException{
        this.file = file;
        this.scanner = new Scanner(file);
        this.prompt = "";
    }
    /**
     * Команда, проверяющая, закончился ли файл
     * @return true/false
     */
    public boolean checkNext(){
        return scanner.hasNextLine();
    }
    /**
     * Команда, показывающая, получаем ли мы данные 
     * из файла, а не из стандартной консоли
     * @return true
     */
    @Override
    public boolean fileMode(){
        return true;
    }

}

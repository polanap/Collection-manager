package Consoles;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс для вывода в стандартную консоль
 */
public class Console implements Output, Input {
    /**
     * Символ в начале пригласительной строки
     */
    protected String prompt = "> ";
    Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String[] args){
        for(String str: args){
            System.out.print(str);
            System.out.print(" ");
        }
        System.out.println("\n");
    }
    @Override
    public void print(String arg){
        System.out.println(arg);
    }

    @Override
    public void print(double arg){
        System.out.println(arg);
    }
    
    @Override
    public void printError(String arg){
        System.err.println(arg);
    }
    /**
     * Команда для вывода в стандартную консоль 
     * пригласительной строки с сообщением
     * @param invitation сообщение пригласительной строки
     */
    public void invitationLine(String invitation){
        System.out.println(invitation);
        System.out.print(prompt);
    }
    /**
     * Команда для вывода в стандартную консоль 
     * пригласительной строки
     */
    public void invitationLine(){
        System.out.print(prompt);
    }
    /**
     * Команда для чтения из стандартной консоли 
     * @return прочитанная строка без пробелов в начеле и в конце
     */
    @Override
    public String read(){
        try{
        String line = scanner.nextLine();
        return line.trim();
        }catch(NoSuchElementException e){
            System.exit(0);
            return "";
        }
    }
    /**
     * Команда, показывающая, получаем ли мы данные 
     * из файла, а не из стандартной консоли
     * @return false
     */
    public boolean fileMode(){
        return false;
    }



}

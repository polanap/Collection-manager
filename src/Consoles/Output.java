package Consoles;
/**
 * Интерфейс классов, выводящих данные в стандартную консоль
 */
public interface Output {
        /**
     * Команда для вывода в стандартную консоль массива строк через пробел
     * @param args массив элементов
     */
    public void print(String[] args);
    /**
     * Команда для вывода в стандартную консоль строки
     * @param arg
     */
    public void print(String arg);
    /**
     * Команда для вывода в стандартную консоль числа double
     * @param arg
     */
    public void print(double arg);
    /**
     * Команда для вывода в стандартную консоль 
     * сообщения, информирующего об ошибке
     * @param arg
     */
    public void printError(String arg);
    
}

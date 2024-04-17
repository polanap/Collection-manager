package Consoles;
/**
 * Интерфейс классов, принимающих пользовательские данные
 */
public interface Input {
    /**
     * Команда для чтения
     * @return прочитанная строка без пробелов в начеле и в конце
     */
    public String read();
}

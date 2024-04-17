package CommandManage;
/**
 * Интерфейс для исполняемых команд
 */
public interface Executable {
  /**
 * Выполнение команды
 * @param String[] название комманды и ее аргументы
 */
    public void execute(String[] args);
    
}

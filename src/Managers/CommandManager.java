package Managers;

import java.util.HashMap;
import java.util.Map;

import CommandManage.Command;
/**
 * Класс, отвещаюший за управление коммандами
 */
public class CommandManager {
    /**
     * Словарь комманд
     */
    private final Map<String, Command> commands = new HashMap<>();
    
    /**
     * Добавляет команду
     * @param commandName Название команды
     * @param command Команда
     */
    public void addNewCommand(Command command) {
        commands.put(command.getName(), command);
    }

    /**
     * @return Словарь команд
     */
    public Map<String, Command> getCommands() {
        return commands;
    }

}

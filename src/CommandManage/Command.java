package CommandManage;

import java.util.Objects;

/**
 * Абстрактная команда с именем и описанием
 */
public abstract class Command implements Executable{
  /**
 * Переменная, хранящая имя команды
 */
  private final String commandName;
  /**
 * Переменная, хранящая описание команды
 */
  private final String commandDescription;

  public Command(String commandName, String commandDescription) {
    this.commandName = commandName;
    this.commandDescription = commandDescription;
  }

  /**
   * @return Название и команды.
   */ 
  public String getName() {
    return commandName;
  }

  /**
   * @return Описание команды.
   */
  public String getDescription() {
    return commandDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Command command = (Command) o;
    return Objects.equals(commandName, command.commandName) && Objects.equals(commandDescription, command.commandDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commandName, commandDescription);
  }

  @Override
  public String toString() {
    return this.getName() + ": " + this.getDescription();
  }

}
package Models.Forms;

import java.util.function.Predicate;

import Consoles.Console;

/**
 * Абстрактный класс, отвечающий за интерактивное создание объекта
 */
public abstract class Form<T> {

    protected Console console;

    public Form(Console console){
        this.console = console;
    }

    /**
     * Собитает объект нужного класса в интерактивном режиме
     * @return объект нужного класса
     */
    public abstract T build();

    /**
     * Запрос строкового типа данных String
     * @param field название поля, для которого запрашивается значение 
     * @param limit ограничения значения в строковом формате
     * @param validator ограничения значения в формате функционального интерфейса Predicate
     * @return String
     */
    protected String askString(String field, String limit, Predicate<String> validator){
        do{
            try{
                console.print(String.format("Введите значение поля %s типа Srting (%s)", field, limit));
                String arg = console.read();
                if (arg.isEmpty()) arg = null;
                if (!validator.test(arg)) throw new IllegalArgumentException();
                return arg;
            }catch(IllegalArgumentException e){
                console.printError(limit+"!");
            }
        }
        while(!console.fileMode());
        return null;
    }

    /**
     * Запрос целочисленного типа данных Integer
     * @param field название поля, для которого запрашивается значение 
     * @param limit ограничения значения в строковом формате
     * @param validator ограничения значения в формате функционального интерфейса Predicate
     * @return Integer
     */
    protected Integer askInteger(String field, String limit, Predicate<Integer> validator){
        do{
            try
            {
                console.print(String.format("Введите значение поля %s типа Integer (%s)", field, limit));
                String arg = console.read();
                if (arg.isEmpty()) arg = null;
                if (!validator.test(Integer.parseInt(arg))) throw new IllegalArgumentException();
                if (arg == null) {return null;}
                return Integer.parseInt(arg);
            }
            catch(NumberFormatException e)
            { 
                console.printError("Значение должно быть типа Integer!");
            }
            catch(IllegalArgumentException e)
            {
                console.printError(limit+"!");
            }
        }while(!console.fileMode());
        return null;
    }

    /**
     * Запрос строкового типа данных Long
     * @param field название поля, для которого запрашивается значение 
     * @param limit ограничения значения в строковом формате
     * @param validator ограничения значения в формате функционального интерфейса Predicate
     * @return Long
     */
    protected Long askLong(String field, String limit, Predicate<Long> validator){
        do{
            try
            {
                console.print(String.format("Введите значение поля %s типа Long (%s)", field, limit));
                String arg = console.read();
                if (arg.isEmpty()) arg = null;
                if (!validator.test(Long.parseLong(arg))) throw new IllegalArgumentException();
                if (arg == null) {return null;}
                return Long.parseLong(arg);
            }
            catch(NumberFormatException e)
            { 
                console.printError("Значение должно быть типа Long!");
            }
            catch(IllegalArgumentException e)
            {
                console.printError(limit+"!");
            }
        }while(!console.fileMode());
        return null;
    }

    /**
     * Запрос логического типа данных Boolean
     * @param field название поля, для которого запрашивается значение 
     * @param limit ограничения значения в строковом формате
     * @param validator ограничения значения в формате функционального интерфейса Predicate
     * @return Boolean
     */
    protected Boolean askBoolean(String field, String limit, Predicate<String> validator){
        do{
            try
            {
                console.print(String.format("Введите значение поля %s типа Boolean (%s)", field, limit));
                String arg = console.read();
                if (arg.isEmpty()) arg = null;
                if (!validator.test(arg)) throw new IllegalArgumentException();
                if (arg == null) {return null;}
                return Boolean.parseBoolean(arg);
            }
            catch(IllegalArgumentException e)
            {
                console.printError(limit+"!");
            }
        }while(!console.fileMode());
        return null;
    }

      /**
     * Запрос числового типа данных Double
     * @param field название поля, для которого запрашивается значение 
     * @param limit ограничения значения в строковом формате
     * @param validator ограничения значения в формате функционального интерфейса Predicate
     * @return Double
     */
    protected Double askDouble(String field, String limit, Predicate<Double> validator){
        do {
            try
            {
                console.print(String.format("Введите значение поля %s типа Double (%s)", field, limit));
                String arg = console.read();
                if (arg.isEmpty()) arg = null;
                if (!validator.test(Double.parseDouble(arg))) throw new IllegalArgumentException();
                if (arg == null) {return null;}
                return Double.parseDouble(arg);
            }
            catch(NumberFormatException e)
            { 
                console.printError("Значение должно быть типа Double!");
            }
            catch(IllegalArgumentException e)
            {
                console.printError(limit+"!");
            }
        }while(!console.fileMode());
        return null;
    }

    /**
     * Запрос числового типа данных Float
     * @param field название поля, для которого запрашивается значение 
     * @param limit ограничения значения в строковом формате
     * @param validator ограничения значения в формате функционального интерфейса Predicate
     * @return Float
     */
    protected Float askFloat(String field, String limit, Predicate<Float> validator){
        do{
            try
            {
                console.print(String.format("Введите значение поля %s типа Float (%s)", field, limit));
                String arg = console.read();
                if (arg.isEmpty()) arg = null;
                if (!validator.test(Float.parseFloat(arg))) throw new IllegalArgumentException();
                if (arg == null) {return null;}
                return Float.parseFloat(arg);
            }
            catch(NumberFormatException e)
            { 
                console.printError("Значение должно быть типа Float!");
            }
            catch(IllegalArgumentException e)
            {
                console.printError(limit+"!");
            }
        }while(!console.fileMode());
        return null;
    }

        /**
     * Запрос типа данных Enum
     * @param field название поля, для которого запрашивается значение 
     * @param limit ограничения значения в строковом формате
     * @param validator ограничения значения в формате функционального интерфейса Predicate
     * @return Enum
     */
    protected Enum askEnum(Enum[] values, String field){
        do{
            try
            {
                console.print(String.format("Введите значение поля %s. Допустимые значения:", field));
                for (Enum elem : values){
                    console.print(elem.toString());
                }
                String arg = console.read().toUpperCase();
                if (arg.isEmpty()) arg = null;
                if (arg == null) throw new IllegalArgumentException();
                for (Enum elem : values){
                    if (arg.equals(elem.toString())){
                        return elem;
                    }
                }
                console.printError("Enum не может принимать такое значение");
            }
            catch(IllegalArgumentException e)
            {
                console.printError("Enum не может принимать значение null");
            }
        }while(!console.fileMode());
        return null;
    }


}

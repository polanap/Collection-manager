package Managers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;
import Exeptions.ElementWithIdNotFoundExeption;
import Models.HumanBeing;

/**
 * Класс, отвещаюший за управление коллекцией
 */
public class CollectionManager {
    private HashMap <Integer, HumanBeing> collection = new HashMap<>();
    private LocalDateTime initTime;
    
    /**
     * @return коллекция элементов 
     */
    public HashMap<Integer, HumanBeing> getCollection(){
        return collection;

    }
    /**
     * Команда, добавляющая элемент в коллекцию по ключу
     * @param key ключ элемента
     * @param value значение, которое нужно добавить в коллекцию
     * @throws IllegalArgumentException выбрасывается, если элемент с заданным ключом уже есть в коллекции
     */
    public void setKeyValue(int key, HumanBeing value) throws IllegalArgumentException{
        if (collection.isEmpty()){
            this.initTime = LocalDateTime.now();
        }
        if (this.getKeys().contains(key)) throw new IllegalArgumentException("Элемент с заданным ключом уже есть в коллекции");
        collection.put(key, value);
    }

     /**
     * Команда, заменяющая элемент с заданным ключом в коллекции
     * @param key ключ элемента
     * @param value значение, которое нужно добавить в коллекцию
     * @throws NoSuchElementException выбрасывается, если элемента с заданным ключом нет в коллекции
     */
    public void updateKeyValue(int key, HumanBeing value) throws NoSuchElementException{
        if (!this.getKeys().contains(key)) throw new NoSuchElementException("Элемента с заданным ключом нет в коллекции");
        collection.put(key, value);
    }

    /**
     * Команда, заменяющая элемент с заданным id
     * @param id id элемента
     * @param value новое значение
     * @throws ElementWithIdNotFoundExeption выбрасывается, когда 
     * элемента с заданным id нет в коллекции
     */
    public void updateIdValue(int id, HumanBeing value) throws ElementWithIdNotFoundExeption{
        for(int key: collection.keySet()){
            if (collection.get(key).getId().equals(id)){
                collection.put(key, value);
                break;
            }
        }
        throw new ElementWithIdNotFoundExeption();
    }

    /**
     * @return множество ключей элементов коллекции
     */
    public Set<Integer> getKeys(){
        return collection.keySet();
    }
    /**
     * Удаление элемента по заданному ключу
     * @param key ключ элемента
     */
    public void removeKey(Integer key){
        collection.remove(key);
    }
    /**
     * Очистка коллекции
     */
    public void clearCollection(){
        collection.clear();
    }
    /** 
     * Загрузка коллекции
     */
    public void setCollection(HashMap <Integer, HumanBeing> collection){
        this.collection = collection;
        this.setNextId();
        this.initTime = LocalDateTime.now();
        
    }

    /**
     * Устанавливает значение переменной nextId, 
     * делает его строго большим любого id в коллекции
     */
    private void setNextId(){
        for (HumanBeing value: collection.values()){
            HumanBeing.setNextId(Math.max(value.getId(), HumanBeing.getNextId())+1);
        }
    }

    public String getInfo(){
        return String.format("Информация о коллекции:\n" + //
                            "\t Тип коллекции: HashMap;\n"+ //
                            "\t Количество элементов: %s;\n"+ //
                            "\t Дата инициализации: %s;\n"+ //
                            "\t Тип ключа: Integer;\n"+ //
                            "\t Тип хранимых значений: HumanBeing.", 
                            collection.size(), initTime);
    }


}

package Managers;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import Exeptions.FilePathNotFoundExeption;
import Models.HumanBeing;

/**
 * Класс, отвещаюший за работу с файлами
 */
public class FileManager {

    /**
     * Преобразовывает файл из переменной окружения file_path в строку
     * @return данные из файла
     * @throws IOException выбрасывается, когда происходит ошибка чтения из файла
     * @throws FilePathNotFoundExeption выбрасывается, когда не найдена 
     * переменная окружения, хранящая путь к файлу 
     */
    public String FileToString() throws IOException, FilePathNotFoundExeption{
        String filePath = System.getenv().get("file_path");
        if (filePath == null || filePath.isEmpty()){
            throw new FilePathNotFoundExeption();
        }
        File file = new File(filePath);
        FileReader reader = new FileReader(file);
        StringBuilder flood = new StringBuilder();
        int c;
        while ((c=reader.read())!=-1){
            flood.append((char)c);
        }
        String stringFile = flood.toString();
        reader.close();
        return stringFile;
    }
    /**
   * Записывает коллекцию HashMap <Integer, HumanBeing> в json-файл
   * @param collection коллекция
   */
    public void collectionToJson(HashMap <Integer, HumanBeing> collection) throws IOException, FilePathNotFoundExeption{
        String filePath = System.getenv().get("file_path");
        if (filePath == null || filePath.isEmpty()){
            throw new FilePathNotFoundExeption();
        }
        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream writer = new BufferedOutputStream(fos);
        Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .serializeNulls()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                    .create();
        String json = gson.toJson(collection);

        byte[] array = json.getBytes();
        writer.write(array);
        writer.close();
    }

    
    /**
   * Конвертирует json-файл в коллекцию HashMap <Integer, HumanBeing>
   * @return collection коллекция объектов
   */
    public HashMap <Integer, HumanBeing> jsonToCollection() throws IOException, FilePathNotFoundExeption{
        Type type = new TypeToken<HashMap<Integer, HumanBeing>>(){}.getType();
        Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .serializeNulls()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                    .create();
        HashMap <Integer, HumanBeing> collectionFromJson = gson.fromJson(FileToString(), type);
        return collectionFromJson;
    }

}

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class JsonDatabaseManager<T> {

    private final String filepath;
    private final Class<T> type;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public JsonDatabaseManager(String filepath, Class<T> type) {
        this.filepath = filepath;
        this.type = type;
    }

    private List<T> loadAll() {

        try (Reader reader = new FileReader(filepath)) {
            Type listType = TypeToken.getParameterized(List.class, type).getType();
            List<T> list = gson.fromJson(reader, listType);
            return list != null ? list : new ArrayList<>();
        } catch (IOException e) {

            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveAll(List<T> list) {
        try (Writer writer = new FileWriter(filepath)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(T obj) {
        List<T> list = loadAll();
        list.add(obj);
        saveAll(list);
    }

    public List<T> getAll() {
        return loadAll();
    }

    public void update(int index, T obj) {
        List<T> list = loadAll();
        if (index >= 0 && index < list.size()) {
            list.set(index, obj);
            saveAll(list);
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + list.size());
        }
    }

    public void delete(int index) {
        List<T> list = loadAll();
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            saveAll(list);
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + list.size());
        }
    }
}
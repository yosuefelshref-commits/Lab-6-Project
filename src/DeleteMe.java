import com.google.gson.Gson;

public class DeleteMe {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // كائن بسيط للتجربة
        Person p = new Person("Sofyan", 21);
        String json = gson.toJson(p);
        System.out.println("JSON Output: " + json);

        // تحويل JSON لكائن من جديد
        Person restored = gson.fromJson(json, Person.class);
        System.out.println("Restored Object: " + restored.name + " - " + restored.age);
    }
}

class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

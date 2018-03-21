package Lab2Equals;
import com.google.gson.*;

public class MainEquals {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Person person = new Person();
        person.setAge(18);
        person.setName("Ruslan");

        String json = gson.toJson(person);
        Person personFromJSON = gson.fromJson(json,Person.class);

        Person pers2 = new Person("Second", 2);

        System.out.println(person.toString());
        System.out.println(personFromJSON.toString());
        System.out.println(pers2.toString());

        System.out.println("mb true: " + person.equals(personFromJSON));
        System.out.println("mb false: " + person.equals(pers2));
        System.out.println("mb true: " + pers2.equals(gson.fromJson(gson.toJson(pers2), Person.class)));
        System.out.println("mb false: " + pers2.equals(gson.fromJson(gson.toJson(new Person()), Person.class)));
    }
}

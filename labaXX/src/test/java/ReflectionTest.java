import Entities.Human;
import Entities.Person;
import Entities.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ReflectionTest {
    @Test
    public void testCountHumans() {
        PodamFactory factory = new PodamFactoryImpl();
        List<Object> objects = new ArrayList<>();

        Assertions.assertEquals(0, ReflectionDemon.countHumans(null));
        Assertions.assertEquals(0, ReflectionDemon.countHumans(objects));

        objects.add(factory.manufacturePojo(Human.class));
        objects.add(factory.manufacturePojo(Student.class));
        objects.add(factory.manufacturePojo(Person.class));
        objects.add(factory.manufacturePojo(Human.class));
        objects.add(factory.manufacturePojo(Human.class));

        Assertions.assertEquals(3, ReflectionDemon.countHumans(objects));
    }
    @Test
    public void testGetPublicMethodsNames() {
        PodamFactory factory = new PodamFactoryImpl();
        Person person = factory.manufacturePojo(Person.class);
        List<String> publicMethods = new ArrayList<>();

        Assertions.assertEquals(publicMethods, ReflectionDemon.getPublicMethodsNames(null));

        publicMethods.add("getBirthday");
        publicMethods.add("getFirstName");
        publicMethods.add("getSurname");
        publicMethods.add("getPatronymic");
        publicMethods.add("equals");
        publicMethods.add("hashCode");

        List<String> answer = ReflectionDemon.getPublicMethodsNames(person);
        Assertions.assertTrue(publicMethods.size() == answer.size() && publicMethods.containsAll(answer) && answer.containsAll(publicMethods));
    }

    @Test
    public void testGetParentClassesNames() {
        PodamFactory factory = new PodamFactoryImpl();
        List<String> parents = new ArrayList<>();
        Student student = factory.manufacturePojo(Student.class);

        Assertions.assertEquals(new ArrayList<>(), ReflectionDemon.getParentClassesNames(null));

        parents.add("Human");
        parents.add("Object");
        Assertions.assertEquals(parents, ReflectionDemon.getParentClassesNames(student));

    }
}

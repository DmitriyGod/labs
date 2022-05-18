import Entities.Human;
import Entities.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsDemonTest {
    @Test
    public void testGetCountFirstCharacter() {
        PodamFactory factory = new PodamFactoryImpl();
        List<String> strings = new ArrayList<>();

        char value = 'a';

        Assertions.assertEquals(0, CollectionsDemon.getCountFirstCharacter(null, value));
        Assertions.assertEquals(0, CollectionsDemon.getCountFirstCharacter(strings, value));

        for (int i = 0; i < 10; i++) {
            strings.add(factory.manufacturePojo(String.class));
        }

        int counter = 0;

        for (String str : strings) {
            if (str.charAt(0) == value) {
                counter++;
            }
        }

        Assertions.assertEquals(counter, CollectionsDemon.getCountFirstCharacter(strings, value));
    }

    @Test
    public void testGetNamesakes() {
        PodamFactory factory = new PodamFactoryImpl();
        Human originalHuman = factory.manufacturePojo(Human.class);
        List<Human> humans = new ArrayList<>();
        List<Human> emptyResult = new ArrayList<>();

        Assertions.assertEquals(emptyResult, CollectionsDemon.getNamesakes(humans, originalHuman));
        Assertions.assertEquals(emptyResult, CollectionsDemon.getNamesakes(humans, null));
        Assertions.assertEquals(emptyResult, CollectionsDemon.getNamesakes(null, null));

        for (int i = 0; i < 1000; i++) {
            humans.add(factory.manufacturePojo(Human.class));
        }

        originalHuman = humans.get(42);

        ArrayList<Human> namesakesArray = new ArrayList<>();

        for (Human human : humans) {
            if (human == null) continue;

            if (human.getSecondName().equals(originalHuman.getSecondName())) {
                Human humanCopy = new Human(human.getName(), human.getSecondName(), human.getFathersName(), human.getAge());
                namesakesArray.add(humanCopy);
            }
        }

        Assertions.assertEquals(namesakesArray, CollectionsDemon.getNamesakes(humans, originalHuman));
    }

    @Test
    public void testGetCopyWithoutOriginalHuman() {
        PodamFactory factory = new PodamFactoryImpl();
        Human human = factory.manufacturePojo(Human.class);
        List<Human> humans = new ArrayList<>();
        List<Human> emptyResult = new ArrayList<>();

        Assertions.assertEquals(emptyResult, CollectionsDemon.getNamesakes(humans, human));
        Assertions.assertEquals(emptyResult, CollectionsDemon.getNamesakes(humans, null));
        Assertions.assertEquals(emptyResult, CollectionsDemon.getNamesakes(null, null));

        for (int i = 0; i < 1000; i++) {
            humans.add(factory.manufacturePojo(Human.class));
        }
        int id = 42;
        human = humans.get(id);

        List<Human> newHumans = new ArrayList<>(humans);
        newHumans.remove(id);


        Assertions.assertEquals(newHumans, CollectionsDemon.getCopyWithoutOriginalHuman(humans, human));
    }

    @Test
    public void testGetZeroIntersectionArrays() {
        PodamFactory factory = new PodamFactoryImpl();
        List<Set<Integer>> sets = new ArrayList<>();
        Set<Integer> mainSet = new HashSet<>();

        Assertions.assertEquals(sets, CollectionsDemon.getZeroIntersectionArrays(sets, mainSet));
        Assertions.assertEquals(sets, CollectionsDemon.getZeroIntersectionArrays(null, mainSet));

        for (int i = 0; i < 10; i++) {
            Set<Integer> integerSet = new HashSet<>();
            for (int k = 0; k < 100; k++) {
                integerSet.add(factory.manufacturePojo(Integer.class));

            }
            sets.add(integerSet);
        }

        for (int k = 0; k < 50; k++) {
            mainSet.add(factory.manufacturePojo(Integer.class));

        }

        List<Set<Integer>> zeroIntersectionArrays = new ArrayList<>();

        for (Set<Integer> set : sets) {
            if (set == null) continue;

            boolean intersection_flag = false;
            for (Integer i : mainSet) {
                if (i == null) continue;

                if (set.contains(i)) {
                    intersection_flag = true;
                    break;
                }
            }
            if (!intersection_flag) {
                zeroIntersectionArrays.add(set);
            }
        }

        Assertions.assertEquals(zeroIntersectionArrays, CollectionsDemon.getZeroIntersectionArrays(sets, mainSet));

    }
    @Test
    public void testGetMaxAge() {
        PodamFactory factory = new PodamFactoryImpl();
        List<Human> humans = new ArrayList<>();

        Assertions.assertEquals(new ArrayList<Human>(), CollectionsDemon.getMaxAge(humans));
        Assertions.assertEquals(new ArrayList<Human>(), CollectionsDemon.getMaxAge(null));

        for (int i = 0; i < 100; i++) {
            humans.add(factory.manufacturePojo(Human.class));

        }

        int maxAge = humans.stream().max(Comparator.comparing(Human::getAge)).get().getAge();
        List<Human> maxAgeHumans = humans.stream().filter(human -> human.getAge() == maxAge).collect(Collectors.toList());

        Assertions.assertEquals(maxAgeHumans, CollectionsDemon.getMaxAge(humans));



        List<Student> students = new ArrayList<>();

        Assertions.assertEquals(new ArrayList<Student>(), CollectionsDemon.getMaxAge(students));

        for (int i = 0; i < 100; i++) {
            students.add(factory.manufacturePojo(Student.class));

        }

        int studentsMaxAge = students.stream().max(Comparator.comparing(Student::getAge)).get().getAge();;
        List<Student> maxAgeStudents = students.stream().filter(student -> student.getAge() == studentsMaxAge).collect(Collectors.toList());

        Assertions.assertEquals(maxAgeStudents, CollectionsDemon.getMaxAge(students));

    }

    @Test
    public void testGetHumansByKeys() {
        PodamFactory factory = new PodamFactoryImpl();
        Map<Integer, Human> humansMap = new HashMap<>();
        Set<Integer> keys = new HashSet<>();

        Assertions.assertEquals(new HashSet<Human>(), CollectionsDemon.getHumansByKeys(humansMap, keys));
        Assertions.assertEquals(new HashSet<Human>(), CollectionsDemon.getHumansByKeys(null, keys));
        Assertions.assertEquals(new HashSet<Human>(), CollectionsDemon.getHumansByKeys(humansMap, null));
        Assertions.assertEquals(new HashSet<Human>(), CollectionsDemon.getHumansByKeys(null, null));

        for (int i = 0; i < 100; i++) {
            humansMap.put(factory.manufacturePojo(Integer.class), factory.manufacturePojo(Human.class));

        }

        keys = humansMap.keySet().stream().filter(key -> key % 2 == 0).collect(Collectors.toSet());

        Set<Human> humansByKeys = new HashSet<Human>();
        for (Integer key : keys) {
            if (key == null) continue;

            if (humansMap.containsKey(key)) {

                humansByKeys.add(humansMap.get(key));
            }
        }

        Assertions.assertEquals(humansByKeys, CollectionsDemon.getHumansByKeys(humansMap, keys));
    }

    @Test
    public void testGetListOfHumanOlder18() {
        PodamFactory factory = new PodamFactoryImpl();
        Map<Integer, Human> humansMap = new HashMap<>();

        Assertions.assertEquals(new ArrayList<>(), CollectionsDemon.getListOfHumanOlder18(null));
        Assertions.assertEquals(new ArrayList<>(), CollectionsDemon.getListOfHumanOlder18(humansMap));

        for (int i = 0; i < 100; i++) {
            humansMap.put(factory.manufacturePojo(Integer.class), factory.manufacturePojo(Human.class));

        }

        List<Integer> humansByKeysOlder18 = new ArrayList<>();

        for (Integer key : humansMap.keySet()) {
            if (key == null) continue;

            if (humansMap.get(key).getAge() >= 18) {
                humansByKeysOlder18.add(key);

            }
        }

        Assertions.assertEquals(humansByKeysOlder18, CollectionsDemon.getListOfHumanOlder18(humansMap));
    }

    @Test
    public void testMakeNewAgeMap() {
        PodamFactory factory = new PodamFactoryImpl();
        Map<Integer, Human> humansMap = new HashMap<>();
        Map<Integer, Integer> newMap = new HashMap<>();

        Assertions.assertEquals(new HashMap<>(), CollectionsDemon.makeNewAgeMap(null));
        Assertions.assertEquals(new HashMap<>(), CollectionsDemon.makeNewAgeMap(humansMap));

        for (int i = 0; i < 100; i++) {
            humansMap.put(factory.manufacturePojo(Integer.class), factory.manufacturePojo(Human.class));

        }

        for (Integer key : humansMap.keySet()) {
            if (key == null) continue;

            newMap.put(key, humansMap.get(key).getAge());
        }

        Assertions.assertEquals(newMap, CollectionsDemon.makeNewAgeMap(humansMap));

    }

    @Test
    public void testMadeAgeToHumansMap() {
        PodamFactory factory = new PodamFactoryImpl();
        Set<Human> humans = new HashSet<>();
        Map<Integer, List<Human>> ageToHumans = new HashMap<>();

        Assertions.assertEquals(new HashMap<>(), CollectionsDemon.madeAgeToHumansMap(null));
        Assertions.assertEquals(new HashMap<>(), CollectionsDemon.madeAgeToHumansMap(humans));

        for (int i = 0; i < 10000; i++) {
            humans.add(factory.manufacturePojo(Human.class));

        }

        for (Human human : humans) {
            if (human == null) continue;

            if (!ageToHumans.containsKey(human.getAge())) {
                ageToHumans.put(human.getAge(), new ArrayList<>());
            }

            ageToHumans.get(human.getAge()).add(human);
        }

        Assertions.assertEquals(ageToHumans, CollectionsDemon.madeAgeToHumansMap(humans));
    }
}

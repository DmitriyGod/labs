import Entities.Human;

import java.util.*;

public class CollectionsDemon {

    public static int getCountFirstCharacter(List<String> strings, char value) {
        if (strings == null) {
            return 0;
        }

        int counter = 0;

        for (String str : strings) {
            if (str == null) continue;

            if (str.charAt(0) == value) {
                counter++;
            }
        }

        return counter;
    }

    public static List<Human> getNamesakes(List<Human> humans, Human comparingHuman) {
        if (comparingHuman == null || humans == null || humans.isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<Human> namesakesArray = new ArrayList<>();

        for (Human human : humans) {
            if (human == null) continue;

            if (human.getSecondName().equals(comparingHuman.getSecondName())) {
                Human humanCopy = new Human(human.getName(), human.getSecondName(), human.getFathersName(), human.getAge());
                namesakesArray.add(humanCopy);
            }
        }

        return namesakesArray;
    }

    public static List<Human> getCopyWithoutOriginalHuman(List<Human> humans, Human comparingHuman) {
        if (comparingHuman == null || humans == null || humans.isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<Human> otherHumansArray = new ArrayList<>();

        for (Human human : humans) {
            if (human == null) continue;

            if (!human.equals(comparingHuman)) {
                Human humanCopy = new Human(human.getName(), human.getSecondName(), human.getFathersName(), human.getAge());
                otherHumansArray.add(humanCopy);
            }

        }

        return otherHumansArray;
    }

    public static List<Set<Integer>> getZeroIntersectionArrays(List<Set<Integer>> sets, Set<Integer> mainSet) {
        if (sets == null || sets.isEmpty()) {
            return new ArrayList<>();
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

        return zeroIntersectionArrays;
    }

    public static <T extends Human> List<T> getMaxAge(List<T> humans) {
        if (humans == null || humans.isEmpty()) {
            return new ArrayList<T>();
        }

        List<T> maxAgeHumans = new ArrayList<>();

        int maxAge = 0;
        for (T human : humans) {
            if (human == null) continue;

            if (human.getAge() >= maxAge) {
                maxAge = human.getAge();
            }
        }

        for (T human : humans) {
            if (human == null) continue;

            if (maxAge == human.getAge()) {

                maxAgeHumans.add(human);
            }
        }

        return maxAgeHumans;
    }

    public static Set<Human> getHumansByKeys(Map<Integer, Human> humansMap, Set<Integer> keys) {
        if (humansMap == null || humansMap.isEmpty() || keys == null || keys.isEmpty()) {
            return new HashSet<>();
        }

        Set<Human> humansByKeys = new HashSet<Human>();

        for (Integer key : keys) {
            if (key == null) continue;

            if (humansMap.containsKey(key)) {

                humansByKeys.add(humansMap.get(key));
            }
        }

        return humansByKeys;
    }

    public static List<Integer> getListOfHumanOlder18(Map<Integer, Human> humansMap) {
        if (humansMap == null || humansMap.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> humansByKeysOlder18 = new ArrayList<>();

        for (Integer key : humansMap.keySet()) {
            if (key == null) continue;

            if (humansMap.get(key).getAge() >= 18) {
                humansByKeysOlder18.add(key);

            }
        }

        return humansByKeysOlder18;
    }

    public static Map<Integer, Integer> makeNewAgeMap(Map<Integer, Human> humansMap) {
        if (humansMap == null || humansMap.isEmpty()) {
            return new HashMap<>();
        }

        Map<Integer, Integer> keyHumanAgeMap = new HashMap<>();

        for (Integer key : humansMap.keySet()) {
            if (key == null) continue;

            keyHumanAgeMap.put(key, humansMap.get(key).getAge());
        }

        return keyHumanAgeMap;
    }

    public static Map<Integer, List<Human>> madeAgeToHumansMap(Set<Human> humans) {
        if (humans == null || humans.isEmpty()) {
            return new HashMap<>();
        }

        Map<Integer, List<Human>> ageToHumansMap = new HashMap<>();

        for (Human human : humans) {
            if (human == null) continue;

            if (!ageToHumansMap.containsKey(human.getAge())) {
                ageToHumansMap.put(human.getAge(), new ArrayList<>());
            }

            ageToHumansMap.get(human.getAge()).add(human);
        }

        return ageToHumansMap;
    }

}

import Entities.Human;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemon {
    public static final Function<String, Integer> getLength = String::length;
    public static final Function<String, String> getFirstChar = s -> String.valueOf(s.charAt(0));
    public static final Predicate<String> isContainSpace = s -> s.contains(" ");
    public static final Function<String, Integer> countWordsSeparatedByCommas = s -> s.split(",").length;
    public static final Function<Human, Integer> getAge = Human::getAge;
    public static final BiPredicate<Human, Human> isNamesEquals = ((humanLeft, humanRight) ->
    {
        if (humanLeft.getName() == null) {
            return humanRight.getName() == null;
        } else {
            return humanLeft.getName().equals(humanRight.getName());
        }
    });
    public static final Function<Human, String> getFullName = human ->
            String.join(" ", human.getName(), human.getSecondName(), human.getFathersName());
    public static final Function<Human, Human> getHumanPlusYear = human ->
            new Human(human.getName(), human.getSecondName(), human.getFathersName(), human.getAge() + 1);
    public static final ThreeHumanFunction isHumansHaveLessAge = ((human1, human2, human3, age) ->
            human1.getAge() < age && human2.getAge() < age && human3.getAge() < age);
}

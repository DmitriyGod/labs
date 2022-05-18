import Entities.Human;

@FunctionalInterface
public interface ThreeHumanFunction {
    boolean apply(Human human1, Human human2, Human human3, int age);

}

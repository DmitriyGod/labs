import Entities.Human;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaRunner {
    public static <T, R> R runFunction(Function<T, R> lambda, T parameter) {
        return lambda.apply(parameter);
    }

    public static <T> boolean runPredicate(Predicate<T> lambda, T parameter) {
        return lambda.test(parameter);
    }

    public static <T> boolean runBiPredicate(BiPredicate<T, T> lambda, T humanLeft, T humanRight) {
        return lambda.test(humanLeft, humanRight);
    }

    public static boolean runThreeHumanFunction(ThreeHumanFunction lambda, Human human1, Human human2, Human human3, int age) {
        return lambda.apply(human1, human2, human3, age);
    }
}

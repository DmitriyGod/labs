import Entities.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class LambdaDemonTest {
    @Test
    public void testGetLength() {
        Assertions.assertEquals(6, LambdaDemon.getLength.apply("ahahah"));
    }
    @Test
    public void testGetFirstChar() {
        Assertions.assertEquals("l", LambdaDemon.getFirstChar.apply("lol"));
    }
    @Test
    public void testIsContainSpace() {
        Assertions.assertTrue(LambdaDemon.isContainSpace.test("asdsa asd s"));
        Assertions.assertFalse(LambdaDemon.isContainSpace.test("asdsaasds"));
    }
    @Test
    public void testCountWordsSeparatedByCommas() {
        Assertions.assertEquals(3, LambdaDemon.countWordsSeparatedByCommas.apply("asdsa,asd,s"));
        Assertions.assertEquals(1, LambdaDemon.countWordsSeparatedByCommas.apply("asdsaasds"));
    }
    @Test
    public void testGetAge() {
        PodamFactory factory = new PodamFactoryImpl();
        Human human = factory.manufacturePojo(Human.class);

        Assertions.assertEquals(human.getAge(), LambdaDemon.getAge.apply(human));
    }

    @Test
    public void testIsNamesEquals() {
        PodamFactory factory = new PodamFactoryImpl();
        Human human = factory.manufacturePojo(Human.class);
        Human human2 = factory.manufacturePojo(Human.class);


        if (!human.getName().equals(human2.getName())) {
            Assertions.assertFalse(LambdaDemon.isNamesEquals.test(human, human2));
        } else {
            Assertions.assertTrue(LambdaDemon.isNamesEquals.test(human, human2));
        }
    }
    @Test
    public void tesGetFullName() {
        PodamFactory factory = new PodamFactoryImpl();
        Human human = factory.manufacturePojo(Human.class);

        String fullName = String.join(" ", human.getName(), human.getSecondName(), human.getFathersName());

        Assertions.assertEquals(fullName, LambdaDemon.getFullName.apply(human));
    }
    @Test
    public void tesGetHumanPlusYear() {
        PodamFactory factory = new PodamFactoryImpl();
        Human human = factory.manufacturePojo(Human.class);

        Human newHuman = LambdaDemon.getHumanPlusYear.apply(human);
        human.setAge(human.getAge() + 1);

        Assertions.assertEquals(human, newHuman);
    }
    @Test
    public void isHumansHaveLessAge() {
        PodamFactory factory = new PodamFactoryImpl();
        Human human1 = factory.manufacturePojo(Human.class);
        Human human2 = factory.manufacturePojo(Human.class);
        Human human3 = factory.manufacturePojo(Human.class);

        human1.setAge(10);
        human2.setAge(12);
        human3.setAge(14);

        Assertions.assertTrue(LambdaDemon.isHumansHaveLessAge.apply(human1, human2, human3, 15));
        Assertions.assertFalse(LambdaDemon.isHumansHaveLessAge.apply(human1, human2, human3, 14));
        Assertions.assertFalse(LambdaDemon.isHumansHaveLessAge.apply(human1, human2, human3, 9));
    }
}

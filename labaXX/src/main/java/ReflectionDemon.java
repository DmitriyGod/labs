import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemon {
    public static int countHumans(List<?> objects) {
        if (objects == null) {
            return 0;
        }

        int count = 0;
        for (Object object : objects) {
            if ((object.getClass().getSimpleName().equals("Human"))) {
                count++;
            }
        }
        return count;
    }

    public static List<String> getPublicMethodsNames(Object object) {
        if (object == null) {
            return new ArrayList<>();
        }

        List<String> publicMethods = new ArrayList<>();
        Method[] methods = object.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if ((Modifier.isPublic(method.getModifiers()))) {
                publicMethods.add(method.getName());

            }
        }
        return publicMethods;
    }

    public static List<String> getParentClassesNames(Object object){
        if (object == null) {
            return new ArrayList<>();
        }

        List<String> parentClassesNames = new ArrayList<>();

        Class<?> parentClass = object.getClass().getSuperclass();
        while(parentClass != null){
            parentClassesNames.add(parentClass.getSimpleName());
            parentClass = parentClass.getSuperclass();
        }

        return parentClassesNames;
    }
}

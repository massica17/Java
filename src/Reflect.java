import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Reflect {
    @Test
    public  void testGetFields(){
        Class c = User.class;
        try{
            User u1 = (User) c.getConstructor().newInstance();
            User u2 = (User) c.getConstructor(String.class, int.class, Double.class, String.class).newInstance("adafs", 1, 1.0, "asdfasdf");
            System.out.println(u2);
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getType().getSimpleName() + " " + field.getName());
            }
            Field fname = c.getDeclaredField("Name");
            fname.setAccessible(true);
            fname.set(u2, "adfasdf");
            System.out.println(u2);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

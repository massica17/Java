package oralTest;

import Solutions.User;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Main {
    public static Unsafe createUnsafe() {
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void staticTest() throws Exception {
        // User user = new User();
        Unsafe unsafe = Main.createUnsafe();
        assert unsafe != null;
        System.out.println(unsafe.shouldBeInitialized(User.class));
        Field sexField = User.class.getDeclaredField("name");
        long fieldOffset = unsafe.staticFieldOffset(sexField);
        Object fieldBase = unsafe.staticFieldBase(sexField);
        Object object = unsafe.getObject(fieldBase, fieldOffset);
        System.out.println(object);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.staticTest();
    }
}

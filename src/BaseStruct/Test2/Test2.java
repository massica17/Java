package BaseStruct.Test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        String users = "10001:张三:男:1999-01-01#10002:李四:女:1299-12-01#10005:王五:男:1999-07-11#10001:张三:男:1999-01-01#10002:李四:女:1299-12-01#10005:王五:男:1999-07-11";
        String[] single = users.split("#");
        List<User> persons = new ArrayList<>();
        for(String info:single){
            persons.add(new User(info));
        }
        HashMap<String, Integer> count = new HashMap<>();
        for(User user : persons){
            count.put(user.getName(), count.getOrDefault(user.getName(), 1) + 1);
        }
        for(Map.Entry<String, Integer>  en : count.entrySet()){
            String name = en.getKey();
            int nums = en.getValue();
            System.out.printf("%s %d %n", name, nums);
        }
    }
}

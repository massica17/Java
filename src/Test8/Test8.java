package Test8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test8 {

    private int a = 0;
    public class Student{
        String name;
        List<String> choice;

        public Student(String name) {
            this.name = name;
            this.choice = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Test8 t = new Test8();
        Test8.Student student1 = t.new Student("zhang");
        Test8.Student student2 = t.new Student("li");
        Test8.Student student3 = t.new Student("cui");
        Test8.Student student4 = t.new Student("shuai");
        Test8.Student student5 = t.new Student("rong");
        student1.choice.add("1");
        student1.choice.add("2");
        student2.choice.add("3");
        student2.choice.add("2");
        student2.choice.add("4");
        student3.choice.add("2");
        student4.choice.add("3");
        student4.choice.add("4");
        student5.choice.add("1");
        List<Student> all = new ArrayList<>();
        all.add(student1);
        all.add(student2);
        all.add(student3);
        all.add(student4);
        all.add(student5);

        HashMap<String, Integer> act = new HashMap<>();
        int max = 0;
        String max_act = "";
        for (Student student : all) {
            for (int j = 0; j < student.choice.size(); j++) {
                if(max < act.getOrDefault(student.choice.get(j), 0) + 1){
                    max = act.getOrDefault(student.choice.get(j), 0) + 1;
                    max_act = student.choice.get(j);
                }
                act.put(student.choice.get(j), act.getOrDefault(student.choice.get(j), 0) + 1);
            }
        }
        System.out.printf("选择最多的活动是: %s 选择了%d次 %n", max_act, max);

        for(Student student : all){
            if(!student.choice.contains(max_act)){
                System.out.printf("%s没有选择%s %n", student.name, max_act);
            }
        }
    }
}

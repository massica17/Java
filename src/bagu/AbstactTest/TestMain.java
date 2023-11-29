package bagu.AbstactTest;

class Student implements Cloneable{
    public String name;
    public int age;

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student newStudent = (Student) super.clone();
        newStudent.name = new String("123");
        return newStudent;
    }
}
public class TestMain extends AbstractMain{
    public static void main(String[] args) {
    }
}
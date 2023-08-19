import java.io.Serializable;

public class User implements Serializable {
    private String Name;
    private int Age;
    private Double use;

    private transient String Password;

    public User(String name, int age, Double use, String password) {
        Name = name;
        Age = age;
        this.use = use;
        Password = password;
    }

    public User() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Double getUse() {
        return use;
    }

    public void setUse(Double use) {
        this.use = use;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", use=" + use +
                ", Password='" + Password + '\'' +
                '}';
    }
}

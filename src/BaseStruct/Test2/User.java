package BaseStruct.Test2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    private long id;
    private String name;
    private String gender;
    private LocalDate birthday;

    public User(long id, String name, String gender, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public User(String userInfo){
        String[] info = userInfo.split(":");
        this.id = Integer.parseInt(info[0]);
        this.name = info[1];
        this.gender = info[2];
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.birthday = LocalDate.parse(info[3], df);
    }

    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("%d:%s:%s:%s", this.id, this.name, this.gender, df.format(this.birthday));
    }
}

package BaseStruct.Test9;

public class Worker{
    private String name;
    private int money;

    public Worker(String name) {
        this.name = name;
        this.money = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

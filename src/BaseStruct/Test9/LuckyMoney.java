package BaseStruct.Test9;

public class LuckyMoney {
    private int money;
    private boolean been_get;

    public LuckyMoney(int money, boolean been_get) {
        this.money = money;
        this.been_get = been_get;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isBeen_get() {
        return been_get;
    }

    public void setBeen_get(boolean been_get) {
        this.been_get = been_get;
    }
}

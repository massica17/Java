import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String CardID;
    private int money;

    private int wants = 0;

    private final Lock lock = new ReentrantLock();
    public Account(String cardID, int money) {
        CardID = cardID;
        this.money = money;
    }


    public int getWants() {
        return wants;
    }

    public void setWants(int wants) {
        this.wants = wants;
    }

    public Account() {
    }

    public String getCardID() {
        return CardID;
    }

    public void setCardID(String cardID) {
        CardID = cardID;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public void takeMoney() {
        Thread t = Thread.currentThread();
        try{
            lock.lock();
            while(this.money >= this.wants){
                this.money = this.money - this.wants;
                System.out.printf("%s get money %d, leave %d %n", t.getName(), this.wants, this.money);
            }
            System.out.printf("%s failed leave %d %n", t.getName(), this.money);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}

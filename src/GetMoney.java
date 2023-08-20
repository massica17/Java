public class GetMoney extends Thread {
    private Account acc;
    public GetMoney(String name) {
        super(name);
    }

    public GetMoney(Account account, String name){
        super();
        this.acc = account;
        super.setName(name);
    }
    @Override
    public void run() {
        this.acc.takeMoney();
    }
}

package bagu.proxytest;

public class SmsSendServiceImpl implements SmsSendService{
    @Override
    public void send(String msg) {
        System.out.println("send message: " + msg);
    }

    @Override
    public String getMsg() {
        return "getMessage";
    }
}

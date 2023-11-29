package bagu.proxytest;

import java.lang.reflect.Proxy;

public class UseProxy {
    public static void main(String[] args) {
        SmsSendService smsSendService = (SmsSendService) ProxyFactory.getProxy(new SmsSendServiceImpl());
        smsSendService.send("java");
        System.out.println(smsSendService.getMsg());
        StringBuffer sb = new StringBuffer();
    }
}

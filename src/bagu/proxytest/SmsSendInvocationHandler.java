package bagu.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SmsSendInvocationHandler implements InvocationHandler {
    private final Object target;

    public SmsSendInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method " + method.getName());
        return result;
    }
}

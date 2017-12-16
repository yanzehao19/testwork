package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler {
    private Object target;
    public TransactionHandler(Object target){
        Super();
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务...");
        method.invoke(target);
        System.out.println("提交事务...");
        return null;
    }
}

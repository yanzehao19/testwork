package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[ ] args ){
        UserMgr userMgr=new UserMgrImpl();

        //1.第一层代理，通过动态代理，添加事务处理
        InvocationHandler handler=new TransactionHandler(userMgr);
        UserMgr userMgrProxy=(UserMgr) Proxy.newProxyInstance(userMgr.getClass().getClassLoader(),userMgr.getClass().getInterfaces(),handler);
        //2.第二层代理，通过动态代理，添加时间处理
        InvocationHandler handler2=new TimeHandler(userMgrProxy);
        UserMgr userMgrProxy2=(UserMgr) Proxy.newProxyInstance(userMgrProxy.getClass().getClassLoader(),userMgrProxy.getClass().getInterfaces(),handler2);
        userMgrProxy2.addUser();
        System.out.println("==============");
        userMgrProxy2.delUser();

    }

}

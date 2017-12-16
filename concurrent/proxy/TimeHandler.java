package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Calendar;

public class TimeHandler implements InvocationHandler {
    private Object target;
    public TimeHandler(Object target ){
        super();
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
        Canlendar canlendar= Calendar.getInstance();
        System.out.println("start time:"+canlendar.get(Calendar.HOUR_OF_DAY));
        method.invoke(target);
        System.out.println("end time:"+canlendar.get(Calendar.HOUR_OF_DAY));
        return null;
    }
}

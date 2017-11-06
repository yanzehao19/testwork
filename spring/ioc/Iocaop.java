package ioc;

import java.beans.VetoableChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.activiti.spring.ApplicationContextElResolver;

import com.sun.tools.xjc.be.Bind.Method;
import com.sun.tools.xjc.be.Element;
import com.thoughtworks.xstream.converters.javabean.BeanProperty;

import control.IfElse;
import iterator.pattern.Iterator;

public class Iocaop {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("application.xml");
		Animal animal = (Animal) context.getBean("animal");
		animal.say();

		if (beanProperty.element("map") != null) {
			Map<String, Object> propertiesMap = new HashMap<String, Object>();
			Element propertiesListMap = (Element) beanProperty.elements().get(0);
			Iterator<?> propertiesIterator = propertiesListMap.elements().iterator();
			while (propertiesIterator.hasNext()) {
				Element vElement = (Element) propertiesIterator.next();
				if (vet.getName().equals("entry")) {
					String key = vet.attributeValue("key");
					Iterator<?> valuesIterator = vet.elements().iterator();
					while (valuesIterator.hasNext()) {
						Element value = (Element) valuesIterator.next();
						if (value.getName().equals("value")) {
							propertiesMap.put(key, value.getText());

						}
						if (value.getName().equals("ref")) {
							propertiesMap.put(key, new String[] { value.attributeValue("value") });
						}
					}
				}
			}
		}

	}
	
	
	public static Object newInstance(String className){
		Class<?> cls=null;
		Object obj=null;
		try{
			cls=Class.forName(className);
			obj=cls.newInstance();
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e);
		}catch(InstantiationException e){
			throw new RuntimeException(e);
		}catch(IllegalAccessException e){
			throw new RuntimeException(e);
		}
		
		return obj;
	}
	
	public static void setProperty(Object obj,String name,String value){
		Class<? extends Object> clazz=obj.getClass();
		try{
			String methodName=returnSetMethodName(name);
			Method[] ms=clazz.getMethods();
			for(Method m:ms){
				if(m.getName().equals(methodName)){
					if(m.getParameterTypes().length==1){
						Class<?> clazzParameterType=m.getParameterTypes()[0];
						setFieldValue(clazzParameterType.getName(),value,m,obj);
						break;
					}
				}
			}
		}catch(SecurityException e){
			throw new RuntimeException(e);
		}catch(IllegalArgumentException e){
			throw new RuntimeException();
		}catch(IllegalAccessException e){
			throw new RuntimeException(e);
		}catch(InvocationTargetException e){
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
	if(value instanceof map){
		Iterator<?> entryIterator =((Map<?, ?>) value).entrySet().iterator();
		Map<String, Object> map=new HashMap<String ,Object>();
		while(entryIterator.hasNext()){
			Entry<?,?>entryMap=(Entry<?,?>)entryIterator.next();
			if(entryMap.getValue()instanceof String[]){
				map.put((String) entryMap.getKey(), getBean(((String[])entryMap.getValue())[0]]));
			}
		}
		BeanProcesser.setProperty(obj,property,map);
	}
	
	
	

}

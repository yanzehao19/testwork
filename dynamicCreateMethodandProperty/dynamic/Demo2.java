package dynamic;

import java.util.Arrays;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;

public class Demo2 {
	public static void main(String[] args) throws CannotCompileException, Exception {
		test06();
		}
	/**
     * 处理类的基本用法
     * @throws Exception 
     */
    public static void test01() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("dynamic.Emp");//获取已有的类

        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));

        System.out.println(cc.getName());//获取类名
        System.out.println(cc.getSimpleName());//获取简要类名
        System.out.println(cc.getSuperclass());//获取父类
        System.out.println(cc.getInterfaces());//获取接口
    }
    
    /**
     * 测试产生新的方法
     */
    public static void test02() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("dynamic.Emp");//获取已有的类
        //CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}", cc);
        //另一种方式，参数：返回类型，方法名，可变参数类型，CtClass对象
        CtMethod m = new CtMethod(CtClass.intType, "add", 
                new CtClass[]{CtClass.intType,CtClass.intType}, cc);

        m.setModifiers(javassist.Modifier.PUBLIC);
        m.setBody("{System.out.println(\"返回方法体中的打印信息\");return $1+$2;}");

        cc.addMethod(m);

        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();//调用Emp无参构造器，创建新的Emp对象
        java.lang.reflect.Method method = clazz.getDeclaredMethod("add", int.class,int.class);
        Object result = method.invoke(obj, 200,300);
        System.out.println(result);
    }
    
    /**
     * 修改已有方法的方法体内容
     * @throws Exception 
     */
    public static void test03() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("dynamic.Emp");//获取已有的类

        CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
        cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
        cm.insertAt(9, "int b=3;System.out.println(\"b=\"+b);");
        cm.insertAfter("System.out.println(\"end!!!\");");

        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();//调用Emp无参构造器，创建新的Emp对象
        java.lang.reflect.Method method = clazz.getDeclaredMethod("sayHello", int.class);
        method.invoke(obj, 300);
    }
    
    /**
     * 测试产生新的属性
     */
    public static void test04() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("dynamic.Emp");//获取已有的类

        //CtField f1 = CtField.make("private int salary;", cc);
        //另一种方式
        CtField f1 = new CtField(CtClass.intType, "salary",cc);
        f1.setModifiers(Modifier.PRIVATE);
        cc.addField(f1);

        //cc.getDeclaredField("salary");//获取指定的属性
        //另一种方式
        cc.addMethod(CtNewMethod.getter("getSalary", f1));
        cc.addMethod(CtNewMethod.getter("setSalary", f1));

        //通过反射调用，省略。。。
    }
    
    /**
     * 测试构造器
     */
    public static void test05() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("dynamic.Emp");//获取已有的类

        CtConstructor[] cs = cc.getConstructors();
        for (CtConstructor c : cs) {
            System.out.println(c.getLongName());
        }
    }
    /**
     * 测试注解
     */
    public static void test06() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("dynamic.Emp");//获取已有的类

        Object[] all = cc.getAnnotations();
        Author a = (Author) all[0];
        String name = a.name();
        int year = a.year();
        System.out.println("name:" + name + ",year:" + year);
    }
    
    
    
}

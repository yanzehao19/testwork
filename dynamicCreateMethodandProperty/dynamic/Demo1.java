package dynamic;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;

public class Demo1 {
	public static void main(String[] args) throws CannotCompileException, Exception {

		ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("dynamic.Emp");

        //创建属性
        CtField f1 = CtField.make("private int empno;",cc);
        CtField f2 = CtField.make("private String ename;",cc);
        cc.addField(f1);
        cc.addField(f2);

        //创建方法
        CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
        CtMethod m2 = CtMethod.make("public void setEmpno(){this.empno = empno;}", cc);
        cc.addMethod(m1);
        cc.addMethod(m2);

        //添加构造器
        CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")},cc);
        constructor.setBody("{this.empno = empno; this.ename = ename;}");
        cc.addConstructor(constructor);

        cc.writeFile("E:/Source/testwork");//将上面构造好的类写入到指定的工作空间中
        System.out.println("生成类，成功！");
		
	}
}

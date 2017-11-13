package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Description:定义注解
 * @ClasName:ZxfResource
 * @author lenovo
 *
 */
//在运行时执行
@Retention(RetentionPolicy.RUNTIME)
//注解使用地方（字段和方法）
@Target({ElementType.FIELD,ElementType.METHOD})

public @interface ZxfResource {
	//注解的name属性
	public String name() default "";
}

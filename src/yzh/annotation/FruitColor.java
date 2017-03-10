package yzh.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
  /*
   * 颜色枚举
   * @author yzh	
   */
	public enum Color{BULE,RED,GREEN};
	/*
	 * 颜色属性
	 */
	Color fruitColor() default Color.GREEN;
}

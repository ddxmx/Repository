package com.test.day10;

/**
 * 访问权限
 * private < 缺省 < protected < public
 * 修饰符	  当前类  同一包内  不同包子类  其他包
 * public	    Y	    Y	    Y	        Y
 * protected	Y	    Y		Y   	    N
 * default	    Y	    Y		N	        N
 * private	    Y	    N		N	        N
 * <p>
 * 可以修饰：类、类的内部结构（属性、方法、构造方法、内部类）
 * 类：public、缺省
 * 内部结构：public、protected、缺省、private
 */
public class AccessAuthorityDemo02 {
    public static void main(String[] args) {

    }
}

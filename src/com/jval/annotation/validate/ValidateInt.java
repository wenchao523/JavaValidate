/*
 * 文 件 名:  ValidateInt.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  文超
 * 创建时间:  2012-12-18 上午11:20:02  
 * 
 * 修改内容:  <修改内容>
 * 修改时间:  <修改时间>
 * 修改人:    <修改人>
 */
package com.jval.annotation.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <功能详细描述>
 * 
 * @author  文超
 * @version  [版本号, 2012-12-18 上午11:20:02 ]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateInt {
	
    int max() default Integer.MAX_VALUE;
    
    int min() default Integer.MIN_VALUE;
	
	String message() default "";
	
}

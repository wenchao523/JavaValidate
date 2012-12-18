/*
 * 文 件 名:  ClassFiledValue.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  文超
 * 创建时间:  2012-12-18 上午11:03:45  
 * 
 * 修改内容:  <修改内容>
 * 修改时间:  <修改时间>
 * 修改人:    <修改人>
 */
package com.jval.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.jval.core.AnnotationValidable;


/**
 * <功能详细描述>
 * 
 * @author  文超
 * @version  [版本号, 2012-12-18 上午11:03:45 ]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ClassFiledValue {

	/**
	 * <功能详细描述>
	 * 创 建 人:  文超
	 * 创建时间:  2012-12-18 上午11:08:38  
	 * @param filter
	 * @param fieldName
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @see [类、类#方法、类#成员]
	 */
	public static Object getClassFieldValue(AnnotationValidable filter,String fieldName) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		String firstLetter=fieldName.substring(0,1).toUpperCase();
		String methodName = "get"+firstLetter+fieldName.substring(1);
		Method method = filter.getClass().getMethod(methodName);
		Object value =method.invoke(filter);
		return value;
	}
}

/*
 * 文 件 名:  ValidateIntHandler.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  文超
 * 创建时间:  2012-12-18 下午02:05:49  
 * 
 * 修改内容:  <修改内容>
 * 修改时间:  <修改时间>
 * 修改人:    <修改人>
 */
package com.jval.annotation.handler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import org.apache.log4j.Logger;
import com.jval.annotation.validate.ValidateInt;
import com.jval.common.exception.ValidateException;
import com.jval.common.util.ClassFiledValue;
import com.jval.core.AnnotationValidable;


/**
 * <功能详细描述>
 * 
 * @author  文超
 * @version  [版本号, 2012-12-18 下午02:05:49 ]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ValidateIntHandler implements Handler {
   
	private static final Logger LOG =Logger.getLogger(ValidateIntHandler.class);
    
	/**
	 * 数据验证接口
	 * 创 建 人:  文超
	 * 创建时间:  2012-12-18 下午03:00:33  
	 * @param filter  验证的数据对象
	 * @param field   验证对象的属性名
	 * @throws ValidateException
	 * @see [类、类#方法、类#成员]
	 */
	@Override
	public void validate(AnnotationValidable filter,Field field) throws ValidateException {
	  Annotation[] s=field.getAnnotations();
	  System.out.println(s);
		if(field.isAnnotationPresent(ValidateInt.class)){
        	this.checkInt(filter, field);
        }
		
	}
	
	/**
	 * 整型的验证方法
	 * 创 建 人:  文超
	 * 创建时间:  2012-12-18 下午03:01:31  
	 * @param filter
	 * @param field
	 * @throws ValidateException
	 * @see [类、类#方法、类#成员]
	 */
	private void checkInt(AnnotationValidable filter, Field field)throws ValidateException {
		ValidateInt annot= field.getAnnotation(ValidateInt.class);
		int min = annot.min();
		int max = annot.max();
		String message =annot.message();
		Integer integer_value=null;
		try{
			integer_value =(Integer)ClassFiledValue.getClassFieldValue(filter, field.getName());
		}catch(Exception e){
			LOG.error(e.getMessage()+" 当前值转换为Integer类型异常", e);
			throw new ValidateException(e.getMessage(),e);
		}
		if(integer_value==null)return;
		int value = integer_value.intValue();
		if(value<min){
			LOG.error("当前值："+value+"，小于指定最小值"+min);
			throw new ValidateException(message+"当前值："+value+"，小于指定最小值"+min);
		}
		if(value>max){
			LOG.error("当前值："+value+"，大于指定最大值"+max);
			throw new ValidateException(message+"当前值："+value+"，大于指定最大值"+max);
		}
		
		
	}



}

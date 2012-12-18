/*
 * 文 件 名:  Handler.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  文超
 * 创建时间:  2012-12-18 上午11:09:12  
 * 
 * 修改内容:  <修改内容>
 * 修改时间:  <修改时间>
 * 修改人:    <修改人>
 */
package com.jval.annotation.handler;

import java.lang.reflect.Field;

import com.jval.common.exception.ValidateException;
import com.jval.core.AnnotationValidable;

/**
 * <功能详细描述>
 * 
 * @author  文超
 * @version  [版本号, 2012-12-18 上午11:09:12 ]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface Handler {
	
	/**
	 * 数据验证接口
	 * 创 建 人:  文超
	 * 创建时间:  2012-12-18 下午03:00:33  
	 * @param filter  验证的数据对象
	 * @param field   验证对象的属性名
	 * @throws ValidateException
	 * @see [类、类#方法、类#成员]
	 */
	public void validate(AnnotationValidable filter,Field field) throws ValidateException;
}

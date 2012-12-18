/*
 * 文 件 名:  IntegerBean.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  文超
 * 创建时间:  2012-12-18 下午03:05:54  
 * 
 * 修改内容:  <修改内容>
 * 修改时间:  <修改时间>
 * 修改人:    <修改人>
 */
package com.jval.test.bean;

import com.jval.annotation.validate.ValidateInt;
import com.jval.core.AnnotationValidable;

/**
 * <功能详细描述>
 * 
 * @author  文超
 * @version  [版本号, 2012-12-18 下午03:05:54 ]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class IntegerBean implements AnnotationValidable {

	@ValidateInt(min=18,max=50,message="年龄")
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}

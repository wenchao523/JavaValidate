/*
 * 文 件 名:  Validator.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  文超
 * 创建时间:  2012-12-18 下午02:37:26  
 * 
 * 修改内容:  <修改内容>
 * 修改时间:  <修改时间>
 * 修改人:    <修改人>
 */
package com.jval.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.jval.annotation.handler.Handler;
import com.jval.common.exception.ValidateException;
import com.jval.common.util.ClassFiledValue;

/**
 * <功能详细描述>
 * 
 * @author  文超
 * @version  [版本号, 2012-12-18 下午02:37:26 ]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Validator {

	private static final Logger LOG=Logger.getLogger(Validator.class);
	
	private Validator(){
		
	}
	
	private Validator validator=new Validator();
	
	public Validator getInstance(){
		return this.validator;
	}
	
	public final static String PREFIX = "Validate";
	
	public final static String SUFFIX = "Handler";
	
	@SuppressWarnings("unchecked")
	public void validate(AnnotationValidable validatedObj)throws ValidateException {
		if(null==validatedObj){
			LOG.info("验证的对象为空");
			return ;
		}
		
		Class curClass =validatedObj.getClass();
		while (null!=curClass) {
			Field[] fields = curClass.getDeclaredFields();
			for(Field field:fields){
				this.validateField(validatedObj, field);
			}
			Class supClass =curClass.getSuperclass();
			curClass = AnnotationValidable.class.isAssignableFrom(supClass)?supClass:null;
		}
	}
	
	private void validateField(AnnotationValidable validatedObj, Field field) throws ValidateException {
		if(AnnotationValidable.class.isAssignableFrom(field.getType())){
			Object destVal=null;
			try{
				destVal=ClassFiledValue.getClassFieldValue(validatedObj, field.getName());
			}catch(Exception e){
				LOG.error(e.getMessage(), e);
				throw new ValidateException(e.getMessage(),e);
			}
			if(null==destVal){
				return ;
			}else{
				this.validate((AnnotationValidable)destVal);
			}
		}
		
		List<Annotation> list = this.getValidateAnnotations(field);
		if(null==list ||list.size()<=0){
			return ;
		}
		for(Annotation annotation :list){
			String annotationName = annotation.annotationType().getName();
			String className = annotationName + SUFFIX;
			Handler handler = null;
			try {
				handler = (Handler) Class.forName(className).newInstance();
			} catch (Exception ex) {
				LOG.error("不能转动当前handler " + ex.getMessage(), ex);
				throw new ValidateException("不能转动当前handler " + ex.getMessage(), ex);
			}
			handler.validate(validatedObj, field);
		}
	}
	
	
	private List<Annotation> getValidateAnnotations(Field field) {
		List<Annotation> annotations = new ArrayList<Annotation>();
		Annotation[] annos = field.getAnnotations();
		for (Annotation elem : annos) {
			if (elem.annotationType().getSimpleName().startsWith(PREFIX)) {
				annotations.add(elem);
			}
		}
		return annotations;
	}
}

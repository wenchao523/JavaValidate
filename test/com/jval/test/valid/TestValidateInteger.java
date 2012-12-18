package com.jval.test.valid;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.jval.annotation.handler.Handler;
import com.jval.annotation.handler.ValidateIntHandler;
import com.jval.test.bean.IntegerBean;

public class TestValidateInteger {

	private String fieldName="age";
	private Handler handler = null;
	private IntegerBean bean =null;
	
	@Before
	public void setUp() throws Exception {
		handler =new  ValidateIntHandler();
		bean = new IntegerBean();
		bean.setAge(10);
	}

	@After
	public void tearDown() throws Exception {
	}
    
	@Test
	public void testValidate(){
		try {
			handler.validate(bean, bean.getClass().getDeclaredField(fieldName));
		} catch (Exception  e) {
			e.printStackTrace();
		} 
	}
}

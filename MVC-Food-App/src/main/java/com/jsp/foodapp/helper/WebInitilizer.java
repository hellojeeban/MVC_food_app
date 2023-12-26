package com.jsp.foodapp.helper;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] classes = {Config.class};
		return classes;
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}

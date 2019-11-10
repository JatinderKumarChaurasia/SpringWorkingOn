package com.jkc.SecurityApp.config;

import java.util.logging.Logger;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private Logger logger = Logger.getLogger(SpringMvcDispatcherServletInitializer.class.getName());

	@Override
	protected Class<?>[] getRootConfigClasses() {
		logger.info("\t Getting Root Config Classes -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		logger.info("\t Getting Servlet Config Classes -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		return new Class[]{AppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		logger.info("\t Getting Servlet Mappings -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		return new String[]{"/"};
	}

}

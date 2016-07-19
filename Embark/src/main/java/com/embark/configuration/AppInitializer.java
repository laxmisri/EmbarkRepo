/*package com.embark.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;

public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.setServletContext(container);
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		servlet.setInitParameter("com.sun.jersey.spi.container.ContainerResponseFilters", "com.embark.Configuration.CORSFilter");
		
	ServletRegistration.Dynamic dispatcher = container.addServlet("restful", new SpringServlet());
        dispatcher.setLoadOnStartup(2);
        dispatcher.addMapping("/rest/*");
        container.addListener(new ContextLoaderListener(ctx));
        
        
		
	}

}
*/


package com.embark.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;

public class AppInitializer implements WebApplicationInitializer {

 public void onStartup(ServletContext container) throws ServletException {

  
  AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
  
  ctx.register(AppConfig.class);
  
  ctx.setServletContext(container);
  
  ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
  servlet.setLoadOnStartup(1);
  servlet.addMapping("/");
  
  
  ServletRegistration.Dynamic dispatcher = container.addServlet("restful", new SpringServlet());
        dispatcher.setLoadOnStartup(2);
        dispatcher.addMapping("/rest/*");
        container.addListener(new ContextLoaderListener(ctx));
        dispatcher.setInitParameter("com.sun.jersey.spi.container.ContainerResponseFilters", "com.embark.configuration.CORSFilter");
        
  
 }

}
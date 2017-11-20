package com.micro.service.provider;

import com.alibaba.dubbo.remoting.http.servlet.BootstrapListener;
import com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.baomidou.mybatisplus.spring.boot.starter.MybatisPlusAutoConfiguration;
import com.micro.service.core.filter.RestfulRequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//
//@ImportResource(locations = {  "classpath:dao/spring-db.xml", "classpath:spring-properties.xml" })
@ImportResource(locations = { "classpath:dubbo-provider.xml", "classpath:dao/spring-db.xml", "classpath:spring-properties.xml" })
@SpringBootApplication // Spring Boot 应用的标识
@EnableAutoConfiguration(exclude = {MybatisPlusAutoConfiguration.class, DataSourceAutoConfiguration.class })
@EnableTransactionManagement
@ComponentScan(basePackages = "com.micro.service")
public class MicroProviderApplication extends SpringBootServletInitializer {



	private static volatile boolean running = true;

	public static void main(String[] args) {
		// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		try {
			SpringApplication.run(MicroProviderApplication.class, args);
			synchronized (MicroProviderApplication.class) {
				while (running) {
					MicroProviderApplication.class.wait();
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}




//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(MicroProviderApplication.class);
//	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		RestfulRequestFilter restfulRequestFilter = new RestfulRequestFilter();
		registrationBean.setFilter(restfulRequestFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean<BootstrapListener> servletListenerRegistrationBean() {
		return new ServletListenerRegistrationBean<BootstrapListener>(new BootstrapListener());
	}
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		DispatcherServlet dispatcherServlet = new DispatcherServlet() {
			private static final long serialVersionUID = 1L;

			protected void service(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");
				super.service(request, response);
			}
		};
		return new ServletRegistrationBean(dispatcherServlet, "/*");
	}




//	@Bean
//	public HttpMessageConverters fastJsonHttpMessageConverters(){
//		//1.需要定义一个convert转换消息的对象;
//		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//		//2:添加fastJson的配置信息;
//		FastJsonConfig fastJsonConfig =  new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//		//3处理中文乱码问题
//		List<MediaType> mediaTypes = new ArrayList<>();
//		mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//		//4.在convert中添加配置信息.
//		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//		fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
//		HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
//		return new HttpMessageConverters(converter);
//	}


}

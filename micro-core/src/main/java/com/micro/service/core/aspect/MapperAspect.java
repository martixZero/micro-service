package com.micro.service.core.aspect;

import com.micro.service.core.datasource.DataSourceSelector;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import com.micro.service.core.datasource.DataSourceHolder;
//import com.micro.service.core.datasource.DataSourceSelector

import java.lang.reflect.Method;

/**
 * 
 * @author Fermi(fermi@youleyu.com)
 * @date Aug 18, 2014
 * @desc
 */
public class MapperAspect{

	protected static Logger logger = LoggerFactory.getLogger(MapperAspect.class);

	private final static String DEFAULT_DATA_SOURCE_NAME = "master";
	
	@SuppressWarnings("all")
	public void before(JoinPoint point) throws Exception {
		//拦截的实体类
    		Object target = point.getTarget();
		//拦截的方法名称
		String methodName = point.getSignature().getName();
		//拦截的放参数类型
		Class[] parameterTypes = ((MethodSignature)point.getSignature()).getMethod().getParameterTypes();
		Class[] clazzs = target.getClass().getInterfaces();
		Class clazz = null;
		if (clazzs != null && clazzs.length > 0){
			clazz = clazzs[0];
		}
		
		if (clazz == null) {
			logger.info("master");

			//			DataSourceHolder.setDataSourceName(DEFAULT_DATA_SOURCE_NAME);
			return;
		}
		
		// 拿方法级别的注解
		Method m = clazz.getMethod(methodName, parameterTypes);

		if (m != null && m.isAnnotationPresent(DataSourceSelector.class)){
			DataSourceSelector ca = m.getAnnotation(DataSourceSelector.class);
			if (!StringUtils.isEmpty(ca.value())){
				logger.info(ca.value());
				DataSourceHolder.setDataSourceName(ca.value());
				return;
			}
		}
		
		// 拿到类级别的注解
		DataSourceSelector can = (DataSourceSelector) clazz.getAnnotation(DataSourceSelector.class);
		if(can != null && !StringUtils.isEmpty(can.value())){
			logger.info(can.value());
			DataSourceHolder.setDataSourceName(can.value());
			return;
		}
		
		// 都没有默认用master
		logger.info("master");
		DataSourceHolder.setDataSourceName(DEFAULT_DATA_SOURCE_NAME);
	}


}

package com.micro.service.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Fermi(fermi@youleyu.com)
 * @date Aug 18, 2014
 * @desc
 */
public class ControllerAspect {

	protected Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

	/**
	 * 日志添加
	 * 
	 * @Title: before
	 * @Description: 请求前
	 * @param @param joinpoint
	 * @return void 返回类型
	 * @throws
	 */
	public void before(JoinPoint joinpoint) {

		// 此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
		Object[] args = joinpoint.getArgs();

		if (args != null && args.length > 0) {
			
			if (args[0] instanceof HttpServletRequest) {
				HttpServletRequest request = (HttpServletRequest) args[0];
				this.logRequestParams(request);
			}else{
				String logmsg="method:"+joinpoint.getSignature().getName()+",args:";
				for (int i = 0; i < joinpoint.getArgs().length; i++) {
					logmsg+=joinpoint.getArgs()[i].toString();
				}
				logger.info(logmsg);
			}
		}
	}

	private void logRequestParams(HttpServletRequest request) {
		logger.info("Request URI: " + request.getRequestURI());
	}


	/**
	 * @Title: after
	 * @Description: 返回的日志
	 * @param @param joinpoint
	 * @return void 返回类型
	 * @throws
	 */
	public void after(JoinPoint joinpoint) {

		// 后处理

//        SysLog log = new SysLog();
//        log.setLogUserId(0l);
//        log.setLogUserName("fjalksdfjdsklafjdsklfjdkslfjdksafkl");
//        log.setLogUserIp("");
//        log.setLogOptDate(new Date());
//        log.setLogOptParams("");
//        log.setLogOptDesc("");
//        log.setLogRequestUri("");
//        log.setLogOptResult("");
//
//        APIResponse apiResponse = sysLogService.addLog(log);

	}

	/**
	 * 异常处理
	 * 
	 * @Title: doWriteErrorLog
	 * @Description: 异常时处理
	 * @param @param joinpoint
	 * @param @param exception
	 * @return void 返回类型
	 * @throws
	 */
	public void doWriteErrorLog(JoinPoint joinpoint, Exception exception) {

		String className = joinpoint.getTarget().getClass().getName();// 类名
		String methodName = joinpoint.getSignature().getName();// 方法名字

		// 控制台输出
		// exception.printStackTrace();
		// 增加CACTI监控

		String content = "--------------------------------reqlog. Exception error class "
				+ className
				+ "_"
				+ methodName
				+ "====== message ======"
				+ exception.getMessage();
		//QMonitor.recordOne(className + "_" + methodName + "error"); // 类异常
		// 可以增加一个分析日志的模块，进行分析（相关说明）
		logger.error(content);
        logger.error("", exception);
	}

}

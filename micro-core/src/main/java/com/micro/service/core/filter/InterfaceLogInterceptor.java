//package com.micro.service.core.filter;
//
//import java.lang.reflect.Method;
//import java.util.LinkedHashSet;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Set;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.dao.DataAccessException;
//import org.springframework.stereotype.Component;
//
//import com.alibaba.dubbo.rpc.RpcException;
//import com.weiyan.risk.service.outside.entity.EntityRiskInfo;
//import com.weiyan.risk.service.outside.response.BaseResponse;
//
///**
// * 拦截器：记录各个接口调用请求参数，性能统计
// *
// * @author song
// */
//@Aspect
//@Component
//public class InterfaceLogInterceptor {
//	private static final Logger logger = LoggerFactory.getLogger(InterfaceLogInterceptor.class);
//	private static final ObjectMapper mapper = new ObjectMapper();
//
////    @Value("${spring.profiles}")
////    private String env;
//
//	/**
//	 * 定义拦截规则：拦截com.weiyan.risk.applyservice.impl包下面的所有类
//	 */
//	@Pointcut("execution(* com.micro.service..impl..*(..))")
//	public void interfaceMethodPointcut() {
//	}
//
//	/**
//	 * 拦截器具体实现
//	 *
//	 * @param pjp
//	 * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
//	 * @throws Throwable
//	 */
//	@SuppressWarnings("unchecked")
//	@Around("interfaceMethodPointcut()") // 指定拦截器规则；也可以直接把“execution(* com.xjj.........)”写进这里
//	public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
//		long beginTime = System.currentTimeMillis();
//		MethodSignature signature = (MethodSignature) pjp.getSignature();
//		Method method = signature.getMethod(); // 获取被拦截的方法
//		String methodName = method.getName(); // 获取被拦截的方法名
//
//		Set<Object> allParams = new LinkedHashSet<>(); // 保存所有请求参数，用于输出到日志中
//
//		logger.info("请求开始，方法：{}", methodName);
//
//		Object result = null;
//
//		Object[] args = pjp.getArgs();
//		for (Object arg : args) {
//			// logger.debug("arg: {}", arg);
//			if (arg instanceof Map<?, ?>) {
//				// 提取方法中的MAP参数，用于记录进日志中
//				Map<String, Object> map = (Map<String, Object>) arg;
//
//				allParams.add(map);
//			} else if (arg instanceof HttpServletRequest) {
//				HttpServletRequest request = (HttpServletRequest) arg;
////				if (isLoginRequired(method)) {
////					if (!isLogin(request)) {
////						result = new JsonResult(ResultCode.NOT_LOGIN, "该操作需要登录！去登录吗？\n\n（不知道登录账号？请联系老许。）", null);
////					}
////				}
//
//				// 获取query string 或 posted form data参数
//				Map<String, String[]> paramMap = request.getParameterMap();
//				if (paramMap != null && paramMap.size() > 0) {
//					allParams.add(paramMap);
//				}
//			} else if (arg instanceof HttpServletResponse) {
//				// do nothing...TODO----useless
//				HttpServletResponse response = (HttpServletResponse)arg;
//				logger.info("响应内容: status:{}, headers:{}, content:{}",response.getStatus(),response.getHeaderNames(),response.getContentType());
//			} else {
//				allParams.add(arg);
//			}
//		}
//
//		try {
//			if (result == null) {
//				// 一切正常的情况下，继续执行被拦截的方法
//				result = pjp.proceed();
//			}
//		} catch (Throwable e) {
//			logger.info("请求参数: {}", mapper.writeValueAsString(allParams));
//			logger.error("exception: ", e.getMessage());
//			e.printStackTrace();
//			Class<?> returnType = signature.getReturnType();
////			if(returnType.equals(BaseResponse.class)) {
////				if(e instanceof RpcException) return new BaseResponse(-1, "调用服务异常");;
////				if(e instanceof DataAccessException)	return new BaseResponse(-1, "数据异常");
////				return new BaseResponse(-1, "服务器内部错误");
////			}
//			throw e;
//		}
//		long costMs = System.currentTimeMillis() - beginTime;
//		logger.info("{}请求结束，耗时：{}ms", methodName, costMs);
////		if(result instanceof LinkedList)	{
////			logger.info("响应结果: {}", mapper.writeValueAsString((LinkedList<EntityRiskInfo>)result));
////		}
////		if(result instanceof BaseResponse)	{
////			logger.info("响应结果: {}", mapper.writeValueAsString((BaseResponse)result));
////		}
//		return result;
//
//	}
//
//}
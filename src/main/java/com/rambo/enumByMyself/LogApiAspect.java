package com.rambo.enumByMyself;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 枚举aop
 * @author ：baizhanshi
 * @date ：Created in 2021/3/20
 */
@Slf4j
@Aspect
@Component
public class LogApiAspect {
    //切面点为标记了@LogApi注解的方法
    @Pointcut("@annotation(com.rambo.enumByMyself.LogApi)")
    public void logApi() {
    }

    //环绕通知
    @Around("logApi()")
    @SuppressWarnings("unchecked")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long starTime = System.currentTimeMillis();
        HttpServletRequest request = RequestUtils.getHttpServletRequest();
        //请求URL
        String requestURL = request.getRequestURI();
        //请求IP
        String ip = RequestUtils.getIp(request);
        //通过反射获取被调用方法的Class
        Class type = joinPoint.getSignature().getDeclaringType();
        //获取类名
        String typeName = type.getSimpleName();
        //方法名
        String methodName = joinPoint.getSignature().getName();
        //获取参数列表
        Object[] args = joinPoint.getArgs();
        //参数Class的数组
        Class[] clazz = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            clazz[i] = args[i].getClass();
        }
        //通过反射获取调用的方法method
        Method method = type.getMethod(methodName, clazz);
        //获取方法的参数
        Parameter[] parameters = method.getParameters();
        //拼接字符串，格式为{参数1:值1,参数2::值2}
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            String name = parameter.getName();
            sb.append(name).append(":").append(args[i]).append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        //执行结果
        Object res;
        try {
            //执行目标方法，获取执行结果
            res = joinPoint.proceed();
            log.info("调用{}.{}方法成功，参数为[{}]，返回结果[{}]", typeName, methodName, sb.toString(), JSONObject.toJSONString(res));
            log.info("请求URI: {}, 请求IP：{}， 最大内存: {}, 已分配内存: {}, 已分配内存中的剩余空间: {}, 最大可用内存: {} ",
                    requestURL, ip,
                    Runtime.getRuntime().maxMemory() / 1024 / 1024, Runtime.getRuntime().totalMemory() / 1024 / 1024,
                    Runtime.getRuntime().freeMemory() / 1024 / 1024, (Runtime.getRuntime().maxMemory()
                            - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory()) / 1024 / 1024);
        } catch (Exception e) {
            log.error("调用{}.{}方法发生异常", typeName, methodName);
            //如果发生异常，则抛出异常
            throw e;
        } finally {
            log.info("调用{}.{}方法，耗时{}ms", typeName, methodName, (System.currentTimeMillis() - starTime));
        }
        //返回执行结果
        return res;
    }
}

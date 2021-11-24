package com.troyqu.annotation.aop.interceptor.interceptor;

import com.troyqu.annotation.aop.interceptor.annotation.LoggerAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;

/**
 * @Author qujianfei
 * @Date 2021/9/6
 * @Time 下午5:41
 */
@Component
public class LoggerInterceptor implements WebRequestInterceptor {

    private Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

//    springboot 2.1.x版本中处理preHandler和postHandler的方式
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HandlerMethod handlerMethod = (HandlerMethod)handler;
//        Method method = handlerMethod.getMethod();
//        //获取当前方法上的指定注解
//        LoggerAnnotation loggerAnnotation = method.getAnnotation(LoggerAnnotation.class);
//        //判断当前注解是否存在
//        if(loggerAnnotation != null){
//            long startTime = System.currentTimeMillis();
//            request.setAttribute("startTime",startTime);
//            logger.info("进入" + method.getName() + "方法的时间是：" + startTime);
//        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerMethod handlerMethod = (HandlerMethod)handler;
//        Method method = handlerMethod.getMethod();
//        //获取当前方法上的指定注解
//        LoggerAnnotation loggerAnnotation = method.getAnnotation(LoggerAnnotation.class);
//        //判断当前注解是否存在
//        if(loggerAnnotation != null){
//            long endTime = System.currentTimeMillis();
//            long startTime = (Long) request.getAttribute("startTime");
//            long periodTime = endTime - startTime;
//            logger.info("离开" + method.getName() + "方法的时间是：" + endTime);
//            logger.info("在" + method.getName() + "方法的时长是：" + periodTime);
//        }
//    }

    /**
     * springboot 2.5.x版本中处理preHandler和postHandler的方式
     * 缺点：先拦截所有方法，然后进行判断是否方法有LoggerAnnotation注解，不够高效
     *
     * @param request
     * @throws Exception
     */
    @Override
    public void preHandle(WebRequest request) throws Exception {
        logger.info("come in process preHandler");
        //scope=0表示从request中获取属性，scope!=0表示从session中获取属性
        Object object = request.getAttribute("org.springframework.web.servlet.HandlerMapping.bestMatchingHandler", 0);
        if (object instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) object;
            Method method = handlerMethod.getMethod();
            LoggerAnnotation annotation = method.getAnnotation(LoggerAnnotation.class);
            if (null != annotation) {
                logger.info("preHandler method " + method.getName() + " with LoggerAnnotation annotation");
            }
        } else {
            logger.info("request handler mapper is not instance of HandlerMethod skip LoggerInterceptor");
        }

    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        logger.info("come in process postHandler");

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        logger.info("come in process afterCompletion");

    }
}

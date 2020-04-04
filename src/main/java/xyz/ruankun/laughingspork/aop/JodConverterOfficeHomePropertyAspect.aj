package xyz.ruankun.laughingspork.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ��ʱδʵ�֣��������⣬������ȥ
 * 2019-12-21
 */
@Aspect
@Component
public class JodConverterOfficeHomePropertyAspect {

    public final static Logger logger = LoggerFactory.getLogger(JodConverterOfficeHomePropertyAspect.class);


    @Pointcut(value = "execution(public void org.jodconverter.boot.autoconfigure.JodConverterProperties.setOfficeHome(java.lang.String))")
    public void pointCut(){}


    @Around("pointCut() && execution(public void org.jodconverter.boot.autoconfigure.JodConverterProperties.setOfficeHome(java.lang.String))")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint){
        Object[] path = proceedingJoinPoint.getArgs();
        System.out.println("���سɹ���");
        System.out.println(path);
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @AfterReturning(value = "execution(public void org.jodconverter.boot.autoconfigure.JodConverterProperties.setOfficeHome(java.lang.String)))")
    public void after(){
        System.out.println("after did here");
    }

}

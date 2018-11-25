package spittr.AspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
public class LogProcess {

    private final static Logger logger = LoggerFactory.getLogger(LogProcess.class);

    @Pointcut("execution(* spittr.web..*.*(..))")
    public void controlProcess(){}

    @Around("controlProcess()")
    public void watchPerformance(ProceedingJoinPoint jp){
        try {
            System.out.println("切面-日志");
            logger.info(Arrays.toString(jp.getArgs()));
            Object object=jp.proceed();
            logger.info((String) object);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}

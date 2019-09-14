package us.martink.uniquex.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Aspect
@Component
public class SortAlgorithmTimer {
    @Pointcut("execution(* us.martink.uniquex.sort.*.*(..))")
    public void businessMethods() { }

    @Around("businessMethods()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        int count = ((List<Object>)pjp.getArgs()[0]).size();
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        log.info("Sort execution time {}ms for {} records", System.currentTimeMillis() - start, count);
        return output;
    }

}

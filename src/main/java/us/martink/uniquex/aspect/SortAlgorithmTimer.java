package us.martink.uniquex.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

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
        System.out.println("Sort execution time " +  (System.currentTimeMillis() - start) + "ms for " + count + " records");
        return output;
    }

}

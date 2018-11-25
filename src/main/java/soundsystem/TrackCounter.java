package soundsystem;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 演示切面使用被通知方法的参数
 * 在切点@Pointcut中指定参数，在通知中使用参数
 */
@Aspect
@Component
public class TrackCounter {
    private Map<Integer,Integer> trackCounts=new HashMap<>();

    @Pointcut("execution(* soundsystem.CompactDisc.playTrack(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber){}

    @Around("trackPlayed(trackNumber)")
    public void countTrack(ProceedingJoinPoint jp, int trackNumber){

        try {
            int currentCount=getPlayCount(trackNumber);
            this.trackCounts.put(trackNumber,currentCount+1);
            jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            System.out.println("applause");

        }
    }

    @Before("execution(* soundsystem.CompactDisc.play(..))")
    public void slient(){
        System.out.println("stay slient ==");

    }

    @Before("execution(* soundsystem.HadoopIsFirst.when(..))")
    public void record(){
        System.out.println("just for test");

    }


    public int getPlayCount(int trackNumber) {
        return this.trackCounts.containsKey(trackNumber)?this.trackCounts.get(trackNumber):0;
    }
}

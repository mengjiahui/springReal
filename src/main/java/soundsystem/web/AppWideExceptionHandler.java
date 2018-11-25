package soundsystem.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制器通知，由@ControllerAdvice注解
 * 这个类中的由@ExceptionHandler注解的方法，会运用到整个应用所有控制器带@RequestMapping注解的方法上
 */

@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(SpittleNotFoundException.class)
    public String duplicateSpittleHandler() {
        return "errors/duplicate";
    }
}

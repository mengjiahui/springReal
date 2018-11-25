package soundsystem.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 将异常映射为状态码
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException{
}

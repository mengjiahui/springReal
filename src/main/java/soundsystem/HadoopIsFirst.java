package soundsystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HadoopIsFirst {
    @RequestMapping(value = "/toKnow",method = RequestMethod.GET)
    public String when(){
        return "success";
    }
}

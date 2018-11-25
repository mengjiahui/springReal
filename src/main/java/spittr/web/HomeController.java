package spittr.web;


/**
 * 以下演示了最基本的控制器
 */
//@Controller
//public class HomeController {
//
//    @RequestMapping(value = "/",method =GET)
//    public String home(){
//        return "home";
//    }
//
//}

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 拆分@RequestMapping,将其一部分放到类上
 * @RequestMapping的value属性可接受数组
 */
@Controller
@RequestMapping({"/getHappy","/getHappyToo"})
public class HomeController {

    @RequestMapping(method =GET)
    public String home(){
        return "success";
    }

}

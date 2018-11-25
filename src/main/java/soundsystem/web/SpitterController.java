package soundsystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/spitter")
public class SpitterController {

//    private SpitterRepository spitterRepository;
//
//    public SpitterController(SpitterRepository spitterRepository) {
//        this.spitterRepository = spitterRepository;
//    }

    /**
     * 获取注册使用到表单
     * @param model
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    /**
     * InternalResourceViewResolver看见前缀redirect:就知道需要重定向，
     * 类似看见forward:就知道要转发
     * @param
     * @return
     */
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
////    public String processRegistration(Spitter spitter) {
//    public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture,
//                                      @Valid Spitter spitter, Errors errors) {//@Valid校验spitter输入
//        if(errors.hasErrors()) {
//            return "registerForm";
//        }
//        if(spitter.getUsername()==null || "".equals(spitter.getUsername()))
//            throw new SpittleNotFoundException();
//
//        System.out.println(profilePicture.getName()+","+profilePicture.getOriginalFilename()+
//        ","+profilePicture.getContentType()+","+profilePicture.getSize());
//        try {
//            profilePicture.transferTo(new File("/opt/spittr/"+profilePicture.getOriginalFilename()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        this.spitterRepository.save(spitter);
//        return "redirect:/spitter/"+spitter.getUsername();
//    }

    /**
     * Model替换为RedirectAttributes,可设置flash属性，用于重定向传递数据
     * @param spitter
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(Spitter spitter, RedirectAttributes model) {

        System.out.println(spitter);
        model.addAttribute("username",spitter.getUsername());//普通的
        model.addFlashAttribute("spitter",spitter);//Flash
        return "redirect:/spitter/"+spitter.getUsername();

    }



    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
//        Spitter spitter=this.spitterRepository.findByUsername(username);
        System.out.println("username还在不？"+model.containsAttribute("username"));
        System.out.println("spitter还在不？"+model.containsAttribute("spitter"));

        return "profile";
    }

    @RequestMapping(value = "/addSpitter")
    public String addSpitter(){
        throw new SpittleNotFoundException();
    }

//    @ExceptionHandler(SpittleNotFoundException.class)
//    public String handleDuplicateSSpittle(){
//        return "error/duplicate";
//    }


}

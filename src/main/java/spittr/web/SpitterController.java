package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;


@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    /**
     * InternalResourceViewResolver看见前缀redirect:就知道需要重定向，
     * 类似看见forward:就知道要转发
     * @param spitter
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String processRegistration(Spitter spitter) {
    public String processRegistration(@Valid Spitter spitter, Errors errors) {//@Valid校验spitter输入
        if(errors.hasErrors()) {
            return "registerForm";
        }

        this.spitterRepository.save(spitter);
        return "redirect:/spitter/"+spitter.getUsername();
    }

    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
//        Spitter spitter=this.spitterRepository.findByUsername(username);
        Spitter spitter=new Spitter("jbauer","24hours","Jack","Bauer");
        model.addAttribute(spitter);
        return "profile";
    }

}

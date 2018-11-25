package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SpitterCrudController {

    private SpitterRepository spitterRepository;

    public SpitterCrudController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    @ResponseBody
    public String processRegistration(Spitter spitter) {
        this.spitterRepository.save(spitter);
        return "{success:false,msg:\"执行失败!\"}";
    }

    @RequestMapping("/showUser")
    public @ResponseBody List<Spitter> showSpitterProfile() {
        List<Spitter> spitterList = new ArrayList<>();
//        Spitter spitter = this.spitterRepository.findByUsername(null);
        Spitter spitter1 =new Spitter("f1","l1", "u1", "p1", "e1");
        Spitter spitter2 =new Spitter("f2","l2", "u2", "p2", "e2");
        spitterList.add(spitter1);
        spitterList.add(spitter2);
        System.out.println(spitterList);
        return spitterList;

    }


}

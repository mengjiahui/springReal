package spittr.web;
//
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleRepository;
//
import java.util.List;
//
import static org.springframework.web.bind.annotation.RequestMethod.GET;

//
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    //
//    /**
//     * model可将模型传递给视图，实际上是个map
//     * 当不设置key时，model根据数据类型推断，如本例中是个List<Spittle>,key推断为spittleList
//     * @param model
//     * @return
//     */
    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Map model) {
//        model.put("spittleList", this.spittleRepository.findSpittles(Long.MAX_VALUE, 20));
    public String spittles(Model model) {
        model.addAttribute("spittleList", this.spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }
//
//    /**
//     * 下面演示可替代方案：不返回视图名称，不显事设定模型，返回对象或者集合，
//     * 返回值会放到模型中，根据数据类型推断得出key,根据请求路径推断出逻辑视图名称：因为该方法处理"/spittles"的get请求，故为spittles（去掉／）
//     */
////    @RequestMapping(method = GET)
////    public List<Spittle> spittles(){
////        return this.spittleRepository.findSpittles(Long.MAX_VALUE,20);
////    }
//
    private static final String MAX_LONG_AS_STRIN= "999999999";//Long.toString(Long.MAX_VALUE);
//
    //演示了接受查询参数
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public String spittles(@RequestParam(value = "max",defaultValue = MAX_LONG_AS_STRIN) long max,
                                  @RequestParam(value = "count",defaultValue = "20") int count,Model model){
        model.addAttribute("spittleList",this.spittleRepository.findSpittles(max,count));
        return "spittles";
    }

//    //演示通过路径参数接受输入：这个方法将会处理"/spittles/show?spittle_id=123456",是个带参数的操作
//    @RequestMapping(value = "/show",method = RequestMethod.GET)
//    public String showSpittle(@RequestParam("spittle_id") long spittleId, Model model){
//        model.addAttribute(spittleRepository.findOne(spittleId));
//        return "spittle";
//    }
//
    /**
     * 演示通过路径变量接受输入：使用占位符
     * 这个方法将会处理"/spittles/123456",url识别资源
     * 占位符名字和@PathVariable相同时，@PathVariable可省略名字
     * 这种适用于数据少的时候
     * @param spittleId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{spittle_id}",method = RequestMethod.GET)
    public String spittle(@PathVariable("spittle_id") long spittleId, Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittles";
    }
//
//    /**
//     * 数据量大的时候使用表单
//     */
}

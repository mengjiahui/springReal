package spittr.web;
//
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
///**
// * 从Spring3.2开始，可使用MockMvc测试Spring MVC的控制器，不必再启动Web服务器和Web浏览器了
// * 对"/"发起了GET请求，并断言结果视图的名称为home
// *
// * Mockito框架使用
// */
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception{
        HomeController controller=new HomeController();
        MockMvc mockMvc=standaloneSetup(controller).build();
        mockMvc.perform(get("/getHappy")).andExpect(view().name("happy"));
    }
}

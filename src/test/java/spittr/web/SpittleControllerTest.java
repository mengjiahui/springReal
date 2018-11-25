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
public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception{
        List<Spittle> expectedSpittles= createSpittleList(20);
        SpittleRepository mockRepository =mock(SpittleRepository.class);
        //猜测意思是：调用方法findSpittles(Long.MAX_VALUE,20)时响应expectedSpittles
        when(mockRepository.findSpittles(999999999,20)).thenReturn(expectedSpittles);
        SpittleController controller=new SpittleController(mockRepository);
        MockMvc mockMvc=standaloneSetup(controller)
                //调用setSingleView()，mock框架就不会解析控制器的视图名了
                .setSingleView(
                        new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        //以下代码演示传入查询参数，用于分页
        mockMvc.perform(get("/spittles/getList?max=238900&count=30"))
//        mockMvc.perform(get("/spittles/getList"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",
                        hasItems(expectedSpittles.toArray())));



    }
//
//
    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles=new ArrayList<Spittle>();
        for (int i=0;i<count;i++){
            spittles.add(new Spittle("Spittle"+i,new Date()));
        }
        return spittles;
    }
//
//
//
    @Test
    public void testSpittle() throws Exception{
        Spittle expectedSpittle=new Spittle("Hello",new Date());
        SpittleRepository mockRepository =mock(SpittleRepository.class);
        when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
        SpittleController controller=new SpittleController(mockRepository);
        MockMvc mockMvc=standaloneSetup(controller).build();
        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));

    }
//
}

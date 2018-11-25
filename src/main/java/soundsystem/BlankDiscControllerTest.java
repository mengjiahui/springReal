package soundsystem;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class BlankDiscControllerTest {

    @Test
    public void testPlayOnly() throws Exception{
        BlankDisc cdController=new BlankDisc();
        MockMvc mockMvc=standaloneSetup(cdController).build();
        mockMvc.perform(get("/playOnly")).andExpect(view().name("success"));
    }
}

package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    @Test
    public void shouldProcessRegistration() throws Exception{
        SpitterRepository mockRepository=mock(SpitterRepository.class);
        Spitter unsaved=new Spitter("jbauer","24hours","Jack","Bauer");
        Spitter saved=new Spitter(24L,"jbauer","24hours","Jack","Bauer");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller=new SpitterController(mockRepository);
        MockMvc mockMvc=standaloneSetup(controller).build();
        mockMvc.perform(post("/spitter/register")
                .param("firstName","")
                .param("lastName","Bauer")
                .param("username","jbauer")
                .param("password","24hours"))
//                .param("firstName","Jack")
//                .param("lastName","Bauer")
//                .param("username","jbauer")
//                .param("password","24hours"))
        .andExpect(redirectedUrl("/spitter/jbauer"));
        verify(mockRepository,atLeastOnce()).save(unsaved);
    }
}

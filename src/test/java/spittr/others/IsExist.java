package spittr.others;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.RootConfig;
import spittr.AspectJ.LogProcess;
import spittr.config.AspectJConfig;
import spittr.data.SpitterRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)//在测试开始的时候自动创建Spring的应用上下文
@ContextConfiguration(classes = {AspectJConfig.class, RootConfig.class})//从AspectJConfig中加载配置
@ActiveProfiles("dev")//指定运行测试时激活哪个profile
public class IsExist {

    @Rule
    public final StandardOutputStreamLog log=new StandardOutputStreamLog();
    @Autowired
    private LogProcess logProcess;
    @Autowired
    private SpitterRepository repository;


    @Test
    public void logProcessShouldNotBeNull(){
        assertNotNull(logProcess);

    }
    @Test
    public void logProcessEmbark(){
        repository.markAnything();
        assertEquals("just for test\n",log.getLog());

    }
}

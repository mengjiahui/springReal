//package soundsystem;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotNull;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TrackCounterConfig.class)
//public class TrackCounterTest {
//    @Rule
//    public final StandardOutputStreamLog log=new StandardOutputStreamLog();
//    @Autowired
//    private CompactDisc cd;
//    @Autowired
//    private TrackCounter counter;
//
//    @Test
//    public void counterShouldNotIsNull(){
//        assertNotNull(this.counter);
//    }
//
//    @Test
//    public void testTrackCounter(){
//        this.cd.playTrack(1);
//        this.cd.playTrack(1);
//        this.cd.playTrack(2);
//        this.cd.playTrack(4);
//        this.cd.playTrack(6);
//        this.cd.playTrack(6);
//
//        assertEquals(2,this.counter.getPlayCount(1));
//        assertEquals(1,this.counter.getPlayCount(2));
//        assertEquals(0,this.counter.getPlayCount(3));
//        assertEquals(1,this.counter.getPlayCount(4));
//        assertEquals(2,this.counter.getPlayCount(6));
//    }
//
//    @Test
//    public void testPlay(){
//        this.cd.play();
//    }
//
//
//
//}

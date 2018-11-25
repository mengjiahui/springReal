//package soundsystem;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * spring DI有2种方式：JavaConfig和自动注入
// * JavaConfig需要@Bean和@Autowired
// * 自动注入需要@ComponentScan,@Component(使用默认构造器)和@Autowired
// */
//@Configuration
//@EnableAspectJAutoProxy
//@ComponentScan
//public class TrackCounterConfig {
//
////    @Bean
////    public CompactDisc sgtPeppers() {
////        BlankDisc cd = new BlankDisc();
////        cd.setTitle("《呸》");
////        cd.setArtist("蔡依林");
////        List<String> tracks = new ArrayList<>();
////        tracks.add("《第二性》");
////        tracks.add("《Play 我呸》");
////        tracks.add("《美杜莎》");
////        tracks.add("《唇语》");
////        tracks.add("《I'm Not Yours》");
////        tracks.add("《自爱自受》");
////        tracks.add("《Miss Trouble》");
////        tracks.add("《电话皇后》");
////        tracks.add("《第三人称》");
////        tracks.add("《不一样又怎样》");
////        cd.setTracks(tracks);
////        return cd;
////
////    }
//
//    /**
//     * 即使有@Aspect,该@Bean也是必需的
//     * @return
//     */
////    @Bean
////    public TrackCounter trackCounter() {
////        return new TrackCounter();
////    }
//}

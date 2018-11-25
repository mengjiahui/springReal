package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * 声明为@Controller的类不能有继承关系，否则创建失败 ==没异常
 */
//@Controller
@Component
public class BlankDisc implements CompactDisc{
    private String title;
    private String artist;
    private List<String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks=tracks;
    }


    public BlankDisc() {
        this.title="Don't Stop";
        this.artist="蔡依林";
        List<String> tracks = new ArrayList<>();
        tracks.add("《Because of You》");
        tracks.add("《猜想》");
        tracks.add("《空白》");
        tracks.add("《怪我太年轻》");
        tracks.add("《和世界做邻居》");
        tracks.add("《我知道你很难过》");
        tracks.add("《你是谁》");
        tracks.add("《上街》");
        tracks.add("《Good-bye》");
        tracks.add("《The Rose》");
        this.tracks=tracks;
    }

    @Override
    public void play() {
        System.out.println("Playing "+title+" by "+artist);
        for (String track:tracks) {
            System.out.println("-Track"+track);
        }
    }

    @Override
    public void playTrack(int i) {
        String track=this.tracks.get(i-1);
        System.out.println("Playing "+track+" by "+artist);
    }

    @RequestMapping(value = "/playOnly",method = RequestMethod.GET)
    public String playOnly() {
        System.out.println("Playing 《Good-bye》 by 蔡依林");
        return "success";

    }

}

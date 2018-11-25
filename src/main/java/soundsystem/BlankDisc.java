package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * ����Ϊ@Controller���಻���м̳й�ϵ�����򴴽�ʧ�� ==û�쳣
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
        this.artist="������";
        List<String> tracks = new ArrayList<>();
        tracks.add("��Because of You��");
        tracks.add("�����롷");
        tracks.add("���հס�");
        tracks.add("������̫���ᡷ");
        tracks.add("�����������ھӡ�");
        tracks.add("����֪������ѹ���");
        tracks.add("������˭��");
        tracks.add("���Ͻ֡�");
        tracks.add("��Good-bye��");
        tracks.add("��The Rose��");
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
        System.out.println("Playing ��Good-bye�� by ������");
        return "success";

    }

}

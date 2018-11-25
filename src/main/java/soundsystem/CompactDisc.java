package soundsystem;

public interface CompactDisc {

    void play();

    /**
     * 播放CD中的第i首歌
     * @param i
     */
    void playTrack(int i);
}

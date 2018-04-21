package ctci.oop.Q7_3_Jukebox;

import java.util.HashMap;
import java.util.Map;

public class Jukebox {

    private Map<SongKey, Song> songCollection = new HashMap<>();


    public void requestSong(SongKey key) throws Exception {
        Song requestedSong = songCollection.get(key);
        if(requestedSong==null){
            throw new Exception("Song not found");
        }
        requestedSong.play();
    }
}

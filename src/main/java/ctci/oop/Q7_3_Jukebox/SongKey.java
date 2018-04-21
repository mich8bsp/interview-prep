package ctci.oop.Q7_3_Jukebox;

import java.util.Objects;

public class SongKey {
    private String keyCategory;
    private int keyNum;

    public SongKey(String keyCategory, int keyNum) {
        this.keyCategory = keyCategory;
        this.keyNum = keyNum;
    }

    public String getKeyCategory() {
        return keyCategory;
    }

    public void setKeyCategory(String keyCategory) {
        this.keyCategory = keyCategory;
    }

    public int getKeyNum() {
        return keyNum;
    }

    public void setKeyNum(int keyNum) {
        this.keyNum = keyNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongKey songKey = (SongKey) o;
        return keyNum == songKey.keyNum &&
                Objects.equals(keyCategory, songKey.keyCategory);
    }

    @Override
    public int hashCode() {

        return Objects.hash(keyCategory, keyNum);
    }

    @Override
    public String toString() {
        return "SongKey{" +
                "keyCategory='" + keyCategory + '\'' +
                ", keyNum=" + keyNum +
                '}';
    }
}

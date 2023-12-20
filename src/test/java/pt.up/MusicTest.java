package pt.up;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.utils.Music;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import static org.junit.jupiter.api.Assertions.*;

public class MusicTest {

    @Test
    public void MusicTest() {
        Music music = new Music("MenuSound.wav");
        Clip sound = Mockito.mock(Clip.class);
        music.setSound(sound);

        assertFalse(music.isPlaying());

        Mockito.when(sound.isRunning()).thenReturn(true);
        music.start();

        assertTrue(music.isPlaying());

        Mockito.verify(sound, Mockito.times(1)).setMicrosecondPosition(0);
        Mockito.verify(sound, Mockito.times(1)).start();
        Mockito.verify(sound, Mockito.times(1)).loop(Mockito.anyInt());
    }

    @Test
    void createAndLoadSound() {
        String path = "GameOverSound.wav";
        Music music = new Music(path);
        FloatControl floatControl = (FloatControl) music.getSound().getControl(FloatControl.Type.MASTER_GAIN);

        assertNotNull(music);
        assertEquals(-25.0f, floatControl.getValue(), 0.01f);
    }

    @Test
    public void stopTest() {
        Music music = new Music("MenuSound.wav");
        Clip sound = Mockito.mock(Clip.class);
        music.setSound(sound);

        music.stop();

        Mockito.verify(sound).stop();
    }

    @Test
    public void loadNonExistentSoundTest() {
        Music music = new Music("NonExistentSound.wav");
        assertNull(music.loadSound("NonExistentSound.wav"));
    }
}
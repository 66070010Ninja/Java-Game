
import java.net.URL;
import javax.sound.sampled.*;

public class Sound {

    private final URL enemy_boom = getClass().getClassLoader().getResource("Sound/Boom.wav");
    private final URL BG = getClass().getClassLoader().getResource("Sound/AdhesiveWombat - 8 Bit Adventure.wav");
    private final URL get_Item = getClass().getClassLoader().getResource("Sound/get_Item.wav");
    private final URL get_Damage = getClass().getClassLoader().getResource("Sound/get_Damage.wav");
    private final URL Game_Over = getClass().getClassLoader().getResource("Sound/Game_Over.wav");
    private final URL Menu = getClass().getClassLoader().getResource("Sound/8 Bit.wav");
    private Clip clip;

    public void Sound_Enemy_Boom() {
        play(enemy_boom);
    }
    public void Sound_BG() {
        play(BG);
    }
    public void Sound_Get_Item() {
        play(get_Item);
    }
    public void Sound_get_Damage() {
        play(get_Damage);
    }
    public void Sound_Game_Over() {
        play(Game_Over);
    }
    public void Sound_Menu() {
        play(Menu);
    }

    public void stop() {
        getClip().stop();
        getClip().close();
    }

    public Clip getClip() {
        return clip;
    }

    private void play(URL url) {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            if (url == BG) {
                FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-5.0f);
            }
            else if (url == enemy_boom) {
                FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-0.05f);
            }
            else if (url == get_Item) {
                FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(5.0f);
            }
            else if (url == get_Damage) {
                FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(0.50f);
            }
            else if (url == Game_Over) {
                FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(1.0f);
            }
            else if (url == Menu) {
                FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-5.0f);
            }
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.stop();
                        if (url == Menu || url == BG) {
                            clip.start();
                        }
                        else {
                            clip.close();
                        }
                    }
                }
            });
            audioIn.close();
            clip.start();
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}

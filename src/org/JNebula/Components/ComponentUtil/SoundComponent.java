package org.JNebula.Components.ComponentUtil;

import org.JNebula.Components.Component;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class SoundComponent extends Component {
    public String file;


    public boolean loop;
    public boolean mute;


    public boolean pause;

    public boolean playAtStart;

    private Clip clip;

    //WIP. I cant find a frame work for this.

    public SoundComponent(String file) {
        this.file = file;
        this.playAtStart = true;
        this.loop = true;
        try {

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(file));
            clip = AudioSystem.getClip();
            clip.open(audioIn);

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

    }


    public void play() {
        clip.start();
    }
    public void clipStop(){
        clip.stop();
    }

    @Override
    public void init(float dt) {


    }

    @Override
    public void update(float dt) {


    }


}

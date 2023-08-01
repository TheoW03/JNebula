package org.JNebula.Components.ComponentUtil;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.JNebula.Components.Component;

import javax.print.attribute.standard.Media;
import java.util.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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

    private ExecutorService threadPool;

    public boolean pause;

    public boolean playAtStart;

    private Player player;

    public SoundComponent(String file) {
        this.file = file;
        this.playAtStart = true;
        this.loop = true;

    }

    @Override
    public void init(float dt) {




    }

    @Override
    public void update(float dt) {



    }



}

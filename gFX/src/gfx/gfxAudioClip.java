package gfx;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class gfxAudioClip {
    private String name;
    private String fileName;
    private Clip clip;

    public gfxAudioClip(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
        try {
            this.clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
            clip.open(audioInputStream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playSound() {
        if(this.clip != null) {
            if(clip.getMicrosecondPosition() > 0) {
                clip.setMicrosecondPosition(0);
            }
            clip.start();
        }
    }
    
    public void playSound2() {
    	clip.setMicrosecondPosition(0);
    	clip.start();
    }

    public void stop() {
        if(this.clip != null) {
            clip.stop();
        }
    }

    public void dispose() {
        this.clip.flush();
    }
}

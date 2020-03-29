package com.technegames.psotools.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import java.net.URL;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

/**
 *
 * @author Alucard
 */
public class AudioPlaybackManager extends JApplet
{
    private AudioClip audioClip;

    public AudioPlaybackManager() {}

    @Override
    public void start()
    {
        if (audioClip != null)
        {
            audioClip.loop();
        }
    }

    @Override
    public void stop()
    {
        if (audioClip != null)
        {
            audioClip.stop();
            audioClip = null;
        }
    }

    public final void startNewAudioClip(String url)
    {
        try
        {
            audioClip = Applet.newAudioClip(new URL(url));
            audioClip.loop();
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Encountered problems while trying to load the track at: " + url);
        }
    }
}
package com.technegames.psotools.screens.listeners;

import com.technegames.psotools.util.AudioPlaybackManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author arikardo77
 */
public final class SongButtonActionListener implements ActionListener
{
    public static final String SONG_BUTTON_TRACK_TEXT = "Track>>";
    
    private static final String SONG_BUTTON_STOP_TEXT = "  STOP  ";
    private static final String BASE_MIDI_URL = "http://www.vgmusic.com/music/console/sega/dreamcast/";
    private static final String[] TRACKS =
    {
        "psocreatecharacter.mid",
        "pso.mid",
        "bman_dc_pso_motherearthofdishonesty1.mid",
        "volopt.mid",
        "Ruins_(explore_to_Danger).mid"
    };
    
    private final AudioPlaybackManager bgm;
    
    private int currentTrack = -1;

    public SongButtonActionListener(AudioPlaybackManager bgm)
    {
        this.bgm = bgm;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton btnSong = ((JButton) e.getSource());
        bgm.stop();
        currentTrack++;
        if (currentTrack > 4)
        {
            currentTrack = -1;
            btnSong.setText(SONG_BUTTON_TRACK_TEXT);
        }
        else if (currentTrack == 4)
        {
            btnSong.setText(SONG_BUTTON_STOP_TEXT);
        }
        else
        {
            bgm.startNewAudioClip(BASE_MIDI_URL + TRACKS[currentTrack]);
        }
    }
}
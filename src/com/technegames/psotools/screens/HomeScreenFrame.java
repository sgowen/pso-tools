package com.technegames.psotools.screens;

import static com.technegames.psotools.constants.HomeScreenConstants.TITLE;
import com.technegames.psotools.screens.homescreenpanels.AboutPanel;
import com.technegames.psotools.screens.homescreenpanels.AbstractHomeScreenPanel;
import com.technegames.psotools.screens.homescreenpanels.CalcSectionIDPanel;
import com.technegames.psotools.screens.homescreenpanels.MagFeedingChartPanel;
import com.technegames.psotools.screens.listeners.SongButtonActionListener;
import com.technegames.psotools.util.AudioPlaybackManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author arikardo77
 */
public final class HomeScreenFrame extends JFrame
{
    private final JTabbedPane tabs;
    private final JButton rightButton;
    private final ArrayList<AbstractHomeScreenPanel> homeScreenPanels;
    
    private int currentTab = 0;

    public HomeScreenFrame()
    {
        this.tabs = new JTabbedPane();
        this.rightButton = new JButton();
        this.homeScreenPanels = initTabPanels(this.rightButton);

        tabs.addChangeListener(new TabChangeListener());
        rightButton.addActionListener(new RightButtonActionListener());
    }

    public final void display()
    {
        setTitle(TITLE);
        setLayout(new BorderLayout());
        setBackground(new Color(212, 232, 239, 255));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < homeScreenPanels.size(); i++)
        {
            tabs.add(homeScreenPanels.get(i), homeScreenPanels.get(i).getTabName());
            tabs.setToolTipTextAt(i, homeScreenPanels.get(i).getToolTip());
            tabs.setBackgroundAt(i, new Color(24, 169, 224, 255));
        }

        JButton btnSong = new JButton(SongButtonActionListener.SONG_BUTTON_TRACK_TEXT);
        btnSong.addActionListener(new SongButtonActionListener(new AudioPlaybackManager()));

        Panel bottom = new Panel(new BorderLayout());
        bottom.add(btnSong, BorderLayout.WEST);
        bottom.add(rightButton, BorderLayout.EAST);

        add(tabs, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        homeScreenPanels.get(currentTab).refreshUI(this);

        setVisible(true);
    }

    private ArrayList<AbstractHomeScreenPanel> initTabPanels(JButton rightButton)
    {
        ArrayList<AbstractHomeScreenPanel> panels = new ArrayList<AbstractHomeScreenPanel>();
        panels.add(new CalcSectionIDPanel(rightButton));
        panels.add(new MagFeedingChartPanel(rightButton));
        panels.add(new AboutPanel(rightButton));

        return panels;
    }

    private final class TabChangeListener implements ChangeListener
    {
        @Override
        public void stateChanged(ChangeEvent e)
        {
            currentTab = tabs.getSelectedIndex();
            homeScreenPanels.get(currentTab).refreshUI(HomeScreenFrame.this);
        }
    }

    private final class RightButtonActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            homeScreenPanels.get(currentTab).receiveRightButtonActionEvent();
        }
    }
}
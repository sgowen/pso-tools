package com.technegames.psotools.screens.homescreenpanels;

import java.awt.Container;
import java.awt.Panel;
import javax.swing.JButton;

/**
 *
 * @author arikardo77
 */
public abstract class AbstractHomeScreenPanel extends Panel
{
    public abstract String getTabName();
    
    public abstract String getToolTip();
    
    public abstract void refreshUI(Container container);
    
    public abstract void receiveRightButtonActionEvent();
    
    protected final JButton rightButton;
    
    public AbstractHomeScreenPanel(JButton rightButton)
    {
        this.rightButton = rightButton;
    }
}
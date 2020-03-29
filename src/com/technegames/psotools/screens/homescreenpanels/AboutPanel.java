package com.technegames.psotools.screens.homescreenpanels;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author arikardo77
 */
public final class AboutPanel extends AbstractHomeScreenPanel
{
    @Override
    public String getTabName()
    {
        return "About";
    }

    @Override
    public String getToolTip()
    {
        return "About this software!";
    }

    @Override
    public void refreshUI(Container container)
    {
        container.setSize(560, 200);
        rightButton.setVisible(false);
    }

    @Override
    public void receiveRightButtonActionEvent()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public AboutPanel(JButton rightButton)
    {
        super(rightButton);

        setLayout(new BorderLayout());
        
        add(initLabelPanel(), BorderLayout.CENTER);
    }
    
    private JPanel initLabelPanel()
    {
        JPanel labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(new JLabel(
                "<html>"
                            + "<p style=\"text-align:center;\">This software was developed entirely by myself, Stephen Gowen"
                + "<br/>"   + "and is to be used as a tool for Phantasy Star Online Episodes 1&2."
                + "<br/>"   + "If you want to support me so that I can make this software even better,"
                + "<br/>"   + "give me a PayPal donation! My PayPal email is Mastersword_1990@hotmail.com"
                + "<br/>"   + "You can also email me with anything you would like to see added to this software"
                + "<br/>"   + "Thanks, and I hope this helps you as much as it helps me!</p>"
                
                + "</html>"));
        
        return labelPanel;
    }
}
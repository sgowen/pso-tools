package com.technegames.psotools.screens.homescreenpanels;

import com.technegames.psotools.objects.SectionID;
import com.technegames.psotools.util.CharacterNumericValueMap;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author arikardo77
 */
public final class CalcSectionIDPanel extends AbstractHomeScreenPanel
{
    private final CharacterNumericValueMap characterNumericValueMap;
    private final ArrayList<SectionID> sectionIDs;
    private final JEditorPane dropChartsEditorPane;
    private final JTextField nameTextField;
    private final JButton sectionIDIcon;
    private final JLabel resultOneLabel;
    private final JLabel resultTwoLabel;
    
    private int sectionIDIndex = -1;

    @Override
    public String getTabName()
    {
        return "Section ID Calculator";
    }

    @Override
    public String getToolTip()
    {
        return "Enter a name to calculate your section ID!";
    }

    @Override
    public void refreshUI(Container container)
    {
        container.setSize(600, 345);
        rightButton.setEnabled(sectionIDIndex > -1);
        rightButton.setText("Drop Charts");
        rightButton.setVisible(true);
    }

    @Override
    public void receiveRightButtonActionEvent()
    {
        dropChartsEditorPane.setVisible(true);

        try
        {
            dropChartsEditorPane.setPage(new URL("http://www.pso-world.com/item_findings.php?by=sectionid&sectionid=" + (sectionIDIndex + 1) + "&version=v3"));
            dropChartsEditorPane.repaint();
        }
        catch (Exception e)
        {
            dropChartsEditorPane.setText(e.toString());
        }
    }

    public CalcSectionIDPanel(JButton rightButton)
    {
        super(rightButton);

        this.characterNumericValueMap = new CharacterNumericValueMap();
        this.sectionIDs = initSectionIDs();

        this.dropChartsEditorPane = new JEditorPane();
        this.dropChartsEditorPane.setEditable(false);
        this.dropChartsEditorPane.setVisible(false);

        this.nameTextField = new JTextField();
        this.nameTextField.addActionListener(new CalculateSectionIDActionListener());

        this.sectionIDIcon = new JButton();
        this.sectionIDIcon.setVisible(false);
        this.sectionIDIcon.setBackground(SystemColor.menu);
        this.sectionIDIcon.setBorderPainted(false);
        this.sectionIDIcon.addActionListener(new SectionIDIConActionListener());

        this.resultOneLabel = new JLabel("");
        this.resultTwoLabel = new JLabel("");

        JButton calcButton = new JButton("Calculate");
        calcButton.addActionListener(new CalculateSectionIDActionListener());

        setLayout(new BorderLayout());
        
        add(initTopPanel(), BorderLayout.NORTH);
        add(initCenterPanel(calcButton), BorderLayout.CENTER);
    }

    public void displaySectionID()
    {
        sectionIDIndex = getSectionIDIndexFromEntry(nameTextField.getText().toString().trim());
        final SectionID sectionID = sectionIDs.get(sectionIDIndex);

        try
        {
            sectionIDIcon.setIcon(new ImageIcon(new URL("http://www.pso-world.com/sectionids/2/" + sectionID.name + ".gif")));
            sectionIDIcon.setVisible(true);
            resultOneLabel.setText("Your Section ID will be");
            resultTwoLabel.setText(sectionID.name);
            rightButton.setEnabled(true);
            validate();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    private JPanel initTopPanel()
    {
        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("Enter the name you would like to use and your section ID will be calculated"));

        return top;
    }

    private JPanel initCenterPanel(JButton calcButton)
    {
        JPanel middleWN = new JPanel(new BorderLayout());
        middleWN.add(nameTextField, BorderLayout.NORTH);
        middleWN.add(calcButton, BorderLayout.CENTER);

        JPanel middleWS = new JPanel(new BorderLayout());
        middleWS.add(resultOneLabel, BorderLayout.NORTH);
        middleWS.add(resultTwoLabel, BorderLayout.CENTER);
        middleWS.add(sectionIDIcon, BorderLayout.EAST);

        JPanel middleW = new JPanel(new BorderLayout());
        middleW.add(middleWN, BorderLayout.NORTH);
        middleW.add(middleWS, BorderLayout.CENTER);

        JScrollPane jspViewer = new JScrollPane();
        jspViewer.getViewport().add(dropChartsEditorPane, null);
        jspViewer.setBorder(null);

        JPanel middleE = new JPanel(new BorderLayout());
        middleE.add(jspViewer, BorderLayout.CENTER);
        jspViewer.setBounds(jspViewer.getVisibleRect());

        JPanel middle = new JPanel(new BorderLayout());
        middle.add(middleW, BorderLayout.WEST);
        middle.add(middleE, BorderLayout.CENTER);

        return middle;
    }

    private int getSectionIDIndexFromEntry(String letters)
    {
        int total = 0;

        for (int i = 0; i < letters.length(); i++)
        {
            total += characterNumericValueMap.generateNumericValueFromChar(letters.charAt(i));
        }

        while (total > 9)
        {
            total -= 10;
        }

        return total;
    }

    private ArrayList<SectionID> initSectionIDs()
    {
        ArrayList<SectionID> sectionIDsList = new ArrayList<SectionID>();

        sectionIDsList.add(new SectionID("VIRIDIA", "Good for finding shots such as Spreaders and Partisans"));
        sectionIDsList.add(new SectionID("GREENILL", "Good for finding Daggers and Rifles"));
        sectionIDsList.add(new SectionID("SKYLY", "Good for finding Swords and Rifles"));
        sectionIDsList.add(new SectionID("BLUEFULL", "Mostly good for finding Partisans and Rods"));
        sectionIDsList.add(new SectionID("PURPLENUM", "Great for finding Mechguns!"));
        sectionIDsList.add(new SectionID("PINKAL", "Best for Canes, Wands and Technique Discs"));
        sectionIDsList.add(new SectionID("REDRIA", "Good for finding armor, but can find a wide variety of items"));
        sectionIDsList.add(new SectionID("ORAN", "Mostly good for finding Daggers Wands"));
        sectionIDsList.add(new SectionID("YELLOWBOZE", "You will find A LOT of MESETA, but you will also find a fucking Yasminkov 7000V in the Seabed!!"));
        sectionIDsList.add(new SectionID("WHITILL", "Mostly good for finding Slicers and a few Mechguns"));

        return sectionIDsList;
    }

    private final class CalculateSectionIDActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            displaySectionID();
        }
    }

    private final class SectionIDIConActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, sectionIDs.get(sectionIDIndex).description);
        }
    }
}
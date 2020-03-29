package com.technegames.psotools.screens.homescreenpanels;

import com.technegames.psotools.constants.Items;
import com.technegames.psotools.objects.Mag;
import com.technegames.psotools.objects.MagItemAttributes;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author arikardo77
 */
public final class MagFeedingChartPanel extends AbstractHomeScreenPanel
{
    private final ArrayList<Mag> mags;
    private final JLabel subHeaderLabel;
    private final JPanel magChartContainerPanel;
    
    private String selectedMagName;

    @Override
    public String getTabName()
    {
        return "Mag Feeding Charts";
    }

    @Override
    public String getToolTip()
    {
        return "Learn how to properly feed your mag here!";
    }

    @Override
    public void refreshUI(Container container)
    {
        container.setSize(685, 372);
        rightButton.setEnabled(true);
        rightButton.setText(selectedMagName + " Feeding Chart");
        rightButton.setVisible(true);
    }

    @Override
    public void receiveRightButtonActionEvent()
    {
        subHeaderLabel.setText(selectedMagName + " Feeding Chart");
        magChartContainerPanel.removeAll();
        magChartContainerPanel.add(mags.get(getMagsListIndexForMagName(selectedMagName)).generateMagChartTable());
        validate();
    }

    public MagFeedingChartPanel(JButton rightButton)
    {
        super(rightButton);

        this.mags = initMags(
                initItemAttributeValuesForMagType0(),
                initItemAttributeValuesForMagType1(),
                initItemAttributeValuesForMagType2(),
                initItemAttributeValuesForMagType3(),
                initItemAttributeValuesForMagType4(),
                initItemAttributeValuesForMagType5(),
                initItemAttributeValuesForMagType6());

        this.subHeaderLabel = new JLabel("Select a mag from the list");
        this.magChartContainerPanel = new JPanel(new FlowLayout());

        setLayout(new BorderLayout());

        JPanel top = new JPanel(new FlowLayout());
        top.add(subHeaderLabel);

        JScrollPane jspMag = new JScrollPane();
        jspMag.getViewport().add(magChartContainerPanel, null);

        JComboBox magComboBox = new JComboBox(getSortedMagNamesArray());
        magComboBox.addItemListener(new MagSelectorItemListener());

        add(top, BorderLayout.NORTH);
        add(jspMag, BorderLayout.CENTER);
        add(magComboBox, BorderLayout.SOUTH);

        selectedMagName = magComboBox.getSelectedItem().toString();
    }

    private ArrayList<Mag> initMags(ArrayList<MagItemAttributes> magItemAttributes0, ArrayList<MagItemAttributes> magItemAttributes1, ArrayList<MagItemAttributes> magItemAttributes2, ArrayList<MagItemAttributes> magItemAttributes3, ArrayList<MagItemAttributes> magItemAttributes4, ArrayList<MagItemAttributes> magItemAttributes5, ArrayList<MagItemAttributes> magItemAttributes6)
    {
        ArrayList<Mag> magList = new ArrayList<Mag>();

        magList.add(new Mag("Mag", magItemAttributes0));

        magList.add(new Mag("Varuna", magItemAttributes1));
        magList.add(new Mag("Vrita", magItemAttributes1));
        magList.add(new Mag("Kalki", magItemAttributes1));

        magList.add(new Mag("Ashvinau", magItemAttributes2));
        magList.add(new Mag("Sumba", magItemAttributes2));
        magList.add(new Mag("Namuci", magItemAttributes2));
        magList.add(new Mag("Marutah", magItemAttributes2));
        magList.add(new Mag("Rudra", magItemAttributes2));

        magList.add(new Mag("Surya", magItemAttributes3));
        magList.add(new Mag("Tapas", magItemAttributes3));
        magList.add(new Mag("Mitra", magItemAttributes3));

        magList.add(new Mag("Asparas", magItemAttributes4));
        magList.add(new Mag("Vayu", magItemAttributes4));
        magList.add(new Mag("Varaha", magItemAttributes4));
        magList.add(new Mag("Ushasu", magItemAttributes4));
        magList.add(new Mag("Kama", magItemAttributes4));
        magList.add(new Mag("Kaitabha", magItemAttributes4));
        magList.add(new Mag("Kumara", magItemAttributes4));
        magList.add(new Mag("Bhirava", magItemAttributes4));

        magList.add(new Mag("Ila", magItemAttributes5));
        magList.add(new Mag("Garuda", magItemAttributes5));
        magList.add(new Mag("Sita", magItemAttributes5));
        magList.add(new Mag("Soma", magItemAttributes5));
        magList.add(new Mag("Durga", magItemAttributes5));
        magList.add(new Mag("Nandin", magItemAttributes5));
        magList.add(new Mag("Yaksa", magItemAttributes5));
        magList.add(new Mag("Ribhava", magItemAttributes5));

        magList.add(new Mag("Andhaka", magItemAttributes6));
        magList.add(new Mag("Kabanda", magItemAttributes6));
        magList.add(new Mag("Naga", magItemAttributes6));
        magList.add(new Mag("Naraka", magItemAttributes6));
        magList.add(new Mag("Bana", magItemAttributes6));
        magList.add(new Mag("Marica", magItemAttributes6));
        magList.add(new Mag("Madhu", magItemAttributes6));
        magList.add(new Mag("Ravana", magItemAttributes6));

        return magList;
    }

    private ArrayList<MagItemAttributes> initItemAttributeValuesForMagType0()
    {
        ArrayList<MagItemAttributes> itemAttributeValues = new ArrayList<MagItemAttributes>();

        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monomate, "+3", "+3", "+4", "+3", "+3", "+4"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Dimate, "+3", "+3", "+4", "+4", "+6", "+3"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trimate, "+3", "+4", "+3", "+3", "+4", "+3"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monofluid, "+3", "+1", "+1", "+5", "+5", "+10"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Difluid, "+15", "+5", "+10", "+15", "+5", "+5"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trifluid, "+15", "+15", "+25", "+40", "+45", "+50"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antidote, "0", "0", "0", "+10", "0", "+30"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antiparalysis, "+25", "+25", "+5", "+5", "+10", "+5"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Sol_Atomizer, "+5", "+10", "+40", "+44", "+15", "+15"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Moon_Atomizer, "+25", "0", "0", "0", "+40", "+45"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Star_Atomizer, "+50", "0", "+10", "+25", "+30", "+25"));

        return itemAttributeValues;
    }

    private ArrayList<MagItemAttributes> initItemAttributeValuesForMagType1()
    {
        ArrayList<MagItemAttributes> itemAttributeValues = new ArrayList<MagItemAttributes>();

        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monomate, "0", "+2", "+3", "0", "+2", "+3"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Dimate, "0", "+2", "-2", "+3", "+4", "0"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trimate, "+1", "+2", "+0", "+1", "+2", "+1"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monofluid, "0", "+2", "-2", "+3", "+5", "+6"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Difluid, "+12", "+5", "+7", "+7", "0", "-1"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trifluid, "+10", "+9", "+14", "+10", "+15", "+21"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antidote, "0", "0", "-7", "+5", "0", "+11"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antiparalysis, "0", "+9", "0", "+3", "+4", "0"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Sol_Atomizer, "+3", "+6", "+15", "+14", "+8", "+9"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Moon_Atomizer, "+18", "-1", "-3", "-7", "+8", "+13"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Star_Atomizer, "+19", "0", "+5", "0", "+11", "+11"));

        return itemAttributeValues;
    }

    private ArrayList<MagItemAttributes> initItemAttributeValuesForMagType2()
    {
        ArrayList<MagItemAttributes> itemAttributeValues = new ArrayList<MagItemAttributes>();

        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monomate, "0", "+3", "+4", "0", "+3", "+3"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Dimate, "-1", "0", "+4", "-1", "+4", "-1"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trimate, "0", "+1", "-1", "0", "+2", "+1"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monofluid, "0", "-2", "+1", "+2", "+1", "+1"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Difluid, "+8", "0", "+4", "+6", "-5", "-5"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trifluid, "0", "+4", "+7", "+9", "+13", "+16"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antidote, "-5", "-10", "-15", "+4", "-6", "+11"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antiparalysis, "-5", "+8", "0", "0", "+2", "0"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Sol_Atomizer, "0", "+5", "+12", "+11", "+3", "0"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Moon_Atomizer, "+6", "-5", "-10", "-15", "+9", "+13"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Star_Atomizer, "+17", "-5", "+4", "-5", "+11", "+9"));

        return itemAttributeValues;
    }

    private ArrayList<MagItemAttributes> initItemAttributeValuesForMagType3()
    {
        ArrayList<MagItemAttributes> itemAttributeValues = new ArrayList<MagItemAttributes>();

        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monomate, "0", "+2", "+3", "0", "0", "+2"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Dimate, "-3", "+3", "+3", "-2", "+3", "-1"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trimate, "0", "+1", "0", "+1", "+2", "+3"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monofluid, "0", "-2", "+2", "+2", "0", "+5"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Difluid, "+4", "0", "+4", "+4", "0", "-4"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trifluid, "-10", "+8", "+7", "+3", "+7", "+14"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antidote, "0", "-5", "-10", "0", "-5", "+9"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antiparalysis, "+5", "+7", "0", "0", "+6", "0"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Sol_Atomizer, "0", "+3", "+7", "+20", "+6", "-8"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Moon_Atomizer, "+7", "0", "-5", "-10", "+4", "+8"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Star_Atomizer, "+15", "0", "-5", "+9", "+7", "+7"));

        return itemAttributeValues;
    }

    private ArrayList<MagItemAttributes> initItemAttributeValuesForMagType4()
    {
        ArrayList<MagItemAttributes> itemAttributeValues = new ArrayList<MagItemAttributes>();

        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monomate, "+2", "+2", "0", "+2", "+2", "0"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Dimate, "+2", "-2", "+4", "+3", "+3", "-1"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trimate, "0", "+1", "-1", "0", "+1", "-1"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monofluid, "+3", "-2", "0", "+2", "-5", "0"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Difluid, "+4", "-5", "0", "+4", "-5", "+7"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trifluid, "+5", "-5", "+4", "+9", "+11", "+14"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antidote, "0", "-10", "-15", "-5", "-3", "+21"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antiparalysis, "-20", "+6", "-5", "0", "0", "-6"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Sol_Atomizer, "0", "0", "+16", "0", "-5", "+5"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Moon_Atomizer, "+8", "0", "-10", "-15", "+10", "+11"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Star_Atomizer, "+15", "-5", "-3", "-20", "+21", "+5"));

        return itemAttributeValues;
    }

    private ArrayList<MagItemAttributes> initItemAttributeValuesForMagType5()
    {
        ArrayList<MagItemAttributes> itemAttributeValues = new ArrayList<MagItemAttributes>();

        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monomate, "+2", "0", "+2", "+2", "0", "+2"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Dimate, "0", "-1", "+4", "+2", "+3", "-1"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trimate, "+1", "0", "-1", "+1", "0", "+1"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monofluid, "+1", "-1", "0", "+2", "-4", "0"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Difluid, "+3", "-4", "0", "+3", "+5", "0"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trifluid, "+4", "-10", "+2", "+13", "+16", "+19"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antidote, "-5", "-15", "-20", "-6", "-4", "+17"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antiparalysis, "-15", "+8", "-5", "0", "-2", "-5"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Sol_Atomizer, "0", "0", "+6", "+14", "-5", "+5"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Moon_Atomizer, "+3", "-5", "-15", "-18", "+13", "+16"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Star_Atomizer, "+19", "-5", "-10", "-15", "+21", "+6"));

        return itemAttributeValues;
    }

    private ArrayList<MagItemAttributes> initItemAttributeValuesForMagType6()
    {
        ArrayList<MagItemAttributes> itemAttributeValues = new ArrayList<MagItemAttributes>();

        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monomate, "-1", "+2", "+2", "-1", "+2", "+2"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Dimate, "+2", "-2", "+3", "0", "+3", "+1"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trimate, "0", "0", "+1", "0", "0", "-1"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Monofluid, "+3", "-1", "+2", "+2", "-3", "0"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Difluid, "+2", "-3", "0", "-2", "0", "0"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Trifluid, "+9", "-5", "0", "+9", "+11", "+15"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antidote, "-4", "-10", "-15", "+6", "-15", "-20"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Antiparalysis, "+20", "+11", "-3", "0", "0", "-3"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Sol_Atomizer, "0", "0", "+9", "+9", "-5", "+5"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Moon_Atomizer, "0", "-4", "-10", "-16", "+9", "+11"));
        itemAttributeValues.add(new MagItemAttributes(Items.Item.Star_Atomizer, "+19", "-15", "+6", "+17", "-20", "+11"));

        return itemAttributeValues;
    }

    private String[] getSortedMagNamesArray()
    {
        String[] magsArray = new String[mags.size()];

        for (int i = 0; i < magsArray.length; i++)
        {
            magsArray[i] = mags.get(i).name;
        }

        Arrays.sort(magsArray);

        return magsArray;
    }

    private int getMagsListIndexForMagName(String magName)
    {
        for (int i = 0; i < mags.size(); i++)
        {
            if (mags.get(i).name.equalsIgnoreCase(magName))
            {
                return i;
            }
        }

        throw new IllegalArgumentException("Invalid mag name: " + magName);
    }

    private final class MagSelectorItemListener implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent e)
        {
            selectedMagName = e.getItem().toString();
            rightButton.setText(selectedMagName + " Feeding Chart");
        }
    }
}
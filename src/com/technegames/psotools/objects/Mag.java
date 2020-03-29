package com.technegames.psotools.objects;

import com.technegames.psotools.constants.Attribute;
import com.technegames.psotools.constants.Items;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author arikardo77
 */
public final class Mag
{
    public final String name;
    private final JTable magChartTable;

    public Mag(String name, ArrayList<MagItemAttributes> magItemAttributes)
    {
        this.name = name;
        this.magChartTable = initMagChartTable(magItemAttributes);
    }

    public JTable generateMagChartTable()
    {
        return magChartTable;
    }

    private JTable initMagChartTable(ArrayList<MagItemAttributes> magItemAttributes)
    {
        JTable table = new JTable(new MagChartTableModel(magItemAttributes));

        TableColumn column;
        
        for (int i = 0; i < 5; i++)
        {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(100);
        }

        return table;
    }
    
    private final class MagChartTableModel extends AbstractTableModel
    {
        private final String[] COLUMN_NAMES =
        {
            Items.ITEM,
            Attribute.SYNC.name(),
            Attribute.IQ.name(),
            Attribute.DEF.name(),
            Attribute.POW.name(),
            Attribute.DEX.name(),
            Attribute.MIND.name()
        };
        
        private final Object[][] data;

        public MagChartTableModel(ArrayList<MagItemAttributes> mia)
        {
            data = new Object[mia.size() + 2][COLUMN_NAMES.length];

            data[0][0] = Items.ITEM;
            data[0][1] = Attribute.SYNC.name();
            data[0][2] = Attribute.IQ.name();
            data[0][3] = Attribute.DEF.name();
            data[0][4] = Attribute.POW.name();
            data[0][5] = Attribute.DEX.name();
            data[0][6] = Attribute.MIND.name();

            for (int i = 0; i < mia.size(); i++)
            {
                data[i + 2][0] = Items.toString(mia.get(i).item);
            }

            for (int i = 0; i < mia.size(); i++)
            {
                data[i + 2][1] = mia.get(i).syncValue;
            }

            for (int i = 0; i < mia.size(); i++)
            {
                data[i + 2][2] = mia.get(i).IQValue;
            }

            for (int i = 0; i < mia.size(); i++)
            {
                data[i + 2][3] = mia.get(i).defValue;
            }

            for (int i = 0; i < mia.size(); i++)
            {
                data[i + 2][4] = mia.get(i).powValue;
            }

            for (int i = 0; i < mia.size(); i++)
            {
                data[i + 2][5] = mia.get(i).dexValue;
            }

            for (int i = 0; i < mia.size(); i++)
            {
                data[i + 2][6] = mia.get(i).mindValue;
            }
        }

        @Override
        public int getRowCount()
        {
            return data.length;
        }

        @Override
        public int getColumnCount()
        {
            return COLUMN_NAMES.length;
        }

        @Override
        public Object getValueAt(int i, int i1)
        {
            return data[i][i1];
        }
    }
}
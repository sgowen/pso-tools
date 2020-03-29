package com.technegames.psotools.objects;

import com.technegames.psotools.constants.Items;

/**
 *
 * @author arikardo77
 */
public class MagItemAttributes
{
    public final Items.Item item;
    public final String syncValue;
    public final String IQValue;
    public final String defValue;
    public final String powValue;
    public final String dexValue;
    public final String mindValue;

    public MagItemAttributes(Items.Item item, String syncValue, String IQValue, String defValue, String powValue, String dexValue, String mindValue)
    {
        this.item = item;
        this.syncValue = syncValue;
        this.IQValue = IQValue;
        this.defValue = defValue;
        this.powValue = powValue;
        this.dexValue = dexValue;
        this.mindValue = mindValue;
    }
}
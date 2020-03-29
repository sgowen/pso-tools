package com.technegames.psotools.constants;

/**
 *
 * @author arikardo77
 */
public class Items
{
    public static final String ITEM = "ITEM";

    public enum Item
    {
        Moon_Atomizer,
        Star_Atomizer,
        Sol_Atomizer,
        Monomate,
        Dimate,
        Trimate,
        Monofluid,
        Difluid,
        Trifluid,
        Antidote,
        Antiparalysis
    };

    public static String toString(Item item)
    {
        return item.name().replace("_", " ");
    }
}
package com.technegames.psotools.util;

import java.util.HashMap;

/**
 *
 * @author arikardo77
 */
public class CharacterNumericValueMap
{
    private final HashMap<Character, Integer> characterNumericValueHashMap;

    public CharacterNumericValueMap()
    {
        characterNumericValueHashMap = new HashMap<Character, Integer>();

        characterNumericValueHashMap.put('e', 1);
        characterNumericValueHashMap.put('G', 1);
        characterNumericValueHashMap.put('Q', 1);
        characterNumericValueHashMap.put('o', 1);
        characterNumericValueHashMap.put('y', 1);
        characterNumericValueHashMap.put('3', 1);
        characterNumericValueHashMap.put(')', 1);
        characterNumericValueHashMap.put('=', 1);
        characterNumericValueHashMap.put('[', 1);

        characterNumericValueHashMap.put('f', 2);
        characterNumericValueHashMap.put('H', 2);
        characterNumericValueHashMap.put('R', 2);
        characterNumericValueHashMap.put('p', 2);
        characterNumericValueHashMap.put('z', 2);
        characterNumericValueHashMap.put('4', 2);
        characterNumericValueHashMap.put('*', 2);
        characterNumericValueHashMap.put('>', 2);
        characterNumericValueHashMap.put(' ', 2);

        characterNumericValueHashMap.put('g', 3);
        characterNumericValueHashMap.put('I', 3);
        characterNumericValueHashMap.put('S', 3);
        characterNumericValueHashMap.put('q', 3);
        characterNumericValueHashMap.put('5', 3);
        characterNumericValueHashMap.put('!', 3);
        characterNumericValueHashMap.put('+', 3);
        characterNumericValueHashMap.put('?', 3);
        characterNumericValueHashMap.put(']', 3);
        characterNumericValueHashMap.put('{', 3);

        characterNumericValueHashMap.put('h', 4);
        characterNumericValueHashMap.put('J', 4);
        characterNumericValueHashMap.put('T', 4);
        characterNumericValueHashMap.put('h', 4);
        characterNumericValueHashMap.put('r', 4);
        characterNumericValueHashMap.put('6', 4);
        characterNumericValueHashMap.put('@', 4);
        characterNumericValueHashMap.put('"', 4);
        characterNumericValueHashMap.put('^', 4);
        characterNumericValueHashMap.put(',', 4);

        characterNumericValueHashMap.put('i', 5);
        characterNumericValueHashMap.put('A', 5);
        characterNumericValueHashMap.put('K', 5);
        characterNumericValueHashMap.put('U', 5);
        characterNumericValueHashMap.put('i', 5);
        characterNumericValueHashMap.put('s', 5);
        characterNumericValueHashMap.put('7', 5);
        characterNumericValueHashMap.put('#', 5);
        characterNumericValueHashMap.put('-', 5);
        characterNumericValueHashMap.put('}', 5);
        characterNumericValueHashMap.put('_', 5);

        characterNumericValueHashMap.put('j', 6);
        characterNumericValueHashMap.put('B', 6);
        characterNumericValueHashMap.put('L', 6);
        characterNumericValueHashMap.put('V', 6);
        characterNumericValueHashMap.put('j', 6);
        characterNumericValueHashMap.put('t', 6);
        characterNumericValueHashMap.put('8', 6);
        characterNumericValueHashMap.put('$', 6);
        characterNumericValueHashMap.put('.', 6);
        characterNumericValueHashMap.put('~', 6);

        characterNumericValueHashMap.put('a', 7);
        characterNumericValueHashMap.put('C', 7);
        characterNumericValueHashMap.put('M', 7);
        characterNumericValueHashMap.put('W', 7);
        characterNumericValueHashMap.put('k', 7);
        characterNumericValueHashMap.put('u', 7);
        characterNumericValueHashMap.put('9', 7);
        characterNumericValueHashMap.put('%', 7);
        characterNumericValueHashMap.put('/', 7);

        characterNumericValueHashMap.put('b', 8);
        characterNumericValueHashMap.put('D', 8);
        characterNumericValueHashMap.put('N', 8);
        characterNumericValueHashMap.put('X', 8);
        characterNumericValueHashMap.put('l', 8);
        characterNumericValueHashMap.put('v', 8);
        characterNumericValueHashMap.put('0', 8);
        characterNumericValueHashMap.put('&', 8);
        characterNumericValueHashMap.put(':', 8);

        characterNumericValueHashMap.put('c', 9);
        characterNumericValueHashMap.put('E', 9);
        characterNumericValueHashMap.put('O', 9);
        characterNumericValueHashMap.put('Y', 9);
        characterNumericValueHashMap.put('m', 9);
        characterNumericValueHashMap.put('w', 9);
        characterNumericValueHashMap.put('1', 9);
        characterNumericValueHashMap.put('\'', 9);
        characterNumericValueHashMap.put(';', 9);
    }

    public int generateNumericValueFromChar(char character)
    {
        return characterNumericValueHashMap.containsKey(character) ? characterNumericValueHashMap.get(character) : 0;
    }
}
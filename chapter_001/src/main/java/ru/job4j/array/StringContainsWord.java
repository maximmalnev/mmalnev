package ru.job4j.array;
/**
 * StringContainsWord.
 */

import java.util.Arrays;

public class StringContainsWord {
    /**
     * StringContainsWord.
     * @param originArray - исходная строка
     * @param subArray - подстрока для поиска
     * @return  - true если подстрока соддержится в иходной строке
     */
    boolean contains(String originArray, String subArray) {

        char[] origin = originArray.toCharArray();
        char[] sub = subArray.toCharArray();
        boolean result = false;
        for (int i = 0; i < origin.length - sub.length; i++) {
            if (origin[i] == sub[0]) {
                int n = i;
                int letters = 0;
                for (int j = 0; j < sub.length; j++) {
                    if (origin[n] == sub[j]) {
                        n++;
                        letters++;
                    }
                }
                if (letters == sub.length) {
                    result = true;
                }
            }
        }
        return result;
    }
}

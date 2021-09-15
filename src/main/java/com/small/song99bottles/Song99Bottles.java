package com.small.song99bottles;

import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.RuleBasedNumberFormat;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Locale;

import static com.ibm.icu.text.RuleBasedNumberFormat.SPELLOUT;

public class Song99Bottles {
    public String verse(int input) {
        String bottle = (input == 1) ? "bottle" : "bottles";
        String quantity = numberToWords(input);
        String remainingQuantity = numberToWords(input-1);
        String remainingBottle = (input - 1 == 1) ? "bottle" : "bottles";
        String stanza = "%s %s of beer on the wall, %s %s of beer. "
                .formatted(WordUtils.capitalize(quantity), bottle, quantity, bottle);
        String hook = (input > 0)
                ? "Take one down, pass it around, %s %s of beer on the wall."
                    .formatted(remainingQuantity, remainingBottle)
                : "Go to the store, buy some more, ninety-nine bottles of beer on the wall.";

        return stanza + hook;
    }

    private String numberToWords(int input) {
        if (0 == input) {
            return "no";
        }
        Locale locale = new Locale("En", "US");
        Double d = (double) input;
        NumberFormat formatter = new RuleBasedNumberFormat(locale, SPELLOUT);
        return formatter.format(d);
    }
}

package com.danielrosehill.casemenu;

import java.util.Locale;
import java.util.Random;

public class ChaosCaseActivity extends CaseActivity {
    private static final Random RNG = new Random();

    /** Random case per letter, but never more than two letters in a row share a case. */
    @Override
    protected String transform(String text) {
        Locale loc = Locale.getDefault();
        StringBuilder sb = new StringBuilder(text.length());
        boolean lastUpper = false;
        int run = 0;
        for (int i = 0; i < text.length(); ) {
            int cp = text.codePointAt(i);
            i += Character.charCount(cp);
            if (!Character.isLetter(cp)) {
                sb.appendCodePoint(cp);
                continue;
            }
            boolean upper = run >= 2 ? !lastUpper : RNG.nextBoolean();
            run = (upper == lastUpper) ? run + 1 : 1;
            lastUpper = upper;
            String s = new String(Character.toChars(cp));
            sb.append(upper ? s.toUpperCase(loc) : s.toLowerCase(loc));
        }
        return sb.toString();
    }
}

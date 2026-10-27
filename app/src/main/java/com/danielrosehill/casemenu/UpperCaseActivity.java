package com.danielrosehill.casemenu;

import java.util.Locale;

public class UpperCaseActivity extends CaseActivity {
    @Override
    protected String transform(String text) {
        return text.toUpperCase(Locale.getDefault());
    }
}

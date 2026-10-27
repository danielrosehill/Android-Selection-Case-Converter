package com.danielrosehill.casemenu;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Receives ACTION_PROCESS_TEXT from the selection menu, transforms the text and
 * hands it back. If the source field is read-only, the result goes to the clipboard.
 */
public abstract class CaseActivity extends Activity {

    protected abstract String transform(String text);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent in = getIntent();
        CharSequence text = in.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
        if (text != null) {
            String out = transform(text.toString());
            if (in.getBooleanExtra(Intent.EXTRA_PROCESS_TEXT_READONLY, false)) {
                ClipboardManager cm = getSystemService(ClipboardManager.class);
                cm.setPrimaryClip(ClipData.newPlainText(getString(R.string.app_name), out));
                Toast.makeText(this, R.string.copied, Toast.LENGTH_SHORT).show();
            } else {
                setResult(RESULT_OK, new Intent().putExtra(Intent.EXTRA_PROCESS_TEXT, out));
            }
        }
        finish();
    }
}

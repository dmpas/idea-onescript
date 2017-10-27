package ru.dmpas.onescript.plugin;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class OneScriptAdapter extends FlexAdapter {
    public OneScriptAdapter() {
        super(new OneScriptLexer((Reader)null));
    }
}

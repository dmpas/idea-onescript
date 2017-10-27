package ru.dmpas.onescript.plugin;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;

public class OneScriptLanguage extends Language {

    public static final OneScriptLanguage INSTANCE = new OneScriptLanguage();

    protected OneScriptLanguage() {
        super("OneScript");
    }
}

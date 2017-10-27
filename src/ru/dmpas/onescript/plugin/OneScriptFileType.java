package ru.dmpas.onescript.plugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class OneScriptFileType extends LanguageFileType {

    public static final OneScriptFileType INSTANCE = new OneScriptFileType();

    private OneScriptFileType() {
        super(OneScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "OneScript";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "OneScript file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "os";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }
}

package ru.dmpas.onescript.plugin.psi;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.dmpas.onescript.plugin.OneScriptLanguage;

public class OneScriptElementType extends IElementType {
    public OneScriptElementType(@NotNull String debugName) {
        super(debugName, OneScriptLanguage.INSTANCE);
    }
}

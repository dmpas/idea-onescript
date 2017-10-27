package ru.dmpas.onescript.plugin.psi;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.dmpas.onescript.plugin.OneScriptLanguage;

public class OneScriptTokenType extends IElementType {

    public OneScriptTokenType(@NotNull @NonNls String debugName) {
        super(debugName, OneScriptLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "OneScriptTokenType." + super.toString();
    }
}

package ru.dmpas.onescript.plugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import ru.dmpas.onescript.plugin.OneScriptFileType;
import ru.dmpas.onescript.plugin.OneScriptLanguage;

public class OneScriptFile extends PsiFileBase {

    public OneScriptFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, OneScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return OneScriptFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "OneScript file";
    }

}

package ru.dmpas.onescript.plugin;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.dmpas.onescript.plugin.psi.OneScriptEndOfSub;
import ru.dmpas.onescript.plugin.psi.OneScriptSubdeclaration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OneScriptFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement psiElement, @NotNull Document document, boolean b) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        Collection<OneScriptSubdeclaration> subs = PsiTreeUtil.findChildrenOfType(psiElement, OneScriptSubdeclaration.class);
        for (final OneScriptSubdeclaration sub : subs) {
            final String subName = sub.getSubName().getText();

            PsiElement endOfSub = sub.getNextSibling();
            while (endOfSub != null && !(endOfSub instanceof OneScriptEndOfSub)) {
                endOfSub = endOfSub.getNextSibling();
            }

            if (endOfSub == null) {
                continue;
            }

            TextRange r = new TextRange(sub.getTextRange().getStartOffset(), endOfSub.getTextRange().getEndOffset());
            FoldingDescriptor d = new FoldingDescriptor(sub.getNode(), r) {
                @Nullable
                @Override
                public String getPlaceholderText() {
                    return subName;
                }
            };
            descriptors.add(d);
        }
        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode astNode) {
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode astNode) {
        return true;
    }
}

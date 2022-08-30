package org.ai.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.ai.CmlFileType;
import org.ai.CmlLanguage;
import org.jetbrains.annotations.NotNull;

public class CmlFile extends PsiFileBase {
  public CmlFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, CmlLanguage.INSTANCE);
  }

  @Override
  public @NotNull FileType getFileType() {
    return CmlFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "CML File";
  }
}

package org.ai.psi;

import com.intellij.psi.tree.IElementType;
import org.ai.CmlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CmlElementType extends IElementType {
  public CmlElementType(@NonNls @NotNull String debugName) {
    super(debugName, CmlLanguage.INSTANCE);
  }
}

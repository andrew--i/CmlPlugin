package org.ai.psi;

import com.intellij.psi.tree.IElementType;
import org.ai.CmlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CmlTokenType extends IElementType {
  public CmlTokenType(@NonNls @NotNull String debugName) {
    super(debugName, CmlLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "CmlTokenType." + super.toString();
  }
}

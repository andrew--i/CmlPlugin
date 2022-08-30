package org.ai;

import com.intellij.lexer.FlexAdapter;
import org.ai.psi._CmlLexer;

public class CmlLexerAdapter extends FlexAdapter {
  public CmlLexerAdapter() {
    super(new _CmlLexer(null));
  }
}

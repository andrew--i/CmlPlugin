package org.ai;

import com.intellij.lang.Language;

public class CmlLanguage extends Language {


  public static final CmlLanguage INSTANCE = new CmlLanguage();


  protected CmlLanguage() {
    super("CML");
  }
}

package org.ai;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class CmlFileType extends LanguageFileType {
  public static final CmlFileType INSTANCE = new CmlFileType();

  protected CmlFileType() {
    super(CmlLanguage.INSTANCE);
  }

  @Override
  public @NonNls @NotNull String getName() {
    return "Cml File";
  }

  @Override
  public @NlsContexts.Label @NotNull String getDescription() {
    return "Cml DSL file";
  }

  @Override
  public @NlsSafe @NotNull String getDefaultExtension() {
    return "cml";
  }

  @Override
  public @Nullable Icon getIcon() {
    return CmlIcons.FILE;
  }
}

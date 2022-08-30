package org.ai;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.ai.psi.CmlFile;
import org.ai.psi.CmlTypes;
import org.jetbrains.annotations.NotNull;

public class CmlParserDefinition implements ParserDefinition {


  public static final TokenSet COMMENTS = TokenSet.create(CmlTypes.COMMENT);

  public static final IFileElementType FILE = new IFileElementType(CmlLanguage.INSTANCE);


  @Override
  public @NotNull Lexer createLexer(Project project) {
    return new CmlLexerAdapter();
  }

  @Override
  public @NotNull PsiParser createParser(Project project) {
    return new CmlParser();
  }

  @Override
  public @NotNull IFileElementType getFileNodeType() {
    return FILE;
  }

  @Override
  public @NotNull TokenSet getCommentTokens() {
    return COMMENTS;
  }

  @Override
  public @NotNull TokenSet getStringLiteralElements() {
    return TokenSet.EMPTY;
  }

  @Override
  public @NotNull PsiElement createElement(ASTNode node) {
    return CmlTypes.Factory.createElement(node);
  }

  @Override
  public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
    return new CmlFile(viewProvider);
  }
}

package org.ai;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.ai.psi.CmlTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class CmlSyntaxHighlighter implements SyntaxHighlighter {
  public static final TextAttributesKey META_START =
      createTextAttributesKey("META_START", DefaultLanguageHighlighterColors.METADATA);

  public static final TextAttributesKey PROTOCOL =
      createTextAttributesKey("PROTOCOL", DefaultLanguageHighlighterColors.CONSTANT);
  public static final TextAttributesKey BLOCK_COMMENT =
      createTextAttributesKey("BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);

  public static final TextAttributesKey KEYWORD_TOKEN =
      createTextAttributesKey("KEYWORD_TOKEN", DefaultLanguageHighlighterColors.KEYWORD);

  public static final TextAttributesKey ID =
      createTextAttributesKey("ID", DefaultLanguageHighlighterColors.IDENTIFIER);

  public static final TextAttributesKey DOC =
      createTextAttributesKey("DOC", DefaultLanguageHighlighterColors.STRING);

  public static final TextAttributesKey BAD_CHARACTER =
      createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


  private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
  private static final TextAttributesKey[] BLOCK_COMMENT_KEYS = new TextAttributesKey[]{BLOCK_COMMENT};
  private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD_TOKEN};
  private static final TextAttributesKey[] ID_KEYS = new TextAttributesKey[]{ID};
  private static final TextAttributesKey[] DOC_KEYS = new TextAttributesKey[]{DOC};
  private static final TextAttributesKey[] META_START_KEYS = new TextAttributesKey[]{META_START};
  private static final TextAttributesKey[] PROTOCOL_KEYS = new TextAttributesKey[]{PROTOCOL};
  private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];


  @Override
  public @NotNull Lexer getHighlightingLexer() {
    return new CmlLexerAdapter();
  }

  @Override
  public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
    if (tokenType.equals(CmlTypes.BLOCK_COMMENT)) {
      return BLOCK_COMMENT_KEYS;
    }

    if (tokenType.equals(CmlTypes.META_START)) {
      return META_START_KEYS;
    }

    if (tokenType.equals(CmlTypes.BOUNDED_CONTEXT_TOKEN) ||
        tokenType.equals(CmlTypes.CONSUMER_TOKEN) ||
        tokenType.equals(CmlTypes.SERVICE_TOKEN) ||
        tokenType.equals(CmlTypes.AGGREFATE_TOKEN) ||
        tokenType.equals(CmlTypes.HINT_TOKEN) ||
        tokenType.equals(CmlTypes.IMPORT_TOKEN) ||
        tokenType.equals(CmlTypes.DOMAIN_VISTION_TOKEN) ||
        tokenType.equals(CmlTypes.TECHNOLOGY_TOKEN) ||
        tokenType.equals(CmlTypes.COMMAND_EVENT_TOKEN) ||
        tokenType.equals(CmlTypes.DOMAIN_EVENT_TOKEN) ||
        tokenType.equals(CmlTypes.APPLICATION_TOKEN) ||
        tokenType.equals(CmlTypes.CAPTION_TOKEN) ||
        tokenType.equals(CmlTypes.OWNER_TOKEN) ||
        tokenType.equals(CmlTypes.VIA_TOKEN)
    ) {
      return KEYWORD_KEYS;
    }

    if (tokenType.equals(CmlTypes.REST_TOKEN) ||
        tokenType.equals(CmlTypes.QUEUE_TOKEN)) {
      return PROTOCOL_KEYS;
    }


    if (tokenType.equals(CmlTypes.STRING)) {
      return DOC_KEYS;
    }

    if (tokenType.equals(CmlTypes.ID)) {
      return ID_KEYS;
    }

    if (tokenType.equals(TokenType.BAD_CHARACTER)) {
      return BAD_CHAR_KEYS;
    }
    return EMPTY_KEYS;
  }
}

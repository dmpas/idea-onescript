package ru.dmpas.onescript.plugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import ru.dmpas.onescript.plugin.psi.OneScriptTypes;
import com.intellij.psi.TokenType;

%%

%class OneScriptLexer
%implements FlexLexer
%unicode
%ignorecase
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("//")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "
SYM_CHARS       = [a-zA-Z0-9]
SYM_START_CHARS = [a-zA-Z]
IDENTIFIER = {SYM_START_CHARS}{SYM_CHARS}*
WORD = {IDENTIFIER}
SUB_WORD="процедура"|"функция"|"procedure"|"function"
SUB_NAME={IDENTIFIER}

%state WAITING_VALUE
%state WAITING_SUB_NAME

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return OneScriptTypes.COMMENT; }

<YYINITIAL> {SUB_WORD}                                      { yybegin(WAITING_SUB_NAME); return OneScriptTypes.SUB_WORD; }

<WAITING_SUB_NAME> {WHITE_SPACE}+                               { yybegin(WAITING_SUB_NAME); return TokenType.WHITE_SPACE; }

<WAITING_SUB_NAME> {SUB_NAME}                                   { yybegin(YYINITIAL); return OneScriptTypes.SUB_NAME; }

// <YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return OneScriptTypes.KEY; }

// <YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return OneScriptTypes.SEPARATOR; }

// <WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

// <WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

// <WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return OneScriptTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }

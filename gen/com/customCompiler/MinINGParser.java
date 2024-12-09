// Generated from D:/University/2024-09_Semester-5/Random-projects/Compilator-project/CustomCompiler/src/main/java/com/customCompiler/MinINGParser.g4 by ANTLR 4.13.2
package com.customCompiler;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MinINGParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR_GLOBAL=1, DECLARATION=2, INSTRUCTION=3, CONST=4, TYPE=5, IF=6, ELSE=7, 
		FOR=8, READ=9, WRITE=10, IDF=11, INT=12, FLOAT=13, CHAR=14, ADD=15, SUB=16, 
		MUL=17, DIV=18, AND=19, OR=20, NOT=21, GREATER=22, GREATEREQUAL=23, LESS=24, 
		LESSEQUAL=25, EQUAL=26, NOTEQUAL=27, LPAREN=28, RPAREN=29, LBRACE=30, 
		RBRACE=31, LBRACKET=32, RBRACKET=33, SEMI=34, COLON=35, COMMA=36, COMMENT=37, 
		NEWLINE=38, SPACE=39, RECEIVE=40, STRING_LITERAL=41;
	public static final int
		RULE_prog = 0, RULE_varGlobal = 1, RULE_declaration = 2, RULE_instruction = 3, 
		RULE_varDeclaration = 4, RULE_arrayList = 5, RULE_arrayDecl = 6, RULE_statement = 7, 
		RULE_assignment = 8, RULE_condition = 9, RULE_loop = 10, RULE_ioOperation = 11, 
		RULE_expression = 12, RULE_term = 13, RULE_factor = 14, RULE_conditionExpr = 15, 
		RULE_comparisonOp = 16, RULE_stringOrExpression = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "varGlobal", "declaration", "instruction", "varDeclaration", 
			"arrayList", "arrayDecl", "statement", "assignment", "condition", "loop", 
			"ioOperation", "expression", "term", "factor", "conditionExpr", "comparisonOp", 
			"stringOrExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'VAR_GLOBAL'", "'DECLARATION'", "'INSTRUCTION'", "'CONST'", null, 
			"'IF'", "'ELSE'", "'FOR'", "'READ'", "'WRITE'", null, null, null, null, 
			"'+'", "'-'", "'*'", "'/'", "'&&'", "'||'", "'!'", "'>'", "'>='", "'<'", 
			"'<='", "'=='", "'!='", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", 
			"':'", "','", null, null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR_GLOBAL", "DECLARATION", "INSTRUCTION", "CONST", "TYPE", "IF", 
			"ELSE", "FOR", "READ", "WRITE", "IDF", "INT", "FLOAT", "CHAR", "ADD", 
			"SUB", "MUL", "DIV", "AND", "OR", "NOT", "GREATER", "GREATEREQUAL", "LESS", 
			"LESSEQUAL", "EQUAL", "NOTEQUAL", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"LBRACKET", "RBRACKET", "SEMI", "COLON", "COMMA", "COMMENT", "NEWLINE", 
			"SPACE", "RECEIVE", "STRING_LITERAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MinINGParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MinINGParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ProgContext {
		public VarGlobalContext varGlobal() {
			return getRuleContext(VarGlobalContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MinINGParser.EOF, 0); }
		public ProgramContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			_localctx = new ProgramContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			varGlobal();
			setState(37);
			declaration();
			setState(38);
			instruction();
			setState(39);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarGlobalContext extends ParserRuleContext {
		public VarGlobalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varGlobal; }
	 
		public VarGlobalContext() { }
		public void copyFrom(VarGlobalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableGlobalSegmentContext extends VarGlobalContext {
		public TerminalNode VAR_GLOBAL() { return getToken(MinINGParser.VAR_GLOBAL, 0); }
		public TerminalNode LBRACE() { return getToken(MinINGParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MinINGParser.RBRACE, 0); }
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public VariableGlobalSegmentContext(VarGlobalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterVariableGlobalSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitVariableGlobalSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitVariableGlobalSegment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarGlobalContext varGlobal() throws RecognitionException {
		VarGlobalContext _localctx = new VarGlobalContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_varGlobal);
		int _la;
		try {
			_localctx = new VariableGlobalSegmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(VAR_GLOBAL);
			setState(42);
			match(LBRACE);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST || _la==TYPE) {
				{
				{
				setState(43);
				varDeclaration();
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationSegmentContext extends DeclarationContext {
		public TerminalNode DECLARATION() { return getToken(MinINGParser.DECLARATION, 0); }
		public TerminalNode LBRACE() { return getToken(MinINGParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MinINGParser.RBRACE, 0); }
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public DeclarationSegmentContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterDeclarationSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitDeclarationSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitDeclarationSegment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		int _la;
		try {
			_localctx = new DeclarationSegmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(DECLARATION);
			setState(52);
			match(LBRACE);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST || _la==TYPE) {
				{
				{
				setState(53);
				varDeclaration();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends ParserRuleContext {
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	 
		public InstructionContext() { }
		public void copyFrom(InstructionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionSegmentContext extends InstructionContext {
		public TerminalNode INSTRUCTION() { return getToken(MinINGParser.INSTRUCTION, 0); }
		public TerminalNode LBRACE() { return getToken(MinINGParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MinINGParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public InstructionSegmentContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterInstructionSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitInstructionSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitInstructionSegment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		int _la;
		try {
			_localctx = new InstructionSegmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(INSTRUCTION);
			setState(62);
			match(LBRACE);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3904L) != 0)) {
				{
				{
				setState(63);
				statement();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	 
		public VarDeclarationContext() { }
		public void copyFrom(VarDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayDeclarationContext extends VarDeclarationContext {
		public TerminalNode TYPE() { return getToken(MinINGParser.TYPE, 0); }
		public ArrayListContext arrayList() {
			return getRuleContext(ArrayListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MinINGParser.SEMI, 0); }
		public ArrayDeclarationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitArrayDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitArrayDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends VarDeclarationContext {
		public TerminalNode TYPE() { return getToken(MinINGParser.TYPE, 0); }
		public List<TerminalNode> IDF() { return getTokens(MinINGParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(MinINGParser.IDF, i);
		}
		public TerminalNode SEMI() { return getToken(MinINGParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MinINGParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MinINGParser.COMMA, i);
		}
		public VariableDeclarationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstDeclarationContext extends VarDeclarationContext {
		public TerminalNode CONST() { return getToken(MinINGParser.CONST, 0); }
		public TerminalNode TYPE() { return getToken(MinINGParser.TYPE, 0); }
		public TerminalNode IDF() { return getToken(MinINGParser.IDF, 0); }
		public TerminalNode RECEIVE() { return getToken(MinINGParser.RECEIVE, 0); }
		public TerminalNode SEMI() { return getToken(MinINGParser.SEMI, 0); }
		public TerminalNode INT() { return getToken(MinINGParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(MinINGParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(MinINGParser.CHAR, 0); }
		public ConstDeclarationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterConstDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitConstDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitConstDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDeclaration);
		int _la;
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new VariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(TYPE);
				setState(72);
				match(IDF);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(73);
					match(COMMA);
					setState(74);
					match(IDF);
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(80);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new ArrayDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(TYPE);
				setState(82);
				arrayList();
				setState(83);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new ConstDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				match(CONST);
				setState(86);
				match(TYPE);
				setState(87);
				match(IDF);
				setState(88);
				match(RECEIVE);
				setState(89);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(90);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayListContext extends ParserRuleContext {
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MinINGParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MinINGParser.COMMA, i);
		}
		public ArrayListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterArrayList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitArrayList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitArrayList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayListContext arrayList() throws RecognitionException {
		ArrayListContext _localctx = new ArrayListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arrayList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			arrayDecl();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(94);
				match(COMMA);
				setState(95);
				arrayDecl();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayDeclContext extends ParserRuleContext {
		public TerminalNode IDF() { return getToken(MinINGParser.IDF, 0); }
		public TerminalNode LBRACKET() { return getToken(MinINGParser.LBRACKET, 0); }
		public TerminalNode INT() { return getToken(MinINGParser.INT, 0); }
		public TerminalNode RBRACKET() { return getToken(MinINGParser.RBRACKET, 0); }
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitArrayDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arrayDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(IDF);
			setState(102);
			match(LBRACKET);
			setState(103);
			match(INT);
			setState(104);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IOStatementContext extends StatementContext {
		public IoOperationContext ioOperation() {
			return getRuleContext(IoOperationContext.class,0);
		}
		public IOStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterIOStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitIOStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitIOStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentStatementContext extends StatementContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignmentStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionStatementContext extends StatementContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterConditionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitConditionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitConditionStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopStatementContext extends StatementContext {
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public LoopStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDF:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				assignment();
				}
				break;
			case IF:
				_localctx = new ConditionStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				condition();
				}
				break;
			case FOR:
				_localctx = new LoopStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				loop();
				}
				break;
			case READ:
			case WRITE:
				_localctx = new IOStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				ioOperation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends AssignmentContext {
		public TerminalNode IDF() { return getToken(MinINGParser.IDF, 0); }
		public TerminalNode RECEIVE() { return getToken(MinINGParser.RECEIVE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MinINGParser.SEMI, 0); }
		public AssignmentExpressionContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignment);
		try {
			_localctx = new AssignmentExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(IDF);
			setState(113);
			match(RECEIVE);
			setState(114);
			expression();
			setState(115);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalStatementContext extends ConditionContext {
		public TerminalNode IF() { return getToken(MinINGParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(MinINGParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(MinINGParser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(MinINGParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(MinINGParser.RBRACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MinINGParser.ELSE, 0); }
		public ConditionalStatementContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterConditionalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitConditionalStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitConditionalStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_condition);
		int _la;
		try {
			_localctx = new ConditionalStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(IF);
			setState(118);
			match(LPAREN);
			setState(119);
			conditionExpr();
			setState(120);
			match(RPAREN);
			setState(121);
			match(LBRACE);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3904L) != 0)) {
				{
				{
				setState(122);
				statement();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(RBRACE);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(129);
				match(ELSE);
				setState(130);
				match(LBRACE);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3904L) != 0)) {
					{
					{
					setState(131);
					statement();
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(137);
				match(RBRACE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopContext extends ParserRuleContext {
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	 
		public LoopContext() { }
		public void copyFrom(LoopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopDefinitionContext extends LoopContext {
		public TerminalNode FOR() { return getToken(MinINGParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(MinINGParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(MinINGParser.COLON, i);
		}
		public TerminalNode INT() { return getToken(MinINGParser.INT, 0); }
		public TerminalNode IDF() { return getToken(MinINGParser.IDF, 0); }
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MinINGParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MinINGParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LoopDefinitionContext(LoopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterLoopDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitLoopDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitLoopDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_loop);
		int _la;
		try {
			_localctx = new LoopDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(FOR);
			setState(141);
			match(LPAREN);
			setState(142);
			assignment();
			setState(143);
			match(COLON);
			setState(144);
			match(INT);
			setState(145);
			match(COLON);
			setState(146);
			match(IDF);
			setState(147);
			match(RPAREN);
			setState(148);
			match(LBRACE);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3904L) != 0)) {
				{
				{
				setState(149);
				statement();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IoOperationContext extends ParserRuleContext {
		public IoOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ioOperation; }
	 
		public IoOperationContext() { }
		public void copyFrom(IoOperationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadOperationContext extends IoOperationContext {
		public TerminalNode READ() { return getToken(MinINGParser.READ, 0); }
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public TerminalNode IDF() { return getToken(MinINGParser.IDF, 0); }
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(MinINGParser.SEMI, 0); }
		public ReadOperationContext(IoOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterReadOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitReadOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitReadOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WriteOperationContext extends IoOperationContext {
		public TerminalNode WRITE() { return getToken(MinINGParser.WRITE, 0); }
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(MinINGParser.SEMI, 0); }
		public List<StringOrExpressionContext> stringOrExpression() {
			return getRuleContexts(StringOrExpressionContext.class);
		}
		public StringOrExpressionContext stringOrExpression(int i) {
			return getRuleContext(StringOrExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MinINGParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MinINGParser.COMMA, i);
		}
		public WriteOperationContext(IoOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterWriteOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitWriteOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitWriteOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IoOperationContext ioOperation() throws RecognitionException {
		IoOperationContext _localctx = new IoOperationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ioOperation);
		int _la;
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case READ:
				_localctx = new ReadOperationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(READ);
				setState(158);
				match(LPAREN);
				setState(159);
				match(IDF);
				setState(160);
				match(RPAREN);
				setState(161);
				match(SEMI);
				}
				break;
			case WRITE:
				_localctx = new WriteOperationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				match(WRITE);
				setState(163);
				match(LPAREN);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199291721728L) != 0)) {
					{
					setState(164);
					stringOrExpression();
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(165);
						match(COMMA);
						setState(166);
						stringOrExpression();
						}
						}
						setState(171);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(174);
				match(RPAREN);
				setState(175);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditionContext extends ExpressionContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> ADD() { return getTokens(MinINGParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(MinINGParser.ADD, i);
		}
		public AdditionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitAddition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubtractionContext extends ExpressionContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> SUB() { return getTokens(MinINGParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(MinINGParser.SUB, i);
		}
		public SubtractionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterSubtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitSubtraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		int _la;
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new AdditionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				term();
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ADD) {
					{
					{
					setState(179);
					match(ADD);
					setState(180);
					term();
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new SubtractionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				term();
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SUB) {
					{
					{
					setState(187);
					match(SUB);
					setState(188);
					term();
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationContext extends TermContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(MinINGParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(MinINGParser.MUL, i);
		}
		public MultiplicationContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivisionContext extends TermContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> DIV() { return getTokens(MinINGParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(MinINGParser.DIV, i);
		}
		public DivisionContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_term);
		int _la;
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new MultiplicationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				factor();
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MUL) {
					{
					{
					setState(197);
					match(MUL);
					setState(198);
					factor();
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new DivisionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				factor();
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DIV) {
					{
					{
					setState(205);
					match(DIV);
					setState(206);
					factor();
					}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends FactorContext {
		public TerminalNode INT() { return getToken(MinINGParser.INT, 0); }
		public IntegerContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatContext extends FactorContext {
		public TerminalNode FLOAT() { return getToken(MinINGParser.FLOAT, 0); }
		public FloatContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisContext extends FactorContext {
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public ParenthesisContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends FactorContext {
		public TerminalNode IDF() { return getToken(MinINGParser.IDF, 0); }
		public VariableContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharContext extends FactorContext {
		public TerminalNode CHAR() { return getToken(MinINGParser.CHAR, 0); }
		public CharContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitChar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_factor);
		try {
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new ParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(LPAREN);
				setState(215);
				expression();
				setState(216);
				match(RPAREN);
				}
				break;
			case INT:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				match(FLOAT);
				}
				break;
			case CHAR:
				_localctx = new CharContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				match(CHAR);
				}
				break;
			case IDF:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(221);
				match(IDF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionExprContext extends ParserRuleContext {
		public ConditionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionExpr; }
	 
		public ConditionExprContext() { }
		public void copyFrom(ConditionExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ConditionExprContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonOpContext comparisonOp() {
			return getRuleContext(ComparisonOpContext.class,0);
		}
		public ComparisonContext(ConditionExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionExprContext conditionExpr() throws RecognitionException {
		ConditionExprContext _localctx = new ConditionExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_conditionExpr);
		try {
			_localctx = new ComparisonContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			expression();
			setState(225);
			comparisonOp();
			setState(226);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonOpContext extends ParserRuleContext {
		public TerminalNode GREATER() { return getToken(MinINGParser.GREATER, 0); }
		public TerminalNode GREATEREQUAL() { return getToken(MinINGParser.GREATEREQUAL, 0); }
		public TerminalNode LESS() { return getToken(MinINGParser.LESS, 0); }
		public TerminalNode LESSEQUAL() { return getToken(MinINGParser.LESSEQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(MinINGParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(MinINGParser.NOTEQUAL, 0); }
		public ComparisonOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterComparisonOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitComparisonOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitComparisonOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOpContext comparisonOp() throws RecognitionException {
		ComparisonOpContext _localctx = new ComparisonOpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comparisonOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 264241152L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringOrExpressionContext extends ParserRuleContext {
		public StringOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringOrExpression; }
	 
		public StringOrExpressionContext() { }
		public void copyFrom(StringOrExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends StringOrExpressionContext {
		public TerminalNode STRING_LITERAL() { return getToken(MinINGParser.STRING_LITERAL, 0); }
		public StringLiteralContext(StringOrExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionInWriteContext extends StringOrExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionInWriteContext(StringOrExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterExpressionInWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitExpressionInWrite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitExpressionInWrite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringOrExpressionContext stringOrExpression() throws RecognitionException {
		StringOrExpressionContext _localctx = new StringOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stringOrExpression);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(STRING_LITERAL);
				}
				break;
			case IDF:
			case INT:
			case FLOAT:
			case CHAR:
			case LPAREN:
				_localctx = new ExpressionInWriteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001)\u00eb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001-\b\u0001\n\u0001\f\u00010\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00027\b\u0002\n\u0002\f\u0002"+
		":\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003A\b\u0003\n\u0003\f\u0003D\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004L\b\u0004"+
		"\n\u0004\f\u0004O\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\\\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005a\b\u0005\n\u0005\f\u0005d\t\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007o\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t|\b\t\n\t\f"+
		"\t\u007f\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0085\b\t\n\t\f\t"+
		"\u0088\t\t\u0001\t\u0003\t\u008b\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0097\b\n\n\n\f\n\u009a"+
		"\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u00a8\b\u000b\n\u000b\f\u000b\u00ab\t\u000b\u0003\u000b\u00ad\b"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00b1\b\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0005\f\u00b6\b\f\n\f\f\f\u00b9\t\f\u0001\f\u0001\f\u0001\f"+
		"\u0005\f\u00be\b\f\n\f\f\f\u00c1\t\f\u0003\f\u00c3\b\f\u0001\r\u0001\r"+
		"\u0001\r\u0005\r\u00c8\b\r\n\r\f\r\u00cb\t\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u00d0\b\r\n\r\f\r\u00d3\t\r\u0003\r\u00d5\b\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00df\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u00e9\b\u0011"+
		"\u0001\u0011\u0000\u0000\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\u0002\u0001\u0000"+
		"\f\u000e\u0001\u0000\u0016\u001b\u00f4\u0000$\u0001\u0000\u0000\u0000"+
		"\u0002)\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000\u0006="+
		"\u0001\u0000\u0000\u0000\b[\u0001\u0000\u0000\u0000\n]\u0001\u0000\u0000"+
		"\u0000\fe\u0001\u0000\u0000\u0000\u000en\u0001\u0000\u0000\u0000\u0010"+
		"p\u0001\u0000\u0000\u0000\u0012u\u0001\u0000\u0000\u0000\u0014\u008c\u0001"+
		"\u0000\u0000\u0000\u0016\u00b0\u0001\u0000\u0000\u0000\u0018\u00c2\u0001"+
		"\u0000\u0000\u0000\u001a\u00d4\u0001\u0000\u0000\u0000\u001c\u00de\u0001"+
		"\u0000\u0000\u0000\u001e\u00e0\u0001\u0000\u0000\u0000 \u00e4\u0001\u0000"+
		"\u0000\u0000\"\u00e8\u0001\u0000\u0000\u0000$%\u0003\u0002\u0001\u0000"+
		"%&\u0003\u0004\u0002\u0000&\'\u0003\u0006\u0003\u0000\'(\u0005\u0000\u0000"+
		"\u0001(\u0001\u0001\u0000\u0000\u0000)*\u0005\u0001\u0000\u0000*.\u0005"+
		"\u001e\u0000\u0000+-\u0003\b\u0004\u0000,+\u0001\u0000\u0000\u0000-0\u0001"+
		"\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/1\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000012\u0005\u001f\u0000"+
		"\u00002\u0003\u0001\u0000\u0000\u000034\u0005\u0002\u0000\u000048\u0005"+
		"\u001e\u0000\u000057\u0003\b\u0004\u000065\u0001\u0000\u0000\u00007:\u0001"+
		"\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u0000"+
		"9;\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;<\u0005\u001f\u0000"+
		"\u0000<\u0005\u0001\u0000\u0000\u0000=>\u0005\u0003\u0000\u0000>B\u0005"+
		"\u001e\u0000\u0000?A\u0003\u000e\u0007\u0000@?\u0001\u0000\u0000\u0000"+
		"AD\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000"+
		"\u0000CE\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000EF\u0005\u001f"+
		"\u0000\u0000F\u0007\u0001\u0000\u0000\u0000GH\u0005\u0005\u0000\u0000"+
		"HM\u0005\u000b\u0000\u0000IJ\u0005$\u0000\u0000JL\u0005\u000b\u0000\u0000"+
		"KI\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000"+
		"\u0000MN\u0001\u0000\u0000\u0000NP\u0001\u0000\u0000\u0000OM\u0001\u0000"+
		"\u0000\u0000P\\\u0005\"\u0000\u0000QR\u0005\u0005\u0000\u0000RS\u0003"+
		"\n\u0005\u0000ST\u0005\"\u0000\u0000T\\\u0001\u0000\u0000\u0000UV\u0005"+
		"\u0004\u0000\u0000VW\u0005\u0005\u0000\u0000WX\u0005\u000b\u0000\u0000"+
		"XY\u0005(\u0000\u0000YZ\u0007\u0000\u0000\u0000Z\\\u0005\"\u0000\u0000"+
		"[G\u0001\u0000\u0000\u0000[Q\u0001\u0000\u0000\u0000[U\u0001\u0000\u0000"+
		"\u0000\\\t\u0001\u0000\u0000\u0000]b\u0003\f\u0006\u0000^_\u0005$\u0000"+
		"\u0000_a\u0003\f\u0006\u0000`^\u0001\u0000\u0000\u0000ad\u0001\u0000\u0000"+
		"\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000c\u000b\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000ef\u0005\u000b\u0000\u0000"+
		"fg\u0005 \u0000\u0000gh\u0005\f\u0000\u0000hi\u0005!\u0000\u0000i\r\u0001"+
		"\u0000\u0000\u0000jo\u0003\u0010\b\u0000ko\u0003\u0012\t\u0000lo\u0003"+
		"\u0014\n\u0000mo\u0003\u0016\u000b\u0000nj\u0001\u0000\u0000\u0000nk\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000\u0000"+
		"o\u000f\u0001\u0000\u0000\u0000pq\u0005\u000b\u0000\u0000qr\u0005(\u0000"+
		"\u0000rs\u0003\u0018\f\u0000st\u0005\"\u0000\u0000t\u0011\u0001\u0000"+
		"\u0000\u0000uv\u0005\u0006\u0000\u0000vw\u0005\u001c\u0000\u0000wx\u0003"+
		"\u001e\u000f\u0000xy\u0005\u001d\u0000\u0000y}\u0005\u001e\u0000\u0000"+
		"z|\u0003\u000e\u0007\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000"+
		"\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080"+
		"\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u008a\u0005"+
		"\u001f\u0000\u0000\u0081\u0082\u0005\u0007\u0000\u0000\u0082\u0086\u0005"+
		"\u001e\u0000\u0000\u0083\u0085\u0003\u000e\u0007\u0000\u0084\u0083\u0001"+
		"\u0000\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0089\u0001"+
		"\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u008b\u0005"+
		"\u001f\u0000\u0000\u008a\u0081\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u0013\u0001\u0000\u0000\u0000\u008c\u008d\u0005"+
		"\b\u0000\u0000\u008d\u008e\u0005\u001c\u0000\u0000\u008e\u008f\u0003\u0010"+
		"\b\u0000\u008f\u0090\u0005#\u0000\u0000\u0090\u0091\u0005\f\u0000\u0000"+
		"\u0091\u0092\u0005#\u0000\u0000\u0092\u0093\u0005\u000b\u0000\u0000\u0093"+
		"\u0094\u0005\u001d\u0000\u0000\u0094\u0098\u0005\u001e\u0000\u0000\u0095"+
		"\u0097\u0003\u000e\u0007\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097"+
		"\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0001\u0000\u0000\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a"+
		"\u0098\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u001f\u0000\u0000\u009c"+
		"\u0015\u0001\u0000\u0000\u0000\u009d\u009e\u0005\t\u0000\u0000\u009e\u009f"+
		"\u0005\u001c\u0000\u0000\u009f\u00a0\u0005\u000b\u0000\u0000\u00a0\u00a1"+
		"\u0005\u001d\u0000\u0000\u00a1\u00b1\u0005\"\u0000\u0000\u00a2\u00a3\u0005"+
		"\n\u0000\u0000\u00a3\u00ac\u0005\u001c\u0000\u0000\u00a4\u00a9\u0003\""+
		"\u0011\u0000\u00a5\u00a6\u0005$\u0000\u0000\u00a6\u00a8\u0003\"\u0011"+
		"\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000"+
		"\u0000\u00ac\u00a4\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u001d\u0000"+
		"\u0000\u00af\u00b1\u0005\"\u0000\u0000\u00b0\u009d\u0001\u0000\u0000\u0000"+
		"\u00b0\u00a2\u0001\u0000\u0000\u0000\u00b1\u0017\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b7\u0003\u001a\r\u0000\u00b3\u00b4\u0005\u000f\u0000\u0000\u00b4"+
		"\u00b6\u0003\u001a\r\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b9"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8"+
		"\u0001\u0000\u0000\u0000\u00b8\u00c3\u0001\u0000\u0000\u0000\u00b9\u00b7"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bf\u0003\u001a\r\u0000\u00bb\u00bc\u0005"+
		"\u0010\u0000\u0000\u00bc\u00be\u0003\u001a\r\u0000\u00bd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00be\u00c1\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2\u00b2\u0001\u0000"+
		"\u0000\u0000\u00c2\u00ba\u0001\u0000\u0000\u0000\u00c3\u0019\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c9\u0003\u001c\u000e\u0000\u00c5\u00c6\u0005\u0011"+
		"\u0000\u0000\u00c6\u00c8\u0003\u001c\u000e\u0000\u00c7\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00d5\u0001\u0000"+
		"\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00d1\u0003\u001c"+
		"\u000e\u0000\u00cd\u00ce\u0005\u0012\u0000\u0000\u00ce\u00d0\u0003\u001c"+
		"\u000e\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d4\u00c4\u0001\u0000\u0000\u0000\u00d4\u00cc\u0001\u0000"+
		"\u0000\u0000\u00d5\u001b\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u001c"+
		"\u0000\u0000\u00d7\u00d8\u0003\u0018\f\u0000\u00d8\u00d9\u0005\u001d\u0000"+
		"\u0000\u00d9\u00df\u0001\u0000\u0000\u0000\u00da\u00df\u0005\f\u0000\u0000"+
		"\u00db\u00df\u0005\r\u0000\u0000\u00dc\u00df\u0005\u000e\u0000\u0000\u00dd"+
		"\u00df\u0005\u000b\u0000\u0000\u00de\u00d6\u0001\u0000\u0000\u0000\u00de"+
		"\u00da\u0001\u0000\u0000\u0000\u00de\u00db\u0001\u0000\u0000\u0000\u00de"+
		"\u00dc\u0001\u0000\u0000\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u001d\u0001\u0000\u0000\u0000\u00e0\u00e1\u0003\u0018\f\u0000\u00e1\u00e2"+
		"\u0003 \u0010\u0000\u00e2\u00e3\u0003\u0018\f\u0000\u00e3\u001f\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0007\u0001\u0000\u0000\u00e5!\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e9\u0005)\u0000\u0000\u00e7\u00e9\u0003\u0018\f"+
		"\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e7\u0001\u0000\u0000"+
		"\u0000\u00e9#\u0001\u0000\u0000\u0000\u0016.8BM[bn}\u0086\u008a\u0098"+
		"\u00a9\u00ac\u00b0\u00b7\u00bf\u00c2\u00c9\u00d1\u00d4\u00de\u00e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
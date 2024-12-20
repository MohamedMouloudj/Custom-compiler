// Generated from C:/Users/Ramzi/Desktop/ProjetCompile/Custom-compiler/src/main/java/com/customCompiler/MinINGParser.g4 by ANTLR 4.13.2
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
		RULE_assignment = 8, RULE_condition = 9, RULE_loop = 10, RULE_loopAssignment = 11, 
		RULE_ioOperation = 12, RULE_expression = 13, RULE_term = 14, RULE_operation_gf = 15, 
		RULE_factor = 16, RULE_conditionExpr = 17, RULE_comparisonOp = 18, RULE_stringOrExpression = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "varGlobal", "declaration", "instruction", "varDeclaration", 
			"arrayList", "arrayDecl", "statement", "assignment", "condition", "loop", 
			"loopAssignment", "ioOperation", "expression", "term", "operation_gf", 
			"factor", "conditionExpr", "comparisonOp", "stringOrExpression"
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
			setState(40);
			varGlobal();
			setState(41);
			declaration();
			setState(42);
			instruction();
			setState(43);
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
			setState(45);
			match(VAR_GLOBAL);
			setState(46);
			match(LBRACE);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST || _la==TYPE) {
				{
				{
				setState(47);
				varDeclaration();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
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
			setState(55);
			match(DECLARATION);
			setState(56);
			match(LBRACE);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST || _la==TYPE) {
				{
				{
				setState(57);
				varDeclaration();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
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
			setState(65);
			match(INSTRUCTION);
			setState(66);
			match(LBRACE);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268566336L) != 0)) {
				{
				{
				setState(67);
				statement();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
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
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new VariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(TYPE);
				setState(76);
				match(IDF);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(77);
					match(COMMA);
					setState(78);
					match(IDF);
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new ArrayDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(TYPE);
				setState(86);
				arrayList();
				setState(87);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new ConstDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				match(CONST);
				setState(90);
				match(TYPE);
				setState(91);
				match(IDF);
				setState(92);
				match(RECEIVE);
				setState(93);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(94);
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
			setState(97);
			arrayDecl();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(98);
				match(COMMA);
				setState(99);
				arrayDecl();
				}
				}
				setState(104);
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
			setState(105);
			match(IDF);
			setState(106);
			match(LBRACKET);
			setState(107);
			match(INT);
			setState(108);
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
	public static class ExpressionStatementContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MinINGParser.SEMI, 0); }
		public ExpressionStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitExpressionStatement(this);
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
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				assignment();
				}
				break;
			case 2:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				expression(0);
				setState(112);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new ConditionStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				condition();
				}
				break;
			case 4:
				_localctx = new LoopStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(115);
				loop();
				}
				break;
			case 5:
				_localctx = new IOStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(116);
				ioOperation();
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
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayElementAssignmentContext extends AssignmentContext {
		public TerminalNode IDF() { return getToken(MinINGParser.IDF, 0); }
		public TerminalNode LBRACKET() { return getToken(MinINGParser.LBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(MinINGParser.RBRACKET, 0); }
		public TerminalNode RECEIVE() { return getToken(MinINGParser.RECEIVE, 0); }
		public TerminalNode SEMI() { return getToken(MinINGParser.SEMI, 0); }
		public ArrayElementAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterArrayElementAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitArrayElementAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitArrayElementAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignment);
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AssignmentExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(IDF);
				setState(120);
				match(RECEIVE);
				setState(121);
				expression(0);
				setState(122);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new ArrayElementAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(IDF);
				setState(125);
				match(LBRACKET);
				setState(126);
				expression(0);
				setState(127);
				match(RBRACKET);
				setState(128);
				match(RECEIVE);
				setState(129);
				expression(0);
				setState(130);
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
			setState(134);
			match(IF);
			setState(135);
			match(LPAREN);
			setState(136);
			conditionExpr(0);
			setState(137);
			match(RPAREN);
			setState(138);
			match(LBRACE);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268566336L) != 0)) {
				{
				{
				setState(139);
				statement();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			match(RBRACE);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(146);
				match(ELSE);
				setState(147);
				match(LBRACE);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268566336L) != 0)) {
					{
					{
					setState(148);
					statement();
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(154);
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
		public LoopAssignmentContext loopAssignment() {
			return getRuleContext(LoopAssignmentContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(MinINGParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(MinINGParser.COLON, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
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
			setState(157);
			match(FOR);
			setState(158);
			match(LPAREN);
			setState(159);
			loopAssignment();
			setState(160);
			match(COLON);
			setState(161);
			expression(0);
			setState(162);
			match(COLON);
			setState(163);
			expression(0);
			setState(164);
			match(RPAREN);
			setState(165);
			match(LBRACE);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268566336L) != 0)) {
				{
				{
				setState(166);
				statement();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
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
	public static class LoopAssignmentContext extends ParserRuleContext {
		public TerminalNode IDF() { return getToken(MinINGParser.IDF, 0); }
		public TerminalNode RECEIVE() { return getToken(MinINGParser.RECEIVE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterLoopAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitLoopAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitLoopAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopAssignmentContext loopAssignment() throws RecognitionException {
		LoopAssignmentContext _localctx = new LoopAssignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_loopAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(IDF);
			setState(175);
			match(RECEIVE);
			setState(176);
			expression(0);
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
	@SuppressWarnings("CheckReturnValue")
	public static class ReadArrayOperationContext extends IoOperationContext {
		public TerminalNode READ() { return getToken(MinINGParser.READ, 0); }
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public TerminalNode IDF() { return getToken(MinINGParser.IDF, 0); }
		public TerminalNode LBRACKET() { return getToken(MinINGParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(MinINGParser.RBRACKET, 0); }
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(MinINGParser.SEMI, 0); }
		public ReadArrayOperationContext(IoOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterReadArrayOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitReadArrayOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitReadArrayOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IoOperationContext ioOperation() throws RecognitionException {
		IoOperationContext _localctx = new IoOperationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ioOperation);
		int _la;
		try {
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new ReadOperationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(READ);
				setState(179);
				match(LPAREN);
				setState(180);
				match(IDF);
				setState(181);
				match(RPAREN);
				setState(182);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new ReadArrayOperationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(READ);
				setState(184);
				match(LPAREN);
				setState(185);
				match(IDF);
				setState(186);
				match(LBRACKET);
				setState(187);
				expression(0);
				setState(188);
				match(RBRACKET);
				setState(189);
				match(RPAREN);
				setState(190);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new WriteOperationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(WRITE);
				setState(193);
				match(LPAREN);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199291820032L) != 0)) {
					{
					setState(194);
					stringOrExpression();
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(195);
						match(COMMA);
						setState(196);
						stringOrExpression();
						}
						}
						setState(201);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(204);
				match(RPAREN);
				setState(205);
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
	public static class SubstractionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SUB() { return getToken(MinINGParser.SUB, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SubstractionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterSubstraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitSubstraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitSubstraction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(MinINGParser.ADD, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
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
	public static class SimpleTermContext extends ExpressionContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SimpleTermContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterSimpleTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitSimpleTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitSimpleTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleTermContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(209);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(217);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new AdditionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(211);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(212);
						match(ADD);
						setState(213);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new SubstractionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(214);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(215);
						match(SUB);
						setState(216);
						term(0);
						}
						break;
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MUL() { return getToken(MinINGParser.MUL, 0); }
		public Operation_gfContext operation_gf() {
			return getRuleContext(Operation_gfContext.class,0);
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
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode DIV() { return getToken(MinINGParser.DIV, 0); }
		public Operation_gfContext operation_gf() {
			return getRuleContext(Operation_gfContext.class,0);
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
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleOpContext extends TermContext {
		public Operation_gfContext operation_gf() {
			return getRuleContext(Operation_gfContext.class,0);
		}
		public SimpleOpContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterSimpleOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitSimpleOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitSimpleOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleOpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(223);
			operation_gf();
			}
			_ctx.stop = _input.LT(-1);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(231);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(225);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(226);
						match(MUL);
						setState(227);
						operation_gf();
						}
						break;
					case 2:
						{
						_localctx = new DivisionContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(228);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(229);
						match(DIV);
						setState(230);
						operation_gf();
						}
						break;
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Operation_gfContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public TerminalNode SUB() { return getToken(MinINGParser.SUB, 0); }
		public Operation_gfContext operation_gf() {
			return getRuleContext(Operation_gfContext.class,0);
		}
		public TerminalNode ADD() { return getToken(MinINGParser.ADD, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Operation_gfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation_gf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterOperation_gf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitOperation_gf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitOperation_gf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operation_gfContext operation_gf() throws RecognitionException {
		Operation_gfContext _localctx = new Operation_gfContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_operation_gf);
		try {
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(LPAREN);
				setState(237);
				expression(0);
				setState(238);
				match(RPAREN);
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(SUB);
				setState(241);
				operation_gf();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 3);
				{
				setState(242);
				match(ADD);
				setState(243);
				operation_gf();
				}
				break;
			case IDF:
			case INT:
			case FLOAT:
			case CHAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(244);
				factor();
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
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayElementContext extends FactorContext {
		public TerminalNode IDF() { return getToken(MinINGParser.IDF, 0); }
		public TerminalNode LBRACKET() { return getToken(MinINGParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(MinINGParser.RBRACKET, 0); }
		public ArrayElementContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterArrayElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitArrayElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitArrayElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_factor);
		try {
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				match(INT);
				}
				break;
			case 2:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				match(FLOAT);
				}
				break;
			case 3:
				_localctx = new CharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				match(CHAR);
				}
				break;
			case 4:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				match(IDF);
				}
				break;
			case 5:
				_localctx = new ArrayElementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(251);
				match(IDF);
				setState(252);
				match(LBRACKET);
				setState(253);
				expression(0);
				setState(254);
				match(RBRACKET);
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
	public static class ParenthesisConditionContext extends ConditionExprContext {
		public TerminalNode LPAREN() { return getToken(MinINGParser.LPAREN, 0); }
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MinINGParser.RPAREN, 0); }
		public ParenthesisConditionContext(ConditionExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterParenthesisCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitParenthesisCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitParenthesisCondition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegationContext extends ConditionExprContext {
		public TerminalNode NOT() { return getToken(MinINGParser.NOT, 0); }
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public NegationContext(ConditionExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitNegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
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
	@SuppressWarnings("CheckReturnValue")
	public static class OrConditionContext extends ConditionExprContext {
		public List<ConditionExprContext> conditionExpr() {
			return getRuleContexts(ConditionExprContext.class);
		}
		public ConditionExprContext conditionExpr(int i) {
			return getRuleContext(ConditionExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(MinINGParser.OR, 0); }
		public OrConditionContext(ConditionExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterOrCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitOrCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitOrCondition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndConditionContext extends ConditionExprContext {
		public List<ConditionExprContext> conditionExpr() {
			return getRuleContexts(ConditionExprContext.class);
		}
		public ConditionExprContext conditionExpr(int i) {
			return getRuleContext(ConditionExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(MinINGParser.AND, 0); }
		public AndConditionContext(ConditionExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).enterAndCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MinINGParserListener ) ((MinINGParserListener)listener).exitAndCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MinINGParserVisitor ) return ((MinINGParserVisitor<? extends T>)visitor).visitAndCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionExprContext conditionExpr() throws RecognitionException {
		return conditionExpr(0);
	}

	private ConditionExprContext conditionExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionExprContext _localctx = new ConditionExprContext(_ctx, _parentState);
		ConditionExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_conditionExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(259);
				expression(0);
				setState(260);
				comparisonOp();
				setState(261);
				expression(0);
				}
				break;
			case 2:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263);
				match(NOT);
				setState(264);
				conditionExpr(4);
				}
				break;
			case 3:
				{
				_localctx = new ParenthesisConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				match(LPAREN);
				setState(266);
				conditionExpr(0);
				setState(267);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(277);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new OrConditionContext(new ConditionExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionExpr);
						setState(271);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(272);
						match(OR);
						setState(273);
						conditionExpr(4);
						}
						break;
					case 2:
						{
						_localctx = new AndConditionContext(new ConditionExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionExpr);
						setState(274);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(275);
						match(AND);
						setState(276);
						conditionExpr(3);
						}
						break;
					}
					} 
				}
				setState(281);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
		enterRule(_localctx, 36, RULE_comparisonOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
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
		enterRule(_localctx, 38, RULE_stringOrExpression);
		try {
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(STRING_LITERAL);
				}
				break;
			case IDF:
			case INT:
			case FLOAT:
			case CHAR:
			case ADD:
			case SUB:
			case LPAREN:
				_localctx = new ExpressionInWriteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				expression(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 14:
			return term_sempred((TermContext)_localctx, predIndex);
		case 17:
			return conditionExpr_sempred((ConditionExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean conditionExpr_sempred(ConditionExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001)\u0121\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00011\b\u0001"+
		"\n\u0001\f\u00014\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002;\b\u0002\n\u0002\f\u0002>\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003E\b\u0003"+
		"\n\u0003\f\u0003H\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004P\b\u0004\n\u0004\f\u0004S\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"`\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005e\b\u0005\n\u0005"+
		"\f\u0005h\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007v\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u0085\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u008d\b\t\n\t\f\t\u0090\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t"+
		"\u0096\b\t\n\t\f\t\u0099\t\t\u0001\t\u0003\t\u009c\b\t\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u00a8\b\n\n\n\f\n\u00ab\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00c6\b\f\n\f\f\f\u00c9\t\f"+
		"\u0003\f\u00cb\b\f\u0001\f\u0001\f\u0003\f\u00cf\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00da\b\r\n"+
		"\r\f\r\u00dd\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00e8"+
		"\b\u000e\n\u000e\f\u000e\u00eb\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u00f6\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u0101\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u010e\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u0116\b\u0011\n\u0011\f\u0011\u0119"+
		"\t\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u011f"+
		"\b\u0013\u0001\u0013\u0000\u0003\u001a\u001c\"\u0014\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&\u0000\u0002\u0001\u0000\f\u000e\u0001\u0000\u0016\u001b\u0130\u0000"+
		"(\u0001\u0000\u0000\u0000\u0002-\u0001\u0000\u0000\u0000\u00047\u0001"+
		"\u0000\u0000\u0000\u0006A\u0001\u0000\u0000\u0000\b_\u0001\u0000\u0000"+
		"\u0000\na\u0001\u0000\u0000\u0000\fi\u0001\u0000\u0000\u0000\u000eu\u0001"+
		"\u0000\u0000\u0000\u0010\u0084\u0001\u0000\u0000\u0000\u0012\u0086\u0001"+
		"\u0000\u0000\u0000\u0014\u009d\u0001\u0000\u0000\u0000\u0016\u00ae\u0001"+
		"\u0000\u0000\u0000\u0018\u00ce\u0001\u0000\u0000\u0000\u001a\u00d0\u0001"+
		"\u0000\u0000\u0000\u001c\u00de\u0001\u0000\u0000\u0000\u001e\u00f5\u0001"+
		"\u0000\u0000\u0000 \u0100\u0001\u0000\u0000\u0000\"\u010d\u0001\u0000"+
		"\u0000\u0000$\u011a\u0001\u0000\u0000\u0000&\u011e\u0001\u0000\u0000\u0000"+
		"()\u0003\u0002\u0001\u0000)*\u0003\u0004\u0002\u0000*+\u0003\u0006\u0003"+
		"\u0000+,\u0005\u0000\u0000\u0001,\u0001\u0001\u0000\u0000\u0000-.\u0005"+
		"\u0001\u0000\u0000.2\u0005\u001e\u0000\u0000/1\u0003\b\u0004\u00000/\u0001"+
		"\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u0000"+
		"23\u0001\u0000\u0000\u000035\u0001\u0000\u0000\u000042\u0001\u0000\u0000"+
		"\u000056\u0005\u001f\u0000\u00006\u0003\u0001\u0000\u0000\u000078\u0005"+
		"\u0002\u0000\u00008<\u0005\u001e\u0000\u00009;\u0003\b\u0004\u0000:9\u0001"+
		"\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=?\u0001\u0000\u0000\u0000><\u0001\u0000\u0000"+
		"\u0000?@\u0005\u001f\u0000\u0000@\u0005\u0001\u0000\u0000\u0000AB\u0005"+
		"\u0003\u0000\u0000BF\u0005\u001e\u0000\u0000CE\u0003\u000e\u0007\u0000"+
		"DC\u0001\u0000\u0000\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000"+
		"\u0000FG\u0001\u0000\u0000\u0000GI\u0001\u0000\u0000\u0000HF\u0001\u0000"+
		"\u0000\u0000IJ\u0005\u001f\u0000\u0000J\u0007\u0001\u0000\u0000\u0000"+
		"KL\u0005\u0005\u0000\u0000LQ\u0005\u000b\u0000\u0000MN\u0005$\u0000\u0000"+
		"NP\u0005\u000b\u0000\u0000OM\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000"+
		"\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000"+
		"\u0000\u0000SQ\u0001\u0000\u0000\u0000T`\u0005\"\u0000\u0000UV\u0005\u0005"+
		"\u0000\u0000VW\u0003\n\u0005\u0000WX\u0005\"\u0000\u0000X`\u0001\u0000"+
		"\u0000\u0000YZ\u0005\u0004\u0000\u0000Z[\u0005\u0005\u0000\u0000[\\\u0005"+
		"\u000b\u0000\u0000\\]\u0005(\u0000\u0000]^\u0007\u0000\u0000\u0000^`\u0005"+
		"\"\u0000\u0000_K\u0001\u0000\u0000\u0000_U\u0001\u0000\u0000\u0000_Y\u0001"+
		"\u0000\u0000\u0000`\t\u0001\u0000\u0000\u0000af\u0003\f\u0006\u0000bc"+
		"\u0005$\u0000\u0000ce\u0003\f\u0006\u0000db\u0001\u0000\u0000\u0000eh"+
		"\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000"+
		"\u0000g\u000b\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000ij\u0005"+
		"\u000b\u0000\u0000jk\u0005 \u0000\u0000kl\u0005\f\u0000\u0000lm\u0005"+
		"!\u0000\u0000m\r\u0001\u0000\u0000\u0000nv\u0003\u0010\b\u0000op\u0003"+
		"\u001a\r\u0000pq\u0005\"\u0000\u0000qv\u0001\u0000\u0000\u0000rv\u0003"+
		"\u0012\t\u0000sv\u0003\u0014\n\u0000tv\u0003\u0018\f\u0000un\u0001\u0000"+
		"\u0000\u0000uo\u0001\u0000\u0000\u0000ur\u0001\u0000\u0000\u0000us\u0001"+
		"\u0000\u0000\u0000ut\u0001\u0000\u0000\u0000v\u000f\u0001\u0000\u0000"+
		"\u0000wx\u0005\u000b\u0000\u0000xy\u0005(\u0000\u0000yz\u0003\u001a\r"+
		"\u0000z{\u0005\"\u0000\u0000{\u0085\u0001\u0000\u0000\u0000|}\u0005\u000b"+
		"\u0000\u0000}~\u0005 \u0000\u0000~\u007f\u0003\u001a\r\u0000\u007f\u0080"+
		"\u0005!\u0000\u0000\u0080\u0081\u0005(\u0000\u0000\u0081\u0082\u0003\u001a"+
		"\r\u0000\u0082\u0083\u0005\"\u0000\u0000\u0083\u0085\u0001\u0000\u0000"+
		"\u0000\u0084w\u0001\u0000\u0000\u0000\u0084|\u0001\u0000\u0000\u0000\u0085"+
		"\u0011\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u0006\u0000\u0000\u0087"+
		"\u0088\u0005\u001c\u0000\u0000\u0088\u0089\u0003\"\u0011\u0000\u0089\u008a"+
		"\u0005\u001d\u0000\u0000\u008a\u008e\u0005\u001e\u0000\u0000\u008b\u008d"+
		"\u0003\u000e\u0007\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d\u0090"+
		"\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0001\u0000\u0000\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u008e"+
		"\u0001\u0000\u0000\u0000\u0091\u009b\u0005\u001f\u0000\u0000\u0092\u0093"+
		"\u0005\u0007\u0000\u0000\u0093\u0097\u0005\u001e\u0000\u0000\u0094\u0096"+
		"\u0003\u000e\u0007\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u0099"+
		"\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098"+
		"\u0001\u0000\u0000\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099\u0097"+
		"\u0001\u0000\u0000\u0000\u009a\u009c\u0005\u001f\u0000\u0000\u009b\u0092"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u0013"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0005\b\u0000\u0000\u009e\u009f\u0005"+
		"\u001c\u0000\u0000\u009f\u00a0\u0003\u0016\u000b\u0000\u00a0\u00a1\u0005"+
		"#\u0000\u0000\u00a1\u00a2\u0003\u001a\r\u0000\u00a2\u00a3\u0005#\u0000"+
		"\u0000\u00a3\u00a4\u0003\u001a\r\u0000\u00a4\u00a5\u0005\u001d\u0000\u0000"+
		"\u00a5\u00a9\u0005\u001e\u0000\u0000\u00a6\u00a8\u0003\u000e\u0007\u0000"+
		"\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000"+
		"\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ac\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0005\u001f\u0000\u0000\u00ad\u0015\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0005\u000b\u0000\u0000\u00af\u00b0\u0005(\u0000\u0000\u00b0"+
		"\u00b1\u0003\u001a\r\u0000\u00b1\u0017\u0001\u0000\u0000\u0000\u00b2\u00b3"+
		"\u0005\t\u0000\u0000\u00b3\u00b4\u0005\u001c\u0000\u0000\u00b4\u00b5\u0005"+
		"\u000b\u0000\u0000\u00b5\u00b6\u0005\u001d\u0000\u0000\u00b6\u00cf\u0005"+
		"\"\u0000\u0000\u00b7\u00b8\u0005\t\u0000\u0000\u00b8\u00b9\u0005\u001c"+
		"\u0000\u0000\u00b9\u00ba\u0005\u000b\u0000\u0000\u00ba\u00bb\u0005 \u0000"+
		"\u0000\u00bb\u00bc\u0003\u001a\r\u0000\u00bc\u00bd\u0005!\u0000\u0000"+
		"\u00bd\u00be\u0005\u001d\u0000\u0000\u00be\u00bf\u0005\"\u0000\u0000\u00bf"+
		"\u00cf\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\n\u0000\u0000\u00c1\u00ca"+
		"\u0005\u001c\u0000\u0000\u00c2\u00c7\u0003&\u0013\u0000\u00c3\u00c4\u0005"+
		"$\u0000\u0000\u00c4\u00c6\u0003&\u0013\u0000\u00c5\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c9\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000"+
		"\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00ca\u00c2\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0005\u001d\u0000\u0000\u00cd\u00cf\u0005\"\u0000\u0000"+
		"\u00ce\u00b2\u0001\u0000\u0000\u0000\u00ce\u00b7\u0001\u0000\u0000\u0000"+
		"\u00ce\u00c0\u0001\u0000\u0000\u0000\u00cf\u0019\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0006\r\uffff\uffff\u0000\u00d1\u00d2\u0003\u001c\u000e\u0000"+
		"\u00d2\u00db\u0001\u0000\u0000\u0000\u00d3\u00d4\n\u0003\u0000\u0000\u00d4"+
		"\u00d5\u0005\u000f\u0000\u0000\u00d5\u00da\u0003\u001c\u000e\u0000\u00d6"+
		"\u00d7\n\u0002\u0000\u0000\u00d7\u00d8\u0005\u0010\u0000\u0000\u00d8\u00da"+
		"\u0003\u001c\u000e\u0000\u00d9\u00d3\u0001\u0000\u0000\u0000\u00d9\u00d6"+
		"\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000\u00db\u00d9"+
		"\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u001b"+
		"\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de\u00df"+
		"\u0006\u000e\uffff\uffff\u0000\u00df\u00e0\u0003\u001e\u000f\u0000\u00e0"+
		"\u00e9\u0001\u0000\u0000\u0000\u00e1\u00e2\n\u0003\u0000\u0000\u00e2\u00e3"+
		"\u0005\u0011\u0000\u0000\u00e3\u00e8\u0003\u001e\u000f\u0000\u00e4\u00e5"+
		"\n\u0002\u0000\u0000\u00e5\u00e6\u0005\u0012\u0000\u0000\u00e6\u00e8\u0003"+
		"\u001e\u000f\u0000\u00e7\u00e1\u0001\u0000\u0000\u0000\u00e7\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u001d\u0001"+
		"\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005"+
		"\u001c\u0000\u0000\u00ed\u00ee\u0003\u001a\r\u0000\u00ee\u00ef\u0005\u001d"+
		"\u0000\u0000\u00ef\u00f6\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005\u0010"+
		"\u0000\u0000\u00f1\u00f6\u0003\u001e\u000f\u0000\u00f2\u00f3\u0005\u000f"+
		"\u0000\u0000\u00f3\u00f6\u0003\u001e\u000f\u0000\u00f4\u00f6\u0003 \u0010"+
		"\u0000\u00f5\u00ec\u0001\u0000\u0000\u0000\u00f5\u00f0\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f6\u001f\u0001\u0000\u0000\u0000\u00f7\u0101\u0005\f\u0000\u0000"+
		"\u00f8\u0101\u0005\r\u0000\u0000\u00f9\u0101\u0005\u000e\u0000\u0000\u00fa"+
		"\u0101\u0005\u000b\u0000\u0000\u00fb\u00fc\u0005\u000b\u0000\u0000\u00fc"+
		"\u00fd\u0005 \u0000\u0000\u00fd\u00fe\u0003\u001a\r\u0000\u00fe\u00ff"+
		"\u0005!\u0000\u0000\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00f7\u0001"+
		"\u0000\u0000\u0000\u0100\u00f8\u0001\u0000\u0000\u0000\u0100\u00f9\u0001"+
		"\u0000\u0000\u0000\u0100\u00fa\u0001\u0000\u0000\u0000\u0100\u00fb\u0001"+
		"\u0000\u0000\u0000\u0101!\u0001\u0000\u0000\u0000\u0102\u0103\u0006\u0011"+
		"\uffff\uffff\u0000\u0103\u0104\u0003\u001a\r\u0000\u0104\u0105\u0003$"+
		"\u0012\u0000\u0105\u0106\u0003\u001a\r\u0000\u0106\u010e\u0001\u0000\u0000"+
		"\u0000\u0107\u0108\u0005\u0015\u0000\u0000\u0108\u010e\u0003\"\u0011\u0004"+
		"\u0109\u010a\u0005\u001c\u0000\u0000\u010a\u010b\u0003\"\u0011\u0000\u010b"+
		"\u010c\u0005\u001d\u0000\u0000\u010c\u010e\u0001\u0000\u0000\u0000\u010d"+
		"\u0102\u0001\u0000\u0000\u0000\u010d\u0107\u0001\u0000\u0000\u0000\u010d"+
		"\u0109\u0001\u0000\u0000\u0000\u010e\u0117\u0001\u0000\u0000\u0000\u010f"+
		"\u0110\n\u0003\u0000\u0000\u0110\u0111\u0005\u0014\u0000\u0000\u0111\u0116"+
		"\u0003\"\u0011\u0004\u0112\u0113\n\u0002\u0000\u0000\u0113\u0114\u0005"+
		"\u0013\u0000\u0000\u0114\u0116\u0003\"\u0011\u0003\u0115\u010f\u0001\u0000"+
		"\u0000\u0000\u0115\u0112\u0001\u0000\u0000\u0000\u0116\u0119\u0001\u0000"+
		"\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000"+
		"\u0000\u0000\u0118#\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000"+
		"\u0000\u011a\u011b\u0007\u0001\u0000\u0000\u011b%\u0001\u0000\u0000\u0000"+
		"\u011c\u011f\u0005)\u0000\u0000\u011d\u011f\u0003\u001a\r\u0000\u011e"+
		"\u011c\u0001\u0000\u0000\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011f"+
		"\'\u0001\u0000\u0000\u0000\u00192<FQ_fu\u0084\u008e\u0097\u009b\u00a9"+
		"\u00c7\u00ca\u00ce\u00d9\u00db\u00e7\u00e9\u00f5\u0100\u010d\u0115\u0117"+
		"\u011e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
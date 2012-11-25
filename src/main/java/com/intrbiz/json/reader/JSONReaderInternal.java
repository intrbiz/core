package com.intrbiz.json.reader;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.intrbiz.json.JSArray;
import com.intrbiz.json.JSBoolean;
import com.intrbiz.json.JSCustomObject;
import com.intrbiz.json.JSNumber;
import com.intrbiz.json.JSObject;
import com.intrbiz.json.JSString;
import com.intrbiz.json.JSValue;
import com.intrbiz.json.util.StringSerialiser;

@SuppressWarnings("all")
final class JSONReaderInternal implements JSONReaderInternalConstants {

  final public JSValue readValue() throws ParseException {
  JSValue json = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 28:
      jj_consume_token(28);
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 29:
      json = jsObject();
      break;
    case 35:
      json = jsArray();
      break;
    case DIGITS:
    case NAN:
    case INFINITY:
    case BOOLEAN:
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
    case 37:
      json = jsPrimitive();
      break;
    case NULL:
      json = jsNull();
      break;
    case NEW:
      json = jsCustom();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return json;}
    throw new Error("Missing return statement in function");
  }

  final private JSObject jsObject() throws ParseException {
  JSObject o = new JSObject();
    jj_consume_token(29);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER_SANS_EXPONENT:
    case IDENTIFIER_STARTS_WITH_EXPONENT:
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
      Members(o);
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    jj_consume_token(30);
    {if (true) return o;}
    throw new Error("Missing return statement in function");
  }

  final private JSValue jsNull() throws ParseException {
  Token t;
    t = jj_consume_token(NULL);
               {if (true) return null;}
    throw new Error("Missing return statement in function");
  }

  final private void Members(JSObject o) throws ParseException {
    Pair(o);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 31:
      jj_consume_token(31);
      Members(o);
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
  }

  final private void Pair(JSObject o) throws ParseException {
  String property;
  JSValue value;
    property = jsMemberName();
    jj_consume_token(32);
    value = jsValue();
    o.addMember(property, value);
  }

  final private String jsMemberName() throws ParseException {
  Token t = null; JSString value = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
      value = jsString();
      break;
    case IDENTIFIER_SANS_EXPONENT:
    case IDENTIFIER_STARTS_WITH_EXPONENT:
      t = Identifier();
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
        if ( value != null )
                {if (true) return value.getString();}
        else
                {if (true) return t.image ;}
    throw new Error("Missing return statement in function");
  }

  final private JSValue jsCustom() throws ParseException {
        JSCustomObject co = new JSCustomObject();
        List<String> cn = new LinkedList<String>();
    jj_consume_token(NEW);
    cIdentifier(cn);
    jj_consume_token(33);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DIGITS:
    case NULL:
    case NAN:
    case INFINITY:
    case BOOLEAN:
    case NEW:
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
    case 29:
    case 35:
    case 37:
      arguments(co);
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    jj_consume_token(34);
                Collections.reverse(cn);
                StringBuffer sb = new StringBuffer();
                boolean nd = false;
                for (String cp : cn)
                {
                        if (nd) sb.append(".");
                        sb.append(cp);
                        nd = true;
                }
                co.setClassname(sb.toString());
                co.reverse();
                {if (true) return co;}
    throw new Error("Missing return statement in function");
  }

  final private void cIdentifier(List<String> cn) throws ParseException {
        Token t ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER_STARTS_WITH_EXPONENT:
      t = jj_consume_token(IDENTIFIER_STARTS_WITH_EXPONENT);
      break;
    case IDENTIFIER_SANS_EXPONENT:
      t = jj_consume_token(IDENTIFIER_SANS_EXPONENT);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FRACSEP:
      jj_consume_token(FRACSEP);
      cIdentifier(cn);
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
                cn.add(t.image);
  }

  final private void arguments(JSCustomObject co) throws ParseException {
  JSValue element;
    element = jsValue();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 31:
      jj_consume_token(31);
      arguments(co);
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    co.addArgument(element);
  }

  final private JSArray jsArray() throws ParseException {
  JSArray array = new JSArray();
    jj_consume_token(35);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DIGITS:
    case NULL:
    case NAN:
    case INFINITY:
    case BOOLEAN:
    case NEW:
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
    case 29:
    case 35:
    case 37:
      Elements(array);
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    jj_consume_token(36);
    array.reverse();
    {if (true) return array;}
    throw new Error("Missing return statement in function");
  }

  final private void Elements(JSArray array) throws ParseException {
  JSValue element;
    element = jsValue();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 31:
      jj_consume_token(31);
      Elements(array);
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
    array.addElement(element);
  }

  final private JSValue jsValue() throws ParseException {
  JSValue o = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
      o = jsString();
      break;
    case DIGITS:
    case NAN:
    case INFINITY:
    case 37:
      o = jsNumber();
      break;
    case 29:
      o = jsObject();
      break;
    case 35:
      o = jsArray();
      break;
    case BOOLEAN:
      o = jsBoolean();
      break;
    case NEW:
      o = jsCustom();
      break;
    case NULL:
      o = jsNull();
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return o;}
    throw new Error("Missing return statement in function");
  }

  final private JSBoolean jsBoolean() throws ParseException {
  Token t;
    t = jj_consume_token(BOOLEAN);
    boolean value = Boolean.valueOf(t.image);
    {if (true) return new JSBoolean(value);}
    throw new Error("Missing return statement in function");
  }

  final private JSValue jsPrimitive() throws ParseException {
  JSValue value;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
      value = jsString();
                        {if (true) return value;}
      break;
    case DIGITS:
    case NAN:
    case INFINITY:
    case 37:
      value = jsNumber();
                        {if (true) return value;}
      break;
    case BOOLEAN:
      value = jsBoolean();
                         {if (true) return value;}
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final private JSNumber jsNumber() throws ParseException {
  String intpart = null,
         fracpart = null,
         exppart = null;
  JSNumber value;
    if (jj_2_1(2)) {
      value = jsSpecialNumbers();
                              {if (true) return value;}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIGITS:
      case 37:
        intpart = jsInt();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case FRACSEP:
          fracpart = jsFrac();
          break;
        default:
          jj_la1[13] = jj_gen;
          ;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case EXPONENT:
          exppart = jsExp();
          break;
        default:
          jj_la1[14] = jj_gen;
          ;
        }
    Number n;
    if (exppart != null || fracpart != null) {
      fracpart = (fracpart == null) ? "" : fracpart;
      exppart = (exppart == null) ? "" : exppart;
      n = new java.math.BigDecimal(intpart + fracpart + exppart);
    } else {
      n = new java.math.BigInteger(intpart);
    }
    {if (true) return new JSNumber(n);}
        break;
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  final private JSNumber jsSpecialNumbers() throws ParseException {
  boolean negative = false;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NAN:
      jj_consume_token(NAN);
           {if (true) return new JSNumber(Double.NaN);}
      break;
    case INFINITY:
    case 37:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 37:
        jj_consume_token(37);
         negative = true;
        break;
      default:
        jj_la1[16] = jj_gen;
        ;
      }
      jj_consume_token(INFINITY);
                                        {if (true) return new JSNumber(negative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);}
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final private String jsInt() throws ParseException {
  String digits;
  boolean negative = false;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 37:
      jj_consume_token(37);
         negative = true;
      break;
    default:
      jj_la1[18] = jj_gen;
      ;
    }
    digits = Digits();
    if(negative)
      {if (true) return "-" + digits;}
    {if (true) return digits;}
    throw new Error("Missing return statement in function");
  }

  final private String jsFrac() throws ParseException {
  String digits;
    jj_consume_token(FRACSEP);
    digits = Digits();
    {if (true) return "." + digits;}
    throw new Error("Missing return statement in function");
  }

  final private String jsExp() throws ParseException {
  Token t;
    t = jj_consume_token(EXPONENT);
                  {if (true) return t.image;}
    throw new Error("Missing return statement in function");
  }

  final private Token Identifier() throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER_STARTS_WITH_EXPONENT:
      t = jj_consume_token(IDENTIFIER_STARTS_WITH_EXPONENT);
      break;
    case IDENTIFIER_SANS_EXPONENT:
      t = jj_consume_token(IDENTIFIER_SANS_EXPONENT);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                                                                            {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  final private String Digits() throws ParseException {
  Token t;
    t = jj_consume_token(DIGITS);
    {if (true) return t.image;}
    throw new Error("Missing return statement in function");
  }

  final private JSString jsString() throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINGLE_QUOTE_LITERAL:
      t = jj_consume_token(SINGLE_QUOTE_LITERAL);
      break;
    case DOUBLE_QUOTE_LITERAL:
      t = jj_consume_token(DOUBLE_QUOTE_LITERAL);
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    String value = StringSerialiser.decode(t.image);
    {if (true) return new JSString(value);}
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3R_4() {
    if (jj_scan_token(37)) return true;
    return false;
  }

  private boolean jj_3R_3() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_4()) jj_scanpos = xsp;
    if (jj_scan_token(INFINITY)) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_1()) return true;
    return false;
  }

  private boolean jj_3R_2() {
    if (jj_scan_token(NAN)) return true;
    return false;
  }

  private boolean jj_3R_1() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_2()) {
    jj_scanpos = xsp;
    if (jj_3R_3()) return true;
    }
    return false;
  }

  /** Generated Token Manager. */
  public JSONReaderInternalTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[21];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x10000000,0x200c17c0,0xc6000,0x80000000,0xc6000,0x200c17c0,0x6000,0x800,0x80000000,0x200c17c0,0x80000000,0x200c17c0,0xc0740,0x800,0x20,0x40,0x0,0x300,0x0,0x6000,0xc0000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x28,0x0,0x0,0x0,0x28,0x0,0x0,0x0,0x28,0x0,0x28,0x20,0x0,0x0,0x20,0x20,0x20,0x20,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public JSONReaderInternal(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public JSONReaderInternal(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JSONReaderInternalTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public JSONReaderInternal(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new JSONReaderInternalTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public JSONReaderInternal(JSONReaderInternalTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(JSONReaderInternalTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List jj_expentries = new java.util.ArrayList();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[38];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 21; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 38; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}

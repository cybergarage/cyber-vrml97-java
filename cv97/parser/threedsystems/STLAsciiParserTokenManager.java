/* Generated By:JavaCC: Do not edit this line. STLAsciiParserTokenManager.java */
package cv97.parser.threedsystems;
import java.io.*;
import cv97.*;
import cv97.node.*;
import cv97.field.*;

public class STLAsciiParserTokenManager implements STLAsciiParserConstants
{
  public  java.io.PrintStream debugStream = System.out;
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x76a0L) != 0L)
         {
            jjmatchedKind = 16;
            return 0;
         }
         if ((active0 & 0x940L) != 0L)
         {
            jjmatchedKind = 16;
            return 8;
         }
         return -1;
      case 1:
         if ((active0 & 0x7fe0L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 1;
            return 0;
         }
         return -1;
      case 2:
         if ((active0 & 0x7fe0L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 2;
            return 0;
         }
         return -1;
      case 3:
         if ((active0 & 0x400L) != 0L)
            return 0;
         if ((active0 & 0x7be0L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 3;
            return 0;
         }
         return -1;
      case 4:
         if ((active0 & 0x12a0L) != 0L)
            return 0;
         if ((active0 & 0x6940L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 4;
            return 0;
         }
         return -1;
      case 5:
         if ((active0 & 0x6000L) != 0L)
            return 0;
         if ((active0 & 0x940L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 5;
            return 0;
         }
         return -1;
      case 6:
         if ((active0 & 0x800L) != 0L)
            return 0;
         if ((active0 & 0x140L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 6;
            return 0;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa1_0(0x1000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x940L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x80L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      default :
         return jjMoveNfa_0(7, 0);
   }
}
private final int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x80L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x940L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x5420L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private final int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x80L);
      case 100:
         return jjMoveStringLiteralDfa3_0(active0, 0x940L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x1020L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x400L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x6000L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x200L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private final int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa4_0(active0, 0x280L);
      case 102:
         return jjMoveStringLiteralDfa4_0(active0, 0x100L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x20L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x800L);
      case 109:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      case 111:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000L);
      case 112:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 0);
         break;
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x40L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private final int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x4100L);
      case 100:
         if ((active0 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(4, 5, 0);
         break;
      case 101:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000L);
      case 111:
         return jjMoveStringLiteralDfa5_0(active0, 0x840L);
      case 114:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(4, 9, 0);
         else if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(4, 12, 0);
         break;
      case 116:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(4, 7, 0);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private final int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa6_0(active0, 0x100L);
      case 108:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(5, 14, 0);
         return jjMoveStringLiteralDfa6_0(active0, 0x40L);
      case 111:
         return jjMoveStringLiteralDfa6_0(active0, 0x800L);
      case 120:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(5, 13, 0);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private final int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa7_0(active0, 0x100L);
      case 105:
         return jjMoveStringLiteralDfa7_0(active0, 0x40L);
      case 112:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(6, 11, 0);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private final int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(7, 6, 0);
         break;
      case 116:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(7, 8, 0);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 23;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 8:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 18)
                        kind = 18;
                     jjCheckNAdd(9);
                  }
                  else if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(9);
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 16)
                        kind = 16;
                     jjCheckNAdd(0);
                  }
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 15)
                        kind = 15;
                     jjCheckNAddStates(0, 5);
                  }
                  else if ((0x280000000000L & l) != 0L)
                     jjCheckNAddStates(6, 8);
                  else if (curChar == 46)
                     jjCheckNAdd(2);
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 16)
                        kind = 16;
                     jjCheckNAdd(0);
                  }
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAdd(0);
                  break;
               case 1:
                  if (curChar == 46)
                     jjCheckNAdd(2);
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddStates(9, 11);
                  break;
               case 4:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(5);
                  break;
               case 5:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddTwoStates(5, 6);
                  break;
               case 9:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 18)
                     kind = 18;
                  jjCheckNAdd(9);
                  break;
               case 10:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAddStates(6, 8);
                  break;
               case 11:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(11, 12);
                  break;
               case 12:
                  if (curChar != 46)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddStates(12, 14);
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddStates(12, 14);
                  break;
               case 15:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(16);
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddTwoStates(16, 6);
                  break;
               case 17:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddStates(15, 17);
                  break;
               case 19:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(20);
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddTwoStates(20, 6);
                  break;
               case 21:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddStates(0, 5);
                  break;
               case 22:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAdd(22);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 8:
               case 0:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAdd(0);
                  break;
               case 7:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 16)
                        kind = 16;
                     jjCheckNAdd(0);
                  }
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(18, 19);
                  break;
               case 3:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(20, 21);
                  break;
               case 6:
                  if ((0x5000000050L & l) != 0L && kind > 17)
                     kind = 17;
                  break;
               case 14:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(22, 23);
                  break;
               case 18:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(24, 25);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 23 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   22, 11, 12, 17, 18, 6, 11, 1, 17, 2, 3, 6, 13, 14, 6, 17, 
   18, 6, 8, 9, 4, 5, 15, 16, 19, 20, 
};
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, "\163\157\154\151\144", 
"\145\156\144\163\157\154\151\144", "\146\141\143\145\164", "\145\156\144\146\141\143\145\164", 
"\157\165\164\145\162", "\154\157\157\160", "\145\156\144\154\157\157\160", "\143\157\154\157\162", 
"\166\145\162\164\145\170", "\156\157\162\155\141\154", null, null, null, null, };
public static final String[] lexStateNames = {
   "DEFAULT", 
};
static final long[] jjtoToken = {
   0x7ffe1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
private SimpleCharStream input_stream;
private final int[] jjrounds = new int[23];
private final int[] jjstateSet = new int[46];
protected char curChar;
public STLAsciiParserTokenManager(SimpleCharStream stream)
{
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}
public STLAsciiParserTokenManager(SimpleCharStream stream, int lexState)
{
   this(stream);
   SwitchTo(lexState);
}
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 23; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

private final Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

public final Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

}

package com.intrbiz.json.reader;

/** Token Manager. */
public class JSONReaderInternalTokenManager implements JSONReaderInternalConstants
{

	/** Debug output. */
	public java.io.PrintStream debugStream = System.out;

	/** Set debug output. */
	public void setDebugStream(java.io.PrintStream ds)
	{
		debugStream = ds;
	}

	private int jjMoveStringLiteralDfa0_3()
	{
		return jjMoveNfa_3(0, 0);
	}

	private int jjMoveNfa_3(int startState, int curPos)
	{
		int startsAt = 0;
		jjnewStateCnt = 4;
		int i = 1;
		jjstateSet[0] = startState;
		int kind = 0x7fffffff;
		for (;;)
		{
			if (++jjround == 0x7fffffff)
				ReInitRounds();
			if (curChar < 64)
			{
				long l = 1L << curChar;
				do
				{
					switch (jjstateSet[--i])
					{
					case 0:
						if ((0x3ff000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 1;
						break;
					case 1:
						if ((0x3ff000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 2;
						break;
					case 2:
						if ((0x3ff000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 3;
						break;
					case 3:
						if ((0x3ff000000000000L & l) != 0L && kind > 27)
							kind = 27;
						break;
					default:
						break;
					}
				}
				while (i != startsAt);
			}
			else if (curChar < 128)
			{
				long l = 1L << (curChar & 077);
				do
				{
					switch (jjstateSet[--i])
					{
					case 0:
						if ((0x7e0000007eL & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 1;
						break;
					case 1:
						if ((0x7e0000007eL & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 2;
						break;
					case 2:
						if ((0x7e0000007eL & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 3;
						break;
					case 3:
						if ((0x7e0000007eL & l) != 0L && kind > 27)
							kind = 27;
						break;
					default:
						break;
					}
				}
				while (i != startsAt);
			}
			else
			{
				int hiByte = (int) (curChar >> 8);
				@SuppressWarnings("unused")
				int i1 = hiByte >> 6;
				@SuppressWarnings("unused")
				long l1 = 1L << (hiByte & 077);
				@SuppressWarnings("unused")
				int i2 = (curChar & 0xff) >> 6;
				@SuppressWarnings("unused")
				long l2 = 1L << (curChar & 077);
				do
				{
					switch (jjstateSet[--i])
					{
					default:
						break;
					}
				}
				while (i != startsAt);
			}
			if (kind != 0x7fffffff)
			{
				jjmatchedKind = kind;
				jjmatchedPos = curPos;
				kind = 0x7fffffff;
			}
			++curPos;
			if ((i = jjnewStateCnt) == (startsAt = 4 - (jjnewStateCnt = startsAt)))
				return curPos;
			try
			{
				curChar = input_stream.readChar();
			}
			catch (java.io.IOException e)
			{
				return curPos;
			}
		}
	}

	private final int jjStopStringLiteralDfa_0(int pos, long active0)
	{
		switch (pos)
		{
		case 0:
			if ((active0 & 0x100000L) != 0L)
				return 43;
			if ((active0 & 0x1380L) != 0L)
			{
				jjmatchedKind = 13;
				return 10;
			}
			return -1;
		case 1:
			if ((active0 & 0x1380L) != 0L)
			{
				jjmatchedKind = 13;
				jjmatchedPos = 1;
				return 10;
			}
			return -1;
		case 2:
			if ((active0 & 0x1100L) != 0L)
				return 10;
			if ((active0 & 0x280L) != 0L)
			{
				jjmatchedKind = 13;
				jjmatchedPos = 2;
				return 10;
			}
			return -1;
		case 3:
			if ((active0 & 0x80L) != 0L)
				return 10;
			if ((active0 & 0x200L) != 0L)
			{
				jjmatchedKind = 13;
				jjmatchedPos = 3;
				return 10;
			}
			return -1;
		case 4:
			if ((active0 & 0x200L) != 0L)
			{
				jjmatchedKind = 13;
				jjmatchedPos = 4;
				return 10;
			}
			return -1;
		case 5:
			if ((active0 & 0x200L) != 0L)
			{
				jjmatchedKind = 13;
				jjmatchedPos = 5;
				return 10;
			}
			return -1;
		case 6:
			if ((active0 & 0x200L) != 0L)
			{
				jjmatchedKind = 13;
				jjmatchedPos = 6;
				return 10;
			}
			return -1;
		default:
			return -1;
		}
	}

	private final int jjStartNfa_0(int pos, long active0)
	{
		return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
	}

	private int jjStopAtPos(int pos, int kind)
	{
		jjmatchedKind = kind;
		jjmatchedPos = pos;
		return pos + 1;
	}

	private int jjMoveStringLiteralDfa0_0()
	{
		switch (curChar)
		{
		case 34:
			return jjStartNfaWithStates_0(0, 20, 43);
		case 40:
			return jjStopAtPos(0, 33);
		case 41:
			jjmatchedKind = 34;
			return jjMoveStringLiteralDfa1_0(0x10000000L);
		case 44:
			return jjStopAtPos(0, 31);
		case 45:
			return jjStopAtPos(0, 37);
		case 46:
			return jjStopAtPos(0, 11);
		case 58:
			return jjStopAtPos(0, 32);
		case 73:
			return jjMoveStringLiteralDfa1_0(0x200L);
		case 78:
			return jjMoveStringLiteralDfa1_0(0x100L);
		case 91:
			return jjStopAtPos(0, 35);
		case 93:
			return jjStopAtPos(0, 36);
		case 110:
			return jjMoveStringLiteralDfa1_0(0x1080L);
		case 123:
			return jjStopAtPos(0, 29);
		case 125:
			return jjStopAtPos(0, 30);
		default:
			return jjMoveNfa_0(4, 0);
		}
	}

	private int jjMoveStringLiteralDfa1_0(long active0)
	{
		try
		{
			curChar = input_stream.readChar();
		}
		catch (java.io.IOException e)
		{
			jjStopStringLiteralDfa_0(0, active0);
			return 1;
		}
		switch (curChar)
		{
		case 93:
			return jjMoveStringLiteralDfa2_0(active0, 0x10000000L);
		case 97:
			return jjMoveStringLiteralDfa2_0(active0, 0x100L);
		case 101:
			return jjMoveStringLiteralDfa2_0(active0, 0x1000L);
		case 110:
			return jjMoveStringLiteralDfa2_0(active0, 0x200L);
		case 117:
			return jjMoveStringLiteralDfa2_0(active0, 0x80L);
		default:
			break;
		}
		return jjStartNfa_0(0, active0);
	}

	private int jjMoveStringLiteralDfa2_0(long old0, long active0)
	{
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(0, old0);
		try
		{
			curChar = input_stream.readChar();
		}
		catch (java.io.IOException e)
		{
			jjStopStringLiteralDfa_0(1, active0);
			return 2;
		}
		switch (curChar)
		{
		case 78:
			if ((active0 & 0x100L) != 0L)
				return jjStartNfaWithStates_0(2, 8, 10);
			break;
		case 102:
			return jjMoveStringLiteralDfa3_0(active0, 0x200L);
		case 108:
			return jjMoveStringLiteralDfa3_0(active0, 0x80L);
		case 119:
			if ((active0 & 0x1000L) != 0L)
				return jjStartNfaWithStates_0(2, 12, 10);
			break;
		case 125:
			return jjMoveStringLiteralDfa3_0(active0, 0x10000000L);
		default:
			break;
		}
		return jjStartNfa_0(1, active0);
	}

	private int jjMoveStringLiteralDfa3_0(long old0, long active0)
	{
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(1, old0);
		try
		{
			curChar = input_stream.readChar();
		}
		catch (java.io.IOException e)
		{
			jjStopStringLiteralDfa_0(2, active0);
			return 3;
		}
		switch (curChar)
		{
		case 39:
			return jjMoveStringLiteralDfa4_0(active0, 0x10000000L);
		case 105:
			return jjMoveStringLiteralDfa4_0(active0, 0x200L);
		case 108:
			if ((active0 & 0x80L) != 0L)
				return jjStartNfaWithStates_0(3, 7, 10);
			break;
		default:
			break;
		}
		return jjStartNfa_0(2, active0);
	}

	private int jjMoveStringLiteralDfa4_0(long old0, long active0)
	{
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(2, old0);
		try
		{
			curChar = input_stream.readChar();
		}
		catch (java.io.IOException e)
		{
			jjStopStringLiteralDfa_0(3, active0);
			return 4;
		}
		switch (curChar)
		{
		case 10:
			if ((active0 & 0x10000000L) != 0L)
				return jjStopAtPos(4, 28);
			break;
		case 110:
			return jjMoveStringLiteralDfa5_0(active0, 0x200L);
		default:
			break;
		}
		return jjStartNfa_0(3, active0);
	}

	private int jjMoveStringLiteralDfa5_0(long old0, long active0)
	{
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(3, old0);
		try
		{
			curChar = input_stream.readChar();
		}
		catch (java.io.IOException e)
		{
			jjStopStringLiteralDfa_0(4, active0);
			return 5;
		}
		switch (curChar)
		{
		case 105:
			return jjMoveStringLiteralDfa6_0(active0, 0x200L);
		default:
			break;
		}
		return jjStartNfa_0(4, active0);
	}

	private int jjMoveStringLiteralDfa6_0(long old0, long active0)
	{
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(4, old0);
		try
		{
			curChar = input_stream.readChar();
		}
		catch (java.io.IOException e)
		{
			jjStopStringLiteralDfa_0(5, active0);
			return 6;
		}
		switch (curChar)
		{
		case 116:
			return jjMoveStringLiteralDfa7_0(active0, 0x200L);
		default:
			break;
		}
		return jjStartNfa_0(5, active0);
	}

	private int jjMoveStringLiteralDfa7_0(long old0, long active0)
	{
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(5, old0);
		try
		{
			curChar = input_stream.readChar();
		}
		catch (java.io.IOException e)
		{
			jjStopStringLiteralDfa_0(6, active0);
			return 7;
		}
		switch (curChar)
		{
		case 121:
			if ((active0 & 0x200L) != 0L)
				return jjStartNfaWithStates_0(7, 9, 10);
			break;
		default:
			break;
		}
		return jjStartNfa_0(6, active0);
	}

	private int jjStartNfaWithStates_0(int pos, int kind, int state)
	{
		jjmatchedKind = kind;
		jjmatchedPos = pos;
		try
		{
			curChar = input_stream.readChar();
		}
		catch (java.io.IOException e)
		{
			return pos + 1;
		}
		return jjMoveNfa_0(state, pos + 1);
	}

	static final long[] jjbitVec0 =
	{ 0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL };
	static final long[] jjbitVec2 =
	{ 0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL };

	private int jjMoveNfa_0(int startState, int curPos)
	{
		int startsAt = 0;
		jjnewStateCnt = 43;
		int i = 1;
		jjstateSet[0] = startState;
		int kind = 0x7fffffff;
		for (;;)
		{
			if (++jjround == 0x7fffffff)
				ReInitRounds();
			if (curChar < 64)
			{
				long l = 1L << curChar;
				do
				{
					switch (jjstateSet[--i])
					{
					case 43:
						if ((0xfffffffbffffdbffL & l) != 0L)
							jjCheckNAddStates(0, 3);
						else if (curChar == 34)
						{
							if (kind > 19)
								kind = 19;
						}
						break;
					case 4:
						if ((0x3ff000000000000L & l) != 0L)
						{
							if (kind > 6)
								kind = 6;
							jjCheckNAdd(0);
						}
						else if (curChar == 34)
							jjCheckNAddStates(0, 3);
						else if (curChar == 39)
							jjCheckNAddStates(4, 7);
						break;
					case 0:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 6)
							kind = 6;
						jjCheckNAdd(0);
						break;
					case 10:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 13)
							kind = 13;
						jjstateSet[jjnewStateCnt++] = 10;
						break;
					case 12:
						if ((0x3ff000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 13;
						break;
					case 13:
						if ((0x3ff000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 14;
						break;
					case 14:
						if ((0x3ff000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 15;
						break;
					case 15:
						if ((0x3ff000000000000L & l) != 0L && kind > 16)
							kind = 16;
						break;
					case 17:
						if (curChar == 39)
							jjCheckNAddStates(4, 7);
						break;
					case 18:
						if ((0xffffff7fffffdbffL & l) != 0L)
							jjCheckNAddStates(4, 7);
						break;
					case 20:
						if ((0x808400000000L & l) != 0L)
							jjCheckNAddStates(4, 7);
						break;
					case 22:
						if ((0x3ff000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 23;
						break;
					case 23:
						if ((0x3ff000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 24;
						break;
					case 24:
						if ((0x3ff000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 25;
						break;
					case 25:
						if ((0x3ff000000000000L & l) != 0L)
							jjCheckNAddStates(4, 7);
						break;
					case 27:
						if (curChar == 39 && kind > 18)
							kind = 18;
						break;
					case 28:
						if (curChar == 34)
							jjCheckNAddStates(0, 3);
						break;
					case 29:
						if ((0xfffffffbffffdbffL & l) != 0L)
							jjCheckNAddStates(0, 3);
						break;
					case 31:
						if ((0x808400000000L & l) != 0L)
							jjCheckNAddStates(0, 3);
						break;
					case 33:
						if ((0x3ff000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 34;
						break;
					case 34:
						if ((0x3ff000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 35;
						break;
					case 35:
						if ((0x3ff000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 36;
						break;
					case 36:
						if ((0x3ff000000000000L & l) != 0L)
							jjCheckNAddStates(0, 3);
						break;
					case 38:
						if (curChar == 34 && kind > 19)
							kind = 19;
						break;
					case 40:
						if ((0x3ff280000000000L & l) == 0L)
							break;
						if (kind > 5)
							kind = 5;
						jjCheckNAdd(41);
						break;
					case 41:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 5)
							kind = 5;
						jjCheckNAdd(41);
						break;
					case 42:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 14)
							kind = 14;
						jjstateSet[jjnewStateCnt++] = 42;
						break;
					default:
						break;
					}
				}
				while (i != startsAt);
			}
			else if (curChar < 128)
			{
				long l = 1L << (curChar & 077);
				do
				{
					switch (jjstateSet[--i])
					{
					case 43:
						if ((0xffffffffefffffffL & l) != 0L)
							jjCheckNAddStates(0, 3);
						else if (curChar == 92)
							jjstateSet[jjnewStateCnt++] = 32;
						if (curChar == 92)
							jjstateSet[jjnewStateCnt++] = 31;
						break;
					case 4:
						if ((0x7ffffde87ffffdeL & l) != 0L)
						{
							if (kind > 13)
								kind = 13;
							jjCheckNAdd(10);
						}
						else if ((0x2000000020L & l) != 0L)
						{
							if (kind > 14)
								kind = 14;
							jjCheckNAddTwoStates(40, 42);
						}
						else if (curChar == 92)
							jjstateSet[jjnewStateCnt++] = 11;
						if (curChar == 102)
							jjstateSet[jjnewStateCnt++] = 7;
						else if (curChar == 116)
							jjstateSet[jjnewStateCnt++] = 3;
						break;
					case 1:
						if (curChar == 101 && kind > 10)
							kind = 10;
						break;
					case 2:
						if (curChar == 117)
							jjCheckNAdd(1);
						break;
					case 3:
						if (curChar == 114)
							jjstateSet[jjnewStateCnt++] = 2;
						break;
					case 5:
						if (curChar == 115)
							jjCheckNAdd(1);
						break;
					case 6:
						if (curChar == 108)
							jjstateSet[jjnewStateCnt++] = 5;
						break;
					case 7:
						if (curChar == 97)
							jjstateSet[jjnewStateCnt++] = 6;
						break;
					case 8:
						if (curChar == 102)
							jjstateSet[jjnewStateCnt++] = 7;
						break;
					case 9:
						if ((0x7ffffde87ffffdeL & l) == 0L)
							break;
						if (kind > 13)
							kind = 13;
						jjCheckNAdd(10);
						break;
					case 10:
						if ((0x7fffffe87fffffeL & l) == 0L)
							break;
						if (kind > 13)
							kind = 13;
						jjCheckNAdd(10);
						break;
					case 11:
						if (curChar == 117)
							jjstateSet[jjnewStateCnt++] = 12;
						break;
					case 12:
						if ((0x7e0000007eL & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 13;
						break;
					case 13:
						if ((0x7e0000007eL & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 14;
						break;
					case 14:
						if ((0x7e0000007eL & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 15;
						break;
					case 15:
						if ((0x7e0000007eL & l) != 0L && kind > 16)
							kind = 16;
						break;
					case 16:
						if (curChar == 92)
							jjstateSet[jjnewStateCnt++] = 11;
						break;
					case 18:
						if ((0xffffffffefffffffL & l) != 0L)
							jjCheckNAddStates(4, 7);
						break;
					case 19:
						if (curChar == 92)
							jjstateSet[jjnewStateCnt++] = 20;
						break;
					case 20:
						if ((0x14404410000000L & l) != 0L)
							jjCheckNAddStates(4, 7);
						break;
					case 21:
						if (curChar == 117)
							jjstateSet[jjnewStateCnt++] = 22;
						break;
					case 22:
						if ((0x7e0000007eL & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 23;
						break;
					case 23:
						if ((0x7e0000007eL & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 24;
						break;
					case 24:
						if ((0x7e0000007eL & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 25;
						break;
					case 25:
						if ((0x7e0000007eL & l) != 0L)
							jjCheckNAddStates(4, 7);
						break;
					case 26:
						if (curChar == 92)
							jjstateSet[jjnewStateCnt++] = 21;
						break;
					case 29:
						if ((0xffffffffefffffffL & l) != 0L)
							jjCheckNAddStates(0, 3);
						break;
					case 30:
						if (curChar == 92)
							jjstateSet[jjnewStateCnt++] = 31;
						break;
					case 31:
						if ((0x14404410000000L & l) != 0L)
							jjCheckNAddStates(0, 3);
						break;
					case 32:
						if (curChar == 117)
							jjstateSet[jjnewStateCnt++] = 33;
						break;
					case 33:
						if ((0x7e0000007eL & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 34;
						break;
					case 34:
						if ((0x7e0000007eL & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 35;
						break;
					case 35:
						if ((0x7e0000007eL & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 36;
						break;
					case 36:
						if ((0x7e0000007eL & l) != 0L)
							jjCheckNAddStates(0, 3);
						break;
					case 37:
						if (curChar == 92)
							jjstateSet[jjnewStateCnt++] = 32;
						break;
					case 39:
						if ((0x2000000020L & l) == 0L)
							break;
						if (kind > 14)
							kind = 14;
						jjCheckNAddTwoStates(40, 42);
						break;
					case 42:
						if ((0x7fffffe87fffffeL & l) == 0L)
							break;
						if (kind > 14)
							kind = 14;
						jjCheckNAdd(42);
						break;
					default:
						break;
					}
				}
				while (i != startsAt);
			}
			else
			{
				int hiByte = (int) (curChar >> 8);
				int i1 = hiByte >> 6;
				long l1 = 1L << (hiByte & 077);
				int i2 = (curChar & 0xff) >> 6;
				long l2 = 1L << (curChar & 077);
				do
				{
					switch (jjstateSet[--i])
					{
					case 43:
					case 29:
						if (jjCanMove_0(hiByte, i1, i2, l1, l2))
							jjCheckNAddStates(0, 3);
						break;
					case 18:
						if (jjCanMove_0(hiByte, i1, i2, l1, l2))
							jjAddStates(4, 7);
						break;
					default:
						break;
					}
				}
				while (i != startsAt);
			}
			if (kind != 0x7fffffff)
			{
				jjmatchedKind = kind;
				jjmatchedPos = curPos;
				kind = 0x7fffffff;
			}
			++curPos;
			if ((i = jjnewStateCnt) == (startsAt = 43 - (jjnewStateCnt = startsAt)))
				return curPos;
			try
			{
				curChar = input_stream.readChar();
			}
			catch (java.io.IOException e)
			{
				return curPos;
			}
		}
	}

	private final int jjStopStringLiteralDfa_2(int pos, long active0)
	{
		switch (pos)
		{
		default:
			return -1;
		}
	}

	@SuppressWarnings("unused")
	private final int jjStartNfa_2(int pos, long active0)
	{
		return jjMoveNfa_2(jjStopStringLiteralDfa_2(pos, active0), pos + 1);
	}

	private int jjMoveStringLiteralDfa0_2()
	{
		switch (curChar)
		{
		case 117:
			return jjStopAtPos(0, 25);
		default:
			return jjMoveNfa_2(0, 0);
		}
	}

	@SuppressWarnings({ "unused" })
	private int jjMoveNfa_2(int startState, int curPos)
	{
		int startsAt = 0;
		jjnewStateCnt = 1;
		int i = 1;
		jjstateSet[0] = startState;
		int kind = 0x7fffffff;
		for (;;)
		{
			if (++jjround == 0x7fffffff)
				ReInitRounds();
			if (curChar < 64)
			{
				long l = 1L << curChar;
				do
				{
					switch (jjstateSet[--i])
					{
					case 0:
						if ((0x800400000000L & l) != 0L)
							kind = 24;
						break;
					default:
						break;
					}
				}
				while (i != startsAt);
			}
			else if (curChar < 128)
			{
				long l = 1L << (curChar & 077);
				do
				{
					switch (jjstateSet[--i])
					{
					case 0:
						if ((0x14404410000000L & l) != 0L)
							kind = 24;
						break;
					default:
						break;
					}
				}
				while (i != startsAt);
			}
			else
			{
				int hiByte = (int) (curChar >> 8);
				int i1 = hiByte >> 6;
				long l1 = 1L << (hiByte & 077);
				int i2 = (curChar & 0xff) >> 6;
				long l2 = 1L << (curChar & 077);
				do
				{
					switch (jjstateSet[--i])
					{
					default:
						break;
					}
				}
				while (i != startsAt);
			}
			if (kind != 0x7fffffff)
			{
				jjmatchedKind = kind;
				jjmatchedPos = curPos;
				kind = 0x7fffffff;
			}
			++curPos;
			if ((i = jjnewStateCnt) == (startsAt = 1 - (jjnewStateCnt = startsAt)))
				return curPos;
			try
			{
				curChar = input_stream.readChar();
			}
			catch (java.io.IOException e)
			{
				return curPos;
			}
		}
	}

	private final int jjStopStringLiteralDfa_1(int pos, long active0)
	{
		switch (pos)
		{
		default:
			return -1;
		}
	}

	@SuppressWarnings("unused")
	private final int jjStartNfa_1(int pos, long active0)
	{
		return jjMoveNfa_1(jjStopStringLiteralDfa_1(pos, active0), pos + 1);
	}

	private int jjMoveStringLiteralDfa0_1()
	{
		switch (curChar)
		{
		case 92:
			return jjStopAtPos(0, 21);
		default:
			return jjMoveNfa_1(0, 0);
		}
	}

	private int jjMoveNfa_1(int startState, int curPos)
	{
		int startsAt = 0;
		jjnewStateCnt = 2;
		int i = 1;
		jjstateSet[0] = startState;
		int kind = 0x7fffffff;
		for (;;)
		{
			if (++jjround == 0x7fffffff)
				ReInitRounds();
			if (curChar < 64)
			{
				long l = 1L << curChar;
				do
				{
					switch (jjstateSet[--i])
					{
					case 0:
						if ((0xfffffffbffffffffL & l) != 0L)
						{
							if (kind > 23)
								kind = 23;
						}
						else if (curChar == 34)
						{
							if (kind > 22)
								kind = 22;
						}
						break;
					case 1:
						if ((0xfffffffbffffffffL & l) != 0L)
							kind = 23;
						break;
					default:
						break;
					}
				}
				while (i != startsAt);
			}
			else if (curChar < 128)
			{
				long l = 1L << (curChar & 077);
				do
				{
					switch (jjstateSet[--i])
					{
					case 0:
						if ((0xffffffffefffffffL & l) != 0L)
							kind = 23;
						break;
					default:
						break;
					}
				}
				while (i != startsAt);
			}
			else
			{
				int hiByte = (int) (curChar >> 8);
				int i1 = hiByte >> 6;
				long l1 = 1L << (hiByte & 077);
				int i2 = (curChar & 0xff) >> 6;
				long l2 = 1L << (curChar & 077);
				do
				{
					switch (jjstateSet[--i])
					{
					case 0:
						if (jjCanMove_0(hiByte, i1, i2, l1, l2) && kind > 23)
							kind = 23;
						break;
					default:
						break;
					}
				}
				while (i != startsAt);
			}
			if (kind != 0x7fffffff)
			{
				jjmatchedKind = kind;
				jjmatchedPos = curPos;
				kind = 0x7fffffff;
			}
			++curPos;
			if ((i = jjnewStateCnt) == (startsAt = 2 - (jjnewStateCnt = startsAt)))
				return curPos;
			try
			{
				curChar = input_stream.readChar();
			}
			catch (java.io.IOException e)
			{
				return curPos;
			}
		}
	}

	static final int[] jjnextStates =
	{ 29, 30, 37, 38, 18, 19, 26, 27, };

	private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
	{
		switch (hiByte)
		{
		case 0:
			return ((jjbitVec2[i2] & l2) != 0L);
		default:
			if ((jjbitVec0[i1] & l1) != 0L)
				return true;
			return false;
		}
	}

	/** Token literal values. */
	public static final String[] jjstrLiteralImages =
	{ "", null, null, null, null, null, null, "\156\165\154\154", "\116\141\116", "\111\156\146\151\156\151\164\171", null, "\56", "\156\145\167", null, null, null, null, null, null, null, "\42", null, null, null, null, null, null, null, "\51\135\175\47\12", "\173", "\175", "\54", "\72", "\50", "\51", "\133", "\135", "\55", };

	/** Lexer state names. */
	public static final String[] lexStateNames =
	{ "DEFAULT", "STRING_STATE", "ESC_STATE", "HEX_STATE", };

	/** Lex State array. */
	public static final int[] jjnewLexState =
	{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 2, 0, -1, 1, 3, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, };
	static final long[] jjtoToken =
	{ 0x3ff9dd7fe1L, };
	static final long[] jjtoSkip =
	{ 0x1eL, };
	static final long[] jjtoMore =
	{ 0x2200000L, };
	protected SimpleCharStream input_stream;
	private final int[] jjrounds = new int[43];
	private final int[] jjstateSet = new int[86];
	protected char curChar;

	/** Constructor. */
	public JSONReaderInternalTokenManager(SimpleCharStream stream)
	{
		if (SimpleCharStream.staticFlag)
			throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
		input_stream = stream;
	}

	/** Constructor. */
	public JSONReaderInternalTokenManager(SimpleCharStream stream, int lexState)
	{
		this(stream);
		SwitchTo(lexState);
	}

	/** Reinitialise parser. */
	public void ReInit(SimpleCharStream stream)
	{
		jjmatchedPos = jjnewStateCnt = 0;
		curLexState = defaultLexState;
		input_stream = stream;
		ReInitRounds();
	}

	private void ReInitRounds()
	{
		int i;
		jjround = 0x80000001;
		for (i = 43; i-- > 0;)
			jjrounds[i] = 0x80000000;
	}

	/** Reinitialise parser. */
	public void ReInit(SimpleCharStream stream, int lexState)
	{
		ReInit(stream);
		SwitchTo(lexState);
	}

	/** Switch to specified lex state. */
	public void SwitchTo(int lexState)
	{
		if (lexState >= 4 || lexState < 0)
			throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
		else
			curLexState = lexState;
	}

	protected Token jjFillToken()
	{
		final Token t;
		final String curTokenImage;
		final int beginLine;
		final int endLine;
		final int beginColumn;
		final int endColumn;
		String im = jjstrLiteralImages[jjmatchedKind];
		curTokenImage = (im == null) ? input_stream.GetImage() : im;
		beginLine = input_stream.getBeginLine();
		beginColumn = input_stream.getBeginColumn();
		endLine = input_stream.getEndLine();
		endColumn = input_stream.getEndColumn();
		t = Token.newToken(jjmatchedKind, curTokenImage);

		t.beginLine = beginLine;
		t.endLine = endLine;
		t.beginColumn = beginColumn;
		t.endColumn = endColumn;

		return t;
	}

	int curLexState = 0;
	int defaultLexState = 0;
	int jjnewStateCnt;
	int jjround;
	int jjmatchedPos;
	int jjmatchedKind;

	/** Get the next Token. */
	public Token getNextToken()
	{
		Token matchedToken;
		int curPos = 0;

		EOFLoop: for (;;)
		{
			try
			{
				curChar = input_stream.BeginToken();
			}
			catch (java.io.IOException e)
			{
				jjmatchedKind = 0;
				matchedToken = jjFillToken();
				return matchedToken;
			}

			for (;;)
			{
				switch (curLexState)
				{
				case 0:
					try
					{
						input_stream.backup(0);
						while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
							curChar = input_stream.BeginToken();
					}
					catch (java.io.IOException e1)
					{
						continue EOFLoop;
					}
					jjmatchedKind = 0x7fffffff;
					jjmatchedPos = 0;
					curPos = jjMoveStringLiteralDfa0_0();
					break;
				case 1:
					jjmatchedKind = 0x7fffffff;
					jjmatchedPos = 0;
					curPos = jjMoveStringLiteralDfa0_1();
					break;
				case 2:
					jjmatchedKind = 0x7fffffff;
					jjmatchedPos = 0;
					curPos = jjMoveStringLiteralDfa0_2();
					break;
				case 3:
					jjmatchedKind = 0x7fffffff;
					jjmatchedPos = 0;
					curPos = jjMoveStringLiteralDfa0_3();
					break;
				}
				if (jjmatchedKind != 0x7fffffff)
				{
					if (jjmatchedPos + 1 < curPos)
						input_stream.backup(curPos - jjmatchedPos - 1);
					if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
					{
						matchedToken = jjFillToken();
						if (jjnewLexState[jjmatchedKind] != -1)
							curLexState = jjnewLexState[jjmatchedKind];
						return matchedToken;
					}
					else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
					{
						if (jjnewLexState[jjmatchedKind] != -1)
							curLexState = jjnewLexState[jjmatchedKind];
						continue EOFLoop;
					}
					if (jjnewLexState[jjmatchedKind] != -1)
						curLexState = jjnewLexState[jjmatchedKind];
					curPos = 0;
					jjmatchedKind = 0x7fffffff;
					try
					{
						curChar = input_stream.readChar();
						continue;
					}
					catch (java.io.IOException e1)
					{
					}
				}
				int error_line = input_stream.getEndLine();
				int error_column = input_stream.getEndColumn();
				String error_after = null;
				boolean EOFSeen = false;
				try
				{
					input_stream.readChar();
					input_stream.backup(1);
				}
				catch (java.io.IOException e1)
				{
					EOFSeen = true;
					error_after = curPos <= 1 ? "" : input_stream.GetImage();
					if (curChar == '\n' || curChar == '\r')
					{
						error_line++;
						error_column = 0;
					}
					else
						error_column++;
				}
				if (!EOFSeen)
				{
					input_stream.backup(1);
					error_after = curPos <= 1 ? "" : input_stream.GetImage();
				}
				throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
			}
		}
	}

	private void jjCheckNAdd(int state)
	{
		if (jjrounds[state] != jjround)
		{
			jjstateSet[jjnewStateCnt++] = state;
			jjrounds[state] = jjround;
		}
	}

	private void jjAddStates(int start, int end)
	{
		do
		{
			jjstateSet[jjnewStateCnt++] = jjnextStates[start];
		}
		while (start++ != end);
	}

	private void jjCheckNAddTwoStates(int state1, int state2)
	{
		jjCheckNAdd(state1);
		jjCheckNAdd(state2);
	}

	private void jjCheckNAddStates(int start, int end)
	{
		do
		{
			jjCheckNAdd(jjnextStates[start]);
		}
		while (start++ != end);
	}

}

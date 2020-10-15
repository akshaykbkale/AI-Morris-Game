package abk190001;

import java.util.ArrayList;
import java.util.List;

public class GameMoves {
	
	public static List<List<positionVal>> GenerateMovesOpening(List<positionVal> inputList) {
		return GenerateAdd(inputList);
	}
	
	public static List<List<positionVal>> GenerateMovesMidgameEndgame(List<positionVal> inputList) {
		if (MorrisFunctions.getNumPieces(positionVal.W, inputList)==3)
			return GenerateHopping(inputList);
		else
			return GenerateMove(inputList);
	}
	
	public static List<List<positionVal>> GenerateAdd(List<positionVal> inputList) {
		List<List<positionVal>> l = new ArrayList<>();
		for (int i = 0; i < inputList.size(); i++)
		{
			if (inputList.get(i) == positionVal.X)
			{
				List<positionVal> b = new ArrayList<>(inputList);
				b.set(i, positionVal.W);
				if (NeighboursAndCloseMill.closeMill(i, b))
				{
					int s = l.size();
					l = GenerateRemove(b, l);
				}
				else
				{
					l.add(b);
				}
			}
		}
		return l;
	}
	
	public static List<List<positionVal>> GenerateHopping(List<positionVal> inputList) {
		List<List<positionVal>> l = new ArrayList<>();
		for (int i = 0; i < inputList.size(); i++)
		{
			if (inputList.get(i) == positionVal.W)
			{
				for (int j = 0; j < inputList.size(); j++)
				{
					if (inputList.get(j) == positionVal.X)
					{
						List<positionVal> b = new ArrayList<>(inputList);
						b.set(i, positionVal.X);
						b.set(j, positionVal.W);
						if (NeighboursAndCloseMill.closeMill(j, b))
						{
							GenerateRemove(b, l);
						}
						else
						{
							l.add(b);
						}
					}
				}
			}
		}
		return l;
	}
	public static List<List<positionVal>> GenerateMove(List<positionVal> inputList) {
		List<List<positionVal>> l = new ArrayList<>();
//		System.out.println("list: "+inputList.toString());
		for (int i = 0; i < inputList.size(); i++)
		{
			if (inputList.get(i) == positionVal.W)
			{
				List<Integer> n = NeighboursAndCloseMill.neighbors(i);
				for (int j : n)
				{
					if (inputList.get(j) == positionVal.X)
					{
						List<positionVal> b = new ArrayList<>(inputList);
						b.set(i, positionVal.X);
						b.set(j, positionVal.W);
						if (NeighboursAndCloseMill.closeMill(j, b))
						{
							l = GenerateRemove(b, l);
						}
						else
						{
							l.add(b);
						}
					}
				}
			}
		}
		return l;
	}
	
	public static List<List<positionVal>> GenerateRemove(List<positionVal> inputList, List<List<positionVal>> l) {
		for (int i = 0; i < inputList.size(); i++)
		{
			if (inputList.get(i) == positionVal.B)
			{
				if (!NeighboursAndCloseMill.closeMill(i, inputList))
				{
					List<positionVal> b = new ArrayList<>(inputList);
					b.set(i, positionVal.X);
					l.add(b);
				}
			}
		}
		return l;
	}
	
	
	public static List<List<positionVal>> GenerateMovesOpeningBlack(List<positionVal> inputList) {
		List<positionVal> tempb = MorrisFunctions.FlipBoard(inputList);
		List<List<positionVal>> moves = GenerateMovesOpening(tempb);
		for (int i = 0; i < moves.size(); i++)
		{
			List<positionVal> b = moves.get(i);
			moves.set(i, MorrisFunctions.FlipBoard(b));
		}
		return moves;
	}
	
	
	public static List<List<positionVal>> GenerateMovesMidgameEndgameBlack(List<positionVal> inputList) {
		List<positionVal> tempb = MorrisFunctions.FlipBoard(inputList);
		List<List<positionVal>> moves = GenerateMovesMidgameEndgame(tempb);
		List<List<positionVal>> out = new ArrayList<>();
		for (int i = 0; i < moves.size(); i++)
		{
			List<positionVal> b = moves.get(i);
			out.add(MorrisFunctions.FlipBoard(b));
		}
		return out;
	}
}

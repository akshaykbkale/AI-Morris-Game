package abk190001;

import java.util.List;

public class MiniMaxGameBlack {
public static void main(String[] args) {
		
		/**
		 * initial arguments from console board1.txt board2.txt 3
		 */
		String inpFile = args[0];
		String outFile = args[1];
		int depth = Integer.parseInt(args[2]);
		List<positionVal> inputList = MorrisFunctions.readInpFile(inpFile);
		/**
		 * flip the input board poisitions so as to for play black player.
		 */
		inputList = MorrisFunctions.FlipBoard(inputList);
		finalResult output = MiniMax(depth, true, inputList);
		output.b=MorrisFunctions.FlipBoard(output.b);
		MorrisFunctions.writeToFile(output, outFile);
	}
	/**
	 * minimax algorithm to recursively evaluate the best move for black player in Mid or End Game phase, based on given static estimation.
	 * @param depth
	 * @param isWhite
	 * @param inputList
	 * @return
	 */
	private static finalResult MiniMax(int depth, boolean isWhite, List<positionVal> inputList) {

		finalResult out = new finalResult();
		finalResult in = new finalResult();
		List<List<positionVal>> nextMoves;
		if (depth == 0)
		{
			out.leafCount++;
			out.val = StaticEstimation.MidEndGame(inputList);
			return out;
		}
		if(isWhite) {
			out.val = Integer.MIN_VALUE;
			nextMoves = GameMoves.GenerateMovesMidgameEndgame(inputList);
		}
		else {
			out.val = Integer.MAX_VALUE;
			nextMoves = GameMoves.GenerateMovesMidgameEndgameBlack(inputList);
		}
			
		for (List<positionVal> b : nextMoves)
		{
			if (isWhite)
			{
				in = MiniMax(depth - 1, false, b);
				out.leafCount += in.leafCount;
				
				if (in.val > out.val)
				{
					out.val = in.val;
					out.b = b;
				}
			}
			else
			{
				in = MiniMax(depth - 1, true, b);
				out.leafCount += in.leafCount;
				if (in.val < out.val)
				{
					out.val = in.val;
					out.b = b;
				}
			}
		}
		return out;
	}
}

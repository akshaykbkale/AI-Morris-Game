package abk190001;

import java.util.List;

public class MiniMaxOpening {
	
public static void main(String[] args) {
		
		/**
		 * Input and Output file names are passed through arguments. 
		 */
		String inpFile = args[0];
		String outFile = args[1];
		int depth = Integer.parseInt(args[2]);
		List<positionVal> inputList = MorrisFunctions.readInpFile(inpFile);
		finalResult output = MiniMax(depth, true, inputList);
		MorrisFunctions.writeToFile(output, outFile);
	}
	/** 
	 * minimax algorithm to recursively evaluate the best move for white player in opening phase, based on given static estimation
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
			out.val = StaticEstimation.Opening(inputList);
			return out;
		}
		if(isWhite) {
			out.val = Integer.MIN_VALUE;
			nextMoves = GameMoves.GenerateMovesOpening(inputList);
		}
		else {
			out.val = Integer.MAX_VALUE;
			nextMoves = GameMoves.GenerateMovesOpeningBlack(inputList);
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


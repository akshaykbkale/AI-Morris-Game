package abk190001;

import java.util.List;

public class ABOpening {
public static void main(String[] args) {
			
		/**
		 * initial arguments from console board1.txt board2.txt 3
		 */
		String inpFile = args[0];
		String outFile = args[1];
		int depth = Integer.parseInt(args[2]);
		List<positionVal> inputList = MorrisFunctions.readInpFile(inpFile);
		
		finalResult output = ABPruning(depth, true, inputList,Integer.MIN_VALUE, Integer.MAX_VALUE);
		MorrisFunctions.writeToFile(output, outFile);
	}
	/**
	 * AB pruning algorithm is optimized version of minmax algorithm , it evaluates the next best move for player based on given static estimation.
	 * @param depth
	 * @param isWhite
	 * @param inputList
	 * @param alpha
	 * @param beta
	 * @return
	 */
	private static finalResult ABPruning(int depth, boolean isWhite, List<positionVal> inputList,int alpha,int beta) {

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
				in = ABPruning(depth - 1, false, b,alpha,beta);
				out.leafCount += in.leafCount;
				
				if (in.val > alpha)
				{
					alpha = in.val;
					out.b = b;
				}
			}
			else
			{
				in = ABPruning(depth - 1, true, b,alpha,beta);
				out.leafCount += in.leafCount;
				if (in.val < beta)
				{
					beta = in.val;
					out.b = b;
				}
			}
			if (alpha >= beta)
			{	
				
				break;
			}
		}
		out.val = (isWhite) ? alpha : beta;
		return out;
	}
}

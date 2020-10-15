package abk190001;

import java.util.List;

public class StaticEstimation {

	/**
	 * funtion to evaluate static estimation for  Opening phase fr algorithms.
	 * @param list
	 * @return
	 */
	public static int Opening(List<positionVal> list) {
		return (MorrisFunctions.getNumPieces(positionVal.W,list) - MorrisFunctions.getNumPieces(positionVal.B,list));
		
	}
	/**
	 * funtion to evaluate static estimation for  MidEndGame phase fr algorithms.
	 * @param inputList
	 * @return
	 */
	public static int MidEndGame(List<positionVal> inputList) {
		int numBlackPieces = MorrisFunctions.getNumPieces(positionVal.B,inputList);
		int numWhitePieces = MorrisFunctions.getNumPieces(positionVal.W,inputList);
		List<List<positionVal>> l = GameMoves.GenerateMovesMidgameEndgameBlack(inputList);
		int numBlackMoves = l.size();
		if (numBlackPieces <= 2)		
			return 10000;
		else if (numWhitePieces <= 2)
			return -10000;
		else if (numBlackPieces == 0)
			return 10000;
		else
			return 1000*(numWhitePieces - numBlackPieces) - numBlackMoves;		
	}
	
	/**
	 * funtion to evaluate imaproved static estimation for  Opening phase fr algorithms.
	 * @param list
	 * @return
	 */
	public static int OpeningImproved(List<positionVal> list) {

		return (int) (MorrisFunctions.getNumPieces(positionVal.W,list) - MorrisFunctions.getNumPieces(positionVal.B,list)  - 0.5*(NeighboursAndCloseMill.blockedPosition(list,positionVal.W) - NeighboursAndCloseMill.blockedPosition(list,positionVal.B)));
	}
	
	
	/**
	 * funtion to evaluate improved static estimation for  midEndGame phase fr algorithms.
	 * @param inputList
	 * @return
	 */
	public static int MidEndGameImproved(List<positionVal> inputList) {
		int numBlackPieces = MorrisFunctions.getNumPieces(positionVal.B,inputList);
		int numWhitePieces = MorrisFunctions.getNumPieces(positionVal.W,inputList);
		List<List<positionVal>> l = GameMoves.GenerateMovesMidgameEndgameBlack(inputList);
		int numBlackMoves = l.size();
		if (numBlackPieces <= 2)
			return 10000;
		else if (numWhitePieces <= 2)
			return -10000;
		else if (numBlackPieces == 0)
			return 10000;
		else
			return 1000*((int) ( numWhitePieces- numBlackPieces  - 0.5*(NeighboursAndCloseMill.blockedPosition(inputList,positionVal.W) - NeighboursAndCloseMill.blockedPosition(inputList,positionVal.B)))) - numBlackMoves;
			
	}
}

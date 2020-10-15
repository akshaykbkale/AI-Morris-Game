package abk190001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeighboursAndCloseMill {
	
	/**
	 * for given index or position in board list it return the neighbors of it.
	 * @param index
	 * @return neighbors list.
	 */
	public static List<Integer> neighbors(int index)
	{
		switch(index)
		{
			case 0:
				return Arrays.asList(1, 3, 8);
			case 1:
				return Arrays.asList(0, 2, 4);
			case 2:
				return Arrays.asList(1, 5, 13);
			case 3:
				return Arrays.asList(0, 4, 6, 9);
			case 4:
				return Arrays.asList(1, 3, 5);
			case 5:
				return Arrays.asList(2, 4, 7, 12);
			case 6:
				return Arrays.asList(3, 7, 10);
			case 7:
				return Arrays.asList(5, 6, 11);
			case 8:
				return Arrays.asList(0, 9, 20);
			case 9:
				return Arrays.asList(3, 8, 10, 17);
			case 10:
				return Arrays.asList(6, 9, 14);
			case 11:
				return Arrays.asList(7, 12, 16);
			case 12:
				return Arrays.asList(5, 11, 13, 19);
			case 13:
				return Arrays.asList(2, 12, 22);
			case 14:
				return Arrays.asList(10, 15, 17);
			case 15:
				return Arrays.asList(14, 16, 18);
			case 16:
				return Arrays.asList(11, 15, 19);
			case 17:
				return Arrays.asList(9, 14, 18, 20);
			case 18:
				return Arrays.asList(15, 17, 19, 21);
			case 19:
				return Arrays.asList(12, 16, 18, 22);
			case 20:
				return Arrays.asList(8, 17, 21);
			case 21:
				return Arrays.asList(18, 20, 22);
			case 22:
				return Arrays.asList(13, 19, 21);
			default:
				return (new ArrayList<Integer>());
		}
	}
	
	
/**
 * method tells whther the given index and board list it forms close mill or not.
 * @param index
 * @param inputList
 * @return whether it form close mill or not.
 */
public static boolean closeMill(int index, List<positionVal> inputList)
{
	positionVal piece = inputList.get(index);
	if (piece != positionVal.X)
		return checkAllMills(index, piece, inputList);
	return false;
}

/**
 * its helper function for close mills. It contains list of possible closemills for a position.
 * @param index
 * @param piece
 * @param list
 * @return 
 */
public static boolean checkAllMills(int index, positionVal piece, List<positionVal> list)
{

	switch(index)
	{
		case 0:
			return (checkMill(list, piece, 1, 2) || checkMill(list, piece, 8, 20) || checkMill(list, piece, 3, 6));
		case 1:
			return (checkMill(list, piece, 0, 2));
		case 2:
			return (checkMill(list, piece, 0, 1) || checkMill(list, piece, 5, 7) || checkMill(list, piece, 13, 22));
		case 3:
			return (checkMill(list, piece, 0, 6) || checkMill(list, piece, 4, 5) || checkMill(list, piece, 9, 17));
		case 4:
			return (checkMill(list, piece, 3, 5));
		case 5:
			return (checkMill(list, piece, 3, 4) || checkMill(list, piece, 2, 7) || checkMill(list, piece, 12, 19));
		case 6:
			return (checkMill(list, piece, 0, 3) || checkMill(list, piece, 10, 14));
		case 7:
			return (checkMill(list, piece, 2, 5) || checkMill(list, piece, 11, 16));
		case 8:
			return (checkMill(list, piece, 0, 20) || checkMill(list, piece, 9, 10));
		case 9:
			return (checkMill(list, piece, 8, 10) || checkMill(list, piece, 3, 17));
		case 10:
			return (checkMill(list, piece, 8, 9) || checkMill(list, piece, 6, 14));
		case 11:
			return (checkMill(list, piece, 7, 16) || checkMill(list, piece, 12, 13));
		case 12:
			return (checkMill(list, piece, 11, 13) || checkMill(list, piece, 5, 19));
		case 13:
			return (checkMill(list, piece, 11, 12) || checkMill(list, piece, 2, 22));
		case 14:
			return (checkMill(list, piece, 17, 20) || checkMill(list, piece, 15, 16) || checkMill(list, piece, 6, 10));
		case 15:
			return (checkMill(list, piece, 14, 16) || checkMill(list, piece, 18, 21));
		case 16:
			return (checkMill(list, piece, 14, 15) || checkMill(list, piece, 19, 22) || checkMill(list, piece, 7, 11));
		case 17:
			return (checkMill(list, piece, 3, 9) || checkMill(list, piece, 14, 20) || checkMill(list, piece, 18, 19));
		case 18:
			return (checkMill(list, piece, 17, 19) || checkMill(list, piece, 15, 21));
		case 19:
			return (checkMill(list, piece, 17, 18) || checkMill(list, piece, 16, 22) || checkMill(list, piece, 5, 12));
		case 20:
			return (checkMill(list, piece, 0, 8) || checkMill(list, piece, 14, 17) || checkMill(list, piece, 21, 22));
		case 21:
			return (checkMill(list, piece, 20, 22) || checkMill(list, piece, 15, 18));
		case 22:
			return (checkMill(list, piece, 2, 13) || checkMill(list, piece, 16, 19) || checkMill(list, piece, 20, 21));
		default:
			return false;
	}
}

/**
 * Give player position , it returns a value whther its forms mill or not. 
 * @param list
 * @param piece
 * @param neighbor1
 * @param neighbor2
 * @return
 */
private static boolean checkMill(List<positionVal> list, positionVal piece, int neighbor1, int neighbor2)
{
	return (list.get(neighbor1) == piece && list.get(neighbor2) == piece);
}


/**
 * its mehtod written to evaluate number of blocked positon for position.This function is used for improvement of static estimation.
 * @param list
 * @param p
 * @return count of blocked positons
 */
public static int blockedPosition(List<positionVal> list,positionVal p){
	  int count = 0 ;
	  for(int i = 0 ; i < list.size() ; i++) {
	    if (list.get(i) == p) {
	      List<Integer> neighbours = neighbors(i);
	      for (int n : neighbours) {
	        if (list.get(n) != positionVal.X) {
	          count++;
	        }
	      }
	    }
	  }
	   return  count;
	}
}

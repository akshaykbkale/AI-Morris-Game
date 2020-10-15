package abk190001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MorrisFunctions {
	
	/**
	 * 
	 * @param fileName
	 * @return list of board positions defined over enum type for Black ,White and Empty space.   
	 */
	public static List<positionVal> readInpFile(String fileName)
	{
		String line = null;
		
		try
		{
			FileReader fileR = new FileReader(fileName);
			BufferedReader buffR = new BufferedReader(fileR);
			line = buffR.readLine();
			List<positionVal> positionList = new ArrayList<>();
			for (char a : line.toCharArray())
			{
				positionVal pos = (a == 'W') ? positionVal.W : ((a == 'B') ? positionVal.B : positionVal.X);
				positionList.add(pos);
			}
			buffR.close();
			return positionList;
		}
		catch(IOException ex)
		{
			System.out.println("Error with Buffer");
		}
		return null;
	}
	
	/**
	 * using this function we have to write ouput object to outFile.
	 * @param out
	 * @param outFile
	 */
	public static void writeToFile(finalResult out, String outFile)
	{
		try {
			FileWriter data = new FileWriter(outFile);
			BufferedWriter buff = new BufferedWriter(data);
			buff.write(out.toString());
			buff.close();
		}
		catch(IOException ex) {
			System.out.println("Error writing to file '" + outFile + "'");
		}
	}
	
	/**
	 *  it evaluates the number of certain player in board list.
	 * @param player
	 * @param list
	 * @return count pf player
	 */
	public static int getNumPieces(positionVal player, List<positionVal> list)
	{
		int counter = 0;
		for (positionVal pos : list)
		{
			if (pos == player)
				counter++;
		}
		return counter;
	}
	
	/**
	 * it generates flipped board where W->B ,B->W and X remains same.
	 * @param board list
	 * @return fliped board
	 */
	public static List<positionVal> FlipBoard(List<positionVal> list){
		List<positionVal> res = new ArrayList<>(list);
		
		for ( int i = 0; i < list.size(); i++)
		{
			positionVal val = list.get(i);
			if (val == positionVal.B)			
				res.set(i,positionVal.W);
			else if (val == positionVal.W)
				res.set(i,positionVal.B);

		}
		return res;
	}
	
	
}

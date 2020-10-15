package abk190001;

import java.util.List;

public class finalResult {
	
	
		int val;
		int leafCount;
		public List<positionVal> b;
		public String toString()
		{	StringBuffer sb = new StringBuffer();
		      for (positionVal s : b) {
		          sb.append(s);
		       }
			return 	"BoardPosition:\t\t\t" + sb + "\n" +
					"Positions Evaluated:\t" + leafCount + "\n" + 
					"Static estimate:\t\t" + val;
		}
	
}

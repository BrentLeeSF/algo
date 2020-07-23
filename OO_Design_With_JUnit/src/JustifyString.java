import java.util.ArrayList;
import java.util.*;
import java.io.*;

class JustifyThisString {
	
	public String[] getWords(String thisString) {
		String output = thisString.trim();
		String[] words = output.split(" ");
		return words;
	}

	public ArrayList<String> justifyString(String justifyThisString, int limit) {

		ArrayList<String> returnedListOfStrings = new ArrayList<String>();
		
		if (justifyThisString == null || justifyThisString.isEmpty()) {
			throw new RuntimeException("Cannot take in an empty String or null value");
		}
		
		StringBuilder sb = new StringBuilder();
		String[] words = getWords(justifyThisString);
		
		/** Small sentence less than limit */
		if(justifyThisString.length() < limit && words.length > 1) {

			int smallWordCount = 0, smalSpaceCount = 0;
			for(smallWordCount = 0; smallWordCount < words.length; smallWordCount++) {
				sb.append(words[smallWordCount]+" ");
			}
			String newString = sb.toString();
			newString = newString.substring(0, newString.length() - 1);
			smalSpaceCount = smallWordCount-1;
			
			System.out.println("length = "+words.length);
			
			String thisSmallString = addAllWords(newString, smalSpaceCount, limit);
			returnedListOfStrings.add(thisSmallString);
			return returnedListOfStrings;
			
			/** Single word */
		} else if(justifyThisString.length() < limit && words.length == 1) {
			
			String oneWordResult = addOneWord(justifyThisString, limit);
			returnedListOfStrings.add(oneWordResult);
			return returnedListOfStrings;
		}

		int wordCount = 0, characterCount = 0, spaceCount = 0;

		for (int i = 0; i < words.length; i++) {

			if (words[i].length() + characterCount + 1 > limit) {

				String newString = sb.toString();
				newString = newString.substring(0, newString.length() - 1);
				spaceCount--;

				String finalStringToAdd; 			
				
				/** Add all words*/
				if (wordCount > 1) {
					finalStringToAdd = addAllWords(newString, spaceCount, limit);
				}

				/** One word line. Needs to have spaces in front of and at end of */
				else {
					finalStringToAdd = addOneWord(newString, limit);
				}

				wordCount = 0;
				characterCount = 0;
				spaceCount = 0;

				returnedListOfStrings.add(finalStringToAdd);

				sb = new StringBuilder();
				wordCount++;
				characterCount += words[i].length() + 1;
				spaceCount++;
				sb.append(words[i] + " ");

			} else {

				wordCount++;
				characterCount += words[i].length() + 1;
				spaceCount++;
				sb.append(words[i] + " ");
			}

		}

		returnedListOfStrings.add(sb.toString());
		return returnedListOfStrings;
	}
	
	/** Single word within limit */
	public String addOneWord(String newString, int limit) {
		
		int difference = limit - newString.length();
		StringBuilder newStringBuilder = new StringBuilder();
		int half = difference / 2;

		while (half < difference) {
			newStringBuilder.append(" ");
			half++;
		}

		newStringBuilder.append(newString);
		half = difference / 2;
		half = limit%2 != 0 ? ++half : half;

		while (half < difference) {
			newStringBuilder.append(" ");
			half++;
		}
		return newStringBuilder.toString();
	}
	
	/** More than one word within limit */
	public String addAllWords(String newString, int spaceCount, int limit) {
		
		int difference = limit - newString.length();
		StringBuilder sb = new StringBuilder();
		int bySpace = 0, mod = 0;

		if (spaceCount != 0) {
			bySpace = difference / spaceCount;
			mod = difference % spaceCount;
		}

		int newCharCount = 0, newCharTotalCount = 0;

		while (newCharTotalCount < limit) {

			int thisSpace = 0;

			if (newString.charAt(newCharCount) == ' ' && difference > 0) {

				while (thisSpace != bySpace) {
					sb.append(" ");
					difference--;
					newCharTotalCount++;
					thisSpace++;
				}

				if (mod > 0) {
					sb.append(" ");
					difference--;
					newCharTotalCount++;
					mod--;
				}
			}
			sb.append(newString.charAt(newCharCount));

			newCharCount++;
			newCharTotalCount++;
		}
		
		return sb.toString();
	}
}


public class JustifyString {
	
	public static void main(String[] args) {
		
		String testThisString = "A common type of text alignment in print media is justification, where the spaces between words and between glyphs or letters are stretched or compressed in order to align both the left and right ends of consecutive lines of text. When using justification, it is customary to treat the last line of a paragraph separately by simply left or right aligning it, depending on the language direction. Lines in which the spaces have been stretched beyond their normal width are called loose lines, while those whose spaces have been compressed are called tight lines.";
		String testThis = "A common type";
		String testThisNullString = null;
		String emptyString = "";
		
		JustifyThisString js = new JustifyThisString();
		int justificationLimt = 24;
		
		ArrayList<String> returnedString = js.justifyString(emptyString, justificationLimt);
		
		for(int i = 0; i < returnedString.size(); i++) {
			if(i < returnedString.size()-1)
				System.out.println(returnedString.get(i)+"Length="+returnedString.get(i).length());
			System.out.println(returnedString.get(i)+"Length="+returnedString.get(i).length());
		}
	}
}
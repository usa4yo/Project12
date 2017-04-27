import java.util.Arrays;
/**
 * Class        : TranspositionCipher
 * Project 12   : A secret Language
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-23
 * Last Mod.    : 2017-04-27
 * Due Date     : 2017-04-27
 *
 * Transpotion Cipher class for the Secret Language Cipher 
 */

public class TranspositionCipher implements MessageDecoder, MessageEncoder {

	private int n;
	
	public TranspositionCipher(int n) {
		this.n = n;
	} // End bracket of TranspositionCipher constructor
	
	public String encode(String plainText) {
	    // Declare array used for the cipher process
	    char[] c = plainText.toCharArray();
		char[] first  = Arrays.copyOfRange(c, 0, Math.round(c.length/2.0f));
		char[] second = Arrays.copyOfRange(c, Math.round(c.length/2.0f), c.length);
		char[] shuffled = new char[c.length];

		
		int counter = 0;
		for (int i = 0; i < c.length; i++) {
			if ( i < first.length) {
				shuffled[counter++] = first[i];
			}    // End bracket of inner if statement
			
			if ( i < second.length) {
				shuffled[counter++] = second[i];
			}    // End bracket of inner if statement
			
		}    // End bracket of if statement
		
		return String.valueOf(shuffled);			
	}  // End bracket of encode method
	
	public String decode(String cipherText) {
		char[] c = cipherText.toCharArray();
		char[] first = new char[Math.round(c.length/2.0f)];
		char[] second = new char[Math.round(c.length/2.0f)];
		
		int counter1 = 0;
		int counter2 = 0;
		
		for (int i = 0; i < c.length; i++) {

		    if (i % 2 == 0) {
				first[counter1++] = c[i];
			} else {
				second[counter2++] = c[i];
			}    // End bracket of if statement

		} // End bracket of first for loop
		
		for (int i = 0; i < first.length; i++) {
			System.out.println("index " + i + ": " + first[i]);
		} // End bracket of second for loop
		
		char[] decoded = new char[first.length + second.length];
		System.arraycopy(first, 0, decoded, 0, first.length);
		System.arraycopy(second, 0, decoded, first.length, second.length);
		
		return String.valueOf(decoded);		
	}  // End bracket of decode method
	
}   // End TranspositionCipher

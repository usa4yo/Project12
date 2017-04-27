/**
 * Class        : SubstitutionCipher
 * Project 12   : A secret Language
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-23
 * Last Mod.    : 2017-04-27
 * Due Date     : 2017-04-27
 *
 * Substitution Cipher class for the Secret Language Cipher 
 */

public class SubstitutionCipher implements MessageDecoder, MessageEncoder {

	private int shiftBy;
	
	public SubstitutionCipher (int shiftBy) {
		this.shiftBy = shiftBy;
	}  // End bracket of SubstitutionCipher constructor
	
   // decode shift with a positive shiftBy value.
	public String encode(String plainText) {
		int shiftBy = this.shiftBy;
		return shift(plainText, shiftBy);		
	}  // End bracket of encode method
	
	// decode shift with a negative shiftBy value.
	public String decode(String cipherText) {
		int shiftBy = this.shiftBy * -1;	
		return shift(cipherText, shiftBy);		
	}  // End bracket of decode method
	
	private String shift(String inputString, int shiftBy) {
		char[] c = inputString.toCharArray();
		for (int i = 0; i < c.length; i++) {
			c[i] = (char)((c[i] - 'a' + shiftBy) % 26 + 'a');
		} // End bracket of for loop
		return String.valueOf(c);
		
	}  // End bracket of shift method
	
} // End bracket of SubstitutionCipher class
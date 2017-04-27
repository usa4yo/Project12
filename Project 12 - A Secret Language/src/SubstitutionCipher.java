public class SubstitutionCipher implements MessageDecoder, MessageEncoder {

	private int shiftBy;
	
	public SubstitutionCipher (int shiftBy) {
		this.shiftBy = shiftBy;
	} // End constructor
	
	public String encode(String plainText) {
		int shiftBy = this.shiftBy;
		return shift(plainText, shiftBy);		
	} // End encode
	
	// decode does the same thing as encode but with a negative shiftBy value.
	public String decode(String cipherText) {
		int shiftBy = this.shiftBy * -1;	
		return shift(cipherText, shiftBy);		
	} // End decode
	
	private String shift(String inputString, int shiftBy) {
		char[] c = inputString.toCharArray();
		for (int i = 0; i < c.length; i++) {
			c[i] = (char)((c[i] - 'a' + shiftBy) % 26 + 'a');
		} // End for
		return String.valueOf(c);
	} // End shift
} // End SubstitutionCipher
import java.util.Arrays;

public class TranspositionCipher implements MessageDecoder, MessageEncoder {

	private int n;
	
	public TranspositionCipher(int n) {
		this.n = n;
	} // End constructor
	
	public String encode(String plainText) {
		char[] c = plainText.toCharArray();
		
		char[] first  = Arrays.copyOfRange(c, 0, Math.round(c.length/2.0f));
		char[] second = Arrays.copyOfRange(c, Math.round(c.length/2.0f), c.length);

		char[] shuffled = new char[c.length];
		
		int counter = 0;
		for (int i = 0; i < c.length; i++) {
			if ( i < first.length) {
				shuffled[counter++] = first[i];
			} // End if
			if ( i < second.length) {
				shuffled[counter++] = second[i];
			}  // End if
		} // End for
		
		return String.valueOf(shuffled);			
	} // End encode
	
	public String decode(String cipherText) {
		char[] c = cipherText.toCharArray();
		char[] first = new char[Math.round(c.length/2.0f)];
		char[] second = new char[Math.round(c.length/2.0f)];
		
		int counter1 = 0;
		int counter2 = 0;
		for (int i = 0; i < c.length; i++) {
			if (i % 2 == 0) {
				first[counter1++] = c[i];
				//System.out.println("First[" + counter + "] " + first[counter]);
			} else {
				second[counter2++] = c[i];
				//System.out.println("Second[" + counter + "] " + second[counter]);
			} // End if
		} // End for
		for (int i = 0; i < first.length; i++) {
			System.out.println("index " + i + ": " + first[i]);
		} // End for
		
		char[] decoded = new char[first.length + second.length];
		System.arraycopy(first, 0, decoded, 0, first.length);
		System.arraycopy(second, 0, decoded, first.length, second.length);
		
		return String.valueOf(decoded);		
	} // End decode	
	
} // End TranspositionCipher

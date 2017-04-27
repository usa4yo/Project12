/**
 * Class        : MessageDecoder
 * Project 12   : A secret Language
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-23
 * Last Mod.    : 2017-04-27
 * Due Date     : 2017-04-27
 *
 * Message Decoder class for the Secret Language Cipher 
 */


public interface MessageDecoder {
	abstract String decode(String cipherText);
} // End bracket of MessageDecoder class

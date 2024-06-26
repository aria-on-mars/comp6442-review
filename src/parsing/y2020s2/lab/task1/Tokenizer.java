package parsing.y2020s2.lab.task1;

/**
 * Tokenizer - this uses the StreamTokenizer class to make a simpler tokenizer
 * which provides a stream of tokens which are either Integer, Double, or
 * String.
 * 
 * @author Eric McCreath
 * @author dongwookim
 */
public abstract class Tokenizer {

	/**
	 * check whether there is a next token in the remaining text
	 * @return boolean
	 */
	public abstract boolean hasNext();

	/**
	 * return the current token extracted by next() method
	 * @return the current token
	 */
	public abstract Token current();

	/**
	 *  Extract next token from the current text and save it.
	 */
	public abstract void next();
}

package finalreview.prefinal.pre20191.Q2;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * @author huy.pham
 */
public class Tokenizer {
    private String _buffer;
    private final char COMMAND_SEPARATOR = ';'; 
    
    public Tokenizer(String buffer) {
        this._buffer = buffer;
        System.out.println(buffer);
    }
    
    /**
     * @return the next token
     */
    private Token next() {
        _buffer = _buffer.trim();
        if (_buffer.isEmpty())
            return null;
        if (_buffer.startsWith(Token.Type.LEFT.toString())) 
            return new Token(Token.Type.LEFT);
        
        if (_buffer.startsWith(Token.Type.RIGHT.toString())) 
            return new Token(Token.Type.RIGHT);
        
        // TODO: Implement "FORWARD" and "BACK" tokenization.
        // hints:
        // - Character.isDigit() may be useful in extracting the forward or back value from the buffer.
        // - Use new Token(<type>, <original token str>, <value>) to return these tokens
        int i = 0;
        String number = "";
        String actualString = "";
        while (_buffer.charAt(i) != ';') {
            actualString += _buffer.charAt(i);
            if (Character.isDigit(_buffer.charAt(i))) {
                number += _buffer.charAt(i);
            }
            i++;
        }
        if (_buffer.startsWith(Token.Type.FORWARD.toString()))
        return new Token(Token.Type.FORWARD, actualString, Integer.parseInt(number));
        if (_buffer.startsWith(Token.Type.BACK.toString()))
            return new Token(Token.Type.BACK, actualString, Integer.parseInt(number));
        // TODO: Implement "PENUP" and "PENDOWN" tokenization.
        if (_buffer.startsWith(Token.Type.PENDOWN.toString()))
            return new Token(Token.Type.PENDOWN);

        if (_buffer.startsWith(Token.Type.PENUP.toString()))
            return new Token(Token.Type.PENUP);
        return null;
    }

    /**
     * Return the next token and remove it from the buffer
     * @return the next token
     */
    public Token takeNext() {
        // TODO: Add your implementation here.
        Token next = next();
        _buffer = _buffer.substring(next.originalTokenStr.length() + 1);
        return next;
    }

    /**
     * @return whether there is another token to parse in the buffer
     */
    public boolean hasNext() {
        // TODO: Add your implementation here.
        return _buffer.length() > 0;
    }
   
}
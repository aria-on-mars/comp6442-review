package finalreview.prefinal.pre20192.Q4;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * @author huy.pham
 * @author dongwoo
 */
public class Tokenizer {
    private String _buffer;
    private final char COMMAND_SEPARATOR = ';'; 
    private Token current;
    
    public Tokenizer(String buffer) {
        this._buffer = buffer;
        this.next();
    }
    
    /**
     *  Extract the next token from {@code _buffer}
     */
    public void next() {
        _buffer = _buffer.trim();
        if (_buffer.isEmpty()) {
            current = null;
        	return;
        }
        
        if (_buffer.startsWith(Token.Type.LEFT.toString())) 
            current = new Token(Token.Type.LEFT);
        
        else if (_buffer.startsWith(Token.Type.RIGHT.toString()))
            current = new Token(Token.Type.RIGHT);
        
        // TODO: Implement "FORWARD_TO_END" and "BACK_TO_END" tokenization.
        else if (_buffer.startsWith(Token.Type.FORWARD_TO_END.toString())) {
            current = new Token(Token.Type.FORWARD_TO_END);
        }
        else if (_buffer.startsWith(Token.Type.BACK_TO_END.toString())) {
            current = new Token(Token.Type.BACK_TO_END);
        }
        // TODO: Implement "PENUP" and "PENDOWN" tokenization.
        else if (_buffer.startsWith(Token.Type.PENUP.toString())) {
            current = new Token(Token.Type.PENUP);
        }
        else if (_buffer.startsWith(Token.Type.PENDOWN.toString())) {
            current = new Token(Token.Type.PENDOWN);
        }
        else {
            // TODO: Implement "FORWARD" and "BACK" tokenization.
            int index = 0;
            String number = "";
            while (_buffer.charAt(index) != ';') {
                if (Character.isDigit(_buffer.charAt(index))) {
                    number += _buffer.charAt(index);
                }
                index++;
            }
            int n = Integer.parseInt(number);
            if (_buffer.startsWith(Token.Type.FORWARD.toString())) {
                current = new Token(Token.Type.FORWARD, "FORWARD(" + number +")", n);
            }
            if (_buffer.startsWith(Token.Type.BACK.toString())) {
                current = new Token(Token.Type.BACK, "BACK(" + number +")", n);
            }
        }

        _buffer = _buffer.substring(current.originalTokenStr.length()+1);
        // hints:
        // - Do not consider the case where text is syntactically incorrect.        
        // - Careful if you use String.startsWith. FORWARD_TO_END and FORWARD starts with
        //   the same string "FORWARD". Same for the BACK cases.
        // - Character.isDigit() may be useful in extracting the forward or back value from the buffer.
        // - Use new Token(<type>, <original token str>, <value>) to return these tokens
        // - Check the expected outcome in TokenizerTest.java

 
    }
    

    /**
     * Return the token in {@code _current}
     * @return the next token
     */
    public Token current() {
        return current;
    }

    /**
     * @return whether there is another token in {@code _current}
     */
    public boolean hasNext() {
        if(current == null){
            return false;
        }
        return true;
    }

}
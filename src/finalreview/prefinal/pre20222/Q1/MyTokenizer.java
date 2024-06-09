package finalreview.prefinal.pre20222.Q1;

import java.lang.reflect.Type;

public class MyTokenizer implements Tokenizer {

    private String buffer;		//save text
    private Token currentToken;	//save token extracted from next()

    /**
     *  Tokenizer class constructor
     *  The constructor extracts the first token and save it to currentToken
     *  **** please do not modify this part ****
     */
    public MyTokenizer(String text) {
    	buffer = text;		// save input text (string)
        System.out.println(buffer);
    	next();		// extracts the first token.
    }

    /**
     *  This function will find and extract a next token from {@code buffer} and
     *  save the token to {@code currentToken}.
     */
    public void next() {


//        buffer = buffer.trim(); // remove whitespace

         if(buffer.isEmpty()) {
            currentToken = null;	// if there's no string left, set currentToken null and return
            return;
         }

         boolean isSpace = false;
        // ########## YOUR CODE STARTS HERE ##########
        if (!Character.isDigit(buffer.charAt(0)) && !Character.isAlphabetic(buffer.charAt(0))) {
            if (buffer.charAt(0) == ' ') {
                buffer = buffer.substring(1);
                next();
                return;
            }
//            System.out.println("Target: " + buffer.charAt(0));
            currentToken = new Token(Character.toString(buffer.charAt(0)), Token.Type.NON_ALPHANUMERIC);
        }
        else {
            int index = 0;
            String target = "";
            boolean isNumber = false;
            while (index < buffer.length()) {
                if (buffer.charAt(index) == ' ') {
                    isSpace = true;
                    break;
                }
                else if (!Character.isAlphabetic(buffer.charAt(index)) && !Character.isDigit(buffer.charAt(index))) {
                    isSpace = false;
                    break;
                }
                else if (Character.isDigit(buffer.charAt(index))) {
                    isNumber = true;
                    index++;
                }
                else {
                    isNumber = false;
                    index++;
                }
            }
            target = buffer.substring(0, index);
            if (isNumber) {
//                System.out.println("Target number: " + target);
                Integer n = Integer.parseInt(target);
                currentToken = new Token(target, n % 2 == 0 ? Token.Type.EVEN_NUMBER : Token.Type.ODD_NUMBER);
            }
            else {
                boolean hasUpper = false;
                boolean hasLower = false;
//                System.out.println("Target string: " + target);
                for (int i = 0; i < target.length(); ++i) {
                    if (Character.isUpperCase(target.charAt(i))) {
                        hasUpper = true;
                    }
                    else {
                        hasLower = true;
                    }
                }
                if (hasUpper && !hasLower) {
//                    System.out.println("s1");
                    currentToken = new Token(target, Token.Type.UPPER_CASE_WORD);
                }
                else if (hasLower && !hasUpper) {
//                    System.out.println("s2");
                    currentToken = new Token(target, Token.Type.LOWER_CASE_WORD);
                }
                else {
//                    System.out.println("s3");
                    currentToken = new Token(target, Token.Type.CAMEL_CASE_WORD);
                }
            }
        }
        // ########## YOUR CODE ENDS HERE ##########
        
        // Remove the extracted token from buffer
        int tokenLen = currentToken.getValue().length() + (isSpace ? 1 : 0);
        buffer = buffer.substring(tokenLen);
    }

    /**
     *  returned the current token extracted by {@code next()}
     *  **** please do not modify this part ****
     *  
     * @return type: Token
     */
    public Token current() {
    	return currentToken;
    }

    /**
     *  check whether there still exists another tokens in the buffer or not
     *  **** please do not modify this part ****
     *  
     * @return type: boolean
     */
    public boolean hasNext() {
    	return currentToken != null;
    }


}
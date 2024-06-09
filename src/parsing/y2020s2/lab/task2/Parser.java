package parsing.y2020s2.lab.task2;

import parsing.y2020s2.lab.task1.MyTokenizer;
import parsing.y2020s2.lab.task1.Token;

/**
 * Name: Parser.java
 *
 *  The main objective of this class is to implement a simple parser.
 *  It should be able to parser the following grammar rule:
 *  <exp>    ::= <term> | <term> + <exp> | <term> - <exp>
 *  <term>   ::=  <factor> | <factor> * <term> | <factor> / <term>
 *  <factor> ::= <unsigned integer> | ( <exp> )
 *
 */

public class Parser {

    MyTokenizer _tokenizer;

    public Parser(MyTokenizer tokenizer) {
        _tokenizer = tokenizer;
    }

    /*
    <exp>    ::= <term> | <term> + <exp> | <term> - <exp>
     */
    public Exp parseExp() {
        // TODO: Implement parse function for <exp>
        // ########## YOUR CODE STARTS HERE ##########
        Exp term = parseTerm();

        if (!_tokenizer.hasNext()) {

            return term;
        }
        if (_tokenizer.current().token() == "+" ) {
            _tokenizer.next();
            Exp exp = parseExp();
            return new AddExp(term, exp);
        } else if (_tokenizer.current().token() == "-") {
            _tokenizer.next();
            Exp exp = parseExp();
            return new SubExp(term, exp);
        } else {
            return term;
        }
        // ########## YOUR CODE ENDS HERE ##########
    }

    //<term>   ::=  <factor> | <factor> * <term> | <factor> / <term>
    public Exp parseTerm() {
        // TODO: Implement parse function for <term>
        // ########## YOUR CODE STARTS HERE ##########
        Exp factor = parseFactor();

        if (!_tokenizer.hasNext()) {

            return factor;
        }
        if (_tokenizer.current().token() == "*") {
            _tokenizer.next();
            Exp term = parseTerm();
            return new MultExp(factor, term);
        } else if (_tokenizer.current().token() == "/") {
            _tokenizer.next();
            Exp term = parseTerm();
            return new DivExp(factor, term);
        } else {
            return factor;
        }
        // ########## YOUR CODE ENDS HERE ##########
    }
    
    //<factor> ::= <unsigned integer> | ( <exp> )
    public Exp parseFactor() {
        // TODO: Implement parse function for <factor>
        // ########## YOUR CODE STARTS HERE ##########
        if (Character.isDigit(_tokenizer.current().token().charAt(0))) {
            IntExp intExp = new IntExp(Integer.parseInt(_tokenizer.current().token()));
            _tokenizer.next();
            return intExp;
        } else if (_tokenizer.current().token() == "(") {
            _tokenizer.next();
            Exp exp = parseExp();
            _tokenizer.next();
            return exp;
        }
        else {
            return parseExp();
        }
        // ########## YOUR CODE ENDS HERE ##########
    }

    public  static  void ParseSearch(String word) {
        MyTokenizer mathTokenizer = new MyTokenizer("2+1");
        Exp t1 = new Parser(mathTokenizer).parseExp();
    }
}

package finalreview.prefinal.pre20222.Q1;

public class Token {

    public enum Type {
        UPPER_CASE_WORD,
        LOWER_CASE_WORD,
        ODD_NUMBER,
        EVEN_NUMBER,
        CAMEL_CASE_WORD,
        NON_ALPHANUMERIC
    }

	private String value;
    private Type type;


    public Token(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public int getLength() {
        return value.length();
    }
}

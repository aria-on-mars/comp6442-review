package finalreview.prefinal.pre20201.Q4;

public class Token {
    public enum Type {INSERT_INTO, VALUES};
    
    public String originalTokenStr;
    public Type type;
    public String value;

    public Token(Type type, String value, String originalTokenStr) {
        this.type = type;
        this.value = value;
        this.originalTokenStr = originalTokenStr;
    }
}

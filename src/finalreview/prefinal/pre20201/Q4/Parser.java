package finalreview.prefinal.pre20201.Q4;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * Implement a parser to extract the columns and values from tokens and execute
 * the SQL command to insert new customers. Do not insert customers if the
 * following errors are found: 
 * 1 - some brackets are missing 
 * 2 - some columnnames are wrong
 * 
 * Please see the columns names in Customer.java file. Please see test cases in
 * ParserTest.java
 */
public class Parser {

	Tokeniser tokeniser;
	XMLTable table;

	public Parser(Tokeniser tokeniser, XMLTable table) {
		this.tokeniser = tokeniser;
		this.table = table;
	}

	private String cleanText(String text) {
		return text.trim().replaceAll("'", "");
	}

	/**
	 * Extract the columns and values from tokens and execute the SQL command to insert new customers
	 */
	public void parseExp() {

		// TODO: Complete this method
		// START YOUR CODE
		Token insertToken = tokeniser.takeNext();
		int idxLeftBracket = insertToken.value.indexOf('(');
		String tableName = insertToken.value.substring(0, idxLeftBracket - 1);
		String[] columns = insertToken.value.substring(idxLeftBracket + 1, insertToken.value.length() - 1).split(",");

		Token valueToken = tokeniser.takeNext();
		String[] values = valueToken.value.substring(1, valueToken.value.length() - 1).split(",");

		Customer customer = new Customer();
		for (int i = 0; i < columns.length; ++i) {
			String cleanedText = cleanText(values[i]);
			if (columns[i].equals(Customer.KEY_ID)) {
				customer.setId(Integer.parseInt(cleanedText));
			}
			else if (columns[i].equals(Customer.KEY_NAME)) {
				customer.setName(cleanedText);
			}
			else if (columns[i].equals(Customer.KEY_ADDRESS)) {
				customer.setAddress(cleanedText);
			}
			else if (columns[i].equals(Customer.KEY_CITY)) {
				customer.setCity(cleanedText);
			}
			else if (columns[i].equals(Customer.KEY_POSTCODE)) {
				customer.setPostCode(cleanedText);
			}
			else if (columns[i].equals(Customer.KEY_COUNTRY)) {
				customer.setCountry(cleanedText);
			}
			else {
				return;
			}
		}
		table.insert(tableName, customer);
		// END YOUR CODE
	}
}

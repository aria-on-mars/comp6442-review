## Q1 - Tokenization and Tree Build [30 marks]

Part 1 [20 marks]) Implement the 'next()' method of the 'MyTokenizer' class to perform a tokenization process. The 'next()' method should be able to identify the following token types:
upper case words, lower case words, odd integers, even integers, camel case words, and non-alphanumeric characters.

Definitions:
- Digits are single characters from 0 to 9.
- Letters are single characters from 'A' to 'Z' and 'a' to 'z'.
- Words are composed of a series of concatenated letters.
- The word length is the number of characters that the word has.
- Integers are composed a series of concatenated digits of any length.
- Non-alphanumeric characters are single characters other than the digits and letters.

Example:
Consider the text: 'i am the KING of THE castle. The castle is my HOME. I am 10 #@ 1233'.
- "i, am, of" are examples of lower case words.
- "KING, THE, HOME" are examples of upper case words.
- 10 is an example of an even number.
- 1233 is an example of an odd number.
- "., #, @" are examples of non-alphanumeric characters.
- "The" is an example of a camel case word.

Part 2 [10 marks]) Implement the 'build()' method of the 'TreeBuilder' class to create a tree following the specifications below:
- The 'build()' method must create and return a tree containing all lower case words extracted from the input string.
- The key of each node in the tree corresponds to the length of the lower case word.
- If two or more distinct lower case words have the same length, those words must be added to the same node (in a list of strings in that node). For example, if a string contains the words am and of, then am and of should be at the same node of the tree, with key 2.

- The build method receives a string as input and returns a tree containing only the lower case words extracted from the input string.
- You must use the 'MyTokenizer' class to help you extract each lower case word from the input string and insert it in the tree you will return. 

Upload the files: 'MyTokenizer.java' and 'TreeBuilder.java' to Wattle for marking. 

Note that you are expected to give a generic solution that fulfils the question requirements. You are encouraged to create your own test cases locally to check your solutions. We will use different test cases from the given ones to evaluate your solutions.



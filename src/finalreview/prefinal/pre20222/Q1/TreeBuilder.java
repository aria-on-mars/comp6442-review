package finalreview.prefinal.pre20222.Q1;

import java.util.LinkedList;
import java.util.List;

public class TreeBuilder {

    public RBTree<Integer, List<String>> build(String text) {
        // ########## YOUR CODE STARTS HERE ##########
        RBTree<Integer, List<String>> rbTree = new RBTree<>();
        MyTokenizer myTokenizer = new MyTokenizer(text);
        do {
            if (myTokenizer.current().getType() == Token.Type.LOWER_CASE_WORD) {
                List<String> find = rbTree.getData(myTokenizer.current().getValue().length());
                if (find != null) {
                    find.add(myTokenizer.current().getValue());
                }
                else {
                    List<String> data = new LinkedList<>();
                    data.add(myTokenizer.current().getValue());
                    rbTree.insert(data.get(0).length(), data);
                }
            }
            myTokenizer.next();
        } while (myTokenizer.hasNext());
        return rbTree; // change the return
        // ########## YOUR CODE ENDS HERE ##########
    }




}

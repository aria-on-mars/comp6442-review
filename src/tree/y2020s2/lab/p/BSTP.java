package tree.y2020s2.lab.p;

public class BSTP<T extends Comparable<T>> {
    T value;
    BSTP<T> leftNode, rightNode;

    public BSTP (T value) {
        this.value = value;
    }

    // TODO: BST Insertion - Practice
    // you can change the "return null" to return other value
    public BSTP<T> insert(T value) {
        if (this.value.compareTo(value) < 0) {
            if (rightNode == null) {
                rightNode = new BSTP<>(value);
            }
            else {
                rightNode.insert(value);
            }
        }
        else if (this.value.compareTo(value) > 0) {
            if (leftNode == null) {
                leftNode = new BSTP<>(value);
            }
            else {
                leftNode.insert(value);
            }
        }
        return this;
    }

    public T findAndDeleteRightSuccessor() {
        if (rightNode.leftNode == null) {
            T findValue = rightNode.value;
            rightNode = rightNode.rightNode;
            return findValue;
        }
        BSTP<T> pNode = rightNode;
        BSTP<T> toDeleteNode = rightNode.leftNode;
        while (toDeleteNode.leftNode != null) {
            pNode = toDeleteNode;
            toDeleteNode = toDeleteNode.leftNode;
        }
        pNode.leftNode = toDeleteNode.rightNode;
        return toDeleteNode.value;
    }

    // TODO: BST Delete - Practice
    // you can change the "return null" to return other value
    // hint: you need to use helper functions "find and delete successor" to finish this method
    public BSTP<T> delete(T value) {
        if (this.value.compareTo(value) == 0) {
            if (leftNode == null) {
                return rightNode;
            }
            else if (rightNode == null) {
                return leftNode;
            }
            else {
                this.value = findAndDeleteRightSuccessor();
            }
        }
        else if (this.value.compareTo(value) < 0) {
            if (rightNode != null) {
                rightNode = rightNode.delete(value);
            }
        }
        else if (this.value.compareTo(value) > 0) {
            if (leftNode != null) {
                leftNode = leftNode.delete(value);
            }
        }
        return this;
    }

    public String preOrderShow() {
        return value + (leftNode == null ? "" : " " + leftNode.preOrderShow()) + (rightNode == null ? "" : " " + rightNode.preOrderShow());
    }
}

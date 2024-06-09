package finalreview.prefinal.pre20191.Q3;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * @author huy.pham
 */
public class BST {	
	Node root;

	/**
	 * Node class
	 */
	public class Node {
		String value;
		Node parent;
		Node left;
		Node right;

		public Node(String value) {
			this.value = value;
			this.parent = null;
			this.left = null;
			this.right = null;
		}

		private int compareStrings(String a, String b) {
			int commonLength = Math.min(a.length(), b.length());
			for (int i = 0; i < commonLength; ++i) {
				if (a.charAt(i) < b.charAt(i)) {
					return -1;
				}
				else if (a.charAt(i) > b.charAt(i)) {
					return 1;
				}
			}
			if (a.length() == b.length()) {
				return 0;
			}
			else if (a.length() < b.length()) {
				return -1;
			}
			else {
				return 1;
			}
		}

		/**
		 * @param s
		 * @return the node that has the given value.
		 */
	    public Node find(String s) {
			// TODO: Add your implementation here.
			// recursion
//			if (compareStrings(value, s) == 0) {
//				return this;
//			}
//			else if (compareStrings(value, s) == -1 && right != null) {
//				return right.find(s);
//			}
//			else if (compareStrings(value, s) == 1 && left != null) {
//				return left.find(s);
//			}
			// loop
			Node targetNode = this;
			while (targetNode != null) {
				if (targetNode.compareStrings(targetNode.value, s) == 0) {
					return targetNode;
				} else if (targetNode.compareStrings(targetNode.value, s) == 1) {
					targetNode = targetNode.left;
				}
				else {
					targetNode = targetNode.right;
				}
			}
	        return null;
	    }

		/**
		 * Insert a new node into the tree
		 * @param s
		 * @return {@link Node}
		 */
		public Node insert(String s) {
			// TODO: Add your implementation here.
//			// recursion
//			if (compareStrings(value, s) == 0) {
//				return this;
//			}
//			else if (compareStrings(value, s) == -1) {
//				if (right == null) {
//					right = new Node(s);
//					right.parent = this;
//					return right;
//				}
//				else {
//					right.insert(s);
//				}
//			}
//			else {
//				if (left == null) {
//					left = new Node(s);
//					left.parent = this;
//					return left;
//				}
//				else {
//					left.insert(s);
//				}
//			}
//			return this;
			// loop
			Node targetNode = this;
			while (targetNode != null) {
				if (targetNode.compareStrings(targetNode.value, s) == 0) {
					return targetNode;
				} else if (targetNode.compareStrings(targetNode.value, s) == 1) {
					if (targetNode.left == null) {
						targetNode.left = new Node(s);
						targetNode.left.parent = targetNode;
						return targetNode.left;
					}
					targetNode = targetNode.left;
				}
				else {
					if (targetNode.right == null) {
						targetNode.right = new Node(s);
						targetNode.right.parent = targetNode;
						return targetNode.right;
					}
					targetNode = targetNode.right;
				}
			}
			return this;
		}
		
		/**
		 * @return pre-order traversal of the nodes that have odd number of children.
		 */
		public String printOddNodes() {
			// TODO: Add your implementation here.
			String result = "";
			if (isOddNodes()) {
				result += value + " ";
			}
			if (left != null && left.isOddNodes()) {
				result += left.printOddNodes();
			}
			if (right != null && right.isOddNodes()) {
				result += right.printOddNodes();
			}
			return result;
		}

		private boolean isOddNodes() {
			if (left == null && right != null || left != null && right == null) {
				return  true;
			}
			return false;
		}
	}

	public String printOddNodes() {
		return root.printOddNodes();
	}
	
	public BST() {
		root = null;
	}

	public Node insert(String value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}

		return root.insert(value);
	}
	
	public Node find(String s) {
		if (root == null) {
			return null;
		}
		
		return root.find(s);
	}
}
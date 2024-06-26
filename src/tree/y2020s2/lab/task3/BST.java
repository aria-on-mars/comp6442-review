package tree.y2020s2.lab.task3;

/**
Given a binary search tree and two keys of nodes, implement a method to find the key of the lowest common ancestor 
(i.e. the shared ancestor that is located farthest from the root). You can define additional methods of BST and Node 
classes to complete the task. The method signature is:
public Integer lowestCommonAncestor(int x, int y)
Consider that x and y always exist in the tree.
Note that the partial code provided uses slightly different (simplified) implementation of BST, which does not use recursion.
**/
public class BST {

	Node root;

	/**
	 * Please implement this method and feel free to add additional helper methods
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Integer lowestCommonAncestor(int x, int y) {
		// TODO
		// START YOUR CODE
		Node p = root;
		while (p != null) {
			if (x > p.value && y > p.value) {
				p = p.right;
			} else if (x < p.value && y < p.value) {
				p = p.left;
			} else {
				return p.value;
			}
		}

		return null; //you are allowed to change this return statement
		// END YOUR CODE
	}

	public BST() {
		this.root = null;
	}

	/**
	* Find a node given a value
	*
	* @param value of a given node
	* @return the node that contains the value, otherwise null
	*/
	public Node find(Integer value) {
		Node current = root;
		while(current != null) {
			if(current.value.compareTo(value) < 0) {
				current = current.right;
			}else if (current.value.compareTo(value) > 0){
				current = current.left;
			}else if(current.value.compareTo(value) == 0) {
				return current;
			}
		}
		return null;
	}

	/**
	 * This implementation of insert follows the pseudo code in the lecture slide.
	 * Node that we did not use recursion here.
	 *
	 * @param value value of inserted node
	 * @return inserted node (not the entire tree)
	 */
	public Node insert(Integer value) {
		Node parent = null;
		Node current = root;
		while (current != null) {
			if(current.value.compareTo(value) < 0) {
				parent = current;
				current = current.right;
			}else if (current.value.compareTo(value) > 0){
				parent = current;
				current = current.left;
			}
		}

		if (parent == null && current == null) {
			this.root = new Node(value);  // no parent = root is empty
			return this.root;
		}else {
			Node newNode = new Node(value);

			if(parent.value.compareTo(value) < 0) {
				parent.right = newNode;
				newNode.parent = parent;
			}else if(parent.value.compareTo(value) > 0) {
				parent.left = newNode;
				newNode.parent = parent;
			}
			return newNode;
		}
	}

	public class Node {

		Integer value;
		Node parent;
		Node left;
		Node right;

		public Node(Integer value) {
			this.value = value;
			this.parent = null;
			this.left = null;
			this.right = null;
		}
	}
}

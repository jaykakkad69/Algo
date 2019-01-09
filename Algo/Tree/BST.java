class BST{
    Node root;
    public Node getRoot(){
		return this.root;
    }

    // Node class
    class Node{
		int key;
		Node parent,left,right;

		public Node(int key){
			this.key = key;
		}
    }

    // CREATE BST
    public Node create(int[] a){
		for(int i: a)
			add(i);
		return this.root;
    }

    // SEARCH BST
    public Node search(int x){
		Node n = _search(x);
		if(n.key == x)
			System.out.println("Node found in tree");
		else
			System.out.println("Node NOT found in tree");

		return n;
    }
    private Node _search(int x){
		Node node = this.root;
		Node parent = node.parent;
		while(node != null){
			if(node.key == x){
				return node; // current node
			}
			else if(x < node.key){
				parent = node;
				node = node.left;
			}
			else{
				parent = node;
				node = node.right;
			}
		}
		return parent; // parent node
    }

    // ADD BST
    public Node add(int x){
		if(this.root == null){
			root = new Node(x);
			return root;
		}
		Node node = _search(x);
		Node n = new Node(x); //new Node
		if(node.key != x){
			n.parent = node;
			if(x < node.key)
			node.left = n;
			else
			node.right = n;
		}
		return n;
    }

    // Delete BST
    public Node delete(int x){
		Node node = _search(x);
		if(node.key == x)
			return _delete(node);
		return null;
	}
	private Node _delete(Node node){
		// case 0
		if(node.left == null && node.right == null){
			if(node.parent.left == node)
				node.parent.left = null;
			else
				node.parent.right = null;
		}
		// case 1
		else if(node.left == null || node.right == null){
			Node temp;
			if(node.left != null)
				temp = node.left;
			else
				temp = node.right;

			if(node.parent.left == node)
				node.parent.left = temp;
			else
				node.parent.right = temp;
		}
		// case 2
		else{
			Node successor = node.right;
			while(successor.left != null)
				successor = successor.left;

			node.key = successor.key;
			_delete(successor);
		}
		return node;
	}

    // PREORDER
    public void preorder(){
		_preorder(this.root);
		System.out.println("");
    }
    private void _preorder(Node n){
		if(n == null)
			return;

		System.out.print(n.key + " ");
		_preorder(n.left);
		_preorder(n.right);
    } 
}

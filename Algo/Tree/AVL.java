class AVL {
	Node root;

	public Node getRoot() {
		return this.root;
	}

	// Node Class
	class Node {
		int key, h, num, max, min, mingap;
		Node parent, left, right;

		public Node(int key) {
			this.key = key;
		}
	}

	//*************************************
	//CREATE AVL
	public Node create(int[] a) {
		for (int i : a)
			add(i);
		preorder();
		return this.root;
	}

	//******************************************
	// Search AVL
	public void search(int x) {
		Node n = _search(x);
		if (n.key == x)
			System.out.println("Node found in tree");
		else
			System.out.println("Node NOT found in tree");
	}
	private Node _search(int x) {
		Node node = this.root;
		Node parent = node.parent;
		while (node != null) {
			if (node.key == x) {
				return node; // current node
			} else if (x < node.key) {
				parent = node;
				node = node.left;
			} else {
				parent = node;
				node = node.right;
			}
		}
		return parent; // parent node
	}
	private boolean _searchBool(int x){
		Node n = _search(x);
		if (n.key == x)
			return true;
		else
			return false;
	}

	//***************************************
	// ADD BST
	public Node add(int x) {
		if (this.root == null) {
			root = new Node(x);
			root.h = 0;
			return root;
		}
		Node node = _search(x);
		Node n = new Node(x); // new Node
		if (node.key != x) {
			n.parent = node;
			if (x < node.key)
				node.left = n;
			else
				node.right = n;
		}
		balance(n);

		return n;
	}

	//***************************************
	// Delete AVL
    public Node delete(int x){
		Node node = _search(x);
		if(node.key == x){
			Node deleted = _delete(node);
			balance(deleted.parent);
			return deleted;
		}
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
			return _delete(successor);
		}
		return node;
	}

	//**************************************
	//	RANK
	public void rank(int x){
		System.out.println("Rank: " + _rank(x));
	}
	private int _rank(int x){
		countNodes(this.root);
		int rank=0;
		Node temp = this.root;
		while(temp != null){
			if(temp.key < x)
				temp = temp.right;
			else{
				if(temp.right != null)
					rank += 1 + temp.right.num;
				else
					rank += 1;
				temp = temp.left;
			}
		}
		return rank;
	}

	//**************************************
	//  Find Rank
	public void findRank(int k){
		countNodes(this.root);
		int r = 0;
		Node t = this.root;
		while(t != null){
			if(t.right != null)
				r = t.right.num;
			else
				r = 0;

			if(r+1 == k){
				System.out.println("Number at given rank: " + t.key);
				break;
			}
			else if(r+1 < k){
				k = k - (r+1);
				t = t.left;
			}
			else
				t = t.right;
		}
	}
	
	//**************************************
	//	Numbers between X and Y
	public int numbers(int x, int y){
		int extra = 0, numbers = 0;
		if(_searchBool(x))
			extra++;
		if(_searchBool(y))
			extra++;
		if(x<y)
			numbers = (_rank(x) - _rank(y) - 1 + extra);
		else
			numbers = (_rank(y) - _rank(x) - 1 + extra);

		System.out.println("Numbers " + numbers);
		return numbers;
	}
	
	//***************************************
	//	SUM between X and Y
	public int sum(int x, int y){
		int sum = prefixSum(y) - prefixSum(x-1);
		System.out.println("Sum " + sum);
		return sum;
	}
	private int prefixSum(int x){
		int sum = 0;
		Node t = this.root;
		while(t != null){
			if(t.key == x)
				return sum + t.key + subtreeSum(t.left);
			else if(t.key < x){
				sum = sum + t.key + subtreeSum(t.left);
				t = t.right;
			}
			else
				t = t.left;
		}
		return sum;
	}
	private int subtreeSum(Node n){
		if(n == null)
			return 0;
		else
			return subtreeSum(n.left) + subtreeSum(n.right) + n.key;
	}
	
	//***************************************
	// Average Between X and Y
	public void average(int x, int y){
		double s = sum(x,y) / (numbers(x,y) * 1.0);
		System.out.println("Average " + s);
	}
	
	//***************************************
	// MAX & MIN at subtree
	private int max(Node n){
		if(n.left == null && n.right == null)
			n.max = n.key;
		else if(n.left == null)
			n.max = Math.max(n.key, max(n.right));
		else if(n.right == null)
			n.max = Math.max(n.key, max(n.left));
		else
			n.max = Math.max(n.key, Math.max(max(n.left), max(n.right)));

		return n.max;
	}
	private int min(Node n){
		if(n.left == null && n.right == null)
			n.min = n.key;
		else if(n.left == null)
			n.min = Math.min(n.key, min(n.right));
		else if(n.right == null)
			n.min = Math.min(n.key, min(n.left));
		else
			n.min = Math.min(n.key, Math.min(min(n.left), min(n.right)));

		return n.min;
	}

	//***************************************
	// MAXGAP
	public int maxgap(){
		int maxgap = max(this.root) - min(this.root);
		System.out.println("The Max gap in the tree is " + maxgap);
		return maxgap;
	}

	//***************************************
	// MINGAP
	public int mingap(){
		max(this.root);
		min(this.root);
		_mingap(this.root);
		System.out.println("The Min gap in the tree is " + this.root.mingap);
		return this.root.mingap;
	}
	private int _mingap(Node n){
		if(n.left == null && n.right == null)
			n.mingap = Integer.MAX_VALUE;
		else if(n.left == null)
			n.mingap = Math.min(_mingap(n.right), n.right.min - n.key);
		else if(n.right == null)
			n.mingap = Math.min(_mingap(n.left), n.key - n.left.max);
		else
			n.mingap = Math.min(_mingap(n.left),
									Math.min(_mingap(n.right),
										Math.min(n.right.min - n.key, n.key - n.left.max)));
		
		return n.mingap;
	}
	
	//***************************************
	// MAXGAP(X,Y)
	public int maxgap(int x, int y){
		int predecessor_y, successor_x;
		Node s = _search(x);
		Node p = _search(y);

		while(s.parent.right == s)
			s = s.parent;
		s = s.right;
		while(s.left != null)
			s = s.left;
		successor_x = s.key;

		while(p.parent.left == p)
			p = p.parent;
		p = p.left;
		while(p.right != null)
			p = p.right;
		predecessor_y = p.key;

		int maxgap = predecessor_y - successor_x;
		System.out.println("Maxgap between X and Y " + maxgap);
		return maxgap;
	}
	
	//***************************************
	// Calculate Height of all Nodes
	private int height(Node x) {
		if (x == null)
			return 0;
		else {
			x.h = Math.max(height(x.left), height(x.right)) + 1;
			return x.h;
		}
	}
	// Return height of particular Node
	private int _height(Node x) {
		if (x == null)
			return 0;
		else
			return x.h;
	}

	//**************************************
	// Count Nodes in subtree
	private int countNodes(Node x){
		if(x == null)
			return 0;
		else{
			x.num = countNodes(x.left) + countNodes(x.right) + 1;
			return x.num;
		}
	}
	
	//***************************************
	// BALANCE
	private void balance(Node x) {
		height(this.root);
		if (x != null) {
			int diff = _height(x.left) - _height(x.right);
			if (diff == 2) {
				if (_height(x.left.left) > _height(x.left.right)) {
					// ZIG-ZIG LL
					Node a = x, b = x.left, c = x.left.left;
					Node t1 = c.left, t2 = c.right, t3 = b.right, t4 = a.right;

					b.parent = a.parent;
					if (a != this.root) {
						if (a.parent.left == a)
							a.parent.left = b;
						else
							a.parent.right = b;
					} else
						this.root = b;

					b.right = a;
					a.parent = b;
					
					a.left = t3;
					if (t3 != null)
						t3.parent = a;

				} else {
					// ZIG-ZAG LR
					Node a = x, b = x.left, c = x.left.right;
					Node t1 = c.left, t2 = c.right, t3 = b.left, t4 = a.right;

					c.parent = a.parent;
					if (a != this.root) {
						if (a.parent.left == a)
							a.parent.left = c;
						else
							a.parent.right = c;
					} else
						this.root = c;

					c.left = b;
					b.parent = c;

					c.right = a;
					a.parent = c;

					b.right = t1;
					if (t1 != null)
						t1.parent = b;
					
					a.left = t2;
					if (t2 != null)
						t2.parent = a;
				}
			}

			else if (diff == -2) {
				if (_height(x.right.right) > _height(x.right.left)) {
					// ZIG-ZIG RR
					Node a = x, b = x.right, c = x.right.right;
					Node t1 = a.left, t2 = b.left, t3 = c.left, t4 = c.right;

					b.parent = a.parent;
					if (a != this.root) {
						if (a.parent.left == a)
							a.parent.left = b;
						else
							a.parent.right = b;
					} else
						this.root = b;

					b.left = a;
					a.parent = b;

					a.right = t2;
					if (t2 != null)
						t2.parent = a;

				} else {
					// ZIG-ZAG RL
					Node a = x, b = x.right, c = x.right.left;
					Node t1 = a.left, t2 = b.right, t3 = c.left, t4 = c.right;

					c.parent = a.parent;
					if (a != this.root) {
						if (a.parent.left == a)
							a.parent.left = c;
						else
							a.parent.right = c;
					} else
						this.root = c;

					c.left = a;
					a.parent = c;

					c.right = b;
					b.parent = c;
					
					a.right = t3;
					if (t3 != null)
						t3.parent = a;
					
					b.left = t4;
					if (t4 != null)
						t4.parent = b;
				}
			} else {
				balance(x.parent);
			}
		}
	}

	//********************************
	// Preorder
	public void preorder() {
		_preorder(this.root);
		System.out.println("");
	}
	private void _preorder(Node n) {
		if (n != null) {
			System.out.print(n.key + "  ");
			_preorder(n.left);
			_preorder(n.right);
		}
	}
}

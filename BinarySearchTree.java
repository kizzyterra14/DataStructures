public class BinarySearchTree<T extends Comparable<T>>{

	private TNode<T> root;
	public static final int RIGHT = 1;
	public static final int LEFT = 0;
	public static final int NONE = -1;

	public static final int PREORDER = 2;
	public static final int POSTORDER = 3;
	public static final int INORDER = 4;
	public static final int BFS = 5;


	public BinarySearchTree(){
		root = new TNode<T>();
	}

	public BinarySearchTree(T key){
		root = new TNode<T>(key);
	}

	public BinarySearchTree(T[] array, int traversalType){
		
		int n = array.length;

		if(traversalType == PREORDER){
			root = new TNode<T>(array[0]);
			for(int i = 1; i<n; i++){
				insert(array[i], root);
			}
		}
		if(traversalType == POSTORDER){
			
			root = new TNode<T>(array[n-1]);
			for(int i = n-2; i>-0; i--){
				insert(array[i], root);
			}
		}
		if(traversalType == INORDER){
			// iasjaoijsioajsoiajosjaiojs
			
		}
		if(traversalType == BFS){
			root = new TNode<T>(array[0]);
			for(int i = 1; i<n; i++){
				insert(array[i], root);
			}
		}
	}


	public TNode<T> getRoot(){
		return root;
	}

	public void insert(T key, TNode<T> current){
		if(current.getKey() == null){
			current.setKey(key);
		}else{
			if(key.compareTo(current.getKey())>0){
				if(current.right == null){
					current.right = new TNode<T>(key);
				}else{
					insert(key, current.right);
				}
			}else{
				if(current.left == null){
					current.left = new TNode<T>(key);
				}else{
					insert(key, current.left);
				}
			}
		}
	}

	public void remove(T key, TNode<T> current, TNode<T> parent, int side){

		
		if(key.compareTo(current.getKey())==0){

			if(current.left == null && current.right == null ){
				if(parent!= null){
					if(parent.getKey().compareTo(current.getKey())>0) {
						parent.left = null;
					}else{
						parent.right = null;
					}
				}
				current = null;

			}else{
					TNode<T> childLeft = current.left;
					TNode<T> childRight = current.right;
					TNode<T> temp_parent = current;
					TNode<T> temp = null;

					if(current.left != null){
						temp = current.left;

						while(temp.right != null){
							temp_parent = temp;
							temp = temp.right;
						}
						temp_parent.right = null;
						temp.left = childLeft;
						temp.right = childRight;
						}else{
						if(current.right != null){
							temp = current.right;

							while(temp.left != null){
								temp_parent = temp;
								temp = temp.left;
							}
							temp_parent.left = null;
							temp.left = childLeft;
							temp.right = childRight;

						}

					}
					if(parent == null){
						root = temp;
					}else{
						if(side == 0 ) parent.right = temp;
						if(side == 1 ) parent.left = temp;
					}
					
				
			}
		}else{
			if(key.compareTo(current.getKey()) > 0){
				remove(key, current.right, current, RIGHT);
			}else{
				if(key.compareTo(current.getKey()) < 0){
					remove(key, current.left, current, LEFT);
				}
			}

		}

	}

	public boolean search(T key, TNode<T> current){

		if(key.compareTo(current.getKey())==0){
			return true;
		}else{

			if(key.compareTo(current.getKey())>0){
				if(current.right == null){
					return false;
				}else{
					return search(key, current.right);
				}
			}else{
				if(current.left == null){
					return false;
				}else{
					return search(key, current.left);
				}
			}

		}
	}

	public void preOrder(TNode<T> current){

		System.out.println(current.getKey());
		if(current.left != null)
			preOrder(current.left);
		if(current.right != null)
			preOrder(current.right);
	}

	public void inOrder(TNode<T> current){

		
		if(current.left != null)
			inOrder(current.left);
		System.out.println(current.getKey());
		if(current.right != null)
			inOrder(current.right);
	}

	public void postOrder(TNode<T> current){
	
		if(current.left != null)
			postOrder(current.left);
		if(current.right != null)
			postOrder(current.right);
		System.out.println(current.getKey());
	}

	public void BFS(TNode<T> current){

		Queue<TNode<T>> tree = new Queue<TNode<T>>(current);

		while(!(tree.isEmpty() == true)){
			TNode<T> element = tree.pop();
			System.out.println(element.getKey());

			if(element.left != null)
				tree.push(element.left);
			if(element.right != null)
				tree.push(element.right);
		}

	}


	public static void main(String[] args){

		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

		TNode<Integer> root = tree.getRoot();
		
		tree.insert(5, root); /*insertig root*/

		tree.insert(2, root); 
		tree.insert(8, root);

		tree.insert(1, root);
		tree.insert(3, root);

		tree.insert(7, root);
		tree.insert(9, root);

		tree.insert(0, root);
		tree.insert(4, root);
		tree.insert(6, root);

		System.out.println("**BFS**");
		tree.BFS(root);

		System.out.println("\n**Pre Order**");
		tree.preOrder(root);

		System.out.println("\n**In Order**");
		tree.inOrder(root);

		System.out.println("\n**Post Order**");
		tree.postOrder(root);

		System.out.println("\n");
		System.out.println(tree.search(6, root));
		tree.remove(5, root, null, BinarySearchTree.NONE);
		
		System.out.println(tree.search(5, tree.getRoot()));
		System.out.println("\n**In Order**");
		tree.preOrder(tree.getRoot());

	}
	// main
}
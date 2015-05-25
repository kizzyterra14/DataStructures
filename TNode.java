public class TNode <T extends Comparable<T>> implements Comparable<TNode<T>>{

	private T key;
	public TNode<T> right;
	public TNode<T> left;

	public TNode(){
		key = null;
		right = null;
		left = null;
	}

	public TNode(T val){
		key = val;
		right = null;
		left = null;
	}

	public T getKey(){
		return key;
	}

	public void setKey(T val){
		key = val;
	}

	@Override public String toString(){
		return key.toString();
	}

	@Override public int compareTo(TNode<T> node){

		if (this.key.compareTo(node.getKey()) < 0)
			return -1;
		else{
			if (this.key.compareTo(node.getKey())<0){
				return 1;
			}else{
				return 0;
			}
		}
	}
}
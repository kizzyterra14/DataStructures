public class Node<T>{

	private T value;
	public Node<T> next;

	public Node(){

		next = null;
		value = null;
	}

	public Node(T val){

		next = null;
		this.value = val;
	}

	public T getValue(){
		return value;
	}

	public void setValue(T val){
		this.value = val;
	}

	@Override public String toString(){
		return value.toString();
	}

}
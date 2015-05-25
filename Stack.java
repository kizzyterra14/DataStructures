public class Stack<T extends Comparable<T>>{
	private LinkedList<T> stack;

	public Stack(){
		stack =  new LinkedList<T>();
	}

	public Stack(T val){
		stack =  new LinkedList<T>(val);
	}

	public Stack(T[] array){
		stack =  new LinkedList<T>(array);
	}

	public void push(T val){
		stack.insert(val);
	}

	public T pop(){
		stack.remove()
	}

	@Override public String toString(){
		return stack.toString();
	}
}
public class Queue <T extends Comparable<T>>{

	private DoubleLinkedList<T> queue;

	public Queue(){
		queue = new DoubleLinkedList<T>();
	}

	public Queue(T val){
		queue = new DoubleLinkedList<T>(val);
	}
	
	public Queue(T[] array){
		queue = new DoubleLinkedList<T>(array);
	}

	public void push(T val){
		queue.insert(val);
	}

	public T pop(){
		return queue.removeLast();
	}

	public boolean isEmpty(){
		return queue.isEmpty();
	}

	@Override public String toString(){
		return queue.toString();
	}
}
/*Author: Kizzy Terra*/

public class DoubleLinkedList<T extends Comparable<T>>{

	private DNode<T> head;
	private DNode<T> tail;

	public DoubleLinkedList(){

		head = new DNode<T>();
		tail = head;
	}

	public DoubleLinkedList(T val){

		head = new DNode<T>(val);
		tail = head;
	}

	public DoubleLinkedList(T[] array){
		int n = array.length;
		head = new DNode<T>(array[n-1]);
		tail = head;
		for(int i=n-2; i>=0; i--){
			this.insert(array[i]);
		}
	}


	public void insert(T val){ // --> O(1)

		if (head == null){
			head = new DNode<T>(val);
			tail = head;
		}else{

			DNode<T> temp = head;
			head = new DNode<T>(val);
			head.next = temp;
			temp.previous  = head;
			if(tail == head){
				tail = head.next;
			}
		}
	}

	public void insertInTail(T val){ // --> O(1)

		if (tail == null){
			head = new DNode<T>(val);
			tail = head;
		}else{

			DNode<T> temp = tail;
			tail = new DNode<T>(val);
			tail.previous = temp;
			temp.next  = tail;
			
		}
	}

	public void insertAt(int position, T val){ // --> O(n)

		DNode<T> temp = head;
		int counter=0;

		if(position == 0){
			insert(val);
		}else{
			if(position == size()){
				insertInTail(val);
			}else{
				while(temp!= null && counter <(position-1)){
				counter+=1;
				temp=temp.next;
			}

			if (temp != null ){
				DNode<T> node = new DNode<T>(val);
				node.next = temp.next;
				temp.next = node; 
	
				node.previous = temp;
				if(node.next != null)
					node.next.previous = node;
			} else
				System.out.println("Invalid index for insertion");
			}
			
		}
	}

	public DNode<T> head(){
		return head;
	}

	public DNode<T> tail(){
		return tail;
	}
	public DNode<T> get(int position){ // --> O(n)

		DNode<T> temp = head;
		int counter=0;

		if( position == 0){
			return head;
		}else{
			if(position == size()-1){
				return tail;

			}else{
				while(temp!= null && counter < position){
				counter+=1;
				temp=temp.next;
			}

			return temp;
			}
			
		}
	}


	public T removeFirst(){ /* --> O(1) */

		T val = head.getValue();
		if (val != null) {
			head = head.next;
			head.previous = null;
		}
		return val;
	}

	public T removeLast(){ /* --> O(1) */

		T val = tail.getValue();
		if (val != null) {

			if(tail.previous == null){
				head = null;
				tail = null;
			}else{
				tail = tail.previous;
				tail.next = null;
				}
		}
		return val;
	}


	public T removeByValue(T val){ // --> O(n)

		DNode<T> curr = head.next;

		if (curr.previous.getValue() == val){
			head = curr;
			head.previous = null;
			return val;
		}else{

			while(curr!= null && curr.getValue() != val){
				curr = curr.next;	
			}

			if(curr != null){
				curr.next.previous = curr.previous;
				curr.previous.next = curr.next;
				return curr.getValue();
			} else
				return null;
		}
	}

	public void removeAt(int position){ // --> O(n)

		DNode<T> temp = head;
		int counter=0;

		if(position == 0){
			removeFirst();
		}else{
			if(position == size()-1){
				removeLast();
			}else{
				while(temp!= null && counter < (position-1)){
				counter+=1;
				temp=temp.next;
			}

			if (temp != null && temp.next != null){

				temp.next = temp.next.next;
			} else
				System.out.println("Invalid index for removal");
			}
			
		}
	}

	public int size(){ // --> O(n)

		DNode<T> temp = head;
		int counter = 0;

		while(temp != null){
			counter += 1;
			temp = temp.next;
		}

		return counter;
	}

	public void sort(){ //Selection Sort --> O(n^2)

		int index = 0;
		while (index < size()){
			DNode<T> temp = get(index);
			int minIndex = index;
			int position = index;
			T min = temp.getValue();

			while (temp != null){
				T val = temp.getValue();
				if(val.compareTo(min)<0){
					min = val;
					minIndex = position;
				}
				position++;
				temp= temp.next;
			}
			insertAt(index, min);
			if (index<=minIndex)
				minIndex+=1;
			removeAt(minIndex);
			index++;
		}

	}

	@Override public String toString(){ // --> O(n)

		StringBuilder list = new StringBuilder();
		DNode<T> temp = head;

		while(temp!= null){
			list.append(temp.getValue() + " ");
			temp = temp.next;
		}
			return list.toString();
	}

	public boolean isEmpty(){

		if(this.head == null){
			return true;
		}else
			return false;
	}

	public static void main(String [] args){

		System.out.println("** Teste para T = Integer **");
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		System.out.println(list);
		list.insertAt(2,6);
		System.out.println(list);
		
		list.removeByValue(3);
		System.out.println(list);
		
		list.sort();
		System.out.println(list);
		
		list.removeAt(0);
		System.out.println(list);
		
		list.removeAt(1);
		System.out.println(list);
		
		list.insertAt(list.size(), 7);
		System.out.println(list);
		
		list.removeLast();
		System.out.println(list);
		
		list.removeFirst();
		System.out.println(list);
		
		list.insert(5);
		System.out.println(list);
		
		list.insertInTail(9);
		System.out.println(list);

		System.out.println(list.head());
		System.out.println(list.tail());

		

	}
}


class DNode<T> {

	private T value;
	public DNode<T> next;
	public DNode<T> previous;

	public DNode(){

		next = null;
		value = null;
		previous = null;
	
	}

	public DNode(T val){

		next = null;
		value = val;
		previous = null;
	
	}

	public T getValue(){
		return value;
	}

	public void setValue(T val){
		value = val;
	}

	@Override public String toString(){
		return value.toString();
	}


}
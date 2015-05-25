/*Author: Kizzy Terra*/

public class LinkedList<T extends Comparable<T>>{

	private Node<T> head;

	public LinkedList(){

		head = new Node<T>();
	}

	public LinkedList(T val){

		head = new Node<T>(val);
	}

	public LinkedList(T[] array){
		int n = array.length;
		head = new Node<T>(array[n-1]);
		for(int i=n-2; i>=0; i--){
			this.insert(array[i]);
		}
	}


	public void insert(T val){ // --> O(1)

		if (head.getValue() == null)
			head = new Node<T>(val);
		else{
			Node<T> temp = head;
			head = new Node<T>(val);
			head.next = temp;
		}
	}

	public void insertAt(int position, T val){ // --> O(n)

		Node<T> temp = head;
		int counter=0;

		if(position == 0){
			insert(val);
		}else{
			while(temp!= null && counter <(position-1)){
				counter+=1;
				temp=temp.next;
			}

			if (temp != null ){
				Node<T> node = new Node<T>(val);
				node.next = temp.next;
				temp.next = node; 
			} else
				System.out.println("Invalid index for insertion");
		}
	}

	public Node<T> get(int position){ // --> O(n)

		Node<T> temp = head;
		int counter=0;

		if( position == 0){
			return head;
		}else{
			while(temp!= null && counter < position){
				counter+=1;
				temp=temp.next;
			}

			return temp;
		}
	}

	public T remove(){ /* --> O(1) */

		T val = head.getValue();
		if (val != null) {
			head = head.next;
		}
		return val;
	}

	public T removeByValue(T val){ // --> O(n)

		Node<T> previous =  head;
		Node<T> curr = head.next;

		if (previous.getValue() == val){
			head = curr;
			return val;
		}else{

			while(curr!= null && curr.getValue() != val){
				
				previous = previous.next;
				curr = curr.next;	
			}

			if(curr != null){
				previous.next = curr.next;
				return curr.getValue();
			} else
				return null;
		}
	}

	public void removeAt(int position){ // --> O(n)

		Node<T> temp = head;
		int counter=0;

		if(position == 0){
			remove();
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


	public int size(){ // --> O(n)

		Node<T> temp = head;
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
			Node<T> temp = get(index);
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
		Node<T> temp = head;

		while(temp!= null){
			list.append(temp.getValue() + " ");
			temp = temp.next;
		}
			return list.toString();
	}


	public static void main(String[] args){

		System.out.println("** Teste para T = Integer **");
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		System.out.println(list);
		list.sort();
		System.out.println(list);
		list.removeAt(0);
		System.out.println(list);
		list.removeAt(1);
		System.out.println(list);
		list.insertAt(list.size(), 6);
		System.out.println(list);


		System.out.println("\n** Teste para T = String **");
		LinkedList<String> listS = new LinkedList<String>();

		listS.insert("Amo");
		listS.insert("Te");
		listS.insert("Eu");
		listS.insert("Amor,");
		System.out.println(listS);

		listS.insertAt(listS.size(), "!");
		System.out.println(listS);

		listS.sort();
		System.out.println(listS);

		listS.removeAt(0);
		System.out.println(listS);

		listS.removeAt(1);
		System.out.println(listS);

		Integer[] array = {1,2,3,4,5,6,7,8,9};

		LinkedList<Integer> list2 = new LinkedList<Integer>(array);
		System.out.println(list2);
		

	}



}




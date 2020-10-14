public class LinkedList<E>{
	private class Node<E>{
		E data;
		Node<E> next;
		public Node(E data){
			this.data = data;
			next = null; //check//
		}
	}
	int size = 0;
	Node<E> head;

	public LinkedList(){
		head = null;
	}

	public void add(E item){
		if (head == null){
			head = new Node<E>(item);
			++size;
		}
		else {
			Node<E> prev = head;
			while (prev.next != null){
				prev = prev.next;
			}
			prev.next = new Node<E>(item);
			++size;
		}
	}

	public void add(E item, int position){
		if (position == 0){
			Node<E> node = new Node<E>(item);
			node.next = head;
			head = node; //makes 0 position available 
			++size;
		}
		else{
			Node<E> prev = head;
			for (int i = 0; i < position-1; i++){
				prev = prev.next;
			}
			Node<E> node = new Node<E>(item);
			node.next = prev.next;
			prev.next = node;
			++size;
		}
	}

	public E get(int position){
		Node<E> curr = head;
		for (int i = 0; i<position; i++){
			curr = curr.next;
		}
		return curr.data;
	}

	public E remove(int position){
		if (position == 0){
			Node<E> node = head;
			head = head.next;
			--size;
			return node.data;
		}
		else{
			Node<E> prev = head;
			for (int i = 0; i < position-1; i++){
				prev = prev.next;
			}
			Node<E> node = prev.next;
			prev.next = node.next;
			--size;
			return node.data;
		}
	}

	public Node<E> reverse(Node<E> order){
		Node<E> prev = null;
		Node<E> curr = order;
		Node<E> next = null;
		while (curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			System.out.println(prev.data + "prev " + curr.data + "curr " + next.data + " next");
		}
		order = prev;
		return order;
	}
	/*
	

	public void printList(Node node){
		System.out.print("[");
		Node<E> node = head;
		while (node != null){
			System.out.print(node.data, ",");
		}
		System.out.println("]");
	}
	*/

	@Override
	public String toString(){
		String s = "";
		for (Node cur = this.head; cur != null; cur = cur.next){
			s = s +cur.data;
			if (cur.next!=null){
				s=s+"->";
			}
		}
		return s;
	}

	public String toString(Node front){
		String s = "";
		s += front.data;
		if (front.next == null){
			return s;
		}
		else {
			s += "->";
			return s +toString(front.next);
		}
	}

	public Node<E> getHead(){
		return head;
	}

	public static void main(String args[]){
		LinkedList<Integer> numberList = new LinkedList<Integer>();
		numberList.add(1);
		numberList.add(2);
		numberList.add(3);
		numberList.add(4);
		numberList.add(5);
		int findFirstPosition = numberList.get(2);
		System.out.println(numberList);

		numberList.add(6);
		System.out.println(numberList);

		numberList.remove(5);
		numberList.add(6, 0);
		System.out.println(numberList);

		numberList.remove(0);
		numberList.remove(4);
		System.out.println(numberList);

		numberList.add(5);
		System.out.println(numberList);

		System.out.println("The position of 2 in the original linked list is index " + findFirstPosition);

		numberList.reverse(numberList.getHead());
		System.out.println(numberList);
	}
}
public class IntStack {
	// May create private data here.
	private Node top;

	public IntStack() {
		// TODO: Code to initialize your stack.
		this.top = null;
	}

	public void push(int x) {
		// TODO: Code to push an item x onto the stack. The stack wlil never contain more than 100 elements.
		Node node = new Node(x);
		node.setNext(top);
		top = node;
	}

	public int pop() {
		// TODO: Code to pop and retrun an item from the top of the stack. If the stack is empty, return -1.
		int data = top.val;
		top = top.getNext();
		return data;
	}

	public boolean isEmpty(){
		//Checks for null top meaning which is empy (empty = true, not = false)
		return top == null;
	}

	public int peek() {
		return top.val;
	}
}

package arrayImplementationofStacks;

public class DynamicArrayStack {
	private Object[] a;
	private int size;
	
	public DynamicArrayStack(int capacity){
		a=new Object[capacity];
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return (size==0);  // If stack is empty return true otherwise returns false. 
	}
	public void resize() {
		Object temp=a;
		a=new Object[a.length*2];
		System.arraycopy(temp, 0, a, 0, size);
	}
	
	public void push(Object element){
		if(size==a.length) {
			resize();
		}
		a[size++]=element;
	}
	
	public Object pop(){
		if(size==0) {
			throw new IllegalStateException("Stack underflow!");
		}
		Object temp=a[--size];  // Storing the top element of stack in temp variable for returning. 
		a[size]=null;  // Removing the last/top element from the stack making it == null
		
		return temp;  // Returning the removed top element.
	}
	
	public Object peek(){
		if(size==0){
			System.out.print("Sorry, your stack is Empty: ");
			return null;
		}
		return a[size-1];  // we do size-1 because we just have to display the last/top element.
	}
	
	public static void display(DynamicArrayStack s){
		if(s.size()==0) {
			System.out.println("Stack is Empty!");
			return;
		}
		int tempStackSize=s.size();
		DynamicArrayStack tempStack=new DynamicArrayStack(tempStackSize);
		
		// Now for displaying
		System.out.println();
		while(s.size()>0){
			Object element=s.pop();
			System.out.println(" | "+element+" | ");
			tempStack.push(element); // storing elements of original stack into temp stack.
		}
		System.out.println(" --------- ");
		
		// Again re-storing the elements of original stack into original stack from temp stack.
		while(tempStack.size()>0){
			s.push(tempStack.pop());
		}
	}
	
	public static void main(String[] args) {
		DynamicArrayStack bookStack=new DynamicArrayStack(6);
		
		bookStack.push("Book1");
		bookStack.push("Book2");
		bookStack.push("Book3");
		bookStack.push("Book4");
		
		display(bookStack);
		
		Object book4=bookStack.pop();  // Removing the top book from the stack.
		Object book3=bookStack.pop(); // Removing the 2nd-to book from the stack.
		
		display(bookStack);
		
		System.out.println("Top presented Book: "+bookStack.peek());  // peeking the top book i.e Book2
		
		bookStack.push("Book5");  // pushing the another book5 into the stack.
		bookStack.push("Book6");  // pushing the another book6 into the stack.
		
		display(bookStack); // displaying the books after pushing book5 and book6.
		
		bookStack.push("Book7");
		bookStack.push("Book8");  // Capacity is full we stored 6 elements in stack
		bookStack.push("Book9");  // Capacity will be doubled as array is dynamic it resizes capacity=12 now.
		
		display(bookStack);
	}

}

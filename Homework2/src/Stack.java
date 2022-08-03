
public class Stack {
	private Object[] objects;
	private int top;
	
	Stack (int capasity) {
		objects = new Object[capasity];
		top=-1;
	}
	
	public void push(Object data) {
		if(ýsFul()) {
			System.out.println("Your stack is overflow! ");
		}
		else {
			top++;
			objects[top]=data;
		}
	}
	
	public Object pop() {
		if(ýsEmpty()) {
			System.out.println("Your stack is empty!");
			return null;
		}

		else {
			Object redata = objects[top];

			top--;
			return redata;
			
		}

	}
	
	public Object peek() {
		if(ýsEmpty()) {
			System.out.println("Your stack is empty!");
			return null;
		}			
		else {
			return objects[top];
		}
	}
	
	public boolean ýsEmpty() {
		if(top == -1){
            return true;
        }else{
            return false;
        }
	}
	
	public boolean ýsFul() {
		if(top+1==objects.length)
			return true;
		else
			return false;
	}
	
	public int size() {
		return top+1;
	}
}

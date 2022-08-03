
public class Stack {
	private Object[] objects;
	private int top;
	
	Stack (int capasity) {
		objects = new Object[capasity];
		top=-1;
	}
	
	public void push(Object data) {
		if(�sFul()) {
			System.out.println("Your stack is overflow! ");
		}
		else {
			top++;
			objects[top]=data;
		}
	}
	
	public Object pop() {
		if(�sEmpty()) {
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
		if(�sEmpty()) {
			System.out.println("Your stack is empty!");
			return null;
		}			
		else {
			return objects[top];
		}
	}
	
	public boolean �sEmpty() {
		if(top == -1){
            return true;
        }else{
            return false;
        }
	}
	
	public boolean �sFul() {
		if(top+1==objects.length)
			return true;
		else
			return false;
	}
	
	public int size() {
		return top+1;
	}
}

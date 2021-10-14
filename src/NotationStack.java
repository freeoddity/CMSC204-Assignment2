import java.util.ArrayList;
import java.util.List;

public class NotationStack<T> implements StackInterface<T>{
	private final int CAPACITY = 5000;
	private int cap = 0;
	private NotationQueue <T> Stack;	
	
	
	public NotationStack() {
		Stack = new NotationQueue<T>(CAPACITY);
	}
	public NotationStack(int cap) {
		this.cap = cap;
		Stack = new NotationQueue<T>(cap);
	}

	@Override
	public boolean isEmpty() {
		if (Stack.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (Stack.size() == this.cap || Stack.size() == CAPACITY) {
			return true;
		}
		return false;
	}

	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(Stack.isEmpty()) {
			throw new StackUnderflowException();
		}
		T element = null;
		try {
			element = Stack.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if (Stack.isEmpty()) {
			throw new StackUnderflowException();
		}
		T element = Stack.Queue.get(0);
		return element;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Stack.size();
	}

	@Override
	public boolean push(Object e) throws StackOverflowException{
		// TODO Auto-generated method stub
		if(Stack.isFull())
		{
			throw new StackOverflowException();
		}
		try {
			int size = Stack.size();
			if (Stack.enqueue((T)e)) {
				for(int i = 0; i < size; i++) {
					T z = null;
					try {
						z = Stack.dequeue();
					} catch (QueueUnderflowException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Stack.enqueue(z);
				}
				return true;
			}
		} catch (QueueOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		String toReturn ="";
		StringBuilder s = new StringBuilder(Stack.toString(delimiter));
		toReturn = s.reverse().toString();
		return toReturn;
	}
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(Stack.toString());
		String toReturn = s.reverse().toString();
		return toReturn;
	}

	@Override
	public void fill(ArrayList list) {
		// TODO Auto-generated method stub
		ArrayList temp = new ArrayList();
		for (Object e: list) {
			temp.add(e);
		}
		for(Object f:temp) {
			try {
				push(f);
			} catch (StackOverflowException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}

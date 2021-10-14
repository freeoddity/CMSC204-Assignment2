import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface<T>{
	private final int CAPACITY = 5000;
	private int cap = 0;
	private int front,rear;
	ArrayList<T> Queue;
	public NotationQueue() {
		front = rear = 0;
		Queue = new ArrayList<T>(CAPACITY);
	}
	public NotationQueue(int cap) {
		front = rear = 0;
		Queue = new ArrayList<T>(cap);
		this.cap = cap;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (Queue.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if (Queue.size() == cap || Queue.size() == CAPACITY) {
			return true;
		}
		return false;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if (front == rear) {
			throw new QueueUnderflowException();
		}
		T element = Queue.get(front);
		Queue.remove(Queue.indexOf(element));
		rear--;
		return element;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Queue.size();
	}

	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		// TODO Auto-generated method stub
		if (cap == rear || CAPACITY == rear) {
			throw new QueueOverflowException();		
		}
		else {
			rear++;
			return Queue.add((T)e);
		}
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		for (T e: Queue) {
			toReturn += e;
		}
		return toReturn;
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		String toReturn = "";
		for (T e: Queue) {
			if (Queue.indexOf(e) == Queue.size()-1) {
				toReturn += e;
			}
			else {
				toReturn += e;
				toReturn += delimiter;
			}
		}
		return toReturn;
	}

	@Override
	public void fill(ArrayList list) {
		// TODO Auto-generated method stub
		ArrayList<T> temp = new ArrayList<T>();
		for (Object e:list) {
			temp.add((T) e);
		}
		for (T f:temp) {
			Queue.add(f);
			rear++;
		}
		
	}

}

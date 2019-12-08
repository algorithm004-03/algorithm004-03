import java.util.Deque;
import java.util.LinkedList;

public class DequeUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deque<String> deque = new LinkedList<String>();
		deque.addLast("a");
		deque.addLast("b");
		deque.addLast("c");
		System.out.println(deque);
		
		String str = deque.peekFirst();
		System.out.println(str);
		System.out.println(deque);
		
		while (deque.size()>0) {
			System.out.println(deque.removeFirst());
		}
		System.out.println(deque);
	}

}

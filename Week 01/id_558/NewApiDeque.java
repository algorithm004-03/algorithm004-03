import java.util.Deque;
import java.util.LinkedList;

/**
 * 用add first或add last这套新的API改写Deque的代码
 */
public class NewApiDeque {
    public static void testNewApi() {
        Deque<String> deque = new LinkedList<String>();
//        deque.push("a");
//        deque.push("b");
//        deque.push("c");
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
//        String str = deque.peek();
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
//            System.out.println(deque.pop());
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
    }

    public static void main(String[] args) {
        testNewApi();
    }
}

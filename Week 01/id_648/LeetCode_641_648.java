public class LeetCode_641_648 {

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(4);
        System.out.println(myCircularDeque.insertFront(3));
        System.out.println(myCircularDeque.insertFront(8));
        System.out.println(myCircularDeque.insertLast(9));
        System.out.println(myCircularDeque.insertLast(6));
        System.out.println(myCircularDeque.getRear()+" "+myCircularDeque.getFront() );
        System.out.println(myCircularDeque.deleteFront());
        System.out.println(myCircularDeque.deleteFront());
        System.out.println(myCircularDeque.getRear()+" "+myCircularDeque.getFront() );
        System.out.println(myCircularDeque.deleteFront());
        System.out.println(myCircularDeque.getRear()+" "+myCircularDeque.getFront() );
    }


}

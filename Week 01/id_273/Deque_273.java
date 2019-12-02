Deque<String> deque = new LinkedList<>();
deque.addLast("a");
deque.addLast("b");
deque.addLast("c");
System.out.println(deque);

String str = deque.getLast();
System.out.println(str);//c
System.out.println(deque);//a b c

while (deque.size() > 0) {
	System.out.println(deque.removeLast());//c b a
}
System.out.println(deque);//null
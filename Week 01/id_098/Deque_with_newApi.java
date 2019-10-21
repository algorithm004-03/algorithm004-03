    //jdk 1.8

    Deque<String> dequeOld = new LinkedList<String>();
    Deque<String> dequeNew = new LinkedList<String>();

    dequeOld.push("a");
    dequeOld.push("b");
    dequeOld.push("c");

    System.out.println(dequeOld);

    dequeNew.addFirst("a");
    dequeNew.addFirst("b");
    dequeNew.addFirst("c");

    System.out.println(dequeNew);

    String str = dequeOld.peek();
    System.out.println(str);
    System.out.println(dequeOld);

    str = dequeNew.peekFirst();
    System.out.println(str);
    System.out.println(dequeOld);

    while (dequeOld.size()>0){
    System.out.println(dequeOld.pop());
    }
    System.out.println(dequeOld);

    while (dequeNew.size()>0){
    System.out.println(dequeNew.removeFirst());
    }
    System.out.println(dequeNew);

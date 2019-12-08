# NOTE

第一周学习总结:
PartA: 本周学习内容总结
1. 学习数组、链表、队列、栈等数据结构，了解各种数据结构的优缺点。
2. 学习数组的操作方法：例如：循环遍历（多重遍历注意指针下标）、快慢指针、左右指针收敛。
3. 关于链表：快慢指针，递归。对于链表，必须通过理解背诵记忆。
4.队列、栈：主要还是考虑在递归能够解决问题的时候能否通过栈或队列做优化。
5.跳表：优化链表查询的时间，中心思想是通过空间换时间，为每个节点创建索引，缺点是数据发生变化后需要触发索引或者缓存的重建，空间开销大。
6.算法还是很考验记忆力的，但是记忆需要多理解，需要多动手，多思考。


PartB:   PriorityQueue实现
1.PriorityQueue(JDK版本1.8)是一个基于优先级堆的无界优先队列。类图参考:PriorityQueue-uml.png。默认通过自然顺序进行排序，也可以通过构造方法指定排序比较器。
排队和出队方法（offer、poll、remove() 和 add）提供 O(log(n)) 时间；为 remove(Object) 和 contains(Object) 方法提供线性时间；为获取方法（peek、element 和 size）提供固定时间。 
此外该类是非线程安全的，如果是多线程推荐使用PriorityBlockingQueue.
 构造方法： public PriorityQueue() {
              this(DEFAULT_INITIAL_CAPACITY, null);
          }
          public PriorityQueue(Comparator<? super E> comparator) {
              this(DEFAULT_INITIAL_CAPACITY, comparator);
          }
 优先级队列不允许插入null元素，同样不允许插入不可比较的对象。队列的头是按照比较顺序的最小元素。但是允许重复元素。内部使用数组Object[]存放元素。
 示例代码：     PriorityQueue<Integer> queue = new PriorityQueue<>(8);
              queue.add(7);
              queue.add(6);
              queue.add(1);
              queue.add(1);
              //queue.add(null);
              System.out.println(queue);
 输出：        [1, 1, 6, 7]             
2.主要的方法摘要:
    1)boolean add(E e)
        将元素插入到此优先队列,调用的是offer方法,重写父类的add方法,可能会抛出ClassCastException/NullPointerException
    2)boolean offer(E e)
        将元素插入到此优先队列,可能会抛出ClassCastException/NullPointerException
        内部使用变量size存放元素个数，添加元素的时候，如果元素个数超过原数组长度则扩充数组。
        具体调用方法：void grow(int minCapacity)，扩充的策略：原数组长度小于64，则长度加2；否则，长度扩充50%。
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        扩充数组后通过System.arraycopy方法完成数组的拷贝。
        T[] copy = ((Object)newType == (Object)Object[].class)
                    ? (T[]) new Object[newLength]
                    : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        System.arraycopy(original, 0, copy, 0,
                         Math.min(original.length, newLength));
        最后将元素插入到队列里，调用siftUpComparable/siftUpUsingComparator方法，完成比较后插入到对应的队列位置。                                                 
    3)E peek()
        获取但不移除此队列的头,队列为空，则返回null
        由代码分析可知 return (size == 0) ? null : (E) queue[0];其实返回的就是内部数组的首个元素，也就是最小的元素。但是没有附加操作去修改数组长度,因此队列不变。
    4)E poll()
        获取并移除队列的头，队列空则返回null
        该方法首先将内部数组的长度-1，记录数组的首元素。
    5)boolean remove(Object o)
        从此队列中移除指定元素的单个实例（如果此队列包含一个或多个满足 o.equals(e) 的元素 e，则移除一个这样的元素）。
        具体实现方式先通过indexOf(遍历比较是否相等)方法定位下标，然后调用removeAt方法移除指定下标的元素。
    
3.应用场景:
    优先队列以及DelayQueue实现
    /**
     * 从输入的n个数里获取top k
     * @param args
     * @param size
     * @return
     */
    public Object[] testPriorityQueue(int[] args, int size) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(size);
        if (args == null || args.length == 0)
            return null;
        for (int arg : args) {
            if (pq.size() > size) {
                if (pq.peek() < arg) {
                    pq.poll();
                    pq.add(arg);
                }
            }else {
                pq.add(arg);
            }
        }

        return pq.toArray();
    }

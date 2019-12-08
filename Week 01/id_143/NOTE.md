# 学习
# 第一周
## 第三课 数组、链表、跳表
### 数组特性 ---ArrayList代表
1. 每当申请一个数组 实际上是在内存中开辟了一段连续的内存空间
2. 随机访问时间复杂度为O(1)
3. 增、删平均时间复杂度为O(n)
- ArrayList源码学习总结：
    - 特性:
        - 底层于Object数组
        - 非线程安全
        - 实现了RandomAccess接口。
    - 源码分析-主成员
        - 主成员变量
        ```
        /**
             * 默认初始化容量值.
             */
            private static final int DEFAULT_CAPACITY = 10;

            /**
             * 空实例时,这个空对象传给elementData.
             */
            private static final Object[] EMPTY_ELEMENTDATA = {};

            /**
             * 默认构造方法时,传这个空对象给elementData.
             */
            private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

            /**
             * 用于存放实际元素。默认构造方法得到的 ArrayList 在添加第一个元素时 DEFAULTCAPACITY_EMPTY_ELEMENTDATA
             * will be expanded to DEFAULT_CAPACITY .
             */
            transient Object[] elementData; // non-private to simplify nested class access

            /**
             * The size of the ArrayList (the number of elements it contains).
             *
             * @serial
             */
            private int size;
        ```
        - 构造方法
        ```
        /**
             * Constructs an empty list with the specified initial capacity.
             *
             * @param  initialCapacity  the initial capacity of the list
             * @throws IllegalArgumentException if the specified initial capacity
             *         is negative
             */
            public ArrayList(int initialCapacity) {
                if (initialCapacity > 0) {
                    this.elementData = new Object[initialCapacity];
                } else if (initialCapacity == 0) {
                    this.elementData = EMPTY_ELEMENTDATA;
                } else {
                    throw new IllegalArgumentException("Illegal Capacity: "+
                                                       initialCapacity);
                }
            }

            /**
             * Constructs an empty list with an initial capacity of ten.
             */
            public ArrayList() {
                this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
            }

            /**
             * Constructs a list containing the elements of the specified
             * collection, in the order they are returned by the collection's
             * iterator.
             *
             * @param c the collection whose elements are to be placed into this list
             * @throws NullPointerException if the specified collection is null
             */
            public ArrayList(Collection<? extends E> c) {
                elementData = c.toArray();
                if ((size = elementData.length) != 0) {
                    // c.toArray might (incorrectly) not return Object[] (see 6260652)
                    if (elementData.getClass() != Object[].class)
                        elementData = Arrays.copyOf(elementData, size, Object[].class);
                } else {
                    // replace with empty array.
                    this.elementData = EMPTY_ELEMENTDATA;
                }
            }
        ```
        - 添加元素
        ```
        /**
         * Appends the specified element to the end of this list.
         *
         * @param e element to be appended to this list
         * @return <tt>true</tt> (as specified by {@link Collection#add})
         */
        public boolean add(E e) {
            ensureCapacityInternal(size + 1);  // Increments modCount!!
            elementData[size++] = e;
            return true;
        }

        /**
         * Inserts the specified element at the specified position in this
         * list. Shifts the element currently at that position (if any) and
         * any subsequent elements to the right (adds one to their indices).
         *
         * @param index index at which the specified element is to be inserted
         * @param element element to be inserted
         * @throws IndexOutOfBoundsException {@inheritDoc}
         */
        public void add(int index, E element) {
            rangeCheckForAdd(index);

            ensureCapacityInternal(size + 1);  // Increments modCount!!
            System.arraycopy(elementData, index, elementData, index + 1,
                             size - index);
            elementData[index] = element;
            size++;
        }
        /**
         * Increases the capacity of this <tt>ArrayList</tt> instance, if
         * necessary, to ensure that it can hold at least the number of elements
         * specified by the minimum capacity argument.
         *
         * @param   minCapacity   the desired minimum capacity
         */
        public void ensureCapacity(int minCapacity) {
            int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                // any size if not default element table
                ? 0
                // larger than default for default empty table. It's already
                // supposed to be at default size.
                : DEFAULT_CAPACITY;

            if (minCapacity > minExpand) {
                ensureExplicitCapacity(minCapacity);
            }
        }

        private void ensureCapacityInternal(int minCapacity) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
            }

            ensureExplicitCapacity(minCapacity);
        }

        private void ensureExplicitCapacity(int minCapacity) {
            modCount++;

            // overflow-conscious code
            if (minCapacity - elementData.length > 0)
                grow(minCapacity);
        }
         /**
         * Increases the capacity to ensure that it can hold at least the
         * number of elements specified by the minimum capacity argument.
         *
         * @param minCapacity the desired minimum capacity
         */
        private void grow(int minCapacity) {
            // overflow-conscious code
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0)
                newCapacity = hugeCapacity(minCapacity);
            // minCapacity is usually close to size, so this is a win:
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        ```
        - 删除元素
        ```
        /**
         * Removes the element at the specified position in this list.
         * Shifts any subsequent elements to the left (subtracts one from their
         * indices).
         *
         * @param index the index of the element to be removed
         * @return the element that was removed from the list
         * @throws IndexOutOfBoundsException {@inheritDoc}
         */
        public E remove(int index) {
            rangeCheck(index);

            modCount++;
            E oldValue = elementData(index);

            int numMoved = size - index - 1;
            if (numMoved > 0)
                System.arraycopy(elementData, index+1, elementData, index,
                                 numMoved);
            elementData[--size] = null; // clear to let GC do its work

            return oldValue;
        }

        /**
         * Removes the first occurrence of the specified element from this list,
         * if it is present.  If the list does not contain the element, it is
         * unchanged.  More formally, removes the element with the lowest index
         * <tt>i</tt> such that
         * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
         * (if such an element exists).  Returns <tt>true</tt> if this list
         * contained the specified element (or equivalently, if this list
         * changed as a result of the call).
         *
         * @param o element to be removed from this list, if present
         * @return <tt>true</tt> if this list contained the specified element
         */
        public boolean remove(Object o) {
            if (o == null) {
                for (int index = 0; index < size; index++)
                    if (elementData[index] == null) {
                        fastRemove(index);
                        return true;
                    }
            } else {
                for (int index = 0; index < size; index++)
                    if (o.equals(elementData[index])) {
                        fastRemove(index);
                        return true;
                    }
            }
            return false;
        }

        /*
         * Private remove method that skips bounds checking and does not
         * return the value removed.
         */
        private void fastRemove(int index) {
            modCount++;
            int numMoved = size - index - 1;
            if (numMoved > 0)
                System.arraycopy(elementData, index+1, elementData, index,
                                 numMoved);
            elementData[--size] = null; // clear to let GC do its work
        }

        /**
         * Removes all of the elements from this list.  The list will
         * be empty after this call returns.
         */
        public void clear() {
            modCount++;

            // clear to let GC do its work
            for (int i = 0; i < size; i++)
                elementData[i] = null;

            size = 0;
        }
        ```
        - get|set
        ```
        /**
         * Returns the element at the specified position in this list.
         *
         * @param  index index of the element to return
         * @return the element at the specified position in this list
         * @throws IndexOutOfBoundsException {@inheritDoc}
         */
        public E get(int index) {
            rangeCheck(index);
            return elementData(index);
        }

        /**
         * Replaces the element at the specified position in this list with
         * the specified element.
         *
         * @param index index of the element to replace
         * @param element element to be stored at the specified position
         * @return the element previously at the specified position
         * @throws IndexOutOfBoundsException {@inheritDoc}
         */
        public E set(int index, E element) {
            rangeCheck(index);
            E oldValue = elementData(index);
            elementData[index] = element;
            return oldValue;
        }
        ```


### 链表特性 ---LinkedList代表
1. 非连续内存空间,适合内存碎片较多场景。注:jdk1.7采用双向循环链表，jdk1.8采用双向链表
2. 随机访问时间复杂度O(n),增/删时间复杂度为O(1)，但值得一提的是：linkedList仅在增加/删除确定位置下的结点时，时间复杂度为O(1)。因为链表不存在实际下标，若要在指定位置增加或删除某个元素时，必需先通过O(n)的遍历确定node位置再进行操作
3. 优化:链表上面加HashMap。主要思想:空间换时间。升维。如redis为代表的的跳表
- 学习LinkedList源码。LinkedList的工程应用：LRUCache（链表+HashMap，也可以是LinkedHashMap）
- LinkedList的源码学习总结：
    - 特性
        - 底层基于Node对象
        - 双向链表
        - 非线程安全
        - 实现了Deque
    - 主成员变量
    ```
    transient int size = 0;

    /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     *            (first.prev == null && first.item != null)
     */
    transient Node<E> first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     *            (last.next == null && last.item != null)
     */
    transient Node<E> last;
    // 内部类
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    ```
    - 构造函数
    ```
    /**
     * Constructs an empty list.
     */
    public LinkedList() {
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param  c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public LinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }
    ```
   - 添加函数
   ```
   /**
    * Appends the specified element to the end of this list.
    *
    * <p>This method is equivalent to {@link #addLast}.
    *
    * @param e element to be appended to this list
    * @return {@code true} (as specified by {@link Collection#add})
    */
   public boolean add(E e) {
       linkLast(e);
       return true;
   }
   /**
    * Links e as last element.
    */
   void linkLast(E e) {
       final Node<E> l = last;
       final Node<E> newNode = new Node<>(l, e, null);
       last = newNode;
       if (l == null)
           first = newNode;
       else
           l.next = newNode;
       size++;
       modCount++;
   }
  /**
   * Adds the specified element as the tail (last element) of this list.
   *
   * @param e the element to add
   * @return {@code true} (as specified by {@link Queue#offer})
   * @since 1.5
   */
  public boolean offer(E e) {
      return add(e);
  }
  /**
   * Inserts the specified element at the end of this list.
   *
   * @param e the element to insert
   * @return {@code true} (as specified by {@link Deque#offerLast})
   * @since 1.6
   */
  public boolean offerLast(E e) {
      addLast(e);
      return true;
  }
  /**
   * Appends the specified element to the end of this list.
   *
   * <p>This method is equivalent to {@link #add}.
   *
   * @param e the element to add
   */
  public void addLast(E e) {
      linkLast(e);
  }
   /**
    * Inserts the specified element at the specified position in this list.
    * Shifts the element currently at that position (if any) and any
    * subsequent elements to the right (adds one to their indices).
    *
    * @param index index at which the specified element is to be inserted
    * @param element element to be inserted
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public void add(int index, E element) {
       checkPositionIndex(index);

       if (index == size)
           linkLast(element);
       else
           linkBefore(element, node(index));
   }
   /**
    * Inserts element e before non-null Node succ.
    */
   void linkBefore(E e, Node<E> succ) {
       // assert succ != null;
       final Node<E> pred = succ.prev;
       final Node<E> newNode = new Node<>(pred, e, succ);
       succ.prev = newNode;
       if (pred == null)
           first = newNode;
       else
           pred.next = newNode;
       size++;
       modCount++;
   }
   // Deque operations
  /**
   * Inserts the specified element at the front of this list.
   *
   * @param e the element to insert
   * @return {@code true} (as specified by {@link Deque#offerFirst})
   * @since 1.6
   */
  public boolean offerFirst(E e) {
      addFirst(e);
      return true;
  }
   /**
    * Inserts the specified element at the beginning of this list.
    *
    * @param e the element to add
    */
   public void addFirst(E e) {
       linkFirst(e);
   }
   private void linkFirst(E e) {
       final Node<E> f = first;
       final Node<E> newNode = new Node<>(null, e, f);
       first = newNode;
       if (f == null)
           last = newNode;
       else
           f.prev = newNode;
       size++;
       modCount++;
   }
   /**
    * Pushes an element onto the stack represented by this list.  In other
    * words, inserts the element at the front of this list.
    *
    * <p>This method is equivalent to {@link #addFirst}.
    *
    * @param e the element to push
    * @since 1.6
    */
   public void push(E e) {
       addFirst(e);
   }
   ```
   - 删除元素
   ```
    /**
    * Removes the element at the specified position in this list.  Shifts any
    * subsequent elements to the left (subtracts one from their indices).
    * Returns the element that was removed from the list.
    *
    * @param index the index of the element to be removed
    * @return the element previously at the specified position
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public E remove(int index) {
       checkElementIndex(index);
       return unlink(node(index));
   }
   /**
    * Unlinks non-null node x.
    */
    E unlink(Node<E> x) {
       // assert x != null;
       final E element = x.item;
       final Node<E> next = x.next;
       final Node<E> prev = x.prev;

       if (prev == null) {
           first = next;
       } else {
           prev.next = next;
           x.prev = null;
       }

       if (next == null) {
           last = prev;
       } else {
           next.prev = prev;
           x.next = null;
       }

       x.item = null;
       size--;
       modCount++;
       return element;
    }
    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If this list does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * {@code i} such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list
     * changed as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }
    /**
     * Retrieves and removes the first element of this list,
     * or returns {@code null} if this list is empty.
     *
     * @return the first element of this list, or {@code null} if
     *     this list is empty
     * @since 1.6
     */
    public E pollFirst() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }

    /**
     * Retrieves and removes the last element of this list,
     * or returns {@code null} if this list is empty.
     *
     * @return the last element of this list, or {@code null} if
     *     this list is empty
     * @since 1.6
     */
    public E pollLast() {
        final Node<E> l = last;
        return (l == null) ? null : unlinkLast(l);
    }
    /**
     * Unlinks non-null first node f.
     */
    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }

    /**
     * Unlinks non-null last node l.
     */
    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }
    /**
     * Pops an element from the stack represented by this list.  In other
     * words, removes and returns the first element of this list.
     *
     * <p>This method is equivalent to {@link #removeFirst()}.
     *
     * @return the element at the front of this list (which is the top
     *         of the stack represented by this list)
     * @throws NoSuchElementException if this list is empty
     * @since 1.6
     */
    public E pop() {
        return removeFirst();
    }
   ```
   - get|set
   ```
   // Positional Access Operations

   /**
    * Returns the element at the specified position in this list.
    *
    * @param index index of the element to return
    * @return the element at the specified position in this list
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public E get(int index) {
       checkElementIndex(index);
       return node(index).item;
   }

   /**
    * Replaces the element at the specified position in this list with the
    * specified element.
    *
    * @param index index of the element to replace
    * @param element element to be stored at the specified position
    * @return the element previously at the specified position
    * @throws IndexOutOfBoundsException {@inheritDoc}
    */
   public E set(int index, E element) {
       checkElementIndex(index);
       Node<E> x = node(index);
       E oldVal = x.item;
       x.item = element;
       return oldVal;
   }
  /**
   * Returns the first element in this list.
   *
   * @return the first element in this list
   * @throws NoSuchElementException if this list is empty
   */
  public E getFirst() {
      final Node<E> f = first;
      if (f == null)
          throw new NoSuchElementException();
      return f.item;
  }

  /**
   * Returns the last element in this list.
   *
   * @return the last element in this list
   * @throws NoSuchElementException if this list is empty
   */
  public E getLast() {
      final Node<E> l = last;
      if (l == null)
          throw new NoSuchElementException();
      return l.item;
  }
   /**
    * Retrieves, but does not remove, the head (first element) of this list.
    *
    * @return the head of this list, or {@code null} if this list is empty
    * @since 1.5
    */
   public E peek() {
       final Node<E> f = first;
       return (f == null) ? null : f.item;
   }
   /**
    * Retrieves, but does not remove, the first element of this list,
    * or returns {@code null} if this list is empty.
    *
    * @return the first element of this list, or {@code null}
    *         if this list is empty
    * @since 1.6
    */
   public E peekFirst() {
       final Node<E> f = first;
       return (f == null) ? null : f.item;
    }

   /**
    * Retrieves, but does not remove, the last element of this list,
    * or returns {@code null} if this list is empty.
    *
    * @return the last element of this list, or {@code null}
    *         if this list is empty
    * @since 1.6
    */
   public E peekLast() {
       final Node<E> l = last;
       return (l == null) ? null : l.item;
   }
   ```


### 跳表
1. 在linkedList的基础上进行了优化，添加了索引指针层,即升维,空间换时间。
2. 跳表增加的索引级数为logn个
3. 随机访问的时间复杂度O(logn)
4. 实际场景下使用跳表，会因为元素增加/删除导致其索引不工整，造成维护成本较高，每增加/删除一次导致索引都要更新一遍。
- redis跳表的总结资料:极客时间专栏 王争老师的 数据结构与算法之美 第17讲。知乎:https://www.zhihu.com/question/20202931

## 第四课 栈，队列，优先队列，双端队列
### 栈
1. 先进后出。添加，删除时间复杂度为O(1)，查询时间复杂度O(n)
2. api
    1. peek() 查看栈顶元素
    2. pop() 删除并返回栈顶元素
    3. push(E e) 添加至栈顶
3. Stack源码学习总结
    - 特性
        - 继承Vector
        - 线程安全
        - 内部由数组实现
        - search()时间复杂度为O(1)
    - 主成员变量(继承Vector)
    ```
    /**
     * The array buffer into which the components of the vector are
     * stored. The capacity of the vector is the length of this array buffer,
     * and is at least large enough to contain all the vector's elements.
     *
     * <p>Any array elements following the last element in the Vector are null.
     *
     * @serial
     */
    protected Object[] elementData;

    /**
     * The number of valid components in this {@code Vector} object.
     * Components {@code elementData[0]} through
     * {@code elementData[elementCount-1]} are the actual items.
     *
     * @serial
     */
    protected int elementCount;

    /**
     * The amount by which the capacity of the vector is automatically
     * incremented when its size becomes greater than its capacity.  If
     * the capacity increment is less than or equal to zero, the capacity
     * of the vector is doubled each time it needs to grow.
     *
     * @serial
     */
    protected int capacityIncrement;
    ```
    - 构造器
    ```
     /**
     * Creates an empty Stack.
     */
    public Stack() {
    }
    /**
     * Constructs an empty vector with the specified initial capacity and
     * capacity increment.
     *
     * @param   initialCapacity     the initial capacity of the vector
     * @param   capacityIncrement   the amount by which the capacity is
     *                              increased when the vector overflows
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public Vector(int initialCapacity, int capacityIncrement) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        this.elementData = new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement;
    }
    /**
     * Constructs an empty vector with the specified initial capacity and
     * with its capacity increment equal to zero.
     *
     * @param   initialCapacity   the initial capacity of the vector
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public Vector(int initialCapacity) {
        this(initialCapacity, 0);
    }
    ```
    - 添加元素
    ```
    /**
     * Pushes an item onto the top of this stack. This has exactly
     * the same effect as:
     * <blockquote><pre>
     * addElement(item)</pre></blockquote>
     *
     * @param   item   the item to be pushed onto this stack.
     * @return  the <code>item</code> argument.
     * @see     java.util.Vector#addElement
     */
    public E push(E item) {
        addElement(item);

        return item;
    }
    //Vector中的addElement方法
     /**
     * Adds the specified component to the end of this vector,
     * increasing its size by one. The capacity of this vector is
     * increased if its size becomes greater than its capacity.
     *
     * <p>This method is identical in functionality to the
     * {@link #add(Object) add(E)}
     * method (which is part of the {@link List} interface).
     *
     * @param   obj   the component to be added
     */
    public synchronized void addElement(E obj) {
        modCount++;
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = obj;
    }
    ```
    - 删除元素
    ```
     /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return  The object at the top of this stack (the last item
     *          of the <tt>Vector</tt> object).
     * @throws  EmptyStackException  if this stack is empty.
     */
    public synchronized E pop() {
        E       obj;
        int     len = size();

        obj = peek();
        removeElementAt(len - 1);

        return obj;
    }
    //Vector 中的移除元素方法
    /**
     * Deletes the component at the specified index. Each component in
     * this vector with an index greater or equal to the specified
     * {@code index} is shifted downward to have an index one
     * smaller than the value it had previously. The size of this vector
     * is decreased by {@code 1}.
     *
     * <p>The index must be a value greater than or equal to {@code 0}
     * and less than the current size of the vector.
     *
     * <p>This method is identical in functionality to the {@link #remove(int)}
     * method (which is part of the {@link List} interface).  Note that the
     * {@code remove} method returns the old value that was stored at the
     * specified position.
     *
     * @param      index   the index of the object to remove
     * @throws ArrayIndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()})
     */
    public synchronized void removeElementAt(int index) {
        modCount++;
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                                                     elementCount);
        }
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null; /* to let gc do its work */
    }
    ```
    - 查看|查找
    ```
     /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return  the object at the top of this stack (the last item
     *          of the <tt>Vector</tt> object).
     * @throws  EmptyStackException  if this stack is empty.
     */
    public synchronized E peek() {
        int     len = size();

        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }
    //下面两方法为Vector中实现的
    /**
     * Returns the component at the specified index.
     *
     * <p>This method is identical in functionality to the {@link #get(int)}
     * method (which is part of the {@link List} interface).
     *
     * @param      index   an index into this vector
     * @return     the component at the specified index
     * @throws ArrayIndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()})
     */
    public synchronized E elementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }

        return elementData(index);
    }
    /**
     * Returns the 1-based position where an object is on this stack.
     * If the object <tt>o</tt> occurs as an item in this stack, this
     * method returns the distance from the top of the stack of the
     * occurrence nearest the top of the stack; the topmost item on the
     * stack is considered to be at distance <tt>1</tt>. The <tt>equals</tt>
     * method is used to compare <tt>o</tt> to the
     * items in this stack.
     *
     * @param   o   the desired object.
     * @return  the 1-based position from the top of the stack where
     *          the object is located; the return value <code>-1</code>
     *          indicates that the object is not on the stack.
     */
    public synchronized int search(Object o) {
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }
    //下面两方法是Vector中方法
    /**
     * Returns the index of the last occurrence of the specified element
     * in this vector, or -1 if this vector does not contain the element.
     * More formally, returns the highest index {@code i} such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     *         this vector, or -1 if this vector does not contain the element
     */
    public synchronized int lastIndexOf(Object o) {
        return lastIndexOf(o, elementCount-1);
    }

    /**
     * Returns the index of the last occurrence of the specified element in
     * this vector, searching backwards from {@code index}, or returns -1 if
     * the element is not found.
     * More formally, returns the highest index {@code i} such that
     * <tt>(i&nbsp;&lt;=&nbsp;index&nbsp;&amp;&amp;&nbsp;(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i))))</tt>,
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @param index index to start searching backwards from
     * @return the index of the last occurrence of the element at position
     *         less than or equal to {@code index} in this vector;
     *         -1 if the element is not found.
     * @throws IndexOutOfBoundsException if the specified index is greater
     *         than or equal to the current size of this vector
     */
    public synchronized int lastIndexOf(Object o, int index) {
        if (index >= elementCount)
            throw new IndexOutOfBoundsException(index + " >= "+ elementCount);

        if (o == null) {
            for (int i = index; i >= 0; i--)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = index; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
    ```
### 队列
1. 先进先出。添加、删除时间复杂度O(1),查找时间复杂度为O(n)
2. api
    1. 添加        add()      --遇错抛出 offer    --遇错返回特殊值
    2. 删除并返回    remove    --遇错抛出 poll     --遇错返回特殊值
    3. 查看       element     --遇错抛出 peek     --遇错返回特殊值
3.Queue 源码分析
    - Queue接口
    ```
     /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and throwing an {@code IllegalStateException}
     * if no space is currently available.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    boolean add(E e);

    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue, else
     *         {@code false}
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    boolean offer(E e);

    /**
     * Retrieves and removes the head of this queue.  This method differs
     * from {@link #poll poll} only in that it throws an exception if this
     * queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E remove();

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E poll();

    /**
     * Retrieves, but does not remove, the head of this queue.  This method
     * differs from {@link #peek peek} only in that it throws an exception
     * if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E element();

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E peek();
    ```
### 优先队列
1. 特性
    1. 插入操作O(1)
    2. 增加删除操作：O(logN),因为需要按照元素的优先级取出
    3. 底层具体实现的数据结构较为多样和复杂，可以用heap/bst/avl/treap
    4. Java中对队列数据结构的工程实现采用了PriorityQueue
2. PriorityQueue 源码分析
    - PriorityQueue主成员变量
    ```
    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    /**
     * Priority queue represented as a balanced binary heap: the two
     * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
     * priority queue is ordered by comparator, or by the elements'
     * natural ordering, if comparator is null: For each node n in the
     * heap and each descendant d of n, n <= d.  The element with the
     * lowest value is in queue[0], assuming the queue is nonempty.
     */
    transient Object[] queue; // non-private to simplify nested class access

    /**
     * The number of elements in the priority queue.
     */
    private int size = 0;

    /**
     * The comparator, or null if priority queue uses elements'
     * natural ordering.
     */
    private final Comparator<? super E> comparator;

    /**
     * The number of times this priority queue has been
     * <i>structurally modified</i>.  See AbstractList for gory details.
     */
    transient int modCount = 0; // non-private to simplify nested class access
    ```
    - PriorityQueue 构造函数
    ```
    /**
     * Creates a {@code PriorityQueue} with the default initial
     * capacity (11) that orders its elements according to their
     * {@linkplain Comparable natural ordering}.
     */
    public PriorityQueue() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }

    /**
     * Creates a {@code PriorityQueue} with the specified initial
     * capacity that orders its elements according to their
     * {@linkplain Comparable natural ordering}.
     *
     * @param initialCapacity the initial capacity for this priority queue
     * @throws IllegalArgumentException if {@code initialCapacity} is less
     *         than 1
     */
    public PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

    /**
     * Creates a {@code PriorityQueue} with the default initial capacity and
     * whose elements are ordered according to the specified comparator.
     *
     * @param  comparator the comparator that will be used to order this
     *         priority queue.  If {@code null}, the {@linkplain Comparable
     *         natural ordering} of the elements will be used.
     * @since 1.8
     */
    public PriorityQueue(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    /**
     * Creates a {@code PriorityQueue} with the specified initial capacity
     * that orders its elements according to the specified comparator.
     *
     * @param  initialCapacity the initial capacity for this priority queue
     * @param  comparator the comparator that will be used to order this
     *         priority queue.  If {@code null}, the {@linkplain Comparable
     *         natural ordering} of the elements will be used.
     * @throws IllegalArgumentException if {@code initialCapacity} is
     *         less than 1
     */
    public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        // Note: This restriction of at least one is not actually needed,
        // but continues for 1.5 compatibility
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

    /**
     * Creates a {@code PriorityQueue} containing the elements in the
     * specified collection.  If the specified collection is an instance of
     * a {@link SortedSet} or is another {@code PriorityQueue}, this
     * priority queue will be ordered according to the same ordering.
     * Otherwise, this priority queue will be ordered according to the
     * {@linkplain Comparable natural ordering} of its elements.
     *
     * @param  c the collection whose elements are to be placed
     *         into this priority queue
     * @throws ClassCastException if elements of the specified collection
     *         cannot be compared to one another according to the priority
     *         queue's ordering
     * @throws NullPointerException if the specified collection or any
     *         of its elements are null
     */
    @SuppressWarnings("unchecked")
    public PriorityQueue(Collection<? extends E> c) {
        if (c instanceof SortedSet<?>) {
            SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
            this.comparator = (Comparator<? super E>) ss.comparator();
            initElementsFromCollection(ss);
        }
        else if (c instanceof PriorityQueue<?>) {
            PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;
            this.comparator = (Comparator<? super E>) pq.comparator();
            initFromPriorityQueue(pq);
        }
        else {
            this.comparator = null;
            initFromCollection(c);
        }
    }

    /**
     * Creates a {@code PriorityQueue} containing the elements in the
     * specified priority queue.  This priority queue will be
     * ordered according to the same ordering as the given priority
     * queue.
     *
     * @param  c the priority queue whose elements are to be placed
     *         into this priority queue
     * @throws ClassCastException if elements of {@code c} cannot be
     *         compared to one another according to {@code c}'s
     *         ordering
     * @throws NullPointerException if the specified priority queue or any
     *         of its elements are null
     */
    @SuppressWarnings("unchecked")
    public PriorityQueue(PriorityQueue<? extends E> c) {
        this.comparator = (Comparator<? super E>) c.comparator();
        initFromPriorityQueue(c);
    }

    /**
     * Creates a {@code PriorityQueue} containing the elements in the
     * specified sorted set.   This priority queue will be ordered
     * according to the same ordering as the given sorted set.
     *
     * @param  c the sorted set whose elements are to be placed
     *         into this priority queue
     * @throws ClassCastException if elements of the specified sorted
     *         set cannot be compared to one another according to the
     *         sorted set's ordering
     * @throws NullPointerException if the specified sorted set or any
     *         of its elements are null
     */
    @SuppressWarnings("unchecked")
    public PriorityQueue(SortedSet<? extends E> c) {
        this.comparator = (Comparator<? super E>) c.comparator();
        initElementsFromCollection(c);
    }
    ```
    - 添加
    ```
    /**
     * Inserts the specified element into this priority queue.
     *
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws ClassCastException if the specified element cannot be
     *         compared with elements currently in this priority queue
     *         according to the priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    public boolean add(E e) {
        return offer(e);
    }

    /**
     * Inserts the specified element into this priority queue.
     *
     * @return {@code true} (as specified by {@link Queue#offer})
     * @throws ClassCastException if the specified element cannot be
     *         compared with elements currently in this priority queue
     *         according to the priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }
    /**
     * Inserts item x at position k, maintaining heap invariant by
     * promoting x up the tree until it is greater than or equal to
     * its parent, or is the root.
     *
     * To simplify and speed up coercions and comparisons. the
     * Comparable and Comparator versions are separated into different
     * methods that are otherwise identical. (Similarly for siftDown.)
     *
     * @param k the position to fill
     * @param x the item to insert
     */
    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (key.compareTo((E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
    }

    @SuppressWarnings("unchecked")
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }
    ```
    - 删除
    ```
    /**
     * Removes a single instance of the specified element from this queue,
     * if it is present.  More formally, removes an element {@code e} such
     * that {@code o.equals(e)}, if this queue contains one or more such
     * elements.  Returns {@code true} if and only if this queue contained
     * the specified element (or equivalently, if this queue changed as a
     * result of the call).
     *
     * @param o element to be removed from this queue, if present
     * @return {@code true} if this queue changed as a result of the call
     */
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i == -1)
            return false;
        else {
            removeAt(i);
            return true;
        }
    }
    private int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++)
                if (o.equals(queue[i]))
                    return i;
        }
        return -1;
    }

    /**
     * Version of remove using reference equality, not equals.
     * Needed by iterator.remove.
     *
     * @param o element to be removed from this queue, if present
     * @return {@code true} if removed
     */
    boolean removeEq(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == queue[i]) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }
    /**
     * Removes the ith element from queue.
     *
     * Normally this method leaves the elements at up to i-1,
     * inclusive, untouched.  Under these circumstances, it returns
     * null.  Occasionally, in order to maintain the heap invariant,
     * it must swap a later element of the list with one earlier than
     * i.  Under these circumstances, this method returns the element
     * that was previously at the end of the list and is now at some
     * position before i. This fact is used by iterator.remove so as to
     * avoid missing traversing elements.
     */
    @SuppressWarnings("unchecked")
    private E removeAt(int i) {
        // assert i >= 0 && i < size;
        modCount++;
        int s = --size;
        if (s == i) // removed last element
            queue[i] = null;
        else {
            E moved = (E) queue[s];
            queue[s] = null;
            siftDown(i, moved);
            if (queue[i] == moved) {
                siftUp(i, moved);
                if (queue[i] != moved)
                    return moved;
            }
        }
        return null;
    }
    public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        modCount++;
        E result = (E) queue[0];
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }
    /**
     * Inserts item x at position k, maintaining heap invariant by
     * demoting x down the tree repeatedly until it is less than or
     * equal to its children or is a leaf.
     *
     * @param k the position to fill
     * @param x the item to insert
     */
    private void siftDown(int k, E x) {
        if (comparator != null)
            siftDownUsingComparator(k, x);
        else
            siftDownComparable(k, x);
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1;        // loop while a non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // assume left child is least
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                c = queue[child = right];
            if (key.compareTo((E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = key;
    }

    @SuppressWarnings("unchecked")
    private void siftDownUsingComparator(int k, E x) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                comparator.compare((E) c, (E) queue[right]) > 0)
                c = queue[child = right];
            if (comparator.compare(x, (E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }
    ```
    - 获取
    ```
     public E peek() {
        return (size == 0) ? null : (E) queue[0];
    }
    ```
### 双端队列
1. 特性
    1. 在工程应用中一般不直接使用queue或stack，而是采用deque双端队列
    2. 插入删除时间复杂度O(1)，查询时间复杂度O(n)
    3. 可以在首部push/pop，也可以在尾部push/pop，LinkedList就实现了Deque的接口
2. Deque 源码总结
    - Deque接口(注意 throws)
    ```
    /**
     * 头部插入.
     *
     * @param e the element to add
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this deque
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this deque
     */
    void addFirst(E e);

    /**
     * 尾部插入.
     *
     * <p>This method is equivalent to {@link #add}.
     *
     * @param e the element to add
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this deque
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this deque
     */
    void addLast(E e);

    /**
     * 头部插入.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     *         {@code false}
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this deque
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this deque
     */
    boolean offerFirst(E e);

    /**
     * 尾部插入.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     *         {@code false}
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this deque
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this deque
     */
    boolean offerLast(E e);

    /**
     * 移除第一个元素.
     *
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E removeFirst();

    /**
     * 移除最后一个元素.
     *
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E removeLast();

    /**
     * 移除第一个元素.
     *
     * @return the head of this deque, or {@code null} if this deque is empty
     */
    E pollFirst();

    /**
     * 移除最后一个元素.
     *
     * @return the tail of this deque, or {@code null} if this deque is empty
     */
    E pollLast();

    /**
     * 获取第一个元素.
     *
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E getFirst();

    /**
     * 获取最后一个元素.
     *
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E getLast();

    /**
     * 获取第一个元素.
     *
     * @return the head of this deque, or {@code null} if this deque is empty
     */
    E peekFirst();

    /**
     * 获取最后一个元素.
     *
     * @return the tail of this deque, or {@code null} if this deque is empty
     */
    E peekLast();

    /**
     * Removes the first occurrence of the specified element from this deque.
     * If the deque does not contain the element, it is unchanged.
     * More formally, removes the first element {@code e} such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>
     * (if such an element exists).
     * Returns {@code true} if this deque contained the specified element
     * (or equivalently, if this deque changed as a result of the call).
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if an element was removed as a result of this call
     * @throws ClassCastException if the class of the specified element
     *         is incompatible with this deque
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    boolean removeFirstOccurrence(Object o);

    /**
     * Removes the last occurrence of the specified element from this deque.
     * If the deque does not contain the element, it is unchanged.
     * More formally, removes the last element {@code e} such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>
     * (if such an element exists).
     * Returns {@code true} if this deque contained the specified element
     * (or equivalently, if this deque changed as a result of the call).
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if an element was removed as a result of this call
     * @throws ClassCastException if the class of the specified element
     *         is incompatible with this deque
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    boolean removeLastOccurrence(Object o);

    // *** Queue methods ***

    /**
     * Inserts the specified element into the queue represented by this deque
     * (in other words, at the tail of this deque) if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and throwing an
     * {@code IllegalStateException} if no space is currently available.
     * When using a capacity-restricted deque, it is generally preferable to
     * use {@link #offer(Object) offer}.
     *
     * <p>This method is equivalent to {@link #addLast}.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this deque
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this deque
     */
    boolean add(E e);

    /**
     * Inserts the specified element into the queue represented by this deque
     * (in other words, at the tail of this deque) if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and {@code false} if no space is currently
     * available.  When using a capacity-restricted deque, this method is
     * generally preferable to the {@link #add} method, which can fail to
     * insert an element only by throwing an exception.
     *
     * <p>This method is equivalent to {@link #offerLast}.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     *         {@code false}
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this deque
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this deque
     */
    boolean offer(E e);

    /**
     * Retrieves and removes the head of the queue represented by this deque
     * (in other words, the first element of this deque).
     * This method differs from {@link #poll poll} only in that it throws an
     * exception if this deque is empty.
     *
     * <p>This method is equivalent to {@link #removeFirst()}.
     *
     * @return the head of the queue represented by this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E remove();

    /**
     * Retrieves and removes the head of the queue represented by this deque
     * (in other words, the first element of this deque), or returns
     * {@code null} if this deque is empty.
     *
     * <p>This method is equivalent to {@link #pollFirst()}.
     *
     * @return the first element of this deque, or {@code null} if
     *         this deque is empty
     */
    E poll();

    /**
     * Retrieves, but does not remove, the head of the queue represented by
     * this deque (in other words, the first element of this deque).
     * This method differs from {@link #peek peek} only in that it throws an
     * exception if this deque is empty.
     *
     * <p>This method is equivalent to {@link #getFirst()}.
     *
     * @return the head of the queue represented by this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E element();

    /**
     * Retrieves, but does not remove, the head of the queue represented by
     * this deque (in other words, the first element of this deque), or
     * returns {@code null} if this deque is empty.
     *
     * <p>This method is equivalent to {@link #peekFirst()}.
     *
     * @return the head of the queue represented by this deque, or
     *         {@code null} if this deque is empty
     */
    E peek();


    // *** Stack methods ***

    /**
     * Pushes an element onto the stack represented by this deque (in other
     * words, at the head of this deque) if it is possible to do so
     * immediately without violating capacity restrictions, throwing an
     * {@code IllegalStateException} if no space is currently available.
     *
     * <p>This method is equivalent to {@link #addFirst}.
     *
     * @param e the element to push
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this deque
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this deque
     */
    void push(E e);

    /**
     * Pops an element from the stack represented by this deque.  In other
     * words, removes and returns the first element of this deque.
     *
     * <p>This method is equivalent to {@link #removeFirst()}.
     *
     * @return the element at the front of this deque (which is the top
     *         of the stack represented by this deque)
     * @throws NoSuchElementException if this deque is empty
     */
    E pop();


    // *** Collection methods ***

    /**
     * Removes the first occurrence of the specified element from this deque.
     * If the deque does not contain the element, it is unchanged.
     * More formally, removes the first element {@code e} such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>
     * (if such an element exists).
     * Returns {@code true} if this deque contained the specified element
     * (or equivalently, if this deque changed as a result of the call).
     *
     * <p>This method is equivalent to {@link #removeFirstOccurrence(Object)}.
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if an element was removed as a result of this call
     * @throws ClassCastException if the class of the specified element
     *         is incompatible with this deque
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    boolean remove(Object o);

    /**
     * Returns {@code true} if this deque contains the specified element.
     * More formally, returns {@code true} if and only if this deque contains
     * at least one element {@code e} such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this deque is to be tested
     * @return {@code true} if this deque contains the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this deque
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    boolean contains(Object o);

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
    public int size();

    /**
     * Returns an iterator over the elements in this deque in proper sequence.
     * The elements will be returned in order from first (head) to last (tail).
     *
     * @return an iterator over the elements in this deque in proper sequence
     */
    Iterator<E> iterator();

    /**
     * Returns an iterator over the elements in this deque in reverse
     * sequential order.  The elements will be returned in order from
     * last (tail) to first (head).
     *
     * @return an iterator over the elements in this deque in reverse
     * sequence
     */
    Iterator<E> descendingIterator();
    ```
    - Deque实现类 LinkedList 详见 第3课 第二节 链表 章节

    - 课后作业改写
    ```
    Deque<String> deque = new LinkedList<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);
        String last = deque.getLast();
        System.out.println(last);//c
        System.out.println(deque);//a b c
        String first = deque.getFirst();
        System.out.println(first);//a
        while (deque.size() > 0) {
            System.out.println(deque.removeLast());
            //c
            //b
            // a
        }
        System.out.println(deque);//[]
    ```
## 个人感悟
- **时间问题**: 无论如何都要抽出时间,平均保证每天保证有1个小时。
- **练习问题**: 结合自己情况,当天练的题、隔天练、隔四再练。
- 团队问题: 团队的讨论的风气还未形成,一步一步来,咱们先形成相互提醒学习的"**叫醒**"服务。另居然还有组员还没报github帐号,我只能天天催一催。

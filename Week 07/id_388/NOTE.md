# NOTE

#### 1、位操作
    - 将x最右边的n位清零： x&(~0<<n)
    - 获取x的第n位值（0或者1）：(x>>n)&1
    - 获取x的第n位幂值：x&(1<<(n - 1)
    - 仅将第n位置为1：x|(1<<n)
    - 仅将第n位置为0：x&（~(1<<n)）
    - 将x最高位至第n位（含）清零：x&((1<<n)-1)
    - 将第n位至第0位（含）清零：x&(~((1<<(n+1)-1))
    
#### 2、布隆过滤器
   - 布隆过滤器添加元素
        将要添加的元素给k个哈希函数
        得到对应于位数组上的k个位置
        将这k个位置设为1
    - 布隆过滤器查询元素
        将要查询的元素给k个哈希函数
        得到对应于位数组上的k个位置  
        如果k个位置有一个为0，则肯定不在集合中    
        如果k个位置全部为1，则可能在集合中

#### 3、LRU cache
    可以复用java自带的
    ```
        class LRUCache extends LinkedHashMap<Integer, Integer>{
            private int capacity;
            
            public LRUCache(int capacity) {
                super(capacity, 0.75F, true);
                this.capacity = capacity;
            }
        
            public int get(int key) {
                return super.getOrDefault(key, -1);
            }
        
            public void put(int key, int value) {
                super.put(key, value);
            }
        
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity; 
            }
        }
        
    ```    

  
#### 4、
    归并排序
    ```
        public static void mergeSort(int[] array, int left, int right) {
        
            if (right <= left) return;
            int mid = (left + right) >> 1; // (left + right) / 2
        
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        
        }
        
        public static void merge(int[] arr, int left, int mid, int right) {
        
                int[] temp = new int[right - left + 1]; // 中间数组
                int i = left, j = mid + 1, k = 0;
        
                while (i <= mid && j <= right) {
                    temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
                }
        
                while (i <= mid)   temp[k++] = arr[i++];
                while (j <= right) temp[k++] = arr[j++];
        
                for (int p = 0; p < temp.length; p++) {
                    arr[left + p] = temp[p];
                }
                // 也可以用 System.arraycopy(a, start1, b, start2, length)
            }
    ```
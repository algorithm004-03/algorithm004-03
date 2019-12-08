 class MyCircularDeque {

		private int[] data;

		private int capacity;
		private int size = 0;
		private int head = -1;
		private int tail = -1;

		public MyCircularDeque(int capacity) {
			this.capacity = capacity;
			this.data = new int[capacity];
		}

		public boolean deleteFront() {
			if (this.isEmpty()) {
				return false;
			}

			this.data[head] = 0;
			size--;
			head++;

			if (head == capacity) {
				head = 0;
			}

			if (this.isEmpty()) {
				head = -1;
				tail = -1;
			}

			return true;
		}

		public boolean deleteLast() {
			if (this.isEmpty()) {
				return false;
			}

			this.data[tail] = 0;
			size--;
			tail--;

			if (tail < 0) {
				tail = capacity - 1;
			}

			if (this.isEmpty()) {
				head = -1;
				tail = -1;
			}

			return true;
		}

		public int getFront() {
			if (head != -1) {
				return this.data[head];
			}

			return -1;
		}

		public int getRear() {
			if (tail != -1) {
				return this.data[tail];
			}

			return -1;
		}

		public boolean insertFront(int value) {
			if (this.isFull()) {
				return false;
			}

			if (head == -1) {
				head = 0;
				tail = head;
			} else {
				head--;

				if (head < 0) {
					head = capacity - 1;
				}
			}

			this.data[head] = value;
			size++;

			return true;
		}

		public boolean insertLast(int value) {
			if (this.isFull()) {
				return false;
			}

			if (tail == -1) {
				tail = 0;
				head = tail;
			} else {
				tail++;

				if (tail == capacity) {
					tail = 0;
				}
			}

			this.data[tail] = value;
			size++;

			return true;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public boolean isFull() {
			return size == this.capacity;
		}
	}

class LRUCache1 extends LinkedHashMap<Integer, Integer> {

	private static final long serialVersionUID = -8670003437340362842L;
	private int capacity;

	public LRUCache1(int capacity) {
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

class LRUCache2 {

	class Node {
		int key;
		int value;
		Node prev;
		Node next;
	}

	private void addNode(Node node) {
		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	private void removeNode(Node node) {
		Node prev = node.prev;
		Node next = node.next;

		prev.next = next;
		next.prev = prev;
	}

	private void moveToHead(Node node) {
		removeNode(node);
		addNode(node);
	}

	private Node popTail() {
		Node res = tail.prev;
		removeNode(res);
		return res;
	}

	private HashMap<Integer, Node> cache = new HashMap<>();
	private int size;
	private int capacity;
	private Node head;
	private Node tail;

	public LRUCache2(int capacity) {
		this.size = 0;
		this.capacity = capacity;

		head = new Node();

		tail = new Node();

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		Node node = cache.get(key);
		if (node == null) {
			return -1;
		}

		moveToHead(node);

		return node.value;
	}

	public void put(int key, int value) {
		Node node = cache.get(key);

		if (node == null) {
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = value;

			cache.put(key, newNode);
			addNode(newNode);

			if (size + 1 > capacity) {
				Node tail = popTail();
				cache.remove(tail.key);
			} else {
				size++;
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
	}
}
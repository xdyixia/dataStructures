package dataStructures;

public class QueueArray<E> {
	private Object[] data = null;
	private int maxSize; // 队列容量
	private int head; // 队列头，允许删除
	private int tail; // 队列尾，允许插入

	// 构造函数
	public QueueArray() {
		this(10);
	}

	public QueueArray(int initialSize) {
		if (initialSize >= 0) {
			this.maxSize = initialSize;
			data = new Object[initialSize];
			head = tail = 0;
		} else {
			throw new RuntimeException("初始化大小不能小于0：" + initialSize);
		}
	}

	// 判空
	public boolean empty() {
		return tail == head ? true : false;
	}

	// 插入
	public boolean add(E e) {
		if (tail == maxSize) {
			throw new RuntimeException("队列已满，无法插入新的元素！");
		} else {
			data[tail++] = e;
			return true;
		}
	}

	// 返回队首元素，但不删除
	public E peek() {
		if (empty()) {
			throw new RuntimeException("空队列异常！");
		} else {
			return (E) data[head];
		}
	}

	// 出队
	public E poll() {
		if (empty()) {
			throw new RuntimeException("空队列异常！");
		} else {
			E value = (E) data[head]; // 保留队列的head端的元素的值
			data[head++] = null; // 释放队列的head端的元素
			return value;
		}
	}

	// 队列长度
	public int length() {
		return tail - head;
	}
}
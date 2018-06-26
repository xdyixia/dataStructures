package dataStructures;

import java.util.Arrays;

public class QueueArray2<E> {
	public Object[] data = null;
	private int maxSize; // 队列容量
	private int tail;// 队列尾，允许插入
	private int head;// 队列头，允许删除
	private int size = 0; // 队列当前长度

	public QueueArray2() {
		this(10);
	}

	public QueueArray2(int initialSize) {
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
		return size == 0;
	}

	// 插入
	public boolean add(E e) {
		if (size == maxSize) {
			throw new RuntimeException("队列已满，无法插入新的元素！");
		} else {
			data[tail] = e;
			tail = (tail + 1) % maxSize;
			size++;
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
			data[head] = null; // 释放队列的head端的元素
			head = (head + 1) % maxSize; // 队首指针加1
			size--;
			return value;
		}
	}

	// 队列长度
	public int length() {
		return size;
	}

	// 清空循环队列
	public void clear() {
		Arrays.fill(data, null);
		size = 0;
		head = 0;
		tail = 0;
	}
}
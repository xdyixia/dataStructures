package dataStructures;

public class QueueLink<E> {
	// 链栈的节点
	private class Node<E> {
		E e;
		Node<E> next;

		public Node() {
		}

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
	}

	private Node head;// 队列头，允许删除
	private Node tail;// 队列尾，允许插入
	private int size; // 队列当前长度

	public QueueLink() {
		head = null;
		tail = null;
	}

	// 判空
	public boolean empty() {
		return size == 0;
	}

	// 插入
	public boolean add(E e) {
		if (empty()) { // 如果队列为空
			head = new Node(e, null);// 只有一个节点，head、tail都指向该节点
			tail = head;
		} else {
			Node<E> newNode = new Node<E>(e, null);
			tail.next = newNode; // 让尾节点的next指向新增的节点
			tail = newNode; // 以新节点作为新的尾节点
		}
		size++;
		return true;
	}

	// 返回队首元素，但不删除
	public Node<E> peek() {
		if (empty()) {
			throw new RuntimeException("空队列异常！");
		} else {
			return head;
		}
	}

	// 出队
	public Node<E> poll() {
		if (empty()) {
			throw new RuntimeException("空队列异常！");
		} else {
			Node<E> temp = head; // 得到队列头元素
			head = head.next;// 让head引用指向原队列头元素的下一个元素
			temp.next = null; // 释放原队列头元素的next引用
			size--;
			return temp;
		}
	}

	// 队列长度
	public int length() {
		return size;
	}
}
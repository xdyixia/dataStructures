package dataStructures;

public class QueueLink<E> {
	// ��ջ�Ľڵ�
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

	private Node head;// ����ͷ������ɾ��
	private Node tail;// ����β���������
	private int size; // ���е�ǰ����

	public QueueLink() {
		head = null;
		tail = null;
	}

	// �п�
	public boolean empty() {
		return size == 0;
	}

	// ����
	public boolean add(E e) {
		if (empty()) { // �������Ϊ��
			head = new Node(e, null);// ֻ��һ���ڵ㣬head��tail��ָ��ýڵ�
			tail = head;
		} else {
			Node<E> newNode = new Node<E>(e, null);
			tail.next = newNode; // ��β�ڵ��nextָ�������Ľڵ�
			tail = newNode; // ���½ڵ���Ϊ�µ�β�ڵ�
		}
		size++;
		return true;
	}

	// ���ض���Ԫ�أ�����ɾ��
	public Node<E> peek() {
		if (empty()) {
			throw new RuntimeException("�ն����쳣��");
		} else {
			return head;
		}
	}

	// ����
	public Node<E> poll() {
		if (empty()) {
			throw new RuntimeException("�ն����쳣��");
		} else {
			Node<E> temp = head; // �õ�����ͷԪ��
			head = head.next;// ��head����ָ��ԭ����ͷԪ�ص���һ��Ԫ��
			temp.next = null; // �ͷ�ԭ����ͷԪ�ص�next����
			size--;
			return temp;
		}
	}

	// ���г���
	public int length() {
		return size;
	}
}
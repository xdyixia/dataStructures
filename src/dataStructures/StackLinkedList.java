package dataStructures;

import java.util.LinkedList;

public class StackLinkedList<E> {
	private LinkedList<E> ll = new LinkedList<E>();

	// ��ջ
	public void push(E e) {
		ll.addFirst(e);
	}

	// �鿴ջ��Ԫ�ص����Ƴ�
	public E peek() {
		return ll.getFirst();
	}

	// ��ջ
	public E pop() {
		return ll.removeFirst();
	}

	// �п�
	public boolean empty() {
		return ll.isEmpty();
	}

	// ��ӡջԪ��
	public String toString() {
		return ll.toString();
	}
}
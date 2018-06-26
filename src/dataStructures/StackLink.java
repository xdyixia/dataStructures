package dataStructures;

// ��ջ�Ľڵ�
class Node<E> {
	E e; // �ڵ��ֵ
	Node<E> next; // �ýڵ�ָ�����һ���ڵ�
	
	// ���캯��
	public Node(E e, Node next) {
		this.e = e;
		this.next = next;
	}
}

public class StackLink<E> {

	private Node<E> top = null; // ջ��Ԫ��
	private int size = 0; // ��ǰջ��С

	// ��ǰջ��С
	public int length() {
		return size;
	}

	// �п�
	public boolean empty() {
		return size == 0;
	}

	/**
	 * ��ջ����top���ָ���´����Ľڵ㣬�½ڵ��next����ָ��ԭ����ջ��Ԫ��top
	 * Node���вι�������ֱ��������½ڵ�ָ��ԭջ���ڵ������Ȼ��top���ָ���½ڵ㼴��,�����Ͳ����½������oldTop���ݴ��ջ���ڵ�
	 * 
	 * @param e
	 */
	public boolean push(E e) {
		top = new Node(e, top);
		size++;
		return true;
	}

	// �鿴ջ��Ԫ�ص���ɾ��
	public Node<E> peek() {
		if (empty()) {
			throw new RuntimeException("��ջ�쳣��");
		} else {
			return top;
		}
	}

	/**
	 * ��ջ���½���temp���ָ��top�ڵ㣬top���ָ��top����һ���ڵ㣬���ھ��� temp -> top ->
	 * ��temp.next=null�ͷż���
	 */
	public Node<E> pop() {
		if (empty()) {
			throw new RuntimeException("��ջ�쳣��");
		} else {
			Node<E> temp = top; // �õ�ջ��Ԫ��
			top = top.next; // ��top����ָ��ԭջ��Ԫ�ص���һ��Ԫ��
			temp.next = null; // �ͷ�ԭջ��Ԫ�ص�next����
			size--;
			return temp;
		}
	}
}
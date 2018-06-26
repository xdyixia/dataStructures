package dataStructures;

/**
 * ʹ��java.util.Queue�ӿ�,��ײ������һ��LinkedList��˫�˶��У�ʵ��.
 */
import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedList<E> {
	private Queue<E> queue = new LinkedList<E>();

	// ��ָ����Ԫ�ز���˶��У�������������Ҳ���Υ���������ƣ����ڳɹ�ʱ���� true��
	// �����ǰû�п��õĿռ䣬���׳� IllegalStateException��
	public boolean add(E e) {
		return queue.add(e);
	}

	// ��ȡ�����ǲ��Ƴ��˶��е�ͷ��
	public E element() {
		return queue.element();
	}

	// ��ָ����Ԫ�ز���˶��У�������������Ҳ���Υ���������ƣ�����ʹ�����������ƵĶ���ʱ��
	// �˷���ͨ��Ҫ���� add(E)�����߿����޷�����Ԫ�أ���ֻ���׳�һ���쳣��
	public boolean offer(E e) {
		return queue.offer(e);
	}

	// ��ȡ�����Ƴ��˶��е�ͷ������˶���Ϊ�գ��򷵻� null
	public E peek() {
		return queue.peek();
	}

	// ��ȡ���Ƴ��˶��е�ͷ������˶���Ϊ�գ��򷵻� null
	public E poll() {
		return queue.poll();
	}

	// ��ȡ���Ƴ��˶��е�ͷ
	public E remove() {
		return queue.remove();
	}

	// �п�
	public boolean empty() {
		return queue.isEmpty();
	}
}
package dataStructures;

import java.util.Arrays;

public class QueueArray2<E> {
	public Object[] data = null;
	private int maxSize; // ��������
	private int tail;// ����β���������
	private int head;// ����ͷ������ɾ��
	private int size = 0; // ���е�ǰ����

	public QueueArray2() {
		this(10);
	}

	public QueueArray2(int initialSize) {
		if (initialSize >= 0) {
			this.maxSize = initialSize;
			data = new Object[initialSize];
			head = tail = 0;
		} else {
			throw new RuntimeException("��ʼ����С����С��0��" + initialSize);
		}
	}

	// �п�
	public boolean empty() {
		return size == 0;
	}

	// ����
	public boolean add(E e) {
		if (size == maxSize) {
			throw new RuntimeException("�����������޷������µ�Ԫ�أ�");
		} else {
			data[tail] = e;
			tail = (tail + 1) % maxSize;
			size++;
			return true;
		}
	}

	// ���ض���Ԫ�أ�����ɾ��
	public E peek() {
		if (empty()) {
			throw new RuntimeException("�ն����쳣��");
		} else {
			return (E) data[head];
		}
	}

	// ����
	public E poll() {
		if (empty()) {
			throw new RuntimeException("�ն����쳣��");
		} else {
			E value = (E) data[head]; // �������е�head�˵�Ԫ�ص�ֵ
			data[head] = null; // �ͷŶ��е�head�˵�Ԫ��
			head = (head + 1) % maxSize; // ����ָ���1
			size--;
			return value;
		}
	}

	// ���г���
	public int length() {
		return size;
	}

	// ���ѭ������
	public void clear() {
		Arrays.fill(data, null);
		size = 0;
		head = 0;
		tail = 0;
	}
}
package dataStructures;

public class QueueArray<E> {
	private Object[] data = null;
	private int maxSize; // ��������
	private int head; // ����ͷ������ɾ��
	private int tail; // ����β���������

	// ���캯��
	public QueueArray() {
		this(10);
	}

	public QueueArray(int initialSize) {
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
		return tail == head ? true : false;
	}

	// ����
	public boolean add(E e) {
		if (tail == maxSize) {
			throw new RuntimeException("�����������޷������µ�Ԫ�أ�");
		} else {
			data[tail++] = e;
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
			data[head++] = null; // �ͷŶ��е�head�˵�Ԫ��
			return value;
		}
	}

	// ���г���
	public int length() {
		return tail - head;
	}
}
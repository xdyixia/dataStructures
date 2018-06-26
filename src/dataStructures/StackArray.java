package dataStructures;

public class StackArray<E> {

	private Object[] data = null;
	private int maxSize; //ջ����
	private int top = -1; //ջ��ָ��
	
	/**
	 * �޲ι��캯��
	 */
	StackArray(){
		this(10); //Ĭ��ջ��СΪ10 		
	}
	
	/**
	 * �вι��캯��
	 */
	StackArray(int initialSize){
		if(initialSize >= 0){
			this.maxSize = initialSize;
			data = new Object[initialSize];
			top = -1;
		}else{
			throw new RuntimeException("��ʼ����С����С��0��" + initialSize);
		}
	}
	
	//��ջ����һ��Ԫ��top=0��
	public boolean push(E e){
		if(top == maxSize - 1){
			throw new RuntimeException("ջ�������޷���Ԫ����ջ��");
		}else{
			data[++top] = e;
			return true;
		}
	}
	
	//����ջ��Ԫ��
	public E pop(){
		if(top == -1){
			throw new RuntimeException("ջΪ�գ�");
		}else{
			return (E)data[top--];
		}
	}
	
	//�鿴ջ��Ԫ�ص����Ƴ�
	public E peek(){
		if(top == -1){
			throw new RuntimeException("ջΪ�գ�");
		}else{
			return (E)data[top];
		}
	}
	
	//�п�
	public boolean empty(){
		return top == -1 ? true : false;
	}
	
	//���ض�����ջ�е�λ�ã���1Ϊ����
	public int search(E e){
		int i = top;
		while(top != -1){
			if(peek() != e){
				top--;
			}else{
				break;
			}
		}
		int result = top + 1;
		top = i;
		return result;
	}
}

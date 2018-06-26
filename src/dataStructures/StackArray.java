package dataStructures;

public class StackArray<E> {

	private Object[] data = null;
	private int maxSize; //栈容量
	private int top = -1; //栈顶指针
	
	/**
	 * 无参构造函数
	 */
	StackArray(){
		this(10); //默认栈大小为10 		
	}
	
	/**
	 * 有参构造函数
	 */
	StackArray(int initialSize){
		if(initialSize >= 0){
			this.maxSize = initialSize;
			data = new Object[initialSize];
			top = -1;
		}else{
			throw new RuntimeException("初始化大小不能小于0：" + initialSize);
		}
	}
	
	//进栈，第一个元素top=0；
	public boolean push(E e){
		if(top == maxSize - 1){
			throw new RuntimeException("栈已满，无法将元素入栈！");
		}else{
			data[++top] = e;
			return true;
		}
	}
	
	//弹出栈顶元素
	public E pop(){
		if(top == -1){
			throw new RuntimeException("栈为空！");
		}else{
			return (E)data[top--];
		}
	}
	
	//查看栈顶元素但不移除
	public E peek(){
		if(top == -1){
			throw new RuntimeException("栈为空！");
		}else{
			return (E)data[top];
		}
	}
	
	//判空
	public boolean empty(){
		return top == -1 ? true : false;
	}
	
	//返回对象在栈中的位置，以1为基数
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

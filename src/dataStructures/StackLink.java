package dataStructures;

// 链栈的节点
class Node<E> {
	E e; // 节点的值
	Node<E> next; // 该节点指向的下一个节点
	
	// 构造函数
	public Node(E e, Node next) {
		this.e = e;
		this.next = next;
	}
}

public class StackLink<E> {

	private Node<E> top = null; // 栈顶元素
	private int size = 0; // 当前栈大小

	// 当前栈大小
	public int length() {
		return size;
	}

	// 判空
	public boolean empty() {
		return size == 0;
	}

	/**
	 * 入栈：让top句柄指向新创建的节点，新节点的next引用指向原来的栈顶元素top
	 * Node的有参构造器就直接完成了新节点指向原栈顶节点的任务，然后top句柄指向新节点即可,这样就不用新建个句柄oldTop来暂存旧栈顶节点
	 * 
	 * @param e
	 */
	public boolean push(E e) {
		top = new Node(e, top);
		size++;
		return true;
	}

	// 查看栈顶元素但不删除
	public Node<E> peek() {
		if (empty()) {
			throw new RuntimeException("空栈异常！");
		} else {
			return top;
		}
	}

	/**
	 * 出栈：新建个temp句柄指向top节点，top句柄指向top的下一个节点，现在就是 temp -> top ->
	 * 让temp.next=null释放即可
	 */
	public Node<E> pop() {
		if (empty()) {
			throw new RuntimeException("空栈异常！");
		} else {
			Node<E> temp = top; // 得到栈顶元素
			top = top.next; // 让top引用指向原栈顶元素的下一个元素
			temp.next = null; // 释放原栈顶元素的next引用
			size--;
			return temp;
		}
	}
}
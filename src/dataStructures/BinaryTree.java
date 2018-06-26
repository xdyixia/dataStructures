package dataStructures;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeNode<E> {
	public E data; // ������
	public TreeNode<E> lchild; // ����
	public TreeNode<E> rchild; // �Һ���

	TreeNode() {
	}

	TreeNode(E e) {
		this.data = e;
	}

	TreeNode(E data, TreeNode<E> lchild, TreeNode<E> rchild) {
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
}

/**
 * ����������ʽ�洢�ṹ
 */
public class BinaryTree<E> {
	private TreeNode<E> root; // ���ڵ�
	private List<TreeNode> nodeList = null; // ������������ʽ�ṹ

	public BinaryTree() {
	}

	public BinaryTree(TreeNode<E> root) {
		this.root = root;
	}

	// ��һ������ת��Ϊһ����ȫ������
	public TreeNode<E> buildTree(E[] array) {
		nodeList = new LinkedList<TreeNode>();
		// �������е�Ԫ������ת��ΪTreeNode�ڵ㣬�����������
		for (int i = 0; i < array.length; i++) {
			nodeList.add(new TreeNode(array[i]));
		}
		// ��ǰ��array.length / 2 - 1�������ڵ�(�������һ�����ڵ�)�����ո��ڵ��뺢�ӽڵ�����ֹ�ϵ������ȫ������
		// ����ȫ�������������ϵ��£������ҵ�˳�����α��0,1,2,3....N,��i>0�Ľڵ㣬������Ϊ��2*i+1�������Һ���Ϊ��2*i+2��
		for (int j = 0; j < (array.length / 2 - 1); j++) {
			// ����
			nodeList.get(j).lchild = nodeList.get(j * 2 + 1);
			// �Һ���
			nodeList.get(j).rchild = nodeList.get(j * 2 + 2);
		}
		// ���һ�����ڵ㣺��Ϊ���һ�����ڵ����û���Һ��ӣ����Ե�������
		int index = array.length / 2 - 1;
		// ����
		nodeList.get(index).lchild = nodeList.get(index * 2 + 1);
		// �Һ��ӣ��������ĳ���Ϊ���������Һ���
		if (array.length % 2 == 1) {
			nodeList.get(index).rchild = nodeList.get(index * 2 + 2);
		}
		root = nodeList.get(0); // ���ø��ڵ�
		return root;
	}

	// �õ����ĸ߶�
	public int height(TreeNode<E> node) {
		if (node == null) {
			return 0;
		} else {
			int i = height(node.lchild);
			int j = height(node.rchild);
			return (i < j) ? (j + 1) : (i + 1);
		}
	}

	// �õ��ڵ�ĸ���
	public int size(TreeNode<E> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + size(node.lchild) + size(node.rchild);
		}
	}

	// �ݹ�ʵ��������� NLR
	public void preOrder(TreeNode<E> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.lchild);
			preOrder(node.rchild);
		}
	}

	// �ǵݹ�ʵ��������� NLR
	public void nonRecPreOrder(TreeNode<E> node) {
		Stack<TreeNode<E>> nodeStack = new Stack<TreeNode<E>>();
		TreeNode<E> nodeTemp = node; // nodeTemp��Ϊ����ָ��
		while (nodeTemp != null || !nodeStack.isEmpty()) { // ��nodeTemp�ǿջ�ջ�ǿ�ʱѭ��
			if (nodeTemp != null) { // ��ָ��ǿգ�����������
				nodeStack.push(nodeTemp); // ��ָ���ջ
				System.out.print(nodeStack.peek().data + " "); // ��ָ����ջ�����ʸ��ڵ�
				nodeTemp = nodeTemp.lchild; // ÿ�����ǿն�������������
			} else { // ������������
				nodeTemp = nodeStack.pop();
				nodeTemp = nodeTemp.rchild;
			}
		}
	}

	// �ݹ�ʵ��������� LNR
	public void inOrder(TreeNode<E> node) {
		if (node != null) {
			inOrder(node.lchild);
			System.out.print(node.data + " ");
			inOrder(node.rchild);
		}
	}

	// �ǵݹ�ʵ��������� LNR
	public void nonRecInOrder(TreeNode<E> node) {
		Stack<TreeNode<E>> nodeStack = new Stack<TreeNode<E>>();
		TreeNode<E> nodeTemp = node; // nodeTemp��Ϊ����ָ��
		while (nodeTemp != null || !nodeStack.isEmpty()) { // ��nodeTemp�ǿջ�ջ�ǿ�ʱѭ��
			if (nodeTemp != null) { // ��ָ��ǿգ�����������
				nodeStack.push(nodeTemp); // ��ָ���ջ
				nodeTemp = nodeTemp.lchild; // ÿ�����ǿն�������������
			} else {
				nodeTemp = nodeStack.pop(); // ��ָ����ջ�����ʸ��ڵ�
				System.out.print(nodeTemp.data + " ");
				nodeTemp = nodeTemp.rchild; // ������������
			}
		}
	}

	// �ݹ�ʵ�ֺ������ LNR
	public void postOrder(TreeNode<E> node) {
		if (node != null) {
			postOrder(node.lchild);
			postOrder(node.rchild);
			System.out.print(node.data + " ");
		}
	}

	// �ǵݹ�ʵ�ֺ������ LNR
	public void nonRecPostOrder(TreeNode<E> node) {
		Stack<TreeNode<E>> nodeStack = new Stack<TreeNode<E>>();
		TreeNode<E> nodeTemp = node; // nodeTemp��Ϊ����ָ��
		TreeNode<E> preNode = null; // ��ʾ���һ�η��ʵĽڵ�
		while (nodeTemp != null || !nodeStack.isEmpty()) { // ��nodeTemp�ǿջ�ջ�ǿ�ʱѭ��
			while (nodeTemp != null) { // һֱ�����ߣ�����������
				nodeStack.push(nodeTemp);
				nodeTemp = nodeTemp.lchild;
			}
			nodeTemp = nodeStack.peek();
			if (nodeTemp.rchild == null || nodeTemp.rchild == preNode) { // ������Ϊ�ջ��������ѱ�����ʱ���ýڵ��ջ
				nodeTemp = nodeStack.pop();
				System.out.print(nodeTemp.data + " ");
				preNode = nodeTemp; // ���ýڵ㸳ֵ�����һ�����ʽڵ�
				nodeTemp = null; // �˴�����Ҫ�����ճ�ջ�ڵ�����Ϊ�գ���Ӧ��whileѭ��������֮һ������������ѭ��
			} else {
				nodeTemp = nodeTemp.rchild; // ����������
			}
		}
	}

	// ��α���
	public void levelOrder(TreeNode<E> root) {
		Queue<TreeNode<E>> nodeQueue = new LinkedList<TreeNode<E>>();
		TreeNode<E> node = null;
		nodeQueue.add(root); // �����ڵ����
		while (!nodeQueue.isEmpty()) { // ���в���ѭ��
			node = nodeQueue.peek();
			System.out.print(node.data + " ");
			nodeQueue.poll(); // ��ͷԪ�س���
			if (node.lchild != null) { // ���������գ��������������
				nodeQueue.add(node.lchild);
			}
			if (node.rchild != null) { // ���������գ��������������
				nodeQueue.add(node.rchild);
			}
		}
	}

	public static void main(String args[]) {
		// ��һ������ת��Ϊһ����ȫ������
		Object[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.buildTree(array);
		System.out.print("���ĸ߶ȣ�");
		System.out.println(bt.height(root));
		System.out.print("�ڵ�ĸ�����");
		System.out.println(bt.size(root));
		System.out.println("���������");
		bt.preOrder(root);
		System.out.println("\n" + "�ǵݹ����������");
		bt.nonRecPreOrder(root);
		System.out.println();

		System.out.println("���������");
		bt.inOrder(root);
		System.out.println("\n" + "�ǵݹ����������");
		bt.nonRecInOrder(root);
		System.out.println();

		System.out.println("���������");
		bt.postOrder(root);
		System.out.println("\n" + "�ǵݹ���������");
		bt.nonRecPostOrder(root);
		System.out.println();

		System.out.println("��α�����");
		bt.levelOrder(root);

		// �ֹ�����һ�Ŷ�����
		TreeNode nodeA = new TreeNode("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");
		TreeNode nodeD = new TreeNode("D");
		TreeNode nodeE = new TreeNode("E");
		TreeNode nodeF = new TreeNode("F");
		TreeNode nodeG = new TreeNode("G");
		TreeNode nodeH = new TreeNode("H");
		TreeNode nodeI = new TreeNode("I");
		nodeA.lchild = nodeB;
		nodeA.rchild = nodeD;
		nodeB.rchild = nodeC;
		nodeD.lchild = nodeE;
		nodeD.rchild = nodeF;
		nodeF.lchild = nodeG;
		nodeF.rchild = nodeI;
		nodeG.rchild = nodeH;

		System.out.println("\n\n" + "*****************");
		System.out.print("���ĸ߶ȣ�");
		System.out.println(bt.height(nodeA));
		System.out.print("�ڵ�ĸ�����");
		System.out.println(bt.size(nodeA));
		System.out.println("���������");
		bt.preOrder(nodeA);
		System.out.println();

		System.out.println("���������");
		bt.inOrder(nodeA);
		System.out.println();

		System.out.println("���������");
		bt.postOrder(nodeA);
		System.out.println();

		System.out.println("��α�����");
		bt.levelOrder(nodeA);
	}

}

package dataStructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinarySearchTree {
	private TreeNode<Integer> root = null; // ���ڵ�

	public BinarySearchTree() {
	}

	// ��һ������ȥ�������������
	public TreeNode<Integer> buildBST(Integer[] array) {
		if (array.length == 0) {
			return null;
		} else {
			root = null; // ��ʼ����Ϊ����
			for (int i = 0; i < array.length; i++) { // ���ν�ÿ��Ԫ�ز���
				root = insertNode(root, array[i]);
			}
			return root;
		}
	}

	// �ڶ���������в���һ��������Ϊdata�Ľ�㣬�²���Ľ��һ����ĳ��Ҷ�ӽڵ�
	private TreeNode<Integer> insertNode(TreeNode<Integer> node, Integer data) {
		if (node == null) { // ԭ��Ϊ�գ��²���ļ�¼Ϊ���ڵ�
			node = new TreeNode<Integer>(data, null, null);
		} else {
			if (node.data != data) { // ���в�������ͬ�ؼ��ֵĽ��
				if (node.data > data) { // ���ڵ�>�������ݣ����뵽��������
					node.lchild = insertNode(node.lchild, data);
				} else { // ���ڵ�<�������ݣ����뵽��������
					node.rchild = insertNode(node.rchild, data);
				}
			}
		}
		return node;
	}

	// �����������������������Եõ�һ����������������
	public void inOrder(TreeNode<Integer> node) {
		if (node != null) {
			inOrder(node.lchild);
			System.out.print(node.data + " ");
			inOrder(node.rchild);
		}
	}

	// ����������Ĳ�α���
	public void levelOrder(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> nodeQueue = new LinkedList<TreeNode<Integer>>();
		TreeNode<Integer> node = null;
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

	// ����������Ϊdata�Ľ�㣬�������ڣ�����null
	public TreeNode<Integer> searchNode(TreeNode<Integer> node, Integer data) {
		while (node != null && node.data != data) {
			if (node.data > data) {
				node = node.lchild; // ���ڵ�>���ݣ�������
			} else {
				node = node.rchild; // ���ڵ�<���ݣ�������
			}
		}
		return node;
	}

	// �������ֵ�����ϵ�Ѱ�����ӽڵ�
	public TreeNode<Integer> getMaxData(TreeNode<Integer> node) {
		if (node.rchild == null) {
			return node;
		} else {
			return getMaxData(node.rchild);
		}
	}

	// ������Сֵ�����ϵ�Ѱ�����ӽڵ�
	public TreeNode<Integer> getMinData(TreeNode<Integer> node) {
		if (node.lchild == null) {
			return node;
		} else {
			return getMinData(node.lchild);
		}
	}

	// �õ�������Ϊdata�Ľ���ֱ�Ӹ��ڵ�parentNode
	public TreeNode<Integer> getParentNode(TreeNode<Integer> root, Integer data) {
		TreeNode<Integer> parentNode = root;
		if (parentNode.data == data) { // ���ڵ�ĸ��ڵ㷵��Ϊnull
			return null;
		}
		while (parentNode != null) {
			// ���ҵ�ǰ�ڵ�ĸ��ڵ�������ӽڵ㣬������ȣ��򷵻ظø��ڵ�
			if ((parentNode.lchild != null && parentNode.lchild.data == data)
					|| (parentNode.rchild != null && parentNode.rchild.data == data)) {
				return parentNode;
			} else {
				if (parentNode.data > data) { // ������Ҹ��ڵ�
					parentNode = parentNode.lchild;
				} else {
					parentNode = parentNode.rchild; // ���Ҳ��Ҹ��ڵ�
				}
			}
		}
		return null;
	}

	/**
	 * �õ����node��ֱ��ǰ�� a.�ýڵ���������Ϊ�գ���ǰ���ڵ�Ϊ�������������Ԫ��
	 * b.�ýڵ�������Ϊ��:��ǰ���ڵ�Ϊ�����Ƚڵ�(�ݹ�)���Ҹ����Ƚڵ���Һ���ҲΪ�����Ƚڵ� (����һֱ����parent�ң�������պ���Ǹ����Ƚڵ�)
	 */
	public TreeNode<Integer> getPrecessor(TreeNode<Integer> root, TreeNode<Integer> node) {
		if (node == null) {
			return null;
		}
		// a.�ýڵ���������Ϊ�գ���ǰ���ڵ�Ϊ�������������Ԫ��
		if (node.lchild != null) {
			return getMaxData(node.lchild);
		} else { // b.�ýڵ�������Ϊ��: ��ǰ���ڵ�Ϊ�����Ƚڵ�(�ݹ�)
			TreeNode<Integer> parentNode = getParentNode(root, node.data);
			while (parentNode != null && node == parentNode.lchild) {
				node = parentNode;
				parentNode = getParentNode(root, parentNode.data);
			}
			return parentNode;
		}
	}

	/**
	 * �õ����node��ֱ�Ӻ��(��̽ڵ���Ǳ�Ҫɾ���Ľڵ�Ĺؼ�ֵҪ��Ľڵ㼯���е���Сֵ) a.�ýڵ���������Ϊ�գ����̽ڵ�Ϊ������������СԪ��
	 * b.�ýڵ�������Ϊ�գ������̽ڵ�Ϊ�����Ƚڵ�(�ݹ�)���Ҵ����Ƚڵ������Ҳ�Ǹýڵ�����Ƚڵ㣬
	 * ����˵һֱ�����������Ƚڵ㣬ֱ�������ҹպ���Ǹ����Ƚڵ㣺
	 */
	public TreeNode<Integer> getSuccessor(TreeNode<Integer> root, TreeNode<Integer> node) {
		if (node == null) {
			return null;
		}
		// a.�ýڵ���������Ϊ�գ����̽ڵ�Ϊ������������СԪ��
		if (node.rchild != null) {
			return getMinData(node.rchild);
		} else { // b.�ýڵ�������Ϊ�գ������̽ڵ�Ϊ��������Ƚڵ�(�ݹ�)
			TreeNode<Integer> parentNode = getParentNode(root, node.data);
			while (parentNode != null && node == parentNode.rchild) {
				node = parentNode;
				parentNode = getParentNode(root, parentNode.data);
			}
			return parentNode;
		}
	}

	/**
	 * ɾ��������Ϊdata�Ľ�� ������������� a.�����ɾ�����z��Ҷ�ӽڵ㣬��ֱ��ɾ���������ƻ����������������
	 * b.����ڵ�zֻ��һ����������������������z��������Ϊz���ڵ������������z��λ��
	 * c.�����z��������������������z��ֱ�Ӻ�̣���ֱ��ǰ�������z��
	 * Ȼ��Ӷ����������ɾȥ���ֱ�Ӻ�̣���ֱ��ǰ����,������ת��Ϊ��һ��ڶ������
	 * 
	 * @param node
	 *            ����������ĸ��ڵ�
	 * @param data
	 *            ��Ҫɾ���Ľ���������
	 * @return
	 */
	public boolean deleteNode(TreeNode<Integer> node, Integer data) {
		if (node == null) { // ��Ϊ��
			throw new RuntimeException("��Ϊ�գ�");
		}
		TreeNode<Integer> delNode = searchNode(node, data); // ������Ҫɾ���Ľ��
		TreeNode<Integer> parent = null;
		if (delNode == null) { // ������в�����Ҫɾ���Ĺؼ���
			throw new RuntimeException("���в�����Ҫɾ���Ĺؼ��֣�");
		} else {
			parent = getParentNode(node, data); // �õ�ɾ���ڵ��ֱ�Ӹ��ڵ�
			// a.�����ɾ�����z��Ҷ�ӽڵ㣬��ֱ��ɾ���������ƻ����������������
			if (delNode.lchild == null && delNode.rchild == null) {
				if (delNode == parent.lchild) { // ��ɾ���ڵ�Ϊ�丸�ڵ������
					parent.lchild = null;
				} else { // ��ɾ���ڵ�Ϊ�丸�ڵ���Һ���
					parent.rchild = null;
				}
				return true;
			}
			// b1.����ڵ�zֻ��һ��������������z��������Ϊz���ڵ������������z��λ��
			if (delNode.lchild != null && delNode.rchild == null) {
				if (delNode == parent.lchild) { // ��ɾ���ڵ�Ϊ�丸�ڵ������
					parent.lchild = delNode.lchild;
				} else { // ��ɾ���ڵ�Ϊ�丸�ڵ���Һ���
					parent.rchild = delNode.lchild;
				}
				delNode.lchild = null; // ���ñ�ɾ����������Ϊnull
				return true;
			}
			// b2.����ڵ�zֻ��һ��������������z��������Ϊz���ڵ������������z��λ��
			if (delNode.lchild == null && delNode.rchild != null) {
				if (delNode == parent.lchild) { // ��ɾ���ڵ�Ϊ�丸�ڵ������
					parent.lchild = delNode.rchild;
				} else { // ��ɾ���ڵ�Ϊ�丸�ڵ���Һ���
					parent.rchild = delNode.rchild;
				}
				delNode.rchild = null; // ���ñ�ɾ�������Һ���Ϊnull
				return true;
			}
			// c.�����z������������������ɾ���ý��ĺ�̽�㣬���øú�̽��ȡ���ý��
			if (delNode.lchild != null && delNode.rchild != null) {
				TreeNode<Integer> successorNode = getSuccessor(node, delNode); // �õ���ɾ�����ĺ�̽ڵ�
				deleteNode(node, successorNode.data); // ɾ���ý��ĺ�̽��
				delNode.data = successorNode.data; // �øú�̽��ȡ���ý��
				return true;
			}
		}
		return false;

	}

	/**
	 * ĳЩ�����ķǵݹ�ʵ�� 1. ����ڵ�insertNode(): 2. �������������������� 3. �õ���������������ֵ����Сֵ��
	 */
	// 1. �ڶ���������в���һ��������Ϊdata�Ľ�㣬�²���Ľ��һ����ĳ��Ҷ�ӽڵ�
	public TreeNode<Integer> insertNode2(TreeNode<Integer> node, Integer data) {
		TreeNode<Integer> newNode = new TreeNode<Integer>(data, null, null);
		TreeNode<Integer> tmpNode = node; // �����ڵ�
		TreeNode<Integer> pnode = null; // ��¼��ǰ�ڵ�ĸ��ڵ�

		if (node == null) { // ԭ��Ϊ�գ��²���ļ�¼Ϊ���ڵ�
			node = newNode;
			return node;
		}
		while (tmpNode != null) {
			pnode = tmpNode;
			if (tmpNode.data == data) { // ���д�����ͬ�ؼ��ֵĽ��,ʲôҲ����
				return node;
			} else {
				if (tmpNode.data > data) { // ���ڵ�>�������ݣ����뵽��������
					tmpNode = tmpNode.lchild;
				} else { // ���ڵ�<�������ݣ����뵽��������
					tmpNode = tmpNode.rchild;
				}
			}
		}
		if (pnode.data > data) {
			pnode.lchild = newNode;
		} else {
			pnode.rchild = newNode;
		}
		return node;
	}

	// 2. ������������������LNR�����Եõ�һ����������������
	public void inOrder2(TreeNode<Integer> node) {
		Stack<TreeNode<Integer>> nodeStack = new Stack<TreeNode<Integer>>();
		TreeNode<Integer> tempNode = node; // ����ָ��
		while (tempNode != null || !nodeStack.isEmpty()) {
			if (tempNode != null) {
				nodeStack.push(tempNode);
				tempNode = tempNode.lchild;
			} else {
				tempNode = nodeStack.pop();
				System.out.print(tempNode.data + " ");
				tempNode = tempNode.rchild;
			}
		}
	}

	// 3.1 �������ֵ�����ϵ�Ѱ�����ӽڵ�
	public TreeNode<Integer> getMaxData2(TreeNode<Integer> node) {
		TreeNode<Integer> tempNode = node;
		while (tempNode.rchild != null) {
			tempNode = tempNode.rchild;
		}
		return tempNode;
	}

	// 3.2 ������Сֵ�����ϵ�Ѱ�����ӽڵ�
	public TreeNode<Integer> getMinData2(TreeNode<Integer> node) {
		TreeNode<Integer> tempNode = node;
		while (tempNode.lchild != null) {
			tempNode = tempNode.lchild;
		}
		return tempNode;
	}

	public static void main(String[] args) {
		Integer[] array = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode<Integer> root = bst.buildBST(array);
		System.out.print("��α�����");
		bst.levelOrder(root);

		System.out.print("\n" + "���������");
		bst.inOrder(root);

		System.out.println();
		System.out.print("�õ����ֵ��");
		System.out.println(bst.getMaxData(root).data);
		System.out.print("�õ���Сֵ��");
		System.out.println(bst.getMinData(root).data);

		System.out.print("�����������в���һ���ڵ㣬�����������ڵ��������");
		Scanner input = new Scanner(System.in);
		int data = input.nextInt();
		System.out.print("����ڵ�" + data + "����������Ľ����");
		root = bst.insertNode(root, data);
		bst.inOrder(root);

		System.out.println("\n" + "�ڶ���������в���Ԫ��," + "��������Ҫ���ҵĽ��ֵ��");
		data = input.nextInt();
		if (bst.searchNode(root, data) == null) {
			System.out.println("false");
		} else {
			System.out.println("true");
		}

		System.out.println("���ҽڵ��ֱ�Ӹ��ڵ�," + "��������Ҫ���ҵĽ��ֵ��");
		data = input.nextInt();
		System.out.print("�ڵ�" + data + "�ĸ��ڵ��ǣ�");
		if (bst.getParentNode(root, data) == null) {
			System.out.println("null");
		} else {
			System.out.println(bst.getParentNode(root, data).data);
		}

		System.out.println("ɾ�����," + "��������Ҫɾ���Ľ��ֵ��");
		data = input.nextInt();
		if (bst.deleteNode(root, data)) {
			System.out.print("ɾ������Ĳ�α�����");
			bst.levelOrder(root);
			System.out.print("\n" + "ɾ����������������");
			bst.inOrder(root);
		}

	}

}

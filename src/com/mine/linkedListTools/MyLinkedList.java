package com.mine.linkedListTools;

/**
 * ʵ��������࣬���� ��ӡ�ɾ�������ҡ��޸ġ���ȡ����
 * 
 * @author hzkxma
 * @version 2016/1/26
 */
public class MyLinkedList<E> implements ElementLinkedList<E> {
	private Data root, present;
	private int size;

	/**
	 * ��ӽڵ�
	 * 
	 * @pagram e Ҫ���������
	 */
	public void add(E e) {
		if (root == null) {
			root = new Data();
			root.data = e;
			present = root;
		} else {
			Data temp = new Data();
			temp.data = e;
			present.next = temp;
			present = temp;
		}
		size++;
	}

	/**
	 * ɾ���ڵ�
	 * 
	 * @pagram index Ҫɾ��Ԫ�ص�����
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean delete(int index) {
		if (index >= size && index < 0)
			return false;
		else if (index != 0) {
			Data temp1 = findNode(index - 1);
			Data temp2 = findNode(index);
			temp1.next = temp2.next;

		} else {
			if (present == root)
				present = root.next;
			root = root.next;
		}
		size--;
		return true;
	}

	/**
	 * ����Ԫ��
	 * 
	 * @pagram index Ҫ����Ԫ�ص�����
	 * @return ���ز��ҵ�Ԫ��
	 */
	@SuppressWarnings("unchecked")
	public E find(int index) {
		return (E) findNode(index).data;
	}

	/**
	 * ���ҽڵ�
	 * 
	 * @pagram index Ҫ����Ԫ�ص�����
	 * @return ���ز��ҵĽڵ�
	 */
	public Data findNode(int index) {
		if (index >= size && index < 0)
			throw new IndexOutOfBoundsException("��������Χ");
		else if (index == 0) {
			return root;
		} else if (index == size - 1) {
			return present;
		} else {
			Data temp = root;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		}
	}

	/**
	 * �޸�Ԫ��
	 * 
	 * @pagram index Ҫ����Ԫ�ص�����
	 * @pagram e �޸ĺ��Ԫ��
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean update(int index, E e) {
		if (index >= size && index < 0)
			return false;
		else {
			findNode(index).data = e;
			return true;
		}
	}

	/**
	 * �鿴����
	 * 
	 * @return ����������
	 */
	public int getSize() {
		return size;
	}
}

class Data {
	Object data;
	Data next;
}
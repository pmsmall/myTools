package com.mine.linkedListTools;

/**
 * 实现链表的类，包括 添加、删除、查找、修改、获取长度
 * 
 * @author hzkxma
 * @version 2016/1/26
 */
public class MyLinkedList<E> implements ElementLinkedList<E> {
	private Data root, present;
	private int size;

	/**
	 * 添加节点
	 * 
	 * @pagram e 要传入的数据
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
	 * 删除节点
	 * 
	 * @pagram index 要删除元素的索引
	 * @return 成功返回true，失败返回false
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
	 * 查找元素
	 * 
	 * @pagram index 要查找元素的索引
	 * @return 返回查找的元素
	 */
	@SuppressWarnings("unchecked")
	public E find(int index) {
		return (E) findNode(index).data;
	}

	/**
	 * 查找节点
	 * 
	 * @pagram index 要查找元素的索引
	 * @return 返回查找的节点
	 */
	public Data findNode(int index) {
		if (index >= size && index < 0)
			throw new IndexOutOfBoundsException("超出链表范围");
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
	 * 修改元素
	 * 
	 * @pagram index 要查找元素的索引
	 * @pagram e 修改后的元素
	 * @return 成功返回true，失败返回false
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
	 * 查看长度
	 * 
	 * @return 返回链表长度
	 */
	public int getSize() {
		return size;
	}
}

class Data {
	Object data;
	Data next;
}
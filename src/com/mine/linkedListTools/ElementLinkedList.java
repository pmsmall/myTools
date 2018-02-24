package com.mine.linkedListTools;

/**
 * 实现链表的类，包括 添加、删除、查找、修改、获取长度
 * 
 * @author hzkxma
 * @version 2016/1/26
 */
public interface ElementLinkedList<E> {

	/**
	 * 添加节点
	 * 
	 * @pagram e 要传入的数据
	 */
	public void add(E e);

	/**
	 * 删除节点
	 * 
	 * @pagram index 要删除元素的索引
	 * @return 成功返回true，失败返回false
	 */
	public boolean delete(int index);

	/**
	 * 查找元素
	 * 
	 * @pagram index 要查找元素的索引
	 * @return 返回查找的元素
	 */
	public E find(int index);

	/**
	 * 查找节点
	 * 
	 * @pagram index 要查找元素的索引
	 * @return 返回查找的节点
	 */
	public Data findNode(int index);

	/**
	 * 修改元素
	 * 
	 * @pagram index 要查找元素的索引
	 * @pagram e 修改后的元素
	 * @return 成功返回true，失败返回false
	 */
	public boolean update(int index, E e);

	/**
	 * 查看长度
	 * 
	 * @return 返回链表长度
	 */
	public int getSize();

}

package com.mine.linkedListTools;

/**
 * ʵ��������࣬���� ��ӡ�ɾ�������ҡ��޸ġ���ȡ����
 * 
 * @author hzkxma
 * @version 2016/1/26
 */
public interface ElementLinkedList<E> {

	/**
	 * ��ӽڵ�
	 * 
	 * @pagram e Ҫ���������
	 */
	public void add(E e);

	/**
	 * ɾ���ڵ�
	 * 
	 * @pagram index Ҫɾ��Ԫ�ص�����
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean delete(int index);

	/**
	 * ����Ԫ��
	 * 
	 * @pagram index Ҫ����Ԫ�ص�����
	 * @return ���ز��ҵ�Ԫ��
	 */
	public E find(int index);

	/**
	 * ���ҽڵ�
	 * 
	 * @pagram index Ҫ����Ԫ�ص�����
	 * @return ���ز��ҵĽڵ�
	 */
	public Data findNode(int index);

	/**
	 * �޸�Ԫ��
	 * 
	 * @pagram index Ҫ����Ԫ�ص�����
	 * @pagram e �޸ĺ��Ԫ��
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean update(int index, E e);

	/**
	 * �鿴����
	 * 
	 * @return ����������
	 */
	public int getSize();

}

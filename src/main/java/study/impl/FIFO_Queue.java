package study.impl;

/**
 * 通过双向链表实现了一个先进先出的队列
 *
 * @param <T>
 */
public class FIFO_Queue<T> {
	private transient int size;
	private Node<T> first;
	private Node<T> last;
	
	public boolean offer(T t) {
		Node node = new Node(t, first, null);
		if (first == null) {
			last = node;
		} else {
			first.pre = node;
		}
		first = node;
		size++;
		return true;
	}
	
	public T poll() {
		T item = last.item;
		if (last.pre != null) {
			last.pre.next = null;
		}
		last = last.pre;
		size--;
		return item;
	}
	
	public T peek() {
		return last == null ? null : last.item;
	}
	
	private static class Node<T> {
		T item;
		Node<T> next;
		Node<T> pre;
		
		Node(T element, Node<T> next, Node<T> pre) {
			this.item = element;
			this.next = next;
			this.pre = pre;
		}
	}
}

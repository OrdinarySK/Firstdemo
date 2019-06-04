package linklist;


/**
 * 双链表类
 * @author luokai
 *
 */
public class DoubleLinkedList {

	/**
	 * 链表的头指针
	 */
	private Link head;
	
	/**
	 * 尾指针
	 */
	private Link tail;
	
	/**
	 * 默认构造器
	 */
	public DoubleLinkedList(){
		head = null;
		tail = null;
	}
	
	/**
	 * 包含一个数组元素的构造器
	 * @param array
	 */
	public DoubleLinkedList(int[] array){
		if(array == null) throw new NullPointerException();
		for( int i : array){
			insertTail(i);
		}
	}
	
	/**
	 * 插入元素到头指针处
	 */
	public void insertHead(int x){
		Link newLink = new Link(x);
		if(isEmpty())
			tail = newLink;
		else
			head.previous = newLink ;
		newLink.next = head;
		head = newLink;
	}
	
	/**
	 * 尾部插入元素
	 */
	public void insertTail(int x){
		Link newLink = new Link(x);
		newLink.next = null;
		if(isEmpty()){
			tail = newLink;
			head = tail;
		}else{
			tail.next = newLink;
			newLink.previous = tail;
			tail = newLink;
		}
	}
	
	/**
	 * 删除头部的元素
	 */
	public Link deleteHead(){
		Link temp = head;
		head = head.next;
		head.previous = null;
		if(head == null)
			tail = null;
		return temp;		
	}
	
	/**
	 * 删除元素在尾部
	 */
	public Link deleteTail(){
		Link temp = tail;
		tail = tail.previous;
		tail.next = null;
		if(tail == null){
			head = null;
		}
		return temp;
	}
	
	/**
	 * 从中间删除一个元素
	 */
	
	public void delete(int x){
		Link current = head;
		
		while(current.value != x){
			if(current != tail){
				current = current.next;
			}else{
				throw new RuntimeException("这个被删除的元素不存在");
			}
		}
		
		if(current == head)
			deleteHead();
		
		else if(current ==tail)
		    deleteTail();
		else{
			current.previous.next = current.next;
			current.next.previous = current.previous;
		}
	}
	/**
	 * 插入元素和记录着
	 * 	*/
	
	public void insertOrdered(int x){
		Link newLink = new Link(x);
		Link current = head;
		while(current != null && x > current.value)
			current = current.next;
		if(current == head)
			insertHead(x);
		
		else if(current == null)
		    insertTail(x);
		
		else{
			newLink.previous = current.previous;
			current.previous.next = newLink;
			newLink.next = current;
			current.previous = newLink;
		}
	}
	
	/**
	 * 判断链表是否为空
	 */
	public boolean isEmpty(){
		return (head == null);
	}
	
	/**
	 * 打印链表
	 */
	public void display(){
		Link current = head;
		while(current != null){
			current.displayLink();
			current= current.next;
		}
		System.out.println();
	}
	
}

/**
 * 链表节点类
 * @author luokai
 *
 */
class Link{
	/**
	 * node节点的元素值
	 */
	public int value;
	/**
	 * next节点
	 */
	public Link next;
	/**
	 * previous节点
	 */
	public Link previous;
	
	/**
	 * 构造器
	 * @param value of node
	 */
	public Link(int value){
		this.value = value;
	}
	
	/**
	 * 显示 node节点 的值
	 */
	public void displayLink(){
		System.out.println(value + " ");
	}
	
	/**
	 * 主函数
	 */
	public static void main(String[] args) {
		DoubleLinkedList myList = new DoubleLinkedList();
        myList.insertHead(13);
        myList.insertHead(7);
        myList.insertHead(10);
        myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->

        myList.insertTail(11);
        myList.display(); // <-- 10(head) <--> 7 <--> 13 <--> 11(tail) -->

        myList.deleteTail();
        myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->

        myList.delete(7);
        myList.display(); // <-- 10(head) <--> 13(tail) -->

        myList.insertOrdered(23);
        myList.insertOrdered(67);
        myList.insertOrdered(3);
        myList.display(); // <-- 3(head) <--> 10 <--> 13 <--> 23 <--> 67(tail) -->
	}
	
	
}

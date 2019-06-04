关于双向链表的概念：
=================
1.双向链表的优点：
---------------
传统的链表沿着链表的反向遍历是困难的，以及操作某个节点的前一个元素，也是十分的困难。 
　　双向链表提供了这些能力，即可以向前遍历，也可以向后遍历。其中实现在于每个链节点有两个指向其它节点的引用。一个指向前驱节点，一个像传统链表一样指向后继节点。
![Image text](https://github.com/OrdinarySK/Firstdemo/blob/master/img/shaunglianbiao.png)
双向链表的节点类：

```java
class Link <T>{
    public T val;           //定义的元素值
    public Link<T> next;    //后驱节点
    public Link<T> pre;     //前驱节点

    public Link(T val) {
        this.val = val;
    }
 ｝
```
双向链表的缺点:
-------------
1.每次插入和删除操作时，要处理四个节点的引用，而不是两个。<br>
2.两个连接前一个链节点，两个连接后一个链接点。当然 ，由于多了两个链节点的引用，链节点占用的空间也会变大。双向链表由于前驱指针的存在，可以多种方式插入。addFrist()头插，addLast()尾插，在特定元素之前插入addBefore()，在特定元素之后插入addAfter()。

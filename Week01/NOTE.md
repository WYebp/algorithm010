学习笔记

1.用 add first 或 add last 这套新的 API 改写 Deque 的代码

```java
Deque<String> deque = new LinkedList<String> ()

deque.addFirst("a");
deque.addLast("b");
deque.addLast("c");
System.out.println(deque);

String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);

while( deque.size() > 0 ) {
    System.out.println(deque.removeFirst());
}
System.out.println(deque);
```



2.分析 Queue 和 Priority Queue 的源码

> 1.Queue, 队列，特点是数据先进先出，而PriorityQueue，优先级队列，使用上跟普通队列一样，唯一区别是PriorityQueue会根据排序规则决定谁在队头，谁在队尾。
>
> 
>
> 2.Queue接口方法声明如下：
>
> | 方法               | 说明                                                         |
> | ------------------ | ------------------------------------------------------------ |
> | boolean add(E e)   | 在队列头部增加一个元素，如果容量已满，则抛出异常，成功则返回true |
> | boolean offer(E e) | 在队列头部增加一个元素，如果容量已满，则返回false，成功加入，返回true; |
> | E remove();        | 将队列头部元素移出队列并返回，如果队列为空，则抛出异常。     |
> | E poll();          | 将队列头部元素移出队列并返回，如果队列为空，返回null         |
> | E element();       | 返回队列头部节点，但不移除队列头节点，如果队列为空，则抛出异常。 |
> | E peek();          | 返回队列头部节点，但不移除队列头节点，如果队列为空，返回null。 |
>
> 优先级队列 PriorityQueue 类 实现了 Queue接口，但由于操作元素的规则不同，PriorityQueue有自己的 add() /offer() /remove() 等实现。
>
> 其元素按照其自然顺序进行排序，或者根据构造队列时提供的 Comparator 进行排序，具体取决于所使用的构造方法。该队列不允许使用 null 元素也不允许插入不可比较的对象(没有实现Comparable接口的对象)。
>
> 方法：
>
> ```java
> Comparator<? super E>	comparator()
> ```
>
> 返回排序用的Comparator，如果是自然顺序排序，则返回null
>
> PriorityQueue 队列的头，指排序规则最小元素。如果多个元素都是最小值则随机选一个。
>
>  
>
> 3.PriorityQueue的实现，使用了最小堆，底层用数组存储：object[]数组
>
> 



第一周学习数组链表，栈和队列，熟悉掌握各个数据结构查询以及修改的时间复杂度；

在应用到解决问题过程中，有如下收获

一种解决方法：左右夹逼法

一种思考方式：寻找最近重复子问题

一种加速思想：空间换时间，低维升高维
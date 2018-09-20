> ArrayList可变数组

##### ArrayList构造函数
```
    /**
     * Shared empty array instance used for default sized empty instances. We
     * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
     * first element is added.
     */
     private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    
    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
```
刚开始如果没有设置ArrayList大小,将创建一个空数组赋值给this.elementData。
##### add方法:
```
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }
```
其中ensureCapacityInternal方法保证了内部容量。
##### ensureCapacityInternal方法:
```
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;    
    
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }
```
如果elementData还是默认的空数组的话,那么就比较DEFAULT_CAPACITY和minCapacity,
常量DEFAULT_CAPACITY的值为10,minCapacity的值为当前elementData中元素的个数+1,
其中的大值为10,将10赋值给minCapacity,继续调用ensureExplicitCapacity方法。
##### ensureExplicitCapacity方法:
```
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
```
判断minCapacity是否大于elementData数组的长度,判断为true,进入grow方法,对elementData数组进行扩容。
##### grow方法:
```
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```
oldCapacity的值为当前elementData数组的长度,newCapacity的值为oldCapacity的1.5倍(取整数)，
判断oldCapacity是否小于newCapacity，如果判断为true，将minCapacity的值赋值给newCapacity，
接着判断新的数组容量是否超过数组的最大size，判断为true，将调用hugeCapacity方法，
将扩容后的数组赋值给elementData。
##### get方法:
```
    public E get(int index) {
        rangeCheck(index);

        return elementData(index);
    }
```
先检查是否超出可变数组的size，否则就抛出IndexOutOfBoundsException这个异常,

##### remove方法:
```
    public E remove(int index) {
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }
```
先检查是否超出可变数组的size，否则就抛出IndexOutOfBoundsException这个异常,
得到需要移除的元素赋值给oldValue,作为返回值,如果要移除的元素位置是在中间位置的，
那么numMoved = size - index - 1,得到的结果就是大于0的,将后面的元素向前位移,并将
elementData最后一个位置设置为null,size减1。

由上可知,remove后,elementData的容量并不会有变化。若多次调用add后,elementData的容量扩容后,
调用remove不会使elementData的容量缩减。


### redis对象
#### 1、redisObject
> 1、redis一个对象的操作都是对一个redisObject对象进行的操作

> 2、结构

```
redisObject{
    unsigned type:4 // 类型，五类redis数据结构，string，list，hash，set，zset
    unsigned encoding:4 // 对象的底层编码类别，int，embstr的简单动态字符串，raw（简单动态字符串），
    // ht（字典），linkedlist（双端链表），ziplist（压缩列表），intset（整数集合），
    //skip list（跳跃表字典）。int、emstr（0-39）、raw（>39）三个为字符串类别
    void *ptr；// 指向底层实现数据结构的指针
}

```
> 3、使用encoding属性设置对象所使用的编码类型：提高灵活性和效率，根据不同的场景设置不同的编码，如string对象类型可以根据存储的值类型使用int编码，根据string的长度使用embstr或者raw，以便节省内存或者提高内存分配、查询效率。
##### 1、string
> 1、结构：如下图 ![redis_string](http://note.youdao.com/noteshare?id=1b7c3516c835549940cd1227e258794b)

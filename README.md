## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  |      10,000,000    |    0.012947     |
| Using ReentrantLock     |      10,000,000    |    0.979983     |
| Synchronized method     |      10,000,000    |    0.872181     |
| AtomicLong for total    |      10,000,000    |    0.351162     |

## 1. Using unsynchronized counter object

answer the questions (1.1 - 1.3)
1.1 The total isn't the same each time.
1.2 Runtime is  0.012947 when limit is 10,000,000..
1.3 because thread read value from the counter in the same time then when it return the value to the counter  that make it can be negative or positive number.

## 2. Implications for Multi-threaded Applications

How might this affect real applications?
  In bank application, it will cause the effect like when you transfer a money to your bank account by mobile banking and you withdraw by ATM in the same time,the value will not correct

## 3. Counter with ReentrantLock

answer questions 3.1 - 3.4
3.1 Yes
3.2 Because this class use lock() that make only 1 Thread can read the counter by one time.
3.3 Creates an instance of ReentrantLock. 
3.4 Because if the add method can't work and finally will allow them to unlock()

## 4. Counter with synchronized method

answer question 4
4.1 The result is always 0.
4.2 because method add from SynchronousCounter class is synchronized method.
4.3 synchronized blocks the next thread's call to method test() as long as the previous thread's execution is not finished. Threads can access this method one at a time. Without synchronized all threads can access this method simultaneously.

## 5. Counter with AtomicLong

answer question 5
5.1 because AtomicLong is a long value that may be updated atomically
5.2 use an AtomicLong when you have to guarantee that the value can be used in a concurrent environment or You don't need the wrapper class (as this class will not autobox)

## 6. Analysis of Results

answer question 6
6.1 The fastest is the counter that using AtomicLong for total value.The slowest is counter that using ReentrantLock
6.2	 in my opinion i will use ReetranLock because it can choose the scope that you want to lock.

## 7. Using Many Threads (optional)


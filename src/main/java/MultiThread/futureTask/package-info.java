package MultiThread.futureTask;
/**
 * FutureTask 实现的 RunnableFuture 接口继承了 Runnable 和 Future 接口
 * 因此，FutureTask既可以作为参数传给 ThreadPoolExecutor对象 实现框架的异步调用
 *      也可以灵活的用做线程类Thread 的参数
 *      同时也可以直接使用 FutureTask.run()方法执行
 *
 *
 *      FutureTask 的构造方法接收Callable 传参,这个构造方法相当于将Callable 转化成了Runnable ，这样
 *      得到的futureTask 即可用于 ThreadPoolExecutor的submit方法(可获得返回结果),也可用于Executor.execute() 或者单个工作者
 *      线程的创建的场合(!! 这些场合的调用虽然方法返回均为void 但是可以通过 futureTask.get() 获取到调用结果)
 *
 *      因此可以认为所有的FutureTask 均可以被在多场合下调用并且均可以拿到结果
 *
 */
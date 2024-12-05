# Concurrency API

Once you finished using a thread executor, it is important to call the shutdown() method. The shutdown() method does not stop any tasks that have already been submitted to the thread executor. The shutdownNow() attempts to stop all running tasks and discards any that have not been started yet, but it is not guaranteed to succeed because it is possible to create a thread that will never terminate, so any attempt to interrupt it may be ignored.

# ExecutorService methods

| Method name                                                              | Description                                                                                                                                         |
|--------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| `void execute(Runnable command)`                                         | Executes Runnable task at some point in future.                                                                                                     |
| `Future<?> submit(Runnable task)`                                        | Executes Runnable task at some point in future and returns Future representing task.                                                                |
| `<T> Future<T> submit(Callable<T> task)`                                 | Executes Callable task at some point in future and returns Future representing pending results of task.                                             |
| `<T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)` | Executes given tasks and waits for all tasks to complete. Returns List of Future instances in same order in which they were in original collection. |
| `<T> T invokeAny(Collection<? extends Callable<T>> tasks)`               | Executes given tasks and waits for at least one to complete.                                                                                        |

# Future methods

| Method name                                     | Description                                                                                                                                               |
|-------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| `boolean isDone()`                              | Returns true if task was completed, threw exception, or was cancelled.                                                                                    |
| `boolean isCancelled()`                         | Returns true if task was cancelled before it completed normally.                                                                                          |
| `boolean cancel(boolean mayInterruptIfRunning)` | Attempts to cancel execution of task and returns true if it was successfully cancelled or false if it could not be cancelled or is complete.              |
| `V get()`                                       | Retrieves result of task, waiting endlessly if it is not yet available.                                                                                   |
| `V get(long timeout, TimeUnit unit)`            | Retrieves result of task, waiting specified amount of time. If result is not ready by time timeout is reached, checked `TimeoutException` will be thrown. |

# TimeUnit values

| Enum name               | Description                                          |
|-------------------------|------------------------------------------------------|
| `TimeUnit.NANOSECONDS`  | Time in one-billionths of a second (1/1,000,000,000) |
| `TimeUnit.MICROSECONDS` | Time in one-millionths of a second (1/1,000,000)     |
| `TimeUnit.MILLISECONDS` | Time in one-thousandths of a second (1/1,000)        |
| `TimeUnit.SECONDS`      | Time in seconds                                      |
| `TimeUnit.MINUTES`      | Time in minutes                                      |
| `TimeUnit.HOURS`        | Time in hours                                        |
| `TimeUnit.DAYS`         | Time in days                                         |

# ScheduledExecutorService methods

| Method name                                                                              | Description                                                                                                                                                  |
|------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `schedule(Callable<V> callable, long delay, TimeUnit unit)`                              | Creates and executes Callable tasks after given delay                                                                                                        |
| `schedule(Runnable command, long delay, TimeUnit unit)`                                  | Creates and executes Runnable task after given delay                                                                                                         |
| `scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)`   | Creates and executes Runnable task after given initial delay, creating new task every period value that passes                                               |
| `scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)` | Creates and executes Runnable task after given initial delay and subsequently with given delay between termination of one execution and commencement of next |

# Executors factory methods

| Method name                                                   | Description                                                                                                                                                             |
|---------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `ExecutorService newSingleThreadExecutor()`                   | Creates single-threaded executor that uses single worker thread operating off unbounded queue. Results are processed sequentially in order in which they are submitted. |
| `ScheduledExecutorService newSingleThreadScheduledExecutor()` | Creates single-threaded executor that can schedule commands to run after given delay or to execute periodically.                                                        |
| `ExecutorService newCachedThreadPool()`                       | Creates thread pool that creates new threads as needed but reuses previously constructed threads when they are available.                                               |
| `ExecutorService newFixedThreadPool(int)`                     | Creates thread pool that reuses fixed number threads operating off shared unbounded queue.                                                                              |
| `ScheduledExecutorService newScheduledThreadPool(int)`        | Creates thread pool that can schedule commands to run after given delay or execute periodically.                                                                        |

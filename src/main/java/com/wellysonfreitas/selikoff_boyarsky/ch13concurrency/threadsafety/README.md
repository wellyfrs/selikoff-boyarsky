# Atomic classes

| Class name      | Description                                     |
|-----------------|-------------------------------------------------|
| `AtomicBoolean` | A boolean value that may be updated atomically. |
| `AtomicInteger` | An int value that may be updated atomically.    |
| `AtomicLong`    | A long value that may be updated atomically.    |


# Common atomic methods

| Method                     | Description                                                                  |
|----------------------------|------------------------------------------------------------------------------|
| `get()`                    | Retrieves current value                                                      |
| `set(type newValue)`       | Sets given value, equivalent to assignment `=` operator                      |
| `getAndSet(type newValue)` | Atomically sets new value and returns old value                              |
| `incrementAndGet()`        | For numeric classes, atomic pre-increment operation equivalent to `++value`  |
| `getAndIncrement()`        | For numeric classes, atomic post-increment operation equivalent to `value++` |
| `decrementAndGet()`        | For numeric classes, atomic pre-decrement operation equivalent to `--value`  |
| `getAndDecrement()`        | For numeric classes, atomic post-decrement operation equivalent to `value--` |

# Lock methods

| Method                                         | Description                                                                                                                               |
|------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| `void lock()`                                  | Requests lock and blocks until lock is acquired.                                                                                          |
| `void unlock()`                                | Releases lock.                                                                                                                            |
| `boolean tryLock()`                            | Requests lock and returns immediately. Returns boolean indicating whether lock was successfully acquired.                                 |
| `boolean tryLock(long timeout, TimeUnit unit)` | Requests lock and blocks for specified time or until lock is acquired. Returns boolean indicating whether lock was successfully acquired. |

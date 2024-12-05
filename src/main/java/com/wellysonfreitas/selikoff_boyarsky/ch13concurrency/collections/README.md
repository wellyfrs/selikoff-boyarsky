# Concurrent collection classes

| Class name              | Java collections interfaces                                                      | Sorted? | Blocking? |
|-------------------------|----------------------------------------------------------------------------------|---------|-----------|
| `ConcurrentHashMap`     | `Map`<br/>`ConcurrentMap`                                                        | No      | No        |
| `ConcurrentLinkedQueue` | `Queue`                                                                          | No      | No        |
| `ConcurrentSkipListMap` | `Map`<br/>`SortedMap`<br/>`NavigableMap`<br/>`ConcurrentMap`<br/>`ConcurrentMap` | Yes     | No        |
| `ConcurrentSkipListSet` | `Set`<br/>`SortedSet`<br/>`NavigableSet`                                         | Yes     | No        |
| `CopyOnWriteArrayList`  | `List`                                                                           | No      | No        |
| `CopyOnWriteArraySet`   | `Set`                                                                            | No      | No        |
| `LinkedBlockingQueue`   | `Queue`<br/>`BlockingQueue`                                                      | No      | Yes       |

Skip classes are just "sorted" versions of the associated concurrent collections. When you see a class with Skip in the name, just think "sorted concurrent" collections, and the rest should follow naturally.

# Synchronized Collections methods

| Method                                          |
|-------------------------------------------------|
| `synchronizedCollection(Collection<T> c)`       |
| `synchronizedList(List<T> list)`                |
| `synchronizedMap(Map<K,V> m)`                   |
| `synchronizedNavigableMap(NavigableMap<K,V> m)` |
| `synchronizedNavigableSet(NavigableSet<T> s)`   |
| `synchronizedSet(Set<T> s)`                     |
| `synchronizedSortedMap(SortedMap<K,V> m)`       |
| `synchronizedSortedSet(SortedSet<T> s)`         |

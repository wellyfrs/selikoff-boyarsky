# Java Collections Framework types

| Type  | Can contain duplicate elements? | Elements always ordered?        | Has keys and values? | Must add/remove in specific order? |
|-------|---------------------------------|---------------------------------|----------------------|------------------------------------|
| List  | Yes                             | Yes (by index)                  | No                   | No                                 |
| Map   | Yes (for values)                | No                              | Yes                  | No                                 |
| Queue | Yes                             | Yes (retrieve by defined order) | No                   | Yes                                |
| Set   | No                              | No                              | No                   | No                                 |


# Collection attributes

| Type         | Java Collections Framework interface | Sorted? | Calls hashCode? | Calls compareTo? |
|--------------|--------------------------------------|---------|-----------------|------------------|
| `ArrayDeque` | `Deque`                              | No      | No              | No               |
| `ArrayList`  | `List`                               | No      | No              | No               |
| `HashMap`    | `Map`                                | No      | Yes             | No               |
| `HashSet`    | `Set`                                | No      | Yes             | No               |
| `LinkedList` | `List`, `Deque`                      | No      | No              | No               |
| `TreeMap`    | `Map`                                | Yes     | No              | Yes              |
| `TreeSet`    | `Set`                                | Yes     | No              | Yes              |


The data structures that involve sorting do not allow null values.

# Factory methods to create a `List`

| Method                    | Description                                                      | Can add elements? | Can replace elements? | Can delete elements? |
|---------------------------|------------------------------------------------------------------|-------------------|-----------------------|----------------------|
| `Arrays.asList(varargs)`  | Returns fixed size list backed by an array                       | No                | Yes                   | No                   |
| `List.of(varargs)`        | Returns immutable list                                           | No                | No                    | No                   |
| `List.copyOf(collection)` | Returns immutable list with copy of original collection's values | No                | No                    | No                   |

# List methods

| Method                                                | Description                                                                                             |
|-------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| `public boolean add(E element)`                       | Adds element to end (available on call Collection APIs).                                                |
| `public void add(int index, E element)`               | Adds element at index and moves the rest toward the end.                                                |
| `public E get(int index)`                             | Returns element at index.                                                                               |
| `public E remove(int index)`                          | Removes element at index and moves the rest toward the front.                                           |
| `public default void replaceAll(UnaryOperator<E> op)` | Replaces each element in list with result of operator.                                                  |
| `public E set(int index, E e)`                        | Replaces element at index and returns original. Throws `IndexOutOfBoundsException` if index is invalid. |
| `public default void sort(Comparator<? super E> c)`   | Sorts list. We cover this later in the chapter in the "Sorting Data" section.                           |

# Queue Methods

| Functionality             | Methods                                                    |
|---------------------------|------------------------------------------------------------|
| Add to back               | `public boolean add(E e)`*<br/>`public boolean offer(E e)` |
| Read from front           | `public E element()`*<br/>`public E peek()`                |
| Get and remove from front | `public E remove()`*<br/>`public E poll()`                 |

*Throws an exception when something goes wrong, like trying to read from an empty Queue.

# Deque Methods

| Functionality             | Methods                                                           |
|---------------------------|-------------------------------------------------------------------|
| Add to front              | `public void addFirst(E e)`*<br/>`public boolean offerFirst(E e)` |
| Add to back               | `public void addLast(E e)`*<br/>`public boolean offerLast(E e)`   |
| Read from front           | `public E getFirst()`*<br/>`public E peekFirst()`                 |
| Read from back            | `public E getLast()`*<br/>`public E peekLast()`                   |
| Get and remove from front | `public E removeFirst()`*<br/>`public E poolFirst()`              |
| Get and remove from back  | `public E removeLast()`*<br/>`public E pollLast()`                |

# Using a Deque as a stack

| Functionality             | Methods                  |
|---------------------------|--------------------------|
| Add to the front/top      | `public void push(E e)`* |
| Remove from the front/top | `public E pop()`*        |
| Get first element         | `public E peek()`        |

# Map Methods

| Method                                                   | Description                                                                                               |
|----------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| `public void clear()`                                    | Removes all keys and values from map.                                                                     |
| `public boolean containsKey(Object key)`                 | Returns whether key is in map.                                                                            |
| `public boolean containsValue(Object value)`             | Returns whether value is in map.                                                                          |
| `public Set<Map.Entry<K,V>> entrySet()`                  | Returns Set of key/value pairs.                                                                           |
| `public void forEach(BiConsumer<K key, V value>)`        | Loops through each key/value pair.                                                                        |
| `public V get(Object key)`                               | Returns value mapped by key or null if none is mapped.                                                    |
| `public V getOrDefault(Object key, V defaultValue)`      | Returns value mapped by key of default value if none is mapped.                                           |
| `public boolean IsEmpty()`                               | Returns whether map is empty.                                                                             |
| `public Set<K> keySet()`                                 | Returns set of all keys.                                                                                  |
| `public V merge(K key, V value, Function(<V,V,V> func))` | Sets value if key not set. Runs function if key is set, to determine new value. Removes if value is null. |
| `public V put(K key, V value)`                           | Adds or replaces key/value pair. Returns previous value or null.                                          |
| `public V putIfAbsent(K key, V value)`                   | Adds value if key not present and returns null. Otherwise, returns existing value.                        |
| `public V remove(Object key)`                            | Removes and returns value mapped to key. Returns null if none.                                            |
| `public V replace(K key, V value)`                       | Replaces value for given key if key is set. Returns original value or null if none.                       |
| `public void replaceAll(BiFunction<K,V,V> func)`         | Replaces each value with results of function.                                                             |
| `public int size()`                                      | Returns number of entries (key/value pairs) in map.                                                       |
| `public Collection<V> values()`                          | Returns Collection of all values.                                                                         |

# Behaviour of the `merge()` method

| If the requested key _____  | Add mapping function returns _____ | Then:                                                                         |
|-----------------------------|------------------------------------|-------------------------------------------------------------------------------|
| has a null value in map     | N/A (mapping function not called)  | update key's value in map with value parameter                                |
| has a non-null value in map | null                               | remove key from map                                                           |
| has a non-null value in map | a non-null value                   | set key to mapping function result                                            |
| is not in map               | N/A (mapping function not called)  | add key with value parameter to map directly without calling mapping function |

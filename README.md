# **Java Collection**

## <U>A Collection</U>
- A collection is an object that represents a group of objects.
- The group of objects has some relationship to each other.
- Collection objects including arrays, lists, vectors, sets, queues, tables, dictionaries, maps.
- These are differentiated by the way they store the objects in memory, how objects are retrieved and ordered, and whether nulls and duplicate entries are permitted. 


## <u>Collections Framework</u>
- Oracle's Java documentation describes it's collections framework as: 
> "A unified architecture for representing and manipulating collections, enabling collections to be manipulated independently of implementation details."
- The Quote emphasizes that a collections framework provides a standardized and abstracted way of working with collections, shielding developers from implementation complexities and allowing them to focus on the high-level tasks they want to accomplish.
- ***Definition:***
  - Collections Framework is a set of interfaces and classes in Java that provides a comprehensive architecture for representing and manipulating collections of objects.
- ***The Collections framework consists of:***
  - Interfaces:
    - The framework includes several core interfaces such as Collection, List, Set, Map, Queue, and Deque. These interfaces define common behaviors and operations that various collection types can support.
  - Implementations:
    - The framework provides concrete implementation of the collection interfaces. These implementations offer different strategies for storing and organizing elements. Include ArrayList, LinkedList, HashSet, HashMap, PriorityQueue, TreeMap.
  - Algorithms:
    - The Collections class provides a set of algorithms (Static methods) for performing common operations on collections, such as sorting, searching, shuffling, and more. These algorithms are designed to work with any collection type that implements the appropriate interfaces. 


## <u>Collections Interface</u>
- Collection interface serves as the foundation for the Java Collections Framework. It defines the basic operations applicable to all collection types. These operations include adding elements ['add( )'], removing elements ['remove( )'], checking for containment ['contain( )'], determining size ['size( )'], and more.
- ![image](https://github.com/huygi/Java_Collections/assets/105019803/b16f366b-5baf-4dff-a756-c5c0baa06336)

  ![Screenshot 2024-02-19 200052](https://github.com/huygi/Java_Collections/assets/105019803/2a399726-fd04-4bb8-a34e-f32241d6029c)
- 
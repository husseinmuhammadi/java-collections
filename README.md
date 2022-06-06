Equal Objects must have equal hashcode.
This is one of contract for hashcode and equals method in java docs.
In the implementation of `hashtable` and found out below code in `put` method
```
if ((e.hash == hash) && e.key.equals(key)) 
```

[What is the optimal capacity and load factor for a fixed-size HashMap?](https://stackoverflow.com/questions/7115445)

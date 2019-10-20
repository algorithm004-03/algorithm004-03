# 第一周学习总结


在做题过程中发现自己遇到以前做过的一些题目又不会解了，实践下来觉得“五毒神掌刷题法”是一个挺好的学习方法。在大多数题目开始做题的时候，基本上只能想到暴力解题法，以前是觉得能解出题目就行，也不太在意空间和时间复杂度。进行了第一周的学习之后，发现有那么多优秀解题方法，决定还是要多多练习。

  
## deque示例代码改写

```
		Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
```


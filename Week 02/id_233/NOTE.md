# 233-Week 02 学习总结

## 本周知识点
- **数据结构：** 哈希表、树
- **算法：** 递归、分治、回溯

## 递归阶梯技巧 四步骤
- terminator 终止条件
- process current logic 处理当前层逻辑
- drill down 进入下一层
- restore current status 清理当前层状态
```
// Java 递归模版
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
}
```
[HashMap 源码分析参考文章1](https://blog.csdn.net/zxt0601/article/details/77413921)
[HashMap 源码分析参考文章2](https://juejin.im/post/5a7719456fb9a0633e51ae14)
## ！！分治 回溯的代码还没搞明白，搞定后更新总结

// 思路总结：
/* 
  1. 把当前的结点放入队列
  2. 将队列的值依次弹出，弹出是顺便将结点值的孩子结点中的内容全部放入队列
  
*/
var levelOrder = function(root) {
    if (root == null) return [];
  
    let res = []
    let queue = [];
    
    queue.push(root)
  
    while (queue.length != 0) {
      let i = queue.length;
      let list = []
      while (i--) {
        let cur = queue.shift();
        
        list.push(cur.val);
        for (const node of cur.children) {
          if (node!=null) {
             queue.push(node);
          }
        }
      }
      res.push(list)
    }
      return res
    };
    
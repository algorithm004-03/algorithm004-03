// 26 删除排序数组中的重复项
/**
 * @description 1.  原数组删除 2. O(1) 条件下
 * @return 返回数组长度
 */
const removeDuplicates = nums => {
  const l = nums.length
  let j = 1
  // 从 1 开始比较
  for (let i = 1; i < l; i++) {
    // 不重复直接 添加到nums中
    if (nums[i] !== nums[i - 1]) {
      nums[j++] = nums[i]
    }
  }
  return (nums.length = j)
}

// 解题 思路 双指针 数组双指针 确实是非常常用的解题思路
// 唯一的疑问是 社区的题解 貌似并没有真正改变数组的长度 而是返回了 重排的长度 如果有人 review 这套代码 如果您能解答这个问题 真是感激不尽

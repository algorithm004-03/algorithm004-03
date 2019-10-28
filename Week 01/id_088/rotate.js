// 189. 旋转数组
/**
 * @description 1.  三种方法 2. O(1)
 * @return null
 */
const rotate = (nums, k) => {
  // 循环嵌套
  const l = nums.length
  k = k % nums.length
  let temp = nums[l - 1]
  // 不变的元素需要移动的距离
  for (let i = 0; i < k; i++) {
    temp = nums[l - 1]
    // 需要移动的次数
    for (let j = 0; j < l - 1; j++) {
      // 每次只需要 移动 l-1 次
      nums[l - 1 - j] = nums[l - 2 - j]
    }
    nums[0] = temp
  }
  // 这个时间复杂度 应该是 O(n^2)
}

// 两次循环
const rotate = (nums, k) => {
  const l = nums.length
  k = k % nums.length
  // 将所有的元素 先向后 统一移动 k 的距离
  for (let i = 0; i < l; i++) {
    nums[l - 1 - i + k] = nums[l - 1 - i]
  }
  // 再将多余的元素 填充回来
  for (let i = 0; i < k; i++) {
    nums[i] = nums[l + i]
  }
  nums.length = l
  // 1. 这种方法 并不是空间上的O(1) 如果 k 是最后一个元素 或者 倒数第二个元素 的话 实际上数组相当于 又多 开辟了 n/n-1 个内存 个人觉得是 O(n) 的 空间复杂度
  // 2. 不是很理解 题例 问什么要提出来 k > nums.length 这种情况 挺无语的
}

// leetcode上的高票答案 三次反转
const rotate = (nums, k) => {
  const l = nums.length
  if (!nums || l < 2) return
  k = k % nums.length
  // 进行三次反转
  reverse(nums, 0, nums.length - k - 1)
  reverse(nums, nums.length - k, nums.length - 1)
  reverse(nums, 0, nums.length - 1)
}

const reverse = (nums, st, ed) => {
  let temp = 0
  while (st < ed) {
    temp = nums[st]
    nums[st] = nums[ed]
    nums[ed] = temp
    st++
    ed--
  }
}

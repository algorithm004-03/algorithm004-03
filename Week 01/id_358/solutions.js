/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * #21. 合并两个有序链表 - 解法一
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
function ListNode(val) {
    this.val = val;
    this.next = null;
}
var mergeTwoLists = function (l1, l2) {
    //设置额外的第三条链表，拼接排序后的节点，作为结果返回
    const l3 = new ListNode(-1);
    //设置head节点指向l3，随着循环一直指向最后，l3作为链表首节点不变，最后作为结果返回
    const head = l3;
    while (l1 !== null && l2 !== null) {
        if (l1.val <= l2.val) {
            head.next = l1;
            l1 = l1.next;
        } else {
            head.next = l2;
            l2 = l2.next;
        }
        //每轮循环都要向后移动head节点
        head = head.next;
    }
    //循环结束后拼接剩下的不为空的链表，且一定是排序的。
    head.next = l1 ? l1 : l2;
    return l3.next;
};

/**
 * 21. 合并两个有序链表 - 解法二
 * @param {*} l1 
 * @param {*} l2 
 */
var mergeTwoLists = function (l1, l2) {
    //递归
    // 终止条件，递归处理的子问题中，链表为空；注意参数顺序；返回不为空的子链表即可；
    if (l1 === null) {
        return l2;
    }
    if (l2 === null) {
        return l1;
    }
    // 比较l1和l2的val，较小的节点一定作为头部节点，更新其next节点；把next之后的节点和另一条链表递归处理；
    // 注意头部节点需要return；
    if (l1.val <= l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}

/**
 * 88. 合并两个有序数组
 * @param {*} nums1 
 * @param {*} m 
 * @param {*} nums2 
 * @param {*} n 
 */
var merge = function (nums1, m, nums2, n) {
    //双指针，从两个数组有效数字位置往前循环，较大的数字往nums1后面开始填充；
    //循环结束后将num2剩余的数字填充到nums1前面；需要自行实现js版本的数组拷贝函数；
    let len1 = m - 1;
    let len2 = n - 1;
    let len = m + n - 1;
    while (len1 >= 0 && len2 >= 0) {
        if (nums1[len1] >= nums2[len2]) {
            nums1[len--] = nums1[len1--];
        } else {
            nums1[len--] = nums2[len2--];
        }
    }

    function arrayCopy(src, srcIndex, dest, destIndex, length) {
        dest.splice(destIndex, length, ...src.slice(srcIndex, srcIndex + length))
    }
    arrayCopy(nums2, 0, nums1, 0, len2 + 1);
};


/**
 * 1. 两数之和
 * @param {*} nums 
 * @param {*} target 
 */
var twoSum = function (nums, target) {
    let hashMap = []; // 这里也可以用map。
    for (let i = 0; i < nums.length; i++) {
        let key = target - nums[i]
        if (hashMap[key] !== undefined) { // 注意这个地方极容易出错。
            //一般写if判断，按习惯会写成if(hashMap[key]), 但是这里会添加数组下标0，
            //导致if(hashMap[key])在匹配时返回0，if不成立，最后得不到正确结果。
            //因此以后遇到向数组和map中添加数组下标并取出判断时注意为0的情况，使用与undefiend判断。
            return [hashMap[key], i]
        } else {
            hashMap[nums[i]] = i;
        }
    }
}

/**
 * 66. 加一
 * @param {*} digits 
 */
var plusOne = function(digits) {
    let len = digits.length;
    digits[len-1] +=1;
    let i =0;
    while(digits[len-1-i] > 9) {
        digits[len-1-i] -=10;
        i++;
        if(digits[len-1-i]) {
            digits[len-1-i] +=1
        } else {
            digits.unshift(1)
        }
        
    }
    return digits;
};
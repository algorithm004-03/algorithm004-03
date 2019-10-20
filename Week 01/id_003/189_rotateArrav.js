//方法一 暴力法
var rotate = function(nums, k) {
    let previous;
    for (let i = 0; i < k; i++) {
        previous = nums[nums.length - 1];
        for ( let j = 0; j < nums.length; j++ ){
            [nums[j],previous]=[previous,nums[j]];
        }
    }
};
//方法2 辅助空间
var rotate = function(nums, k) {
    let previous;
    for (let i = 0; i < k; i++) {
        previous = nums[nums.length - 1];
        for ( let j = 0; j < nums.length; j++ ){
            [nums[j],previous]=[previous,nums[j]];
        }
    }
};

//方法3 使用环状替换

var rotate = function(nums, k) {
    k %= nums.length;
    let start = 0;
    for(let count = 0; count < nums.length; count++){
        let current = start;
        let prev = nums[start];
        do{
            let next = (current + k) % nums.length;
            let temp = nums[next];
            nums[next] = prev;
            prev = temp;
            current = next;
            count++;            
        }while(start != current)
    }

}

//方法4  反转数组法
var rotate = function(nums, k) {
    k %= nums.length;
    revrse(nums, 0, nums.length -1);
    revrse(nums, 0, k - 1);
    revrse(nums, k - 1, nums.length -1);
}

var revrse = function(nums, start, end) {
    while ( start < end ) {
        let temp = nums[start];
        nums[start] = nums[ennd];
        nums[end] = temp;
        start++;
        end--;
    }
}


var removeDuplicates = function(nums) {
    if (nums.length == 0) return 0;
    var i = 0;
    var j = 1;
    nums.map((item,index,arr)=>{
        if( item !== nums[i] ) {
            i++;
            nums[i] = item;
        }
    })
        return i+1;
};
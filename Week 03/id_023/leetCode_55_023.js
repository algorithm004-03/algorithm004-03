/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function (nums) {
  function canJumpFromWhere(position, nums) {
    if (position == nums.length - 1) {
      return true;
    }
    var furthestPosition = Math.min(position + nums[position], nums.length - 1);
    for (var nextPosition = position + 1; nextPosition <= furthestPosition; nextPosition++) {
      if (canJumpFromWhere(nextPosition, nums)) {
        return true;
      }
    }
    return false;
  }
  return canJumpFromWhere(0, nums);
};
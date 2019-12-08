/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    var arr = new Array(amount + 1).fill(-2);
    return find(coins, amount, arr);

    function find(coins, amount, arr){
        if (amount <= 0) {
            return 0;
        }

        if (arr[amount] != -2) {
            return arr[amount];
        }

        var min = Infinity;

        for (var i = 0; i < coins.length; ++i) {
            if (amount >= coins[i]){
                var temp = find(coins, amount - coins[i], arr);

                if (temp != -1){
                    temp + 1 < min && (min = temp + 1);
                }
            }
        }

        return arr[amount] = Number.isFinite(min) ? min : -1;
    }
};

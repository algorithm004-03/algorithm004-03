/**
 * 题目： 柠檬水找零
 * 语言： JavaScript
 * 执行结果： 打败了65%的用户
 * 方法：贪心算法
 * */


/**
 * @param {number[]} bills
 * @return {boolean}
 */
const lemonadeChange = function (bills) {
    let five = 0;
    let ten = 0;

    for(let key in bills) {
        const money = bills[key];

        if(money === 5) five++;
        else if(money === 10) {
            if(five < 1) return false;
            five--;
            ten++;
        }else{
            if(ten > 0 && five > 0) {
                ten--;
                five--;
            }else if(five > 2) {
                five = five-3;
            }else return false;
        }
    }

    return true;
};

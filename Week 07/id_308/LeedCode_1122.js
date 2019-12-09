/**
 * 题目： 数组的相对排序
 * 语言： JavaScript
 * 执行结果： 打败了70.12%的用户
 * */

/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    let res = [];
    let i=0;

    while(i < arr2.length) {
        if(arr1.indexOf(arr2[i])> -1) {
            res.push(arr2[i]);
            arr1.splice(arr1.indexOf(arr2[i]),1);
        }else i++;
    }

    return res.concat(arr1.sort((a,b)=>a-b));

};
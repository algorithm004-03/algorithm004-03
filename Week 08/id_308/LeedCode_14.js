
/**
 * 题目： 最长公共前缀
 * 语言： JavaScript
 * 执行结果： 打败了78.75%的用户
 * */


var longestCommonPrefix = function(strs) {
    let res = strs[0] || '';
    if(res.length == 0) return '';
    for(let i=1;i<strs.length;i++) {
        while(!strs[i].startsWith(res)) {
            const temp = res.split('');
            temp.pop();
            res = temp.join('');
            if(res.length == 0) return '';
        }
    }

    return res;
};
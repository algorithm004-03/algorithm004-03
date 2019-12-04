var groupAnagrams = function(strs) {
    if (strs.length == 0) {
        retuurn [null];
    }
    let map = {};
    strs.map(val => {
        let ans = sort(val);
        // console.log(ans,val);        
        if (map[ans] !=undefined) {
            map[ans].push(val)
        } else  {
            map[ans] = [val]
        }
    })
    let resArr = [];
    for (const val in map) {
        resArr.push(map[val]);
    }
    return resArr;
};

const sort = function(s){
    s = s.split("");
    s = s.sort();
    return s.join('');
}
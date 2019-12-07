/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    // 生成地图，外围扩大一圈，用于边界判断
    var map = [];

    for (var i = 0; i < n + 2; ++i) {
        map.push(0);
    }

    for (var i = 0; i < n; ++i) {
        map.push(0);

        for (j = 0; j < n; ++j) {
            map.push(".");
        }

        map.push(0);
    }

    for (var i = 0; i < n + 2; ++i) {
        map.push(0);
    }

    // 生成步进，只搜索上面，左右及下面都不需要搜索
    var step = [-n - 3, -n - 2, -n - 1];

    var result = [];

    // 从第一行开始递归
    putPieceToLine(0);

    return result;

    // 指定行放棋子
    function putPieceToLine(line){
        if (line === n) {
            pushResult();
            return true;
        }

        var blankPoint = findBlankFromLine(line);

        if (blankPoint.length === 0) {
            return false;
        }

        for (var i = 0; i < blankPoint.length; ++i) {
            map[blankPoint[i]] = "Q";
            putPieceToLine(line + 1);
            map[blankPoint[i]] = ".";
        }
    }

    // 搜索指定行可放棋子点位
    function findBlankFromLine(line){
        var start = (line + 1) * (n + 2) + 1;
        var end = start + n;
        var result = [];

        // 该行空白点都检查一遍
        find: for (var i = start; i < end; ++i) {
            // 三个方向都检查一遍
            for (var j = 0; j < step.length; ++j) {
                var k = i;

                while (1) {
                    // 向指定方向步进
                    k += step[j];

                    // 已到达边界，跳出该方向
                    if (!map[k]) {
                        break;
                    }

                    // 发现棋子，跳过该空白点
                    if (map[k] === "Q") {
                        continue find;
                    }
                }
            }

            // 合格点位，记录
            result.push(i);
        }

        return result;
    }

    // 将当前 map 输出为题目要求的格式
    function pushResult(){
        var lines = [];

        for (var i = 1; i <= n; ++i) {
            var str = "";

            for (var j = 1; j <= n; ++j) {
                str += map[i * (n + 2) + j];
            }

            lines.push(str);
        }

        result.push(lines);
    }
};

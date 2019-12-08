/**
 * 72. Edit Distance
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
    let distances = [];
    
    for (let row = 0; row < word1.length + 1; ++ row) {
        distances.push(new Array(word2.length + 1));
    }
    
    for (let row = 0; row < word1.length + 1; ++ row) {
        distances[row][0] = row;
    }
    
    for (let column = 0; column < word2.length + 1; ++ column) {
        distances[0][column] = column;
    }
    
    for (let row = 1; row < word1.length + 1; ++ row) {
        for (let column = 1; column < word2.length + 1; ++ column) {
            if (word1[row - 1] === word2[column - 1]) {
                distances[row][column] = distances[row - 1][column - 1];
            } else {
                distances[row][column] = 1 + Math.min(
                    distances[row - 1][column],
                    distances[row][column - 1],
                    distances[row - 1][column - 1]);
            }
        }
    }
    
    return distances[word1.length][word2.length];
};

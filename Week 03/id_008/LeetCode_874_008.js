/**
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function(commands, obstacles) {
    var direction = "N";
    var obs = [];
    var x = 0;
    var y = 0;
    var max = 0;
    var distance = 0;

    for (var i = 0; i < obstacles.length; ++i) {
        if (typeof obs[obstacles[i][0]] === "undefined") {
            obs[obstacles[i][0]] = [];
        }

        obs[obstacles[i][0]][obstacles[i][1]] = 1;
    }

    for (var i = 0; i < commands.length; ++i) {
        if (commands[i] === -1) {
            switch (direction) {
                case "N": direction = "E"; break;
                case "E": direction = "S"; break;
                case "S": direction = "W"; break;
                case "W": direction = "N"; break;
            }
        }
        else if (commands[i] === -2) {
            switch (direction) {
                case "N": direction = "W"; break;
                case "W": direction = "S"; break;
                case "S": direction = "E"; break;
                case "E": direction = "N"; break;
            }
        }
        else {
            for (var j = 0; j < commands[i]; ++j) {
                if (direction === "N") {
                    if (isBlank(x, y + 1)) {
                        y += 1;
                    }
                }
                else if (direction === "S") {
                    if (isBlank(x, y - 1)) {
                        y -= 1;
                    }
                }
                else if (direction === "W") {
                    if (isBlank(x - 1, y)) {
                        x -= 1;
                    }
                }
                else if (direction === "E") {
                    if (isBlank(x + 1, y)) {
                        x += 1;
                    }
                }
            }

            distance = x * x + y * y;
            distance > max && (max = distance);
        }
    }

    return max;

    function isBlank(x, y){
        if (obs[x] && obs[x][y]) {
            return false;
        }

        return true;
    }
};

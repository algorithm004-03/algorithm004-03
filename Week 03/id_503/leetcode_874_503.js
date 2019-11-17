/**
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function (commands, obstacles) {
    const obstaclesMap = {};
    obstacles.forEach(o => {
        obstaclesMap[o[0] + "-" + o[1]] = true;
    });

    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    let x = y = dir = 0;

    let distance = 0;
    for (let i = 0; i < commands.length; i++) {

        switch (commands[i]) {
            case -2:
                dir = (dir + 3) % 4;
                break;
            case -1:
                dir = (dir + 1) % 4;
                break;
            default:
                let step = 0;

                while (step < commands[i]) {

                    const nextX = x + directions[dir][0];
                    const nextY = y + directions[dir][1];

                    const key = nextX + "-" + nextY;
                    if (obstaclesMap[key]) {
                        break;
                    }

                    x = nextX;
                    y = nextY;
                    step++;
                }
                const newDistance = x * x + y * y;
                distance = distance > newDistance ? distance : newDistance;
        }
    }

    return distance;
};
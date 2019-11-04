class Solution(object):
    def robotSim(self, commands, obstacles):
        """
        模拟机器人走路：https://leetcode-cn.com/problems/walking-robot-simulation/description/
        
        :type commands: List[int]
        :type obstacles: List[List[int]]
        :rtype: int
        """
        # dx,dy每个元素一一对应，顺序从0到4方向表示向右转command == -1，顺序从4到0方向表示向左转command == -2
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        obset = set([(v[0], v[1]) for v in obstacles]) # 等价于 obset = set(map(tuple, obstacles))
        
        # df表示目前dx,dy的下标
        x = y = di = 0
        result = 0
        for command in commands:
            if command == -1: # 右转90度,(di + 1) % 4
                di = (di + 1) % 4
            elif command == -2: # 左转90度,(di - 1) % 4
                di = (di - 1) % 4
            else: # 移动步数
                for i in range(1, command + 1):
                    if (x + dx[di], y + dy[di]) not in obset:
                        x += dx[di]
                        y += dy[di]
                    else:
                        break
                result = max(result, x * x + y * y)
        return result
                    
                    
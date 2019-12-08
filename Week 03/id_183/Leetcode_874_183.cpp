/*
 * @lc app=leetcode id=874 lang=cpp
 *
 * [874] Walking Robot Simulation
 */

// @lc code=start
class Solution {
public:
	int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
		int a = 0;//方向
		int x = 0;//机器人的x坐标
		int y = 0;//机器人的y坐标
		int maxn = 0;//最大欧式距离
        int mindes;//最近的障碍物某一坐标
        bool flag=false;//标志是否被障碍物挡住
		for (int i = 0; i < commands.size(); i++)
		{
            if(flag && commands[i]!=-1 && commands[i]!=-2)//被障碍物挡住，停止前进
                continue;
			if (commands[i] == -1)
			{
				a = (a + 1) % 4;
                flag=false;
				continue;
			}
			if (commands[i] == -2)
			{
				a = (a + 3) % 4;
                flag=false;
				continue;
			}
			int k = 0;
			if (a == 0)//北方向
			{
                mindes=INT_MAX;
				for (; k < obstacles.size(); k++)
				{
					if (obstacles[k][0] == x && obstacles[k][1]>y)
                    {
                        mindes=min(mindes,obstacles[k][1]);
                    }
				}
				if (mindes!=INT_MAX)
				{
					if (mindes > (y + commands[i]))
						y += commands[i];
					else
					{
						y = mindes - 1;
                        flag=true;
					}
				}
				else y += commands[i];
				maxn = max(maxn, x*x + y * y);
				continue;
			}
			if (a == 1)//东方向
			{
                mindes=INT_MAX;
				for (; k < obstacles.size(); k++)
				{
					if (obstacles[k][1] == y && obstacles[k][0]>x)
                    {
                        mindes=min(mindes,obstacles[k][0]);
                    }
				}
				if (mindes!=INT_MAX)
				{
					if (mindes > (x + commands[i]))
						x += commands[i];
					else
					{
						x = mindes - 1;
                        flag=true;
					}
				}
				else x += commands[i];
				maxn = max(maxn, x*x + y * y);
				continue;
			}
			if (a == 2)//南方向
			{
                mindes=INT_MIN;
				for (; k < obstacles.size(); k++)
				{
					if (obstacles[k][0] == x && obstacles[k][1]<y)
					{
                        mindes=max(mindes,obstacles[k][1]);
                    }
				}
				if (mindes!=INT_MIN)
				{
					if (mindes < (y - commands[i]))
						y -= commands[i];
					else
					{
						y = mindes + 1;
                        flag=true;
					}
				}
				else y -= commands[i];
				maxn = max(maxn, x*x + y * y);
				continue;
			}
			if (a == 3)//西方向
			{
                mindes=INT_MIN;
				for (; k < obstacles.size(); k++)
				{
					if (obstacles[k][1] == y && obstacles[k][0]<x)
					{
                        mindes=max(mindes,obstacles[k][0]);
                    }
				}
				if (mindes!=INT_MIN)
				{
					if (mindes < (x - commands[i]))
						x -= commands[i];
					else
					{
						x = mindes + 1;
                        flag=true;
					}
				}
				else x -= commands[i];
				maxn = max(maxn, x*x + y * y);
				continue;
			}
		}
		return maxn;
	}
};

// @lc code=end


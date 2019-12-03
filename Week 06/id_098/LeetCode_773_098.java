//最优解
/*
比较难想到的技术处理就是, 将二维矩阵转换为String, 然后根据字符串中0所在位置能交换的所有坐标进行交换
例如：123405中indexOfzero = 4, 那么这个点能够交换的坐标分别为[0, 1], [1,0], [1,2], 转换为一维后就是1, 3, 5

每一次搜索都获取下一层中能出现的所有情况存入队列
例如：123405 下一层交换后出现的所有情况为：103425 + 123045 + 123450, 每次poll时进行比较是否equals"123450"即可
 */
class Solution {
    public int slidingPuzzle(int[][] board) {
        Set<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        String E = "123450";
        char[] buff = new char[6];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                buff[i * 3 + j] = (char)(board[i][j] + (int)'0');
            }
        }
        String s = new String(buff);
        q.offer(s);
        visited.add(s);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                s = q.poll();
                //System.out.println(s);
                if (0 == s.compareTo(E)) return res;
                this.offer(q, s, visited);
            }
            ++res;
        }

        return -1;
    }

    private void offer(Queue<String> q, String s, Set<String> visited) {
        char[] buff = s.toCharArray();
        for (int i = 0; i < buff.length; i++) {
            if (buff[i] == '0') {
                int x = i / 3, y = i % 3;
                this.swap(q, buff, x, y, x - 1, y, visited);
                this.swap(q, buff, x, y, x + 1, y, visited);
                this.swap(q, buff, x, y, x, y - 1, visited);
                this.swap(q, buff, x, y, x, y + 1, visited);
                return;
            }
        }
    }

    private void swap(Queue<String> q, char[] buff, int x1, int y1,
                      int x2, int y2, Set<String> visited) {
        if (
                x1 < 0 || x1 > 1 || y1 < 0 || y1 > 2 ||
                        x2 < 0 || x2 > 1 || y2 < 0 || y2 > 2
        ) return;

        char t = buff[x1 * 3 + y1];
        buff[x1 * 3 + y1] = buff[x2 * 3 + y2];
        buff[x2 * 3 + y2] = t;
        String s = new String(buff);
        t = buff[x1 * 3 + y1];
        buff[x1 * 3 + y1] = buff[x2 * 3 + y2];
        buff[x2 * 3 + y2] = t;
        if (visited.contains(s)) return;
        q.offer(s);
        visited.add(s);
    }
}
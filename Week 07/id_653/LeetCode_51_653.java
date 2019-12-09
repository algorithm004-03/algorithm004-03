class Solution {
    private int size;
    private int count;
    private int n;
    List<List<String>> lists = new ArrayList<>();

    private void solve(int row, int ld, int rd,String str) {
        if (row == size) {
            count++;
            String [] res = str.split(",");

            ArrayList temps = new ArrayList();
            for (int i = 0; i < res.length; i++) {

                String format = String.format("%016d", Long.parseLong(res[i]));

                format = format.substring(format.length() - n).replace('1', 'Q').replace('0', '.');

                temps.add(format);
            }

            lists.add(temps);
            return;
        }
        int pos = size & (~(row | ld | rd));
//            System.out.println("pos: " + Integer.toBinaryString(pos));
        while (pos != 0) {
//                System.out.println("-pos: " + Integer.toBinaryString(-pos));

            int p = pos & (-pos);
            String s = Integer.toBinaryString(p);

            pos -= p; // pos &= pos - 1;
//                System.out.println("pos: " + Integer.toBinaryString(pos));
            if (str.length()>0) {
                s = s+","+str;
            }
            solve(row | p, (ld | p) << 1, (rd | p) >> 1,s);

        }
    }

    public List<List<String>> solveNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        this.n = n;
        solve(0, 0, 0,"");
        return lists;
    }
}
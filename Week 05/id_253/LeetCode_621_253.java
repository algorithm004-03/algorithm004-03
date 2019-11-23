// class Solution {
//     public int leastInterval(char[] tasks, int n) {
//         int[] map = new int[26];
//         for(char ch : tasks){
//             map[ch - 'A']++;
//         }
//         int time=0;
//         Arrays.sort(map);
//         while(map[25]>0){
//             int i =0 ;
//             while(i<=n){
//                 if(map[25] == 0) break;
//                 if(i<26 && map[25-i]>0) map[25-i]--;
//                 time++;
//                 i++;
//             }
//             Arrays.sort(map);
//         }
//         return time;
//     }
// }
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c : tasks){
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int prespace = map[25] - 1; int idlespace = prespace*n;
        for(int i =24 ; i >= 0 && map[i] > 0 ; i--){
            idlespace -= Math.min(prespace,map[i]);
        }
        return (idlespace> 0)? idlespace + tasks.length : tasks.length;
    }
}

//思路：可以用一个计数器表计算 s 字母的频率，用 t 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
// bool isAnagram(char * s, char * t){
//     int n = strlen(s);
//     int m = strlen(t);
//     if(n!=m)
//         return false;
//     int map[26]={0};
//     for(int i=0; i<n ;i++){
//         map[s[i]-'a']++;
//         map[t[i]-'a']--;
//         }
//     for(int i=0; i<26; i++){
//         if(map[i]!=0)
//             return false;
//     }
//     return true;
   

// }
//思路：
//1.首先判断两个字符串长度是否相等，不相等则直接返回 false；
//2.先排序，后判断是否相等
//编程经验：
//经验证c库函数中qsort为优化后，稳定的快排
int cmp(const void* a, const void* b){
    return *(char*)a - *(char*)b;
}

bool isAnagram(char * s, char * t){
    int n = strlen(s);
    int m = strlen(t);
    if(n!=m)
        return false;
    qsort(s,n,sizeof(char),cmp);
    qsort(t,n,sizeof(char),cmp);   
    printf("%s",s);
    printf("%s",t);
    if(strcmp(s,t))
        return false;
    else 
        return true;
    

}
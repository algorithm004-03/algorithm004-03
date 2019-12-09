/*
 * @lc app=leetcode id=1122 lang=cpp
 *
 * [1122] Relative Sort Array
 */

// @lc code=start
class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        
        int pool[1001] = {0};
        vector<int> output;
        
        for(int i=0; i<arr1.size(); i++){
            
            pool[arr1[i]]++;
        }
        
        for(int i=0; i<arr2.size(); i++){
            
            for(int j=0; j<pool[arr2[i]]; j++){
                
                output.push_back(arr2[i]);
            }
            
            pool[arr2[i]] = 0;
        }
        
        for(int i=0; i<1001; i++){
            
            while(pool[i]-->0){
                
                output.push_back(i);
            }
        }
        
        
        return output;
    }
};

// @lc code=end


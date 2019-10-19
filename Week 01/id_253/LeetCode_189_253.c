void rotate(int* nums, int numsSize, int k){
    int temp[numsSize];
    if(numsSize == 1){
        return ; 
    }
    for(int i=0;i<numsSize ; i++){
        temp[i]=nums[i];
    }
    if(numsSize > k){
      for(int i=0;i<numsSize-k ; i++){
        nums[i+k]=temp[i];
    }

        for(int i=numsSize-k;i<numsSize;i++){
        int j=i+k-numsSize;
        nums[j++]=temp[i];
    
    }  
    }
    else{
        do{ 
            k=k-numsSize;
        }while(k>numsSize);
        for(int i=0;i<numsSize-k ; i++){
        nums[i+k]=temp[i];
    }

        for(int i=numsSize-k;i<numsSize;i++){
        int j=i+k-numsSize;
        nums[j++]=temp[i];
    
    } 
    }
}

package main

func numDecodings(s string)int{
	pre,cur:=1,1
	if s[0:1]=="0"{
		return 0
	}
	for i:=1;i<len(s);i++{
		ttmp:=cur
		if s[i:i+1]=="0"{
			if s[i-1:i]=="1"||s[i-1:i]=="2"{
				cur=pre
			}else{
				return 0
			}
		}else if s[i-1:i]=="1"{
			cur=cur+pre
		}else if s[i-1:i]=="2"{
			if s[i:i+1]< "7"{
				cur=cur+pre
			}
		}
		pre=ttmp
	}
	return cur
}

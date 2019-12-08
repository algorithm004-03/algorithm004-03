//
//  Pown.swift
//  AlgorithmStudy

import Foundation

//50.Pow(x,n) 快速幂算法(递归)
func myPow(_ x: Double, _ n: Int) -> Double {
    var x = x, n = n
    if n<0{
        x = 1/x
        n = -n
    }
    return fastPow(x, n)
}
private func fastPow(_ x: Double, _ n:Int)->Double{
    if n == 0{
        return 1.0
    }
    let half:Double = fastPow(x, n/2)
    if n%2 == 0 {
        return half*half
    }else{
        return half*half*x
    }
}

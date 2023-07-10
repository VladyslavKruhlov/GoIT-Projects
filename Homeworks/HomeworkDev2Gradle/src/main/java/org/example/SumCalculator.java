package org.example;

public class SumCalculator {
    public int sum(int n){
        int sum =0;

        if (n > 0){
            for (int i=0; i <= n; i++){
                sum+=i;
            }
        }
        else {
            throw new IllegalArgumentException("Wrong argument");
        }
        return sum;
    }
}
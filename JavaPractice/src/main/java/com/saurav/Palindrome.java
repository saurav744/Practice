package com.saurav;

public class Palindrome {

    public static boolean isPalindrome(int num) {

        int copy = num>0 ? num : num*-1;
        int rev = 0;

        while(copy >0) {

            rev = rev*10 + copy%10;
            copy = copy/10;
        }

        if(rev == num || rev == num*-1)
            return true;
        else
            return false;
    }
}
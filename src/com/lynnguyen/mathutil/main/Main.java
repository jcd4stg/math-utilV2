 
package com.lynnguyen.mathutil.main;

import com.lynnguyen.mathutil.core.MathUtil;
 

public class Main {
    public static void main(String[] args) {
        //thử nghiệm hàm tính giai thừa coi chạy đúng như thiết kế hay ko
        //ta phải đưa các tình huống sử dụng hàm trong thực tế
        
        //TEST CASE: Một tình huống hàm/app/màn hình/tính năng đc đưa vào sử dụng
        //giả lập hành vi xài của ai đó!!!
        
        //data ĐẦU  VÀO CỤ THỂ NÀO ĐÓ
        //OUTPUT ĐẦU RA ỨNG VỚI XỬ LÍ CỦA HÀM/CHỨC NĂNG CỦA APP, DĨ NHIÊN
        //DÙNG ĐẦU VÀO ĐỂ XỬ LÍ
        
        long expected = 120; //tao kì vọng hàm ói về 120 nếu tính 5!
        int n = 0; //input test case
        long actual = MathUtil.getFactorial(n);
        System.out.println("5! = " + expected + " expected");
        //System.out.println("5! = " + actual + " actual");
    }
}

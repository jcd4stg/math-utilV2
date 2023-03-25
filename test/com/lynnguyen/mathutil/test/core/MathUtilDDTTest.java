
package com.lynnguyen.mathutil.test.core;

import com.lynnguyen.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//câu lệnh này của JUnit báo hiệu rằng sẽ cần loop qua tập data để lấy cặp
//data input/expected nhồi vào hàm test
@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {
   
   //ta trả về mảng 2 chiều gồm nhiều cặp Expected Input
    @Parameterized.Parameters
    public static Object[][] initData() {
      return new Integer[][] {
                                {0, 1},
                                {1, 1},
                                {2, 2},
                                {3, 6},
                                {4, 24},
                                {6, 620}
      }; 
   }
    
    //giả sử loop qa  từng dòng của mảng, ta vẫn cần gán từng value của cột
    //vào biến tương ứng input, expected để lát hồi feed cho hàm.
    
    @Parameterized.Parameter(value = 0) //value = 0 là map với mảng data
    public int n; //biến map với value của 0 của mảng
    
    @Parameterized.Parameter(value = 1)
    public long expected;
    
    @Test   
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        Assert.assertEquals(expected, MathUtil.getFactorial(n));
    }
    
    
}

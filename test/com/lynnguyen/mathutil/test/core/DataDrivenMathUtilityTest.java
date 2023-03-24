
package com.lynnguyen.mathutil.test.core;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import static com.lynnguyen.mathutil.core.MathUtil.getFactorial;

//DDT - data driven testing
@RunWith(value = Parameterized.class) //chơi tham số hoá
                                    //anotation
public class DataDrivenMathUtilityTest {
    
    
    //có bộ data r, chi cho JUnit biết cách lấy từng data với ý nghĩa gì
    //ví dụ mỗi dòng trong bộ data ứng 2 ý nghĩa
    //cột 0, là input cho hàm getF(input)
    //cột 1, là expected value, giá trị hàm getF() phải ói về
    //extract data sẽ thả vào biến, lát hồi biến đưa cho các hàm
    //quy ước là public, non-static
    @Parameter(value = 0)
    public int input; //ứng cột 0
    
    @Parameter(value = 1)
    public long expected; //ứng cột 1
    
    @Test //tự loop qa các bộ data trong hàm initData() ở dưới 
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        assertEquals(expected, getFactorial(input));
    }
    //mảng 2 chiều
    // cần có đầu vào, đầu ra
    //quy ước mảng 2 chiều này phải là static
    //Singleton - design patterns
    
    //extract/trích xuất 
    
    @Parameters
    public static Object[][] initData() {
        return new Integer[][] {
                                {0, 1},
                                {1, 1},
                                {3, 6},
                                {5, 120},
                                {7, 5040}
                               };//chuẩn bị bộ data trước 
                                //sau đó đưa cho hàm getF()
                                //                  assertEquals(1, ?)
                                //data driven testing
                                //OOP 
    }
    
    
}

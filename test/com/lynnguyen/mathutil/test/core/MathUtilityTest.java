package com.lynnguyen.mathutil.test.core;

import com.lynnguyen.mathutil.core.MathUtil;
import org.junit.Test;
import static com.lynnguyen.mathutil.core.MathUtil.getFactorial;
import org.junit.Assert;
import static org.junit.Assert.*;

public class MathUtilityTest {

    //Đây là class sẽ sử dụng các hàm của thư viện/framework JUnit
    //để kiểm tra code chính - hàm tínhGiaiThừa() bên class core.MathUtil
    //viết code để test code chính bên kia
    //có nhiều quy tắc đặt tên hàm kiểm thử
    //nhưng thường sẽ nói lên mục đích của các case/tình huống kiểm thử
    //tình huống xài hàm theo kiểu thành công và thất bại!!!
    //hàm dưới đây là tình huống test hàm chạy thành công, trả về ngon
    //ta sẽ xài hàm kiểu well - đưa 5!, 6!, hông chơi đưa -5!
    //@Test JUnit sẽ phối hợp với JVM để chạy hàm này
    //@Test phía hậu trường chính là public static void main()
    //Có nhiều @Test ứng với nhiều case khác nhau để kiểm thử hàm tính giai thừa
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        //cho giá trị đầu vào, kì vọng giá trị trả về
        int n = 0; //test thử tình huống đầu vào
        long expected = 1; //hi vong 0! = 1
        long actual = getFactorial(n);

        //so sánh expected vs actual dùng xanh xanh đỏ đỏ, framework
        assertEquals(expected, actual);
        //hàm giúp so sánh 2 giá trị nào đó có giống nhau hay ko
        //nếu giống nhau -> thảy màu xanh đèn đường - đường thông, code ngon
        //                  ít nhất cho case đang test
        //thảy màu đỏ đèn đường -> nếu không giống nhau
        //hàm ý expected và actual không giống nhau

        //gộp thêm vài case thành công/đưa đầu vào ngon!!! hàm phải tính ngon
        assertEquals(1, getFactorial(1)); //tui muốn 1! == 1
        assertEquals(2, getFactorial(2)); // 2! == 2
        assertEquals(6, getFactorial(3)); // 3! == 6
        assertEquals(24, getFactorial(4)); //4! ==24
        assertEquals(120, getFactorial(5)); //5! = 120
        assertEquals(720, getFactorial(6)); //6! = 720
    }

    //hàm getF()ta thiết kế có 2 tình huống xử lí
    //1. đưa data tử tế trong [0..20] -> tình huống đúng dc n! -> done
    //2. đưa data cà chớn, âm, > 20, thiết kế của hàm là ném ra ngoại lệ
    //TAO KÌ VỌNG NGOẠI LỆ XUẤT HIỆN KHI N < 0 || N > 20
    //rất mong ngoại lệ xuất hiện với n cà chớn này
    //hàm chạy đúng như thiết kế -> xanh phải xuất hiện
    //nếu hàm nhận vào n > 0 hoặc n < 20 và hàm k ném ra ngoại lệ
    //sure, hàm chạy sai thiết kế, sai kì vọng, màu đỏ
    //Test case
    //input: -5 
    //expected: IllegalArgumentException xuất hiện
    //tình huống bất thường, ngoại lệ, ngoài dự tính, dự liệu
    //là những thứ ko thể so sánh theo kiểu value
    //mà chỉ có thể đo lường = cách chúng có xuất hiện hay ko
    //logic: assertEquals() ko dùng so sánh 2 ngoại lệ 
    //equals() là bằng nhau hay không trên value!!!!
    //màu đỏ đó  em, do hàm đúng là có ném ngoại lê thực sự
    //nhưng không phải là ngoại lệ như kì vọng - thực sự kì vọng sai
    ////ko phải hàm ném sai
    
//    //@Test(expected = NumberFormatException.class)
//    public void testGetFactorialGivenWrongArgumentThrowException() {
//        MathUtil.getFactorial( -5);
//        //hàm @Test chạy, hay getF() chạy   
//        //sẽ ném về ngoại lệ NumberFormat...
//    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGivenWrongArgumentThrowException() {
        getFactorial(-5);
    }

    //cách khác để bắt ngoại lệ xuất hiện, viết tự nhiên hơn!!!
    //hàm sẽ ném về ngoại lệ nếu nhận về 21
    @Test
    public void testGetFactorialGivenWrongArgumentThrowException_LambdaVersion() {
        
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
        // getFactorial( -5);   

    }

    //bắt ngoại lệ, xem hàm có ném về ngoại lệ hay ko khi n cà chớn
    //có ném, tức là hàm chạy đúng thiết kế -> xanh
    @Test
    public void testGetFactorialGivenWrongArgumentThrowException_TryCatch() {
        //chủ động kiểm soát ngoại lệ!!!
        try {
            MathUtil.getFactorial(-5);

        } catch (Exception e) {
            //bắt try catch là JUnit ra xanh do đã chủ động kiểm soát ngoại lệ
            //nhưng ko chắc ngoại lệ mình cần có xuất hiện ko?
            //có đoạn code kiểm soát đúng ngoại lệ IllegalArgumenException xuất hiện
            Assert.assertEquals("Invalid argument. "
                                               + "N must be between 0 and 20", e.getMessage());
        }
    }

}

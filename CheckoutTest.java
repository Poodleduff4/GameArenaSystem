import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class CheckoutTest {

    @Test
    void verifyEmailTest(){
        boolean ans = true;
        boolean fans = false;
        boolean val, val1, val2, val3;
        String email0 = "Banwait_Gurman@outlook.com";
        String email1 = "bruh@gmail.com";
        String email2 = "cruh.com";
        String email3 = "bruhski@";
        Checkout emailCheck = new Checkout();
        val = emailCheck.verifyEmail(email0);
        val1 = emailCheck.verifyEmail(email1);
        val2 = emailCheck.verifyEmail(email2);
        val3 = emailCheck.verifyEmail(email3);
        assertEquals(ans, val);
        assertEquals(ans, val1);
        assertEquals(fans, val2);
        assertEquals(fans, val3);
    }

    @Test
    void verifyPaymentTest() {
        Checkout paymentCheck = new Checkout();
        boolean ans = true;
        boolean fans = false;
        boolean val0, val1, val2, val3;
        String card0 = "1111111111111111"; //16 1's
        String card1 = "1111111111111"; // 13 1's
        String card2 = "1234567890123456"; // 16
        String card3 = "63527"; //5
        val0 = paymentCheck.verifyPayment(card0);
        val1 = paymentCheck.verifyPayment(card1);
        val2 = paymentCheck.verifyPayment(card2);
        val3 = paymentCheck.verifyPayment(card3);
        assertEquals(ans, val0);
        assertEquals(fans, val1);
        assertEquals(ans, val2);
        assertEquals(fans, val3);
    }

    @Test
    void verifyCVVTest() {
        Checkout cvvCheck = new Checkout();
        boolean ans = true;
        boolean fans = false;
        boolean val0, val1, val2, val3, val4, val5;
        String cvv0 = "344"; //T
        String cvv1 = "23"; //F
        String cvv2 = ""; //F
        String cvv3 = "2343"; //F
        String cvv4 = "040"; //T
        String cvv5 = "abc"; //F
        val0 = cvvCheck.verifyCVV(cvv0);
        val1 = cvvCheck.verifyCVV(cvv1);
        val2 = cvvCheck.verifyCVV(cvv2);
        val3 = cvvCheck.verifyCVV(cvv3);
        val4 = cvvCheck.verifyCVV(cvv4);
        val5 = cvvCheck.verifyCVV(cvv5);
        assertEquals(ans, val0);
        assertEquals(fans, val1);
        assertEquals(fans, val2);
        assertEquals(fans, val3);
        assertEquals(ans, val4);
        assertEquals(fans, val5);
    }

    @Test
    void verifyMonthTest() {
        Checkout monthCheck = new Checkout();
        boolean ans = true;
        boolean fans = false;
        boolean val0, val1, val2, val3, val4, val5;
        String m0 = "01"; //T
        String m1 = "04"; //T
        String m2 = " 05"; //F
        String m3 = "11"; //T
        String m4 = "21"; // F
        String m5 = "ab"; //F
        val0 = monthCheck.verifyMonth(m0);
        val1 = monthCheck.verifyMonth(m1);
        val2 = monthCheck.verifyMonth(m2);
        val3 = monthCheck.verifyMonth(m3);
        val4 = monthCheck.verifyMonth(m4);
        val5 = monthCheck.verifyMonth(m5);
        assertEquals(ans, val0);
        assertEquals(ans, val1);
        assertEquals(fans, val2);
        assertEquals(ans, val3);
        assertEquals(fans, val4);
        assertEquals(fans, val5);
    }

    @Test
    void verifyYearTest() {
        Checkout yearCheck = new Checkout();
        boolean ans = true;
        boolean fans = false;
        boolean val0, val1, val2, val3, val4;
        int y0 = 2023; //T
        int y1 = 2024; //T
        int y2 = 2022; //F
        int y3 = 1999; //F
        int y4 = 2025; //T
        val0 = yearCheck.verifyYear(y0);
        val1 = yearCheck.verifyYear(y1);
        val2 = yearCheck.verifyYear(y2);
        val3 = yearCheck.verifyYear(y3);
        val4 = yearCheck.verifyYear(y4);
        assertEquals(ans, val0);
        assertEquals(ans, val1);
        assertEquals(fans, val2);
        assertEquals(fans, val3);
        assertEquals(ans, val4);
    }

    @Test
    void verifyName() {
        Checkout nameCheck = new Checkout();
        boolean ans = true;
        boolean fans = false;
        boolean val0, val1, val2, val3, val4;
        String n0 = "Gurman Banwait"; //T
        String n1 = "Bruh"; //F
        String n2 = "Nick Bruh"; //T
        String n3 = "Luke"; //F
        String n4 = "Gurman  Banwait";// F
        val0 = nameCheck.verifyName(n0);
        val1 = nameCheck.verifyName(n1);
        val2 = nameCheck.verifyName(n2);
        val3 = nameCheck.verifyName(n3);
        val4 = nameCheck.verifyName(n4);
        assertEquals(ans, val0);
        assertEquals(fans, val1);
        assertEquals(ans, val2);
        assertEquals(fans, val3);
        assertEquals(fans, val4);
    }
}
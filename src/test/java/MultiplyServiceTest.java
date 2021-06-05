import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyServiceTest {

    @Test
    void multiplyBigInteger() {
        assertEquals("0", MultiplyService.multiplyBigInteger("0", "99999999999"));
        assertEquals("0", MultiplyService.multiplyBigInteger("99999999999", "0"));
        assertEquals("Wrong input values", MultiplyService.multiplyBigInteger("asd", "123"));
        assertEquals("Wrong input values", MultiplyService.multiplyBigInteger("0", "asd"));
        assertEquals("1416126708052945721046460926137362916", MultiplyService.multiplyBigInteger("324535757856785678676576556346", "4363546"));
        assertEquals("-1416126708052945721046460926137362916", MultiplyService.multiplyBigInteger("-324535757856785678676576556346", "4363546"));
        assertEquals("100", MultiplyService.multiplyBigInteger("10", "10"));
    }


    @Test
    void trimMinus() {
        assertEquals("10", MultiplyService.trimMinus("10"));
        assertEquals("10", MultiplyService.trimMinus("-10"));
    }

    @Test
    void isResultPositive() {
        assertTrue(MultiplyService.isResultPositive("10", "10"));
        assertFalse(MultiplyService.isResultPositive("-10", "10"));
        assertFalse(MultiplyService.isResultPositive("10", "-10"));
        assertTrue(MultiplyService.isResultPositive("-10", "-10"));
    }

    @Test
    void getArrayFromString() {
        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] result = MultiplyService.getArrayFromString("12345");
        assertArrayEquals(expected, result);
    }

    @Test
    void multiplyNative() {
        assertEquals("0", MultiplyService.multiplyNative("0", "99999999999"));
        assertEquals("0", MultiplyService.multiplyNative("99999999999", "0"));
        assertEquals("Wrong input values", MultiplyService.multiplyNative("asd", "123"));
        assertEquals("Wrong input values", MultiplyService.multiplyNative("0", "asd"));
        assertEquals("1416126708052945721046460926137362916", MultiplyService.multiplyNative("324535757856785678676576556346", "4363546"));
        assertEquals("-1416126708052945721046460926137362916", MultiplyService.multiplyNative("-324535757856785678676576556346", "4363546"));
        assertEquals("100", MultiplyService.multiplyNative("10", "10"));
    }
}
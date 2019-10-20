package junit;

import com.prometheus.crypto.impl.AESImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestAES {

    AESImpl aes = new AESImpl();

    @Test
    public void testEncryption() throws Exception{

        byte[] input = new byte[]{
                (byte)0x32,(byte)0x43,(byte)0xf6,(byte)0xa8,
                (byte)0x88,(byte)0x5a,(byte)0x30,(byte)0x8d,
                (byte)0x31,(byte)0x31,(byte)0x98,(byte)0xa2,
                (byte)0xe0,(byte)0x37,(byte)0x07,(byte)0x34};

        byte[] key = new byte[]{
                (byte)0x2b,(byte)0x7e,(byte)0x15,(byte)0x16,
                (byte)0x28,(byte)0xae,(byte)0xd2,(byte)0xa6,
                (byte)0xab,(byte)0xf7,(byte)0x15,(byte)0x88,
                (byte)0x09,(byte)0xcf,(byte)0x4f,(byte)0x3c};

        byte[] encrypted = aes.encrypt(input, key);

        byte[] expected = new byte[] {
                (byte)0x39,(byte)0x25,(byte)0x84,(byte)0x1d,
                (byte)0x02,(byte)0xdc,(byte)0x09,(byte)0xfb,
                (byte)0xdc,(byte)0x11,(byte)0x85,(byte)0x97,
                (byte)0x19,(byte)0x6a,(byte)0x0b,(byte)0x32
        };

        Assert.assertArrayEquals(expected, encrypted);

        byte[] decrypted = aes.decrypt(encrypted, key);

        Assert.assertArrayEquals(input, decrypted);

    }

    @Test
    public void testInverse() {

        int number = 0x53;
        int expectedInv = 0xca;

        int inv = aes.inverse((byte)number);

        Assert.assertTrue((byte)inv == (byte)expectedInv);

    }

    @Test
    public void testKeyExpansion() {

        byte[] cipherKey = {(byte)0x2b,(byte)0x7e,(byte)0x15,(byte)0x16,
                            (byte)0x28,(byte)0xae,(byte)0xd2,(byte)0xa6,
                            (byte)0xab,(byte)0xf7,(byte)0x15,(byte)0x88,
                            (byte)0x09,(byte)0xcf,(byte)0x4f, (byte)0x3c};

        byte[][] expansion = aes.keyExpansion(cipherKey);

        byte[][] expectedExpansion = {
                {(byte)0x2b,(byte)0x7e,(byte)0x15,(byte)0x16},
                {(byte)0x28,(byte)0xae,(byte)0xd2,(byte)0xa6},
                {(byte)0xab,(byte)0xf7,(byte)0x15,(byte)0x88},
                {(byte)0x09,(byte)0xcf,(byte)0x4f, (byte)0x3c},
                {(byte)0xa0,(byte)0xfa, (byte)0xfe, (byte)0x17},
                {(byte)0x88,(byte)0x54, (byte)0x2c, (byte)0xb1},
                {(byte)0x23,(byte)0xa3, (byte)0x39, (byte)0x39},
                {(byte)0x2a,(byte)0x6c, (byte)0x76, (byte)0x05},
                {(byte)0xf2,(byte)0xc2, (byte)0x95, (byte)0xf2},
                {(byte)0x7a,(byte)0x96, (byte)0xb9, (byte)0x43},
                {(byte)0x59,(byte)0x35, (byte)0x80, (byte)0x7a},
                {(byte)0x73,(byte)0x59, (byte)0xf6, (byte)0x7f},
                {(byte)0x3d,(byte)0x80, (byte)0x47, (byte)0x7d},
                {(byte)0x47,(byte)0x16, (byte)0xfe, (byte)0x3e},
                {(byte)0x1e,(byte)0x23, (byte)0x7e, (byte)0x44},
                {(byte)0x6d, (byte)0x7a, (byte)0x88, (byte)0x3b},
                {(byte)0xef, (byte)0x44, (byte)0xa5, (byte)0x41},
                {(byte)0xa8, (byte)0x52, (byte)0x5b, (byte)0x7f},
                {(byte)0xb6, (byte)0x71, (byte)0x25, (byte)0x3b},
                {(byte)0xdb, (byte)0x0b, (byte)0xad, (byte)0x00},
                {(byte)0xd4, (byte)0xd1, (byte)0xc6, (byte)0xf8},
                {(byte)0x7c, (byte)0x83, (byte)0x9d, (byte)0x87},
                {(byte)0xca, (byte)0xf2, (byte)0xb8, (byte)0xbc},
                {(byte)0x11, (byte)0xf9, (byte)0x15, (byte)0xbc},
                {(byte)0x6d, (byte)0x88, (byte)0xa3, (byte)0x7a},
                {(byte)0x11, (byte)0x0b, (byte)0x3e, (byte)0xfd},
                {(byte)0xdb, (byte)0xf9, (byte)0x86, (byte)0x41},
                {(byte)0xca, (byte)0x00, (byte)0x93, (byte)0xfd},
                {(byte)0x4e, (byte)0x54, (byte)0xf7, (byte)0x0e},
                {(byte)0x5f, (byte)0x5f, (byte)0xc9, (byte)0xf3},
                {(byte)0x84, (byte)0xa6, (byte)0x4f, (byte)0xb2},
                {(byte)0x4e, (byte)0xa6, (byte)0xdc, (byte)0x4f},
                {(byte)0xea, (byte)0xd2, (byte)0x73, (byte)0x21},
                {(byte)0xb5, (byte)0x8d, (byte)0xba, (byte)0xd2},
                {(byte)0x31, (byte)0x2b, (byte)0xf5, (byte)0x60},
                {(byte)0x7f, (byte)0x8d, (byte)0x29, (byte)0x2f},
                {(byte)0xac, (byte)0x77, (byte)0x66, (byte)0xf3},
                {(byte)0x19, (byte)0xfa, (byte)0xdc, (byte)0x21},
                {(byte)0x28, (byte)0xd1, (byte)0x29, (byte)0x41},
                {(byte)0x57, (byte)0x5c, (byte)0x00, (byte)0x6e},
                {(byte)0xd0, (byte)0x14, (byte)0xf9, (byte)0xa8},
                {(byte)0xc9, (byte)0xee, (byte)0x25, (byte)0x89},
                {(byte)0xe1, (byte)0x3f, (byte)0x0c, (byte)0xc8},
                {(byte)0xb6, (byte)0x63, (byte)0x0c, (byte)0xa6}
        };

        Assert.assertTrue(Arrays.deepEquals(expansion, expectedExpansion));
    }

    @Test
    public void testAddRoundKey() {

        byte[][] inputState = new byte[][] {
                {(byte)0x32,(byte)0x88,(byte)0x31,(byte)0xe0},
                {(byte)0x43,(byte)0x5a,(byte)0x31,(byte)0x37},
                {(byte)0xf6,(byte)0x30,(byte)0x98,(byte)0x07},
                {(byte)0xa8,(byte)0x8d,(byte)0xa2,(byte)0x34}
        };

        byte[][] roundKey = new byte[][] {
                {(byte)0x2b,(byte)0x28,(byte)0xab,(byte)0x09},
                {(byte)0x7e,(byte)0xae,(byte)0xf7,(byte)0xcf},
                {(byte)0x15,(byte)0xd2,(byte)0x15,(byte)0x4f},
                {(byte)0x16,(byte)0xa6,(byte)0x88,(byte)0x3c}
        };

        byte[][] result = aes.addRoundKey(inputState, roundKey);

        byte[][] expectedResultState = new byte[][] {
                {(byte)0x19,(byte)0xa0,(byte)0x9a,(byte)0xe9},
                {(byte)0x3d,(byte)0xf4,(byte)0xc6,(byte)0xf8},
                {(byte)0xe3,(byte)0xe2,(byte)0x8d,(byte)0x48},
                {(byte)0xbe,(byte)0x2b,(byte)0x2a,(byte)0x08}
        };

        Assert.assertTrue(Arrays.deepEquals(result, expectedResultState));
    }

    @Test
    public void testSubBytes() {

        byte[][] inputState = new byte[][] {
                {(byte)0x19,(byte)0xa0,(byte)0x9a,(byte)0xe9},
                {(byte)0x3d,(byte)0xf4,(byte)0xc6,(byte)0xf8},
                {(byte)0xe3,(byte)0xe2,(byte)0x8d,(byte)0x48},
                {(byte)0xbe,(byte)0x2b,(byte)0x2a,(byte)0x08}
        };

        byte[][] result = aes.subBytes(inputState, false);

        byte[][] expectedResultState = new byte[][] {
                {(byte)0xd4,(byte)0xe0,(byte)0xb8,(byte)0x1e},
                {(byte)0x27,(byte)0xbf,(byte)0xb4,(byte)0x41},
                {(byte)0x11,(byte)0x98,(byte)0x5d,(byte)0x52},
                {(byte)0xae,(byte)0xf1,(byte)0xe5,(byte)0x30}
        };

        Assert.assertTrue(Arrays.deepEquals(result, expectedResultState));

        byte[][] inverse = aes.subBytes(result, true);
        Assert.assertTrue(Arrays.deepEquals(inverse, inputState));
    }


    @Test
    public void testShiftRows() {

        byte[][] inputState = new byte[][] {
                {(byte)0xd4,(byte)0xe0,(byte)0xb8,(byte)0x1e},
                {(byte)0x27,(byte)0xbf,(byte)0xb4,(byte)0x41},
                {(byte)0x11,(byte)0x98,(byte)0x5d,(byte)0x52},
                {(byte)0xae,(byte)0xf1,(byte)0xe5,(byte)0x30}
        };

        byte[][] result = aes.shiftRows(inputState, false);

        byte[][] expectedResultState = new byte[][] {
                {(byte)0xd4,(byte)0xe0,(byte)0xb8,(byte)0x1e},
                {(byte)0xbf,(byte)0xb4,(byte)0x41,(byte)0x27},
                {(byte)0x5d,(byte)0x52,(byte)0x11,(byte)0x98},
                {(byte)0x30,(byte)0xae,(byte)0xf1,(byte)0xe5}
        };

        Assert.assertTrue(Arrays.deepEquals(result, expectedResultState));

        byte[][] invShift = aes.shiftRows(result, true);

        Assert.assertTrue(Arrays.deepEquals(invShift, inputState));
    }

    @Test
    public void testMixColumns() {

        byte[][] inputState = new byte[][] {
                {(byte)0xd4,(byte)0xe0,(byte)0xb8,(byte)0x1e},
                {(byte)0xbf,(byte)0xb4,(byte)0x41,(byte)0x27},
                {(byte)0x5d,(byte)0x52,(byte)0x11,(byte)0x98},
                {(byte)0x30,(byte)0xae,(byte)0xf1,(byte)0xe5}
        };

        byte[][] result = aes.mixColumns(inputState, false);

        byte[][] expectedResultState = new byte[][] {
                {(byte)0x04,(byte)0xe0,(byte)0x48,(byte)0x28},
                {(byte)0x66,(byte)0xcb,(byte)0xf8,(byte)0x06},
                {(byte)0x81,(byte)0x19,(byte)0xd3,(byte)0x26},
                {(byte)0xe5,(byte)0x9a,(byte)0x7a,(byte)0x4c}
        };

        Assert.assertTrue(Arrays.deepEquals(result, expectedResultState));

        byte[][] inverse = aes.mixColumns(result, true);
        Assert.assertTrue(Arrays.deepEquals(inverse, inputState));
    }

    @Test
    public void testPolynomialMultiplication() {

        String poly1 = "00000001";
        String poly2 = "00000010";

        String expectedProduct = "10";

        int product = aes.multiplyPolynomials((byte)Integer.parseInt(poly1,2), (byte)Integer.parseInt(poly2, 2));

        Assert.assertTrue(product == Integer.parseInt(expectedProduct,2));
    }

    @Test
    public void testPolynomialDivisionMod() {

        String poly = "11111101111110";
        String mod = "100011011";

        int quotient = aes.polynomialMod(Integer.parseInt(poly,2), Integer.parseInt(mod,2));

        int expected = 1;

        Assert.assertTrue(quotient == expected);

    }


}

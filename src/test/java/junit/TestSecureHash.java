package junit;

import com.prometheus.crypto.impl.SecureHash;
import com.prometheus.crypto.impl.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class TestSecureHash {


    SecureHash secureHash = new SecureHash(SecureHash.Algorithm.SHA512);

    @Test
    public void testSecureHash256SingleBlock() throws Exception {

        String input = "abc";

        long[] expectedLongs = {0xDDAF35A193617ABAL, 0xCC417349AE204131L, 0x12E6FA4E89A97EA2L, 0x0A9EEEE64B55D39AL,
                                0x2192992A274FC1A8L, 0x36BA3C23A3FEEBBDL, 0x454D4423643CE80EL, 0x2A9AC94FA54CA49FL};

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        for(long l : expectedLongs) {
            bos.write(Utils.longToBytes(l));
        }

        byte[] expectedHash = bos.toByteArray();

        byte[] hash = secureHash.getHashSha512(input.getBytes());

        Assert.assertArrayEquals(expectedHash, hash);
    }

    @Test
    public void testSecureHash256MultiBlock() throws Exception {

        String input = "abcdefghbcdefghicdefghijdefghijkefghijklfghijklmghijklmnhijklmnoijklmnopjklmnopqklmnopqrlmnopqrsmnopqrstnopqrstu";

        long[] expectedLongs = {0x8E959B75DAE313DAL, 0x8CF4F72814FC143FL, 0x8F7779C6EB9F7FA1L, 0x7299AEADB6889018L,
                        0x501D289E4900F7E4L, 0x331B99DEC4B5433AL, 0xC7D329EEB6DD2654L, 0x5E96E55B874BE909L};

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        for(long l : expectedLongs) {
            bos.write(Utils.longToBytes(l));
        }

        byte[] expectedHash = bos.toByteArray();

        byte[] hash = secureHash.getHashSha512(input.getBytes());

        Assert.assertArrayEquals(expectedHash, hash);

    }


}

package algorithms.tests;

import algorithms.KMP;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class KMPTest {

    @Test
    public void testKMPBasic() {
        KMP kmp = new KMP();
        List<Integer> result = kmp.search("ababcabcabababd", "ababd");
        assertEquals(List.of(10), result);
    }

    @Test
    public void testKMPNoMatch() {
        KMP kmp = new KMP();
        List<Integer> result = kmp.search("abcdef", "xyz");
        assertTrue(result.isEmpty());
    }
}


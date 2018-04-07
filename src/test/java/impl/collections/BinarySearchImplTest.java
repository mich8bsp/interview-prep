package impl.collections;

import impl.algo.BinarySearchImpl;
import org.junit.Assert;
import org.junit.Test;

import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinarySearchImplTest {

    @Test
    public void testBothImpl(){
        int[] arr = IntStream.range(0, 1_000_000).toArray();

        Assert.assertEquals(-1, BinarySearchImpl.findIter(-4, arr));
        Assert.assertEquals(-1, BinarySearchImpl.findIter(2_000_000, arr));
        Assert.assertEquals(-1, BinarySearchImpl.findRecursive(-4, arr));
        Assert.assertEquals(-1, BinarySearchImpl.findRecursive(2_000_000, arr));


        Assert.assertEquals(300_000, BinarySearchImpl.findIter(300_000, arr));
        Assert.assertEquals(300_000, BinarySearchImpl.findRecursive(300_000, arr));

        Assert.assertEquals(700_000, BinarySearchImpl.findIter(700_000, arr));
        Assert.assertEquals(700_000, BinarySearchImpl.findRecursive(700_000, arr));

        arr[5]=4;
        Assert.assertEquals(-1, BinarySearchImpl.findIter(5, arr));
        Assert.assertEquals(-1, BinarySearchImpl.findRecursive(5, arr));
    }
}

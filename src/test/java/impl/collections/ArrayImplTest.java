package impl.collections;

import impl.collections.ArrayImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayImplTest {

    private ArrayImpl<Integer> arr;

    @Before
    public void clean(){
        arr = new ArrayImpl<>();
    }

    @Test
    public void testArrayCreation(){
        Assert.assertNotNull(arr);
    }

    @Test
    public void testSizeAndEmpty(){
        Assert.assertEquals(0, arr.size());
        Assert.assertEquals(16, arr.capacity());
        Assert.assertTrue(arr.isEmpty());
    }

    @Test
    public void testInsertAboveCapacity(){
        int oldCapacity = arr.capacity();
        for(int i=0;i<oldCapacity+5;i++){
            arr.insert(i, 4);
        }

        Assert.assertEquals(oldCapacity + 5, arr.size());
        Assert.assertEquals(oldCapacity * 2, arr.capacity());
    }
}

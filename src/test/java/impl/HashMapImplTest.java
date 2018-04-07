package impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class HashMapImplTest {

    private Map<Integer, Integer> map;

    @Before
    public void init(){
        map = new HashMapImpl<>();
    }

    @Test
    public void testPutSameHash(){
        Assert.assertEquals(0, map.size());
        Assert.assertTrue(map.isEmpty());

        map.put(3,4);
        Assert.assertEquals(1, map.size());

        map.put(5, 2);
        Assert.assertEquals(2, map.size());
        map.put(3, 2);
        Assert.assertEquals(2, map.size());
    }

    @Test
    public void testRemove(){
        map.put(3,4);
        Assert.assertEquals(1, map.size());
        map.remove(3);
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void testResize(){
        for(int i=0;i<17;i++){
            map.put(i+1,4);
        }
    }
}

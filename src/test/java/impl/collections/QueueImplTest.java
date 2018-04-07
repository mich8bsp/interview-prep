package impl.collections;

import impl.collections.QueueArrayImpl;
import impl.collections.QueueListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueImplTest {

    private QueueListImpl<Integer> listImpl;
    private QueueArrayImpl<Integer> arrImpl;

    @Before
    public void clean(){
        listImpl = new QueueListImpl<>();
        arrImpl = new QueueArrayImpl<>();
    }

    @Test
    public void testInit(){
        Assert.assertNotNull(listImpl);
        Assert.assertNotNull(arrImpl);
    }

    @Test
    public void testEnqueueDequeue(){
        Assert.assertTrue(listImpl.isEmpty());
        Assert.assertTrue(arrImpl.isEmpty());

        for(int i=0;i<10;i++) {
            listImpl.enqueue(55);
            arrImpl.enqueue(55);
        }
        for(int i=0;i<6;i++) {
            listImpl.dequeue();
            arrImpl.dequeue();
        }

        for(int i=0;i<10;i++) {
            listImpl.enqueue(55);
            arrImpl.enqueue(55);
        }

        Assert.assertEquals(14, listImpl.size());
        Assert.assertEquals(14, arrImpl.size());
    }

    @Test
    public void testArrImplReachLimit(){
        for(int i=0;i<16;i++){
            arrImpl.enqueue(4);
        }
        Assert.assertTrue(arrImpl.isFull());
        try{
            arrImpl.enqueue(34);
            Assert.fail();
        }catch (Exception e){

        }
    }

}

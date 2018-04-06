package impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CircularBufferTest {

    private CircularBuffer<Integer> buffer;

    @Before
    public void clean(){
        buffer = new CircularBuffer<>();
    }

    @Test
    public void testReadWrite() throws IOException {
        for(int i=0;i<15;i++){
            buffer.write(33);
        }

        //prevent overwriting
        try{
            buffer.write(3);
            Assert.fail();
        }catch (Exception e){

        }
        for(int i=0;i<5;i++){
            buffer.read();
        }

        buffer.write(353);

        for(int i=0;i<11;i++){
            buffer.read();
        }

        try{
            buffer.read();
            Assert.fail();
        }catch (Exception e){

        }

    }

}

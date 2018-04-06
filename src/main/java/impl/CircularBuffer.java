package impl;

import java.io.IOException;

public class CircularBuffer<T> {

    private Object[] buffer;
    private int writeIndex = 0;
    private int readIndex = 0;

    public CircularBuffer(){
        this(16);
    }

    public CircularBuffer(int size) {
        buffer = new Object[size];
    }

    private int relativeIndex(int index){
        return (index>=0 ? index : index + buffer.length) % buffer.length;
    }

    public void write(T value) throws IOException {
        if(relativeIndex(writeIndex) == relativeIndex(readIndex - 1)){
            throw new IOException();
        }
        buffer[writeIndex] = value;
        writeIndex = relativeIndex(writeIndex+1);
    }

    public T read() throws IOException {
        if(relativeIndex(readIndex)==relativeIndex(writeIndex)){
            throw new IOException();
        }
        T value = (T) buffer[readIndex];
        readIndex = relativeIndex(readIndex + 1);
        return value;
    }
}

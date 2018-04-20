package ctci.queuestack;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Q3_6_AnimalShelter {

    private abstract class Animal{}
    private class Dog extends Animal{}
    private class Cat extends Animal{}

    private Queue<Dog> dogsQueue = new LinkedList<>();
    private Queue<Long> dogsQueueArrivalTime = new LinkedList<>();
    private Queue<Cat> catsQueue = new LinkedList<>();
    private Queue<Long> catsQueueArrivalTime = new LinkedList<>();

    public void enqueue(Dog dog){
        dogsQueue.add(dog);
        dogsQueueArrivalTime.add(System.currentTimeMillis());
    }

    public void enqueue(Cat cat){
        catsQueue.add(cat);
        catsQueueArrivalTime.add(System.currentTimeMillis());
    }

    public Animal dequeueAny(){
        if(dogsQueue.isEmpty() && catsQueue.isEmpty()){
            return null;
        }
        long lastDogArrival = Optional.ofNullable(dogsQueueArrivalTime.peek()).orElse(Long.MAX_VALUE);
        long lastCatArrival = Optional.ofNullable(catsQueueArrivalTime.peek()).orElse(Long.MAX_VALUE);

        if(lastCatArrival < lastDogArrival){
            catsQueueArrivalTime.poll();
            return catsQueue.poll();
        }else{
            //bias towards dogs if arrived at same time - but it's ok since dogs are better
            dogsQueueArrivalTime.poll();
            return dogsQueue.poll();
        }
    }

    public Dog dequeueDog(){
        if(dogsQueue.isEmpty()){
            return null;
        }
        dogsQueueArrivalTime.poll();
        return dogsQueue.poll();
    }

    public Cat dequeueCat(){
        if(catsQueue.isEmpty()){
            return null;
        }
        catsQueueArrivalTime.poll();
        return catsQueue.poll();
    }
}

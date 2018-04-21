package ctci.oop.Q7_2_CallCenter;

public abstract class Employee {

    protected boolean isFree = true;

    public abstract void receiveCall(Call call) throws Exception;

    public boolean handleCall(Call call){
        //call handling logic

        return true;
    }
}

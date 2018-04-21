package ctci.oop.Q7_2_CallCenter;

public class Director extends Employee {

    @Override
    public void receiveCall(Call call) throws Exception {
        if(!isFree){
            throw new Exception("Director busy");
        }
        handleCall(call);
    }
}

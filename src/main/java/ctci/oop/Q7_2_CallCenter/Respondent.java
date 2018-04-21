package ctci.oop.Q7_2_CallCenter;

public class Respondent extends Employee {

    private Employee manager;

    public Respondent(Employee manager) {
        this.manager = manager;
    }

    @Override
    public void receiveCall(Call call) throws Exception {
        if(!isFree){
            throw new Exception("Line is busy");
        }
        isFree = false;
        try {
            if(!handleCall(call)){
                manager.receiveCall(call);
            }
        } finally {
            isFree = true;
        }
    }


}

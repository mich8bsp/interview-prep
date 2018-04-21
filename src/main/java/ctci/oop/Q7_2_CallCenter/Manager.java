package ctci.oop.Q7_2_CallCenter;

public class Manager extends Employee {

    private Employee supervisor;

    public Manager(Employee supervisor){
        this.supervisor = supervisor;
    }

    @Override
    public void receiveCall(Call call) throws Exception {
        if(!isFree){
            supervisor.receiveCall(call);
        }
        isFree= false;
        try {
            boolean handledCall = handleCall(call);
            if (!handledCall) {
                supervisor.receiveCall(call);
            }
        }finally {
            isFree=true;
        }
    }
}

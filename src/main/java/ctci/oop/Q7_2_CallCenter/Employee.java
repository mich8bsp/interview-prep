package ctci.oop.Q7_2_CallCenter;

public abstract class Employee {

    protected Employee supervisor;
    protected boolean isFree = true;

    public void receiveCall(Call call) throws Exception{
        isFree = false;
        try {
            if(!handleCall(call)){
                isFree = true;
                Employee supervisor = getSupervisor();
                if(supervisor==null){
                    throw new Exception("Couldn't get supervisor, hang up");
                }
                supervisor.receiveCall(call);
            }
        } finally {
            isFree = true;
        }
    }

    protected Employee getSupervisor(){
        return supervisor;
    }

    public boolean handleCall(Call call){
        //call handling logic

        return true;
    }
}

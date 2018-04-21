package ctci.oop.Q7_2_CallCenter;

import java.util.*;

public class CallCenter {
    private List<Employee> respondents = new LinkedList<>();

    public void dispatchCall(Call call){
        Optional<Employee> respondentForHandling = respondents.stream()
                .filter(x->x.isFree)
                .findAny();

        try {
            respondentForHandling.orElse(respondents.get(0)).receiveCall(call);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

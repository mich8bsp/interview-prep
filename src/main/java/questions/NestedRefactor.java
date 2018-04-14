package questions;

import java.util.function.Supplier;

public class NestedRefactor {

    public boolean succeeded(boolean isSucceded){
        return isSucceded;
    }

    public boolean operation1(){
        return true;
    }

    public boolean operation2(){
        return true;
    }

    public boolean operation3(){
        return true;
    }

    public boolean operation4(){
        return true;
    }
    enum OPER_RESULT{
        S_OK,
        OPERATION1FAILED,
        OPERATION2FAILED,
        OPERATION3FAILED,
        OPERATION4FAILED
    }

    public OPER_RESULT toRefactor(){
        OPER_RESULT error = OPER_RESULT.S_OK;

        if(succeeded(operation1())){
            if(succeeded(operation2())){
                if(succeeded(operation3())) {
                    if (succeeded(operation4())) {

                    } else {
                        error = OPER_RESULT.OPERATION4FAILED;
                    }
                }else{
                    error = OPER_RESULT.OPERATION3FAILED;
                }
            }else{
                error = OPER_RESULT.OPERATION2FAILED;
            }
        }else{
            error = OPER_RESULT.OPERATION1FAILED;
        }
        return error;
    }

    private OPER_RESULT runOnSuccess(OPER_RESULT prevResult, Supplier<Boolean> operation, OPER_RESULT operationErrorCode){
        return prevResult == OPER_RESULT.S_OK ? (succeeded(operation.get()) ? OPER_RESULT.S_OK : operationErrorCode) : prevResult;
    }

    public OPER_RESULT refactored(){
        OPER_RESULT error = OPER_RESULT.S_OK;
        error = runOnSuccess(error, this::operation1, OPER_RESULT.OPERATION1FAILED);
        error = runOnSuccess(error, this::operation2, OPER_RESULT.OPERATION2FAILED);
        error = runOnSuccess(error, this::operation3, OPER_RESULT.OPERATION3FAILED);
        error = runOnSuccess(error, this::operation4, OPER_RESULT.OPERATION4FAILED);
        return error;
    }
}

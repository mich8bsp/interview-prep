package questions;

public class Formatter {

    class Service{
        public String askForPermission(){
            return "OK";
        }
    }

    private Service service;

    public Formatter(Service service) {
        this.service = service;
    }

    public String doTheJob(String theInput) {
        String response = service.askForPermission();
        switch (response) {
            case "FAIL":
                return "error";
            case "OK":
                return String.format("%s%s", theInput, theInput);
            default:
                return null;
        }
    }

    enum Permission{
        OK, FAIL;

        public boolean isPermissionGranted(){
            return this == Permission.OK;
        }
    }

    private String getErrorCode(String input){
        return "error";
    }

    private String handleInput(String input){
        return String.format("%s%s", input, input);
    }

    public String doTheJobRefactored(String theInput){
        Permission permission = Permission.valueOf(service.askForPermission());
        return permission.isPermissionGranted() ? handleInput(theInput) : getErrorCode(theInput);
    }
}

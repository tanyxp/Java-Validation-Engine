/**
 * Created by Nathaniel on 2/3/2016.
 */
public class ValidationResult implements IValidationResult {
    public boolean pass = false;
    public String message = "";

    public boolean passes(){
        return pass;
    }

    public String getMessage(){
        return message;
    }
}

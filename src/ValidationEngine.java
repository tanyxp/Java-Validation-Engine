/**
 * Created by Nathaniel on 2/3/2016.
 */
public class ValidationEngine implements IValidationEngine {
    public IValidationResult validate(String value, String[] validationTags){
        ValidationResult result = new ValidationResult();
        double minValue = 1;
        double maxValue = 3.5;
        if(validationTags.length > 0){
            for (String tag: validationTags) {
                switch (tag){
                    case "money":
                        //Testing to see if value has only two decimal places
                        if(!value.matches("^[0-9-]+(\\.[0-9]{1,2})?$")){
                            result.pass = false;
                            result.message = "Value is not a valid monetary value";
                        }
                        else{
                            result.pass = true;
                            result.message = "Value is valid";
                        }
                        break;
                    case "factor":
                        //checking for alpha in string
                        if(!value.matches("^[0-9-.]+$")){
                            result.pass = false;
                            result.message = "Value is not a valid decimal number";
                        }
                        else{
                            result.pass = true;
                            result.message = "Value is valid";
                        }
                        break;
                    case "notEmpty":
                        //checking for null and empty
                        if("".equalsIgnoreCase(value) || value == null){
                            result.pass = false;
                            result.message = "Value cannot be empty";
                        }
                        else{
                            result.pass = true;
                            result.message = "Value is valid";
                        }
                        break;
                    case "notNegative":
                        //checking for negative number
                        try{
                            double doubleValue = Double.parseDouble(value);
                            if(doubleValue < 0){
                                result.pass = false;
                                result.message = "Value is negative";
                            }
                            else{
                                result.pass = true;
                                result.message = "Value is valid";
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        break;
                    case "withinModLimits":
                        //try to convert string to double
                        try{
                            double doubleValue = Double.parseDouble(value);
                            if(!(doubleValue >= minValue && doubleValue <= maxValue)){
                                result.pass = false;
                                result.message = "Value is not within limits for a mod factor";
                            }
                            else{
                                result.pass = true;
                                result.message = "Value is valid";
                            }
                        //catch error if string contained something that's not a number
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        break;
                    case "allAlpha":
                        //checking for all alpha chars
                        if(!value.matches("^[a-zA-Z]+$")){
                            result.pass = false;
                            result.message = "Value has non alphabetic characters";
                        }
                        else{
                            result.pass = true;
                            result.message = "Value is valid";
                        }
                        break;
                    case "firstLetterUpperOnly":
                        //checking for only first char uppercase
                        if(value != null && value != "" ? !Character.isUpperCase(value.charAt(0)) : true){
                            result.pass = false;
                            result.message = "Value's first letter is not uppercase";
                        }
                        else{
                            result.pass = true;
                            result.message = "Value is valid";
                        }
                        break;
                }//end switch
            }//end for loop
        }//end if
        return result;
    }//end method
}//end class

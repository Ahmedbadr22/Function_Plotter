package validate;


import utils.Helper;

/**
 * @author Ahmed Badr Abdeldayem
 */

// Text Input Validation Class 
public class InputValidator {
    /*
    *   Validate The Equation TextField  
    *   1. IF User Enter Nothing The Function Will Alert Him To Enter Equation
    *   2. IF User Enter Space In The Equation The Function Will Alert Him To Remove Space
    *   3. IF User Enter Function Don't in The Term Of X it Alerts Him To Enter Equation in Terms Of X
    **/
    public static boolean isValidEquation(String equation){
        boolean isValid = false;
        // Check If Empty Or Have Space in The String
        if(!equation.isEmpty() && !equation.contains(" ")){
            // Check If The Equation i Term Of X 
            if(equation.contains("x") || equation.contains("X")){
                isValid = true;
            }else{
                // Alert To Enter Equation in Terms of X
                Helper.showWarningDialog("Equation Must be in term of 'x' ");
            }
        }else{
            // Check If The Wrong is That There is No Equation Entered Or There is Empty Space In The Function
            if(equation.contains(" ")){
                // Alert To Enter Equation Without Empty Spaces
                Helper.showWarningDialog("You Must Enter Equation Without Space");
            } else{
                // Alert To Enter Equation 
                Helper.showWarningDialog("You Must Enter Equation");
            }
        }
        return isValid;
    }
    
    /*
    *    Validate The Max and min Value Of X TextField Form 
    *   1. IF User Enter Nothing The Function Will Alert Him To Enter The Value
    *   2. IF User Enter letters in the max or mini  textField Alert Him To Enter Digits 
    *   3. IF User Enter The biggest value in min X text Field and The smallest value in Max TextField Alert Him To Enter Value in Right Place
    */
    public static boolean isValidMaxAndMinValue(String maxText, String minText){
        boolean isValid = false;
        // check If max or min textField is Empty or not
        if(!maxText.isEmpty() && !minText.isEmpty()){
            boolean maxHaveChar = maxText.matches(".*[a-z].*");
            boolean minHaveChar = minText.matches(".*[a-z].*");

            if(!maxHaveChar && !minHaveChar){
                float maxVal = Float.parseFloat(maxText);
                float minVal = Float.parseFloat(minText);
                
                if(maxVal > minVal){
                    isValid = true;
                }else{
                    Helper.showWarningDialog("X min Cant be Greater Than X max");
                }
            }else{
                // check if the max X Value Contain letters or Characters or not if there is letter alert him to enter only digits
                if(!maxHaveChar){
                    Helper.showWarningDialog("X max Value Must Contain Only Digits");
                }else{
                    // check if the min X Value Contain letters or Characters or not if there is letter alert him to enter only digits
                    Helper.showWarningDialog("X min Value Must Contain Only Digits");
                }
            }
        }else{
            // check if the max is empty alert user to enter value
            if(maxText.isEmpty()){
                Helper.showWarningDialog("You Must Enter The Maximum Value of x ");
            }else{
                // check if the min is empty alert user to enter value
                Helper.showWarningDialog("You Must Enter Minimum Value of x");
            }
        }
        return isValid;
    }
    
    // this function to check if all the input are valid or not
    public static boolean isAllInputValid(
            String equation,
            String maxText,
            String minText
    ){
        return isValidEquation(equation) && isValidMaxAndMinValue(maxText, minText);
    }
}

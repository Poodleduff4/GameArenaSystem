import java.util.regex.Pattern;

public class Checkout {



    public boolean verifyEmail(String email){ //Verifys the email entered by the user using a regex expression to ensure that there is an @ symbol and a . symbol for the domain
        String emailRegex = "[A-Za-z0-9].*@[A-Za-z0-9].*\\.[A-z].*";
        Pattern bruh = Pattern.compile(emailRegex);
        if (email == null){
            return false;
        }
        return bruh.matcher(email).matches();
    }

    public boolean verifyPayment(String cardNum){ //Verifys if the card number entered by the user is a valid 16 digit code. Loops through the string and ensures every index is a digit and then ensures that there are 16 digits.
        // Standard 16 digit card number. No spaces in between.
        int trueCard = 0;
        for(int i=0; i<cardNum.length(); i++){
            if(Character.isDigit(cardNum.charAt(i))){
                trueCard+=1;
            }
        }
        if (trueCard != 16) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verifyCVV(String CVV) { // 3 digit CVV number on the back of the card. No spaces in between. Uses the same principles as verifyPayment()
        int trueCVV = 0;
        for (int i=0; i<CVV.length(); i++){
            if (Character.isDigit(CVV.charAt(i))){
                trueCVV+=1;
            }
        }
        if (trueCVV != 3){
            return false;
        } else{
            return true;
        }
    }

    public boolean verifyMonth(String month) {  // MM EX: 1, 2, .., 11, 12    //Checks if the expiration month of the users credit card is a valid month.
        if (month.equals("01")){
            return true;
        } else if (month.equals("02")) {
            return true;
        } else if (month.equals("03")) {
            return true;
        } else if (month.equals("04")) {
            return true;
        } else if (month.equals("05")) {
            return true;
        } else if (month.equals("06")) {
            return true;
        } else if (month.equals("07")) {
            return true;
        } else if (month.equals("08")) {
            return true;
        } else if (month.equals("09")) {
            return true;
        } else if (month.equals("10")) {
            return true;
        } else if (month.equals("11")) {
            return true;
        } else if (month.equals("12")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyYear(int year) {  // YYYY  //Checks the expiration year of the users credit card. Loops through the string and ensures that there are 4 digits in the year and it is greater than 2022. 
        String yearString = String.valueOf(year);
        if (yearString.length() != 4) {
            return false;
        } else if (year <= 2022) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verifyName(String name){ //Ensures that the first and last name of the user are typed using regex. Regex checks the first letter is capitalized for first and last name and ensures that there is a space in between.
        String nameRegex = "[A-Z].*[a-z]\s[A-Z].*[a-z]";
        Pattern bruhskii = Pattern.compile(nameRegex);
        if (name == null){
            return false;
        }
        return bruhskii.matcher(name).matches();
    }
}
import java.util.regex.Pattern;

public class Checkout {

    public boolean emailTicket(){
        return false;
    }

    public boolean verifyEmail(String email){
        String emailRegex = "[A-Za-z0-9].*@[A-Za-z0-9].*\\.[A-z].*";
        Pattern bruh = Pattern.compile(emailRegex);
        if (email == null){
            return false;
        }
        return bruh.matcher(email).matches();
    }

    public boolean verifyPayment(String cardNum){
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

    public boolean verifyCVV(int CVV){ // 3 digit CVV number on the back of the card. No spaces in between.
        int trueCVV = 0;
        while (CVV != 0){
            CVV = CVV / 10;
            trueCVV+=1;
        }
        if (trueCVV != 3){
            return false;
        } else {
            return true;
        }
    }

    public boolean verifyMonth(int month){  // MM EX: 1, 2, .., 11, 12
        int trueMonth = 0;
        while (month != 0){
            month = month / 10;
            trueMonth+=1;
        }
        if (trueMonth != 2){
            return false;
        } else if (month >= 13) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verifyYear(int year) {  // YYYY
        String yearString = String.valueOf(year);
        if (yearString.length() != 4) {
            return false;
        } else if (year <= 2022) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verifyName(String name){
        String nameRegex = "[A-Z].*[a-z]\s[A-Z].*[a-z]";
        Pattern bruhskii = Pattern.compile(nameRegex);
        if (name == null){
            return false;
        }
        return bruhskii.matcher(name).matches();
    }
    
    public void generateTickets() throws Exception{
        for (Ticket ticket :
                GameArenaSystem.cart.getCartItems()) {
            TicketGenerator.generateTicket(ticket);
        }
    }

   /*
    old code if needed
    public boolean verifyYear(int year){  // YYYY
        int trueYear = 0;
        while (year != 0){
            year = year / 10;
            trueYear+=1;
        }
        if (trueYear != 4){
            return false;
        } else if (year <= 2022) {
            return false;
        } else {
            return true;
        }
    } */

}
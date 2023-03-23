
public class Checkout {
    public boolean printTicket(){
        // Function to generate and print ticket, might need another class later
        return false;
    }

    public boolean emailTicket(){
        return false;
    }

    public boolean verifyEmail(String email){
        return false;
    }

    public boolean verifyPayment(int cardNum){   // Standard 16 digit card number. No spaces in between.
        int trueCard = 0;
        while (cardNum != 0){
            cardNum = cardNum / 10;
            trueCard+=1;
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
    }



}
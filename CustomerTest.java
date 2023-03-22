import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
class CustomerTest {
    public static boolean validEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern bruh = Pattern.compile(emailRegex);
        if (email == null){
            return false;
        }
        return bruh.matcher(email).matches();
    }

    public static void main(String[] args){
        ArrayList<String> addy = new ArrayList<>();
        addy.add("bruhski@gmail.com");
        addy.add("croskii.yahoo.gov");
        addy.add("cronem@outlook.com");
        addy.add("broskii@torontomu.ca");

        for (String i : addy) {
            if (validEmail(i))
                System.out.println(i + "  yes");
            else
                System.out.println(i + "  no");
        }
    }

}
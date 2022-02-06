import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        String regex = "(^[^ ][a-zA-z0-9а-яА-яёЁ]*\\s{1}[a-zA-z0-9а-яА-яёЁ]*[^ ]$)";

        if (Pattern.matches(regex,name)) {
            if (name.length() > 2 && name.length() < 20) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelperClass {

    public ResourceBundle messages;
    private Scanner scan = new Scanner(System.in);

    public HelperClass() {
        messages = ResourceBundle.getBundle("messages");
    }

    public String getMessage(String key) {
        return messages.getString(key);
    }

    public int readUserChoice(String[] options) {
        System.out.println("\n" + messages.getString("menu.selectOption"));
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i - 1]);
        }
        return scan.nextInt();
    }

    public String[] buildOptions() {
        return new String[]{
                messages.getString("menu.addItem"),
                messages.getString("menu.removeItem"),
                messages.getString("menu.getTotal"),
                messages.getString("menu.changeLanguage"),
                messages.getString("menu.exit")
        };
    }

    public void setLocale(String lang) {
        messages = Local.getBundle(lang);
    }


}

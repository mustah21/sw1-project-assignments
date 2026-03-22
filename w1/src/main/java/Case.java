import java.util.Scanner;
import java.util.ResourceBundle;


public class Case {

    private final HelperClass helper = new HelperClass();
    private final ShoppingCart shoppingCart = new ShoppingCart();
    private final Scanner scan = new Scanner(System.in);


    public void userAction() {

        System.out.print("Choose language/valitse kieli/välja språk/言語を選択してください (en/fi/sv/ja): ");
        String lang = scan.nextLine();
        helper.setLocale(lang);


        String[] options = helper.buildOptions();
        int choice;

        do {
            choice = helper.readUserChoice(options);
            switch (choice) {
                case 1:
                    scan.nextLine();
                    System.out.println(helper.getMessage("prompt.itemName"));
                    String itemName = scan.nextLine();

                    System.out.print(helper.getMessage("prompt.itemPrice"));
                    int price = scan.nextInt();

                    System.out.print(helper.getMessage("prompt.itemQuantity"));
                    int quantity = scan.nextInt();


                    shoppingCart.addItem(itemName, new Item(price, quantity));
                    break;

                case 2:
                    scan.nextLine();
                    System.out.println(helper.getMessage("prompt.removeItem"));
                    String removeItem = scan.nextLine();

                    shoppingCart.removeItem(removeItem);

                    break;

                case 3:
                    int totalBill = shoppingCart.getTotalBill();
                    System.out.println(helper.getMessage("total.bill") + " " + totalBill);
                    break;

                case 4:
                    scan.nextLine();
                    System.out.print(helper.getMessage("prompt.chooseLanguage"));
                    String lang2 = scan.nextLine();
                    helper.setLocale(lang2);
                    options = helper.buildOptions();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println(helper.getMessage("error.invalidChoice"));
            }
        } while (choice != 5);

    }


}

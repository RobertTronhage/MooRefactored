import java.util.Scanner;

public class SystemIO implements IO{
    private Scanner scanner;

    public SystemIO() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public boolean yesNo(String prompt) {
        System.out.print(prompt + " (yes/no): ");
        String response = scanner.nextLine().toLowerCase();
        return response.equals("yes");
    }

    @Override
    public String getString() {
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    @Override
    public void addString(String s) {
        System.out.println("Added string: " + s);
    }

    @Override
    public void clear() {
        // Implement clearing console screen if needed
        System.out.println("Console cleared.");
    }

    @Override
    public void exit() {
        System.out.println("Exiting the application.");
        System.exit(0);
    }

    public static void main(String[] args) {
        IO console = new SystemIO();

        // Example usage
        boolean response = console.yesNo("Do you want to continue?");
        System.out.println("User response: " + response);

        String inputString = console.getString();
        System.out.println("User entered: " + inputString);

        console.addString("Hello, world!");

        console.clear();

        console.exit();
    }
}

import com.github.javafaker.Faker;

public class Praktikum {

    public static void main(String[] args) {

        Faker faker = new Faker();

        String name = faker.name().fullName();

        Account account = new Account(name);

        if (account.checkNameToEmboss()) {
            System.out.println("\nName is valid: " + name);
        } else {
            System.out.println("\nName is not allowed: " + name);
        }

    }

}
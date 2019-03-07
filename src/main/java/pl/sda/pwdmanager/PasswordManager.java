package pl.sda.pwdmanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * ctrl + Q
 * ALT + ENTER
 */
public abstract class PasswordManager {
    protected List<String> generatePasswords = new ArrayList<>();

    public String generatePassword(int lengthPassword) {
        Random random = new Random();                   // klasa służana do generowania liczb
        String password = random.ints(65, 123)
                .limit(lengthPassword)
                .mapToObj(number -> String.valueOf((char) number))
                .collect(Collectors.joining());        // generujemy stream intów
        generatePasswords.add(password);
        return password;
    }

    public abstract void persist();         // persist - trwać

    public abstract Collection<String> read();  // read - czytaj
}

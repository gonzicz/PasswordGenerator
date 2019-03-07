package pl.sda.pwdmanager;

import java.nio.charset.Charset;
import java.nio.file.Paths;

public class Example {
    public static void main(String[] args) {
        PasswordManager passwordManager = new TextFilePasswordManager(Paths.get("Files","passwords.txt"),Charset.forName("UTF-8"));
       // System.out.println(passwordManager.generatePassword(10));
        for (int i = 0; i <10 ; i++) {
            passwordManager.generatePassword(10);
        }
        passwordManager.persist();
       // passwordManager.read().forEach(p-> System.out.println(p));
        passwordManager.read().forEach(System.out::println);
    }
}

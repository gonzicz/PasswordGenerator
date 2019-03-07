package pl.sda.pwdmanager;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Collection;

public class TextFilePasswordManager extends PasswordManager {

    private Path pathToFile;
    private Charset charset;

    public TextFilePasswordManager(Path pathToFile, Charset charset) {
        this.pathToFile = pathToFile;
        this.charset = charset;
    }

    // ta metoda zapisuje nam hasła do pliku
    @Override
    public void persist() {
        try {
            Files.write(pathToFile, generatePasswords, charset);
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Błąd zapisu - failed to persist generated password. Cannot write to the " +
                            "passwords file: %s", pathToFile), e);

        }
    }

    @Override
    public Collection<String> read() {
        try {
            return Files.readAllLines(pathToFile, Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Błąd odzytu - failed to read password from file : %s", pathToFile), e);
        }
    }
}

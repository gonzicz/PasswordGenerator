package pl.sda.pwdmanager;

import java.util.Collection;

public class InMemoryPasswordManager extends PasswordManager {
    @Override
    public void persist() {

    }

    @Override
    public Collection<String> read() {
        return generatePasswords;
    }
}

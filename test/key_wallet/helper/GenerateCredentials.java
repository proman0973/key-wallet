package key_wallet.helper;

import key_wallet.core.Database;
import key_wallet.core.MasterPassword;
import key_wallet.core.MasterPasswordException;
import key_wallet.crypto.AESEncryption;
import key_wallet.data.Credential;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class GenerateCredentials {
    @Test
    public void generateCredentials() throws MasterPasswordException, IOException, ParseException {
        File dataFile = new File("secret.kw");

        if (dataFile.exists()) {
            dataFile.delete();
        }

        MasterPassword mp = new MasterPassword("1chtrinkenurBIER", new AESEncryption());

        Database db = new Database(dataFile, mp);
        db.clearCredentials();

        db.addCredential(new Credential("Google", "", "max.mustermann@gmail.com", "m@xThaGangs1a", "https://google.de", "Website"));
        db.addCredential(new Credential("GMail", "", "max.mustermann@gmail.com", "m@xThaGangs1a", "https://mail.google.de", "Email"));
        db.addCredential(new Credential("Moodle", "", "max.mustermann@student.dhbw-karlsruhe.de", "m@xThaGangs1a", "https://moodle.dhbw.de", "Other"));

        db.update();
    }
}

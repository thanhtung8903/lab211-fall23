import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class EBank {

    private Locale locale;

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    public String getMessage(String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("language", locale);
        return resourceBundle.getString(key);
    }

    public String checkAccount(String accountNumber) {
        if (!accountNumber.matches("^[0-9]{10}$")) {
            return getMessage("accountError");
        }
        return null;
    }

    public String checkPassword(String password) {
        if (!password.matches("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{8,31}$")) {
            return getMessage("passwordError");
        }
        return null;
    }

    public String generateCaptcha() {
        char[] charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        Random rd = new Random();
        StringBuilder captcha = new StringBuilder();
        for (int i = 1; i <= 6; i++) {
            int randomIndexCharSet = rd.nextInt(charSet.length);
            captcha.append(charSet[randomIndexCharSet]);
        }
        return captcha.toString();
    }

    public String checkCaptcha(String captchaGenerate, String captchaInput) {
        if (!captchaGenerate.contains(captchaInput) || captchaInput.length() == 0) {
            return getMessage("captchaError");
        }
        return null;
    }
}

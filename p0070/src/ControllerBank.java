import java.util.Locale;

public class ControllerBank {

    Validation v = new Validation();

    public void login(Locale locale) {
        EBank eb = new EBank();
        eb.setLocale(locale);
        System.out.print(eb.getMessage("account"));
        String account = v.inputString();
        while (eb.checkAccount(account) != null) {
            System.err.println(eb.getMessage("accountError"));
            System.out.print(eb.getMessage("account"));
            account = v.inputString();
        }
        
//        EBank eb1 = new EBank();
//        eb1.setLocale(new Locale("vi"));

        System.out.print(eb.getMessage("password"));
        String password = v.inputString();
        while (eb.checkPassword(password) != null) {
            System.err.println(eb.getMessage("passwordError"));
            System.out.print(eb.getMessage("password"));
            password = v.inputString();
        }
        String captcha = eb.generateCaptcha();
        System.out.println(eb.getMessage("captcha") + captcha);
        System.out.print(eb.getMessage("captchaInput"));
        String captchaInput = v.inputString().trim();
        while (eb.checkCaptcha(captcha, captchaInput) != null) {
            System.err.println(eb.getMessage("captchaError"));
            System.out.print(eb.getMessage("captchaInput"));
            captchaInput = v.inputString().trim();
        }
        System.out.println(eb.getMessage("loginSuccess"));
    }
}

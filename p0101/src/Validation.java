
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Date;

public class Validation {

    private Scanner sc = new Scanner(System.in);

    public int inputInteger(String msg, int min, int max) {
        int n;
        while (true) {
            System.out.print(msg);
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Invalid, try again");
            }
        }
    }

    public double inputDouble(String msg, double min, double max) {
        double n;
        while (true) {
            System.out.print(msg);
            try {
                n = Double.parseDouble(sc.nextLine().trim());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Invalid, try again");
            }
        }
    }
    
     public double inputDoubleUpdate(String msg, double min, double max) {
        double n;
        while (true) {
            System.out.print(msg);
            try {
                String s = sc.nextLine().trim();
                if (s.isEmpty()) {
                    return -1;
                }
                n = Double.parseDouble(s);
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Invalid, try again");
            }
        }
    }

    public String inputString(String msg, String regex) {
        String s;
        while (true) {
            System.out.print(msg);
            try {
                s = sc.nextLine();
                if (!s.matches(regex)) {
                    throw new Exception();
                }
                return s;
            } catch (Exception e) {
                System.err.println("Invalid, try again");
            }
        }
    }

    public String inputDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Date date;
        LocalDateTime current = LocalDateTime.now();
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine().trim();
            try {
                date = sdf.parse(s);
            } catch (Exception e) {
                System.err.println("Invalid, try again");
                continue;
            }
            String[] dob = s.split("/");
            int yearDob = Integer.parseInt(dob[2]);
            if ((current.getYear() - yearDob) < 18 || ((current.getYear()) - yearDob) > 60) {
                System.err.println("Employee only 18 to 60 year old");
                continue;
            }
            return s;
        }
    }
    
    public String inputDateUpdate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Date date;
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine().trim();
            if (s.isEmpty()) {
                return s;
            }
            try {
                date = sdf.parse(s);
            } catch (Exception e) {
                System.err.println("Invalid, try again");
                continue;
            }
            String[] dob = s.split("/");
            if (Integer.parseInt(dob[2]) < 1963 || Integer.parseInt(dob[2]) > 2005) {
                System.err.println("Employee only 18 to 60 year old");
                continue;
            }
            return s;
        }
    }

    public String intputSex(String msg) {
        String s;
        while (true) {
            System.out.print(msg);
            try {
                s = sc.nextLine().trim();
                if (s.equalsIgnoreCase("Male") || s.equalsIgnoreCase("female")) {
                    return s.toUpperCase();
                }
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid, try again");
            }
        }
    }
    
    public String intputSexUpdate(String msg) {
        String s;
        while (true) {
            System.out.print(msg);
            try {
                s = sc.nextLine().trim();
                if (s.isEmpty()) {
                    return s;
                }
                if (s.equalsIgnoreCase("Male") || s.equalsIgnoreCase("female")) {
                    return s.toUpperCase();
                }
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid, try again");
            }
        }
    }

}

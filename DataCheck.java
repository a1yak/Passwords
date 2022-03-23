package Passwords;

import java.util.Scanner;

public class DataCheck
{
    private static String password;
    private static String login;
    private static String confirmPassword;

    public  static void Start()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your Login and Password (they can only contain English letters, numbers and symbol ' _ '\nLogin: ");
        login = scan.nextLine();
        System.out.println("Password: ");
        password = scan.nextLine();
        System.out.println("Confirm your password");
        confirmPassword=scan.nextLine();
        Checker(login,password,confirmPassword);
    }
    public static void Checker(String login, String password, String confirmPassword)
    {
        try
        {
            if (login.length()>20)
            {
                throw new WrongLoginException("Login is too long (max 20 symbols)");
            }
            if (password.length()>20)
            {
                throw new WrongPasswordException("Password is too long (max 20 symbols)");
            }
            if (password.compareTo(confirmPassword)!=0)
            {
                throw new WrongPasswordException("Password and Confirmed password are not the same");
            }
            for(int i=0;i<login.length();i++)
            {
                if((login.charAt(i) < 48||login.charAt(i)>57)&&(login.charAt(i) < 65||login.charAt(i)>90)&&(login.charAt(i) < 97||login.charAt(i)>122)&&(login.charAt(i)!=95))
                {
                    throw new WrongLoginException("Invalid Login (it can only contain English letters, numbers and symbol ' _ '");
                }
            }
            for(int i=0;i<password.length();i++)
            {
                if((password.charAt(i) < 48||password.charAt(i)>57)&&(password.charAt(i) < 65||password.charAt(i)>90)&&(password.charAt(i) < 97||password.charAt(i)>122)&&(password.charAt(i)!=95))
                {
                    throw new WrongPasswordException("Invalid Password (it can only contain English letters, numbers and symbol ' _ '");
                }
            }
        }
        catch(WrongLoginException exc)
        {
            System.out.println(exc);
            newLogin();
        }
        catch (WrongPasswordException ex)
        {
            System.out.println(ex);
            newPassword();
        }
    }
    public static void newLogin()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new login: ");
        login= sc.nextLine();;
        Checker(login, password, confirmPassword);

    }
    public static void newPassword()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new password: ");
        password = sc.nextLine();
        System.out.println("Confirm your password: ");
        confirmPassword = sc.nextLine();
        Checker(login, password, confirmPassword);
    }
    public static void Print()
    {
        System.out.println("Login: "+login+"\nPassword: "+password);
    }
}

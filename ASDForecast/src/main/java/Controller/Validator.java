/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nayoon
 */
public class Validator implements Serializable {
    private static String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private static String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    private static String passwordPattern = "([a-z]{4,})([0-9]*)";
    private static String integerPattern = "[0-9]*";
    private static String adminKeyPattern="^[a-zA-Z]*$";
    
    public Validator() {}
    
    public static boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }
    
    public static boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }
    
    public static boolean validateName (String name) {
        return validate(namePattern, name);
    }
    
    public static boolean validatePassword (String password) {
        return validate(passwordPattern, password);
    }
    
    public static boolean validateInteger (String integer) {
        return validate(integerPattern, integer);
    }
    
    public static boolean validateAdminKey (String adminKey) {
        return validate(adminKeyPattern, adminKey);
    }
    
    
    public static void clear(HttpSession session) {
        session.setAttribute("emailErr", "Enter Email");
        session.setAttribute("passErr", "Enter Password");
        session.setAttribute("existErr", "");
        session.setAttribute("nameErr", "Enter Name");
        session.setAttribute("intErr", null);
        session.setAttribute("adminKeyErr", "Enter Admin Key");
    }
    
}

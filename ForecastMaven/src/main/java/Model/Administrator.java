/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author Nayoon
 */
public class Administrator {
    private int adminId;
    private String adminPassword, email, firstname, lastname;

    public Administrator(int adminId, String adminPassword, String email, String firstname, String lastname) {
        this.adminId = adminId;
        this.adminPassword = adminPassword;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String admin_password) {
        this.adminPassword = admin_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    //Additional 
    public String randomPassword()
    {
        char[] charaters = {'A','B','C','D','E','F','J','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            '0','1','2','3','4','5','6','7','8','9'};
        char[] specialChar = {'!','*','@','#','$','%','^','&','?','_','~','-'};
        StringBuffer temp = new StringBuffer("");
        StringBuffer tempS = new StringBuffer("");
	Random rn = new Random();
	for( int i = 0 ; i < 9 ; i++ )
        {
            temp.append(charaters[ rn.nextInt( charaters.length ) ] );
        }
        for( int i = 0 ; i < 1; i++ )
        {
            tempS.append(specialChar[ rn.nextInt( specialChar.length ) ] );
        }
        return temp.toString() + tempS.toString();
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ocenjevanjePack;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Luka
 */
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean( name="userBean" )
@SessionScoped
public class UserBean implements Serializable {
    //
    private int userPrivilege;
    private boolean isNoone;
    private boolean isStud;
    private boolean isAsist;
    private boolean isProf;
    private String name;
    private String pass;
    private String pass1;
    private String pass2;
    private String fname;
    private String sname;
    private String number;
    private String email;
    private String phone;
    private String role;
    private ConnectionBean connBean;
    
    @PostConstruct
    public void init() {
        isNoone=true;
        userPrivilege=0;
        //role="1";
        //System.out.println("HERE!!!!! : "+role );
        connBean=new ConnectionBean();
    }
    
    public void noOne(){
        System.out.println("I am no one!");
        userPrivilege=0;
        isNoone=true;
        isStud=false;
        isAsist=false;
        isProf=false;
    }
    
    public void validateUser() {
        //System.out.println("Tralalao");
        
        if(connBean.getUser(name, pass,this)){
            if(role.equals("1")){
                userPrivilege=1;
                isNoone=false;
                isStud=true;
                isAsist=false;
                isProf=false;
            }else if(role.equals("2")){
                userPrivilege=2;
                isNoone=false;
                isStud=false;
                isAsist=true;
                isProf=false;
            }else if(role.equals("3")){
                userPrivilege=3;
                isNoone=false;
                isStud=false;
                isAsist=false;
                isProf=true;
            }
        /*System.out.println("Role: "+role);
            try {
                FacesContext.getCurrentInstance().getExternalContext().dispatch("/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }else{
            System.out.println("Prijava ni uspela.");
        }
    }
    
    public void registerUser() {
        if(pass1.equals(pass2)){
            System.out.println("Validacija uspela.");
            pass=pass1;
        }else{
            System.out.println("Gesli se ne ujemata.");
            return;
        }
        connBean.insertUser(this);
    }
    
    /*public void reset(){
        
        name="";
        pass1="";
        pass2="";
        fname="";
        sname="";
        number="";
        email="";
        phone="";
        role="";
    }*/
    
    
    public boolean isIsNoone() {
        return isNoone;
    }

    public void setIsNoone(boolean isNoone) {
        this.isNoone = isNoone;
    }

    public boolean isIsStud() {
        return isStud;
    }

    public void setIsStud(boolean isStud) {
        this.isStud = isStud;
    }

    public boolean isIsAsist() {
        return isAsist;
    }

    public void setIsAsist(boolean isAsist) {
        this.isAsist = isAsist;
    }

    public boolean isIsProf() {
        return isProf;
    }

    public void setIsProf(boolean isProf) {
        this.isProf = isProf;
    }
    
    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    
    
    /**
     * @return the userMod
     */
    public int getUserPrivilege() {
        return userPrivilege;
    }

    /**
     * @param priviligation the userMod to set
     */
    public void setUserPrivilege(int userPrivilege) {
        this.userPrivilege = userPrivilege;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ocenjevanjePack;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Luka
 */
@ManagedBean( name="gradingBean" )
public class GradingBean {
    @PostConstruct
    public void init() {
        prof="0";
        asist="0";
        stud="0";
        connBean=new ConnectionBean();
    }
    public void changeGrading(){
        System.out.println("Dodajam projekt!");
        connBean.changeGrading(this);
    }
    public void getGrading(){
        connBean.getGrading(this);
    }
    
    private String instructions;
    private String prof;
    private String asist;
    private String stud;
    private ConnectionBean connBean;
    
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getAsist() {
        return asist;
    }

    public void setAsist(String asist) {
        this.asist = asist;
    }

    public String getStud() {
        return stud;
    }

    public void setStud(String stud) {
        this.stud = stud;
    }
    
}

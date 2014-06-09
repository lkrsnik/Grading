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
@ManagedBean( name="projectBean" )
public class ProjectBean {
    @PostConstruct
    public void init() {
        connBean=new ConnectionBean();
    }
    
    public void addProject(){
        System.out.println("Dodajam projekt!");
        connBean.addProject(this);
    }
    
    
    
    
    private String title;
    private String platform;
    private String mate1;
    private String mate2;
    private String projectSource;
    private String codeSource;
    private ConnectionBean connBean;
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getMate1() {
        return mate1;
    }

    public void setMate1(String mate1) {
        this.mate1 = mate1;
    }

    public String getMate2() {
        return mate2;
    }

    public void setMate2(String mate2) {
        this.mate2 = mate2;
    }

    public String getProjectSource() {
        return projectSource;
    }

    public void setProjectSource(String projectSource) {
        this.projectSource = projectSource;
    }

    public String getCodeSource() {
        return codeSource;
    }

    public void setCodeSource(String codeSource) {
        this.codeSource = codeSource;
    }
}

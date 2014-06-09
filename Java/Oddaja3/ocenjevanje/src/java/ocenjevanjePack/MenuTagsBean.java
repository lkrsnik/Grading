/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ocenjevanjePack;

/**
 *
 * @author Luka
 */
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean( name="menuTagsBean" )
@RequestScoped
public class MenuTagsBean implements Serializable {
    private boolean kriterij;
    private boolean projekti;
    private boolean ocenjevanje;

    @ManagedProperty(value="#{userBean.userPrivilege}")
    private int userPrivilege;

    @PostConstruct
    public void init() {
        if(userPrivilege>0){
            kriterij=true;
            projekti=true;
            ocenjevanje=true;
        }
    }

    public void setUserPrivilege(int userMod) {
        this.userPrivilege = userMod;
    }

    
    /**
     * @return the kriterij
     */
    public boolean isKriterij() {
        return kriterij;
    }

    /**
     * @param kriterij the kriterij to set
     */
    public void setKriterij(boolean kriterij) {
        this.kriterij = kriterij;
    }

    /**
     * @return the projekti
     */
    public boolean isProjekti() {
        return projekti;
    }

    /**
     * @param projekti the projekti to set
     */
    public void setProjekti(boolean projekti) {
        this.projekti = projekti;
    }

    /**
     * @return the ocenjevanje
     */
    public boolean isOcenjevanje() {
        return ocenjevanje;
    }

    /**
     * @param ocenjevanje the ocenjevanje to set
     */
    public void setOcenjevanje(boolean ocenjevanje) {
        this.ocenjevanje = ocenjevanje;
    }
    
}

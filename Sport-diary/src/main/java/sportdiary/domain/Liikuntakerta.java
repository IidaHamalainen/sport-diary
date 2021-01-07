/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportdiary.domain;

/**
 *
 * @author iida
 */
public class Liikuntakerta {
    
    private String laji;
    private double km;
    private String pvm;
    
    public Liikuntakerta(String laji, double km, String pvm) {
        this.laji = laji;
        this.km = km;
        this.pvm = pvm;
    }
    public String getLaji() {
        return this.laji;
    }
    public void setLaji(String newLaji) {
        this.laji = newLaji;
    }
    public double getKm() {
        return this.km;   
    }
    public void setKm(double newKm) {
        this.km = newKm;
    }
    public String getPvm() {
        return this.pvm;
    }
    public void setPvm(String newPvm) {
        this.pvm = newPvm;
    }
    
}

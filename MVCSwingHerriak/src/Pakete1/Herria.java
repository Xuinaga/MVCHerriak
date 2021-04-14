/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pakete1;

/**
 *
 * @author suinaga.jon
 */
public class Herria {

    private String herria;
    private String probintzia;
    private boolean hondartza;
    private String oharrak;

    public Herria(String herria, String probintzia, boolean hondartza, String oharrak) {
        this.herria = herria;
        this.probintzia = probintzia;
        this.hondartza = hondartza;
        this.oharrak = oharrak;
    }

    public String getHerria() {
        return herria;
    }

    public String getProbintzia() {
        return probintzia;
    }

    public boolean isHondartza() {
        return hondartza;
    }

    public String getOharrak() {
        return oharrak;
    }

    public void setHerria(String herria) {
        this.herria = herria;
    }

    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    public void setHondartza(boolean hondartza) {
        this.hondartza = hondartza;
    }

    public void setOharrak(String oharrak) {
        this.oharrak = oharrak;
    }

}

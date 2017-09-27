/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


public class Bestilling {
    private String navn;
    private String[] bestilling;
    private String kortnummer;
    private String utløpsdato;
    private String kontrollsiffer;
    
    public Bestilling(){
        
    }


    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String[] getBestilling() {
        return bestilling;
    }

    public void setBestilling(String[] bestilling) {
        this.bestilling = bestilling;
    }

    public String getKortnummer() {
        return kortnummer;
    }

    public void setKortnummer(String kortnummer) {
        this.kortnummer = kortnummer;
    }

    public String getUtløpsdato() {
        return utløpsdato;
    }

    public void setUtløpsdato(String utløpsdato) {
        this.utløpsdato = utløpsdato;
    }

    public String getKontrollsiffer() {
        return kontrollsiffer;
    }

    public void setKontrollsiffer(String kontrollsiffer) {
        this.kontrollsiffer = kontrollsiffer;
    }
    
}


package services;

public class Retter {
    private String type;
    private String navn;
    
    public Retter(){
        
    }
    
    public Retter(String type, String navn){
        this.type = type;
        this.navn = navn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
    
    
}

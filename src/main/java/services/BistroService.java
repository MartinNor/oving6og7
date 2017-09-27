package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/bistro/")
public class BistroService {
    private static Map<String,Bestilling> bestillinger = new HashMap<>();    
    private static ArrayList<Retter> retter = new ArrayList<>();
    private static boolean meny = true;
    private int[] bord = new int[23];
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Bestilling> getKunder() {
        return bestillinger.values();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBestilling(Bestilling bestilling){
        String[] ny = new String[3];
        int tid = Integer.parseInt(bestilling.getBestilling()[0]);
        int rett = 0;

        for(int i = 1; i<bestilling.getBestilling().length; i ++){
            if(Integer.parseInt(bestilling.getBestilling()[i])>0){
                if(i==1||i==2||i==3){
                    ny[rett] = "Forett: Server kl: " + createTid(tid) +"<br>";
                    for(int y = i; y<4;y++){
                        if(Integer.parseInt(bestilling.getBestilling()[y])>0){
                            ny[rett]+=bestilling.getBestilling()[y] + " " + retter.get(y-1).getNavn() + "<br>";
                        }
                    }
                    rett++;
                    tid++;
                    i=4;
                }
                else if(i==4||i==5||i==6){
                    ny[rett] = "Hovedrett: server kl: " + createTid(tid) + "<br>";
                    for(int y = i; y<7;y++){
                        if(Integer.parseInt(bestilling.getBestilling()[y])>0){
                            ny[rett]+=bestilling.getBestilling()[y] + " " + retter.get(y-1).getNavn() + "<br>";
                        }
                    }
                    rett++;
                    tid++;
                    i=7;
                }
                else if(i==7||i==8||i==9){
                    ny[rett]= "Dessert: Server kl: " + createTid(tid)+"<br>";
                    for(int y = i; y<10;y++){
                        if(Integer.parseInt(bestilling.getBestilling()[y])>0){
                            ny[rett]+=bestilling.getBestilling()[y] + " " + retter.get(y-1).getNavn() + "<br>";
                        }
                    }
                    i=10;
                    rett++;
                }
                else if(i==10 || i==11){
                    ny[rett-1]+= "<br>Drikke: serveres ved ankomst!<br>";
                    for(int y = i; y<12; y++){                        
                        if(Integer.parseInt(bestilling.getBestilling()[y])>0){
                            ny[rett-1]+=bestilling.getBestilling()[y] + " " + retter.get(y-1).getNavn() + "<br>";
                        }
                    }
                    i=12;
                }
            }
        }
        Bestilling nyBest = new Bestilling();
        nyBest.setNavn(bestilling.getNavn());
        nyBest.setBestilling(ny);
        nyBest.setKortnummer(bestilling.getKortnummer());
        nyBest.setUtløpsdato(bestilling.getUtløpsdato());
        nyBest.setKontrollsiffer(bestilling.getKontrollsiffer());
        bestillinger.put(nyBest.getNavn(), nyBest);
    }
    
    @GET
    @Path("/retter")
    @Produces(MediaType.APPLICATION_JSON)
    public String[][] getRetter2(){
        String[][] ret = new String[retter.size()][2];
        for(int i = 0; i<ret.length; i ++){
            ret[i][0] = retter.get(i).getType();
            ret[i][1]=retter.get(i).getNavn();
        }
        return ret;
    }
    
    @GET
    @Path("/ordre")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] getOrdre(){
        return bestillinger.values().toArray();
    }
    
    @GET
    @Path("/tid")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] getTidspunkt(){
        int ledige = 0;
        String[] temp = new String[23];
        for(int i = 0; i <temp.length;i++){
            if(bord[i]<7){
                int time = 12+i/2;
                int min = 0+3*(i%2);
                temp[ledige]=time + ":"+min +"0";
                ledige++;
            }
        }
        String[] ret = new String[ledige];
        for(int i = 0; i<ret.length;i++){
            ret[i]=temp[i];
        }
        return ret;
    }
    
    @PUT
    @Path("/retter")
    public void lagRetter(){
        if(meny){
        
        
        retter.add(new Retter("Forett", "Ceasar salat"));
        retter.add(new Retter("Forett", "Gresk salat"));
        retter.add(new Retter("Forett", "Breadsticks"));        
        retter.add(new Retter("Hovedrett", "Biff"));
        retter.add(new Retter("Hovedrett", "Kylling"));
        retter.add(new Retter("Hovedrett", "Fisk"));
        retter.add(new Retter("Dessert", "Is"));
        retter.add(new Retter("Dessert", "Irish coffee"));
        retter.add(new Retter("Dessert", "Panna cotta"));
        retter.add(new Retter("Drikke", "Cola"));
        retter.add(new Retter("Drikke", "Dahl's"));
        meny=false;
        }
    }
    
    private String createTid(int ind){
        String ret;
        int tid = 12 + (ind)/2;
        int min = 0 + 3*((ind)%2);
        ret= tid+":"+min + "0";
        bord[ind]++;
        return ret;       
    }
    
}

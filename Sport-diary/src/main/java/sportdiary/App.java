
package sportdiary;

import java.util.List;
import sportdiary.data_access.DBDao;
import sportdiary.data_access.SportDao;
import sportdiary.domain.Liikuntakerta;
import sportdiary.io.ConsoleIO;
import sportdiary.io.IO;
import sportdiary.services.SportdiaryService;

public class App {
    private IO io;
    private SportdiaryService service;
    private SportDao sportDao = new DBDao();
    
    public App(IO io, SportdiaryService service) {
        this.io = io;
        this.service = service;
        
    }
 
    
    
    public void run() {
        while (true) {
            String command = io.readLine("komento (uusi tai listaa):");

            if (command.isEmpty()) {
                break;
            }
            if (command.equals("uusi")) {
                
                
                String laji = io.readLine("Laji: ");
                String km = io.readLine("kilometrit: ");
                String pvm = io.readLine("päivämäärä: ");
                
                try { 
                    double dkm = Double.parseDouble(km);
                    Liikuntakerta liikunta = new Liikuntakerta(laji, dkm, pvm);
                    sportDao.add(liikunta);
                    
                } catch (Exception e) {
                    System.out.println("Error in adding the bookmark.");
                    System.out.println(e);
                }
            }
            else if (command.equals("listaa")) {
                
                List<Liikuntakerta> liikunnat = sportDao.listAll();
                liikunnat.forEach(liikunta -> {
                    System.out.println("Laji: " + liikunta.getLaji() 
                            + " | Km: " + liikunta.getKm());
                });
            }
        }
    }
    
    public static void main(String[] args) {
        IO io = new ConsoleIO();
        SportDao dao = new DBDao();
        SportdiaryService service = new SportdiaryService(dao);
        
        System.out.println("Tervetuloa liikuntapäiväkirjaan!");
        new App(io, service).run();
    }
}

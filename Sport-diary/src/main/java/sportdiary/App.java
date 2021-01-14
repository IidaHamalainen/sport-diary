
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
    private List<Liikuntakerta> liikuntalistaus;
    
    
    public App(IO io, SportdiaryService service) {
        this.io = io;
        this.service = service;
        
    }
 
    
    public void run() throws Exception {
        while (true) {
            String command = io.readLine("komento (uusi tai listaa):");

            if (command.isEmpty()) {
                break;
            }
            if (command.equals("uusi")) {
                
                
                String laji = io.readLine("Laji: ");
                String km = io.readLine("kilometrit: ");
                String pvm = io.readLine("päivämäärä: ");
                
                service.addLiikuntakerta(laji, km, pvm);
                io.print("liikuntakerta lisätty");
                
                
            }
            else if (command.equals("listaa")) {
                liikuntalistaus = service.list();
                liikuntalistaus.forEach(liikunta -> {
                    io.print("Laji: " + liikunta.getLaji() 
                            + " | Km: " + liikunta.getKm() 
                            + " | pvm: " + liikunta.getPvm());
                });
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        IO io = new ConsoleIO();
        SportDao dao = new DBDao("jdbc:sqlite:liikunnat.db");
        SportdiaryService service = new SportdiaryService(dao, io);
        
        System.out.println("Tervetuloa liikuntapäiväkirjaan!");
        new App(io, service).run();
    }
}

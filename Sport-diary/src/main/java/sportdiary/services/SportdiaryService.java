
package sportdiary.services;

import java.util.List;
import sportdiary.data_access.DBDao;
import sportdiary.data_access.SportDao;
import sportdiary.io.IO;
import sportdiary.domain.Liikuntakerta;


public class SportdiaryService {
    private IO io;
    private SportDao sportDao = new DBDao();
    
    public SportdiaryService(SportDao sportDao) {
        this.io = io;
        this.sportDao = sportDao;
    }
    
    public boolean addLiikuntakerta(String laji, String kmInput, String pvm) {   
        double km = Double.parseDouble(kmInput);
        Liikuntakerta liikunta = new Liikuntakerta(laji, km, pvm);
        sportDao.add(liikunta);
        return true;
    }
    
    public void list() {
        List<Liikuntakerta> liikuntaLista = sportDao.listAll();
        
        liikuntaLista.forEach(liikunta -> {
            io.print("Laji: " + liikunta.getLaji());
        });
        
    }
}

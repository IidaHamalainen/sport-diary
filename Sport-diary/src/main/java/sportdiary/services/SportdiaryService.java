
package sportdiary.services;

import java.util.List;
import sportdiary.data_access.DBDao;
import sportdiary.data_access.SportDao;
import sportdiary.io.IO;
import sportdiary.domain.Liikuntakerta;


public class SportdiaryService {
    private IO io;
    private SportDao sportDao;
    
    public SportdiaryService(SportDao sportDao, IO io) {
        this.io = io;
        this.sportDao = sportDao;
    }
    
    public  Liikuntakerta addLiikuntakerta(String laji, String kmInput, String pvm) throws Exception {   
        double km = Double.parseDouble(kmInput);
        Liikuntakerta liikunta = new Liikuntakerta(laji, km, pvm);
        sportDao.add(liikunta);
        return liikunta;
        
    }
    
    public List<Liikuntakerta> list() throws Exception{
        List<Liikuntakerta> liikuntalista = sportDao.listAll();
        
        return liikuntalista;
        
    }
}

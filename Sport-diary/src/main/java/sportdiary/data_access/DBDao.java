/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportdiary.data_access;

import java.util.ArrayList;
import java.util.List;
import sportdiary.domain.Liikuntakerta;

/**
 *
 * @author iida
 */
public class DBDao implements SportDao{
    
    
    private List<Liikuntakerta> liikunnat = new ArrayList<>();
    
    public DBDao() {
        liikunnat = new ArrayList<>();
    }
    
    @Override
    public void add(Liikuntakerta liikunta) {
        liikunnat.add(liikunta);
    }
    @Override
    public List<Liikuntakerta> listAll() {
        
        return liikunnat;
    }
}

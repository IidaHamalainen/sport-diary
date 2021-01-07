
package sportdiary.data_access;

import java.util.ArrayList;
import java.util.List;
import sportdiary.domain.Liikuntakerta;

public interface SportDao {
    List<Liikuntakerta> listAll();
    void add(Liikuntakerta liikunta);
    //muita metodeja
}


package sportdiary.data_access;

import java.util.ArrayList;
import java.util.List;
import sportdiary.domain.Liikuntakerta;

public interface SportDao {
    List<Liikuntakerta> listAll() throws Exception;
    void add(Liikuntakerta liikunta) throws Exception;
    //muita metodeja
}

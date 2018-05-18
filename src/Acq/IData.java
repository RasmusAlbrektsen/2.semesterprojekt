package Acq;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Bruger
 */
public interface IData {
    Map<String, IUser> getUsers();
    List<ICase> getCases();
}

package api;

import java.io.Serializable;

/**
 * Created by er22317 on 13.12.2018.
 */
public interface IEntity<ID extends Serializable> {

    ID getId();

    void setId(ID id);
}


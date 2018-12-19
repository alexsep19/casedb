package shu.casedb.server.rest.api;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Log4j;
import api.AbstractEntity;
import dao.api.AbstractEntityDao;
import org.apache.log4j.Logger;

public abstract class AbstractEntityRest<I extends Serializable,
        E extends AbstractEntity<I>, R extends AbstractEntityDao<I, E>> {

    private static final Logger log = Logger.getLogger(AbstractEntityRest.class);

    @Inject
    private R dao;
    @Inject
    private EntityValidator<E> validator;

    private Class<E> clazz;

    public AbstractEntityRest(Class<E> clazz) {
        this.clazz = clazz;
    }

    protected R getRepo() {
        return dao;
    }

    protected E getEntity(I id) {
        return dao.find(id);
    }

    public String echo() {
        return getClass().getSimpleName() + " echo test";
    }

    public void create(E entity) {
        if (validator.validate(entity)) {
            try {
                dao.insert(entity);
            } catch (Exception ex) {
                log.fatal("Storing data by dao object throws exception: " + ex.getMessage(), ex);
            }
        }
        else throw new IllegalArgumentException(
                "Can't create entity. Entity not properly set. Entity validation fail " + entity.toString());
    }

    public E read(I id) {
        return getEntity(id);
    }

    public void update(E entity) {
        if (validator.validate(entity)) dao.update(entity);
        else throw new IllegalArgumentException(
                "Can't update entity. Entity not properly set. Entity validation fail " + entity.toString());
    }

    public void delete(I id) {
        dao.remove(getEntity(id));
    }

//    public List<E> listOffset(Integer offset, Integer length) {
//        return dao.list(offset, length);
//    }
    public List<E> listAll() {
        return dao.list();
    }
}

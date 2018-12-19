package dao;

import admino.Actions;
import dao.api.AbstractEntityDao;

import javax.ejb.Stateless;

/**
 * Created by er22317 on 14.12.2018.
 */
@Stateless
public class ActionsDao extends AbstractEntityDao<Long, Actions> {
    public ActionsDao() {super(Actions.class);}
}

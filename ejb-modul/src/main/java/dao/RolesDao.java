package dao;

import admino.Roles;
import dao.api.AbstractEntityDao;

import javax.ejb.Stateless;

/**
 * Created by er22317 on 14.12.2018.
 */
@Stateless
public class RolesDao extends AbstractEntityDao<Long, Roles> {
    public RolesDao() {super(Roles.class);}
}

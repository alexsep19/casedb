package dao;

import admino.Users;
import dao.api.AbstractEntityDao;

import javax.ejb.Stateless;

/**
 * Created by er22317 on 14.12.2018.
 */
@Stateless
public class UsersDao extends AbstractEntityDao<Long, Users> {
        public UsersDao() {super(Users.class);}
}

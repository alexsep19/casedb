package shu.casedb.server.rest;

import admino.Roles;
import dao.RolesDao;
import shu.casedb.server.rest.api.AbstractEntityRest;
import shu.casedb.server.rest.api.IRestApiMediaType;

import javax.ejb.Stateless;
import javax.management.relation.Role;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by er22317 on 09.01.2019.
 */
@Path("/roles")
@Produces(IRestApiMediaType.JSON_UTF8)
@Stateless
public class RoleRest extends AbstractEntityRest<Long, Roles, RolesDao> {
    public RoleRest() {
        super(Roles.class);
    }
    @GET
    @Path("/all")
    @Produces(IRestApiMediaType.JSON_UTF8)
    public List<Roles> getList(){
        return listAll();
    }

}

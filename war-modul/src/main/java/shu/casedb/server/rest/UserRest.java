package shu.casedb.server.rest;

import admino.Users;
import dao.UsersDao;
import shu.casedb.server.rest.api.AbstractEntityRest;
import shu.casedb.server.rest.api.IRestApiMediaType;

import javax.ejb.Stateless;
import javax.ws.rs.*;

import java.util.Date;
import java.util.List;

@Path("/users")
@Produces(IRestApiMediaType.JSON_UTF8)
@Stateless
public class UserRest extends AbstractEntityRest<Long, Users, UsersDao> {

    public UserRest() {
        super(Users.class);
    }

    @GET
    @Path("/echo")
    @Produces(IRestApiMediaType.TEXT_UTF8)
    public String echoo(){
        return echo();
    }

    @GET
    @Path("/all")
    @Produces(IRestApiMediaType.JSON_UTF8)
    public List<Users> getList(){
        return listAll();
    }

//    @POST
//    @Consumes(JSON_UTF8)
//    public List<Users> postList(LinkedHashMap o){
//        return listOffset((Integer)o.get("offset"), (Integer)o.get("length"));
//    }

//    public List<User> postList(@QueryParam("offset") Integer offset,
//                           @QueryParam("length") Integer length){
//        return list(offset,length);
//    }

    @POST
    public List<Users> add(Users user){
        user.setLocked("N");
        user.setCreated(new Date());
        create(user);
        return listAll();
    }

    @PUT
    public List<Users> edit(Users user){
        update(user);
        return listAll();
    }

    @DELETE
    public List<Users> delete(Users user){
        super.delete(user.getId());
        return listAll();
    }
}

package shu.casedb.client.rest;

import admino.Users;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import shu.casedb.client.dto.UsersDto;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by er22317 on 26.12.2018.
 */
@Path("/rest/users")
public interface UserRestClient extends RestService {
    @GET
    @Path("/all")
    public void getList(MethodCallback<List<UsersDto>> callback);

    @POST
    public void add(UsersDto usersDto, MethodCallback<List<UsersDto>> callback);

    @PUT
    public void edit(UsersDto usersDto, MethodCallback<List<UsersDto>> callback);

    @DELETE
    public void delete(UsersDto usersDto, MethodCallback<List<UsersDto>> callback);
}

package shu.casedb.client.rest;

import admino.Users;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import shu.casedb.client.dto.UsersDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by er22317 on 26.12.2018.
 */
@Path("/rest/users")
public interface UserRestClient extends RestService {
    @GET
    @Path("/all")
    public void getList(MethodCallback<List<UsersDto>> callback);

}

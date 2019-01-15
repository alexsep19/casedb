package shu.casedb.client.rest;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import shu.casedb.client.dto.RolesDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by er22317 on 09.01.2019.
 */
@Path("/rest/users")
public interface RoleRestClient extends RestService {
    @GET
    @Path("/all")
    public void getList(MethodCallback<List<RolesDto>> callback);
}

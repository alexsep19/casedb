package shu.casedb.server.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Конфигурация REST приложения
 */
@ApplicationPath("/rest")
public class RestApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();
    public RestApplication(){
//        singletons.add(new RestResource());
    }
//    public RestEasyServices() {
//        singletons.add(new MovieCrudService());
//    }

    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
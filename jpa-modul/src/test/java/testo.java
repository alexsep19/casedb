import admino.Users;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by er22317 on 13.12.2018.
 */
public class testo {
    EntityManager em = null;
    public testo() {
        em = Persistence.createEntityManagerFactory("jpaAdmino").createEntityManager();
    }

    public void SelCol(){
//        List<Users> l = null;
        try{
            List<Users> users = em.createQuery("select u from Users u", Users.class).getResultList();
            System.out.println("Users:");
            for(Users user: users){
                System.out.println(user.getId() + " " + user.getName());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Started");
        testo o = new testo();
        o.SelCol();
    }

}

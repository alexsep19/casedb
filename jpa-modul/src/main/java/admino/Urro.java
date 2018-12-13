package admino;

/**
 * Created by er22317 on 13.12.2018.
 */

import api.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name="urro")
public class Urro extends AbstractEntity<UrroId> {

    @EmbeddedId
    private UrroId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
//    @JsonBackReference
    private Roles role;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
//    @JsonBackReference
    private Users user;

    public Urro() {
    }

    public UrroId getId() {
        return this.id;
    }

    public void setId(UrroId id) {
        this.id = id;
    }

    public Roles getRole() {
        return this.role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Users getUser() {
        return this.user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

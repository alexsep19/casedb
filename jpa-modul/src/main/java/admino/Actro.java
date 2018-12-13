package admino;

import api.AbstractEntity;

import javax.persistence.*;

/**
 * Created by er22317 on 13.12.2018.
 */
@Entity
@Table(name="actro")
public class Actro extends AbstractEntity<ActroId> {
    @EmbeddedId
    private ActroId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
//    @JsonBackReference
    private Roles role;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
//    @JsonBackReference
    private Actions action;

    public Actro() {
    }

    public ActroId getId() {
        return id;
    }

    public void setId(ActroId id) {
        this.id = id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Actions getAction() {
        return action;
    }

    public void setAction(Actions action) {
        this.action = action;
    }

}

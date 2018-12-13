package admino;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by er22317 on 13.12.2018.
 */
@Embeddable
public class ActroId implements Serializable {
    @Column(name = "ACTION_ID")
    private Long actionId;

    @Column(name = "ROLE_ID")
    private Long roleId;

    public ActroId() {
    }
    public ActroId(Actions actions, Roles role) {
        this.actionId = actions.getId();
        this.roleId = role.getId();
    }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}

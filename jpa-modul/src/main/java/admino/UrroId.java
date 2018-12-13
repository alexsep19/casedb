package admino;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by er22317 on 13.12.2018.
 */
@Embeddable
public class UrroId implements Serializable {
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ROLE_ID")
    private Long roleId;

    public UrroId() {
    }
    public UrroId(Users user, Roles role) {
        this.userId = user.getId();
        this.roleId = role.getId();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}

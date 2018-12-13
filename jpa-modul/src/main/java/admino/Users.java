package admino;

import api.AbstractEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by er22317 on 13.12.2018.
 */
@Entity
@Table(name="users")
public class Users extends AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "users_id_seq", allocationSize=1)
    private Long id;
    private String mail;
    private String name;
    private String password;
    private String fio;
    private String locked;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @OneToMany(mappedBy="user", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
//    @JsonBackReference
    private List<Urro> urros;


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

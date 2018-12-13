package admino;

import api.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by er22317 on 13.12.2018.
 */
@Entity
@Table(name="roles")
public class Roles extends AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq_gen")
    @SequenceGenerator(name = "roles_seq_gen", sequenceName = "roles_id_seq",allocationSize=1)
    private Long id;
    private String code;

    @OneToMany(mappedBy="role", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
//    @JsonBackReference
    private List<Urro> urros;

    @OneToMany(mappedBy="role", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
//    @JsonBackReference
    private List<Actro> actros;

    public Roles() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}

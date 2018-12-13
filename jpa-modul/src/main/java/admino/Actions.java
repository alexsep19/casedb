package admino;

import api.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by er22317 on 13.12.2018.
 */
@Entity
@Table(name="actions")
public class Actions extends AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actions_seq_gen")
    @SequenceGenerator(name = "actions_seq_gen", sequenceName = "actions_id_seq",allocationSize=1)
    private Long id;
    private String code;

    @OneToMany(mappedBy="action", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
//    @JsonBackReference
    private List<Actro> actros;

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

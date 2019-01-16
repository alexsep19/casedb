package shu.casedb.client.dto;

import java.util.Date;

/**
 * Created by er22317 on 26.12.2018.
 */
public class UsersDto {
    private Long id;
    private String mail;
    private String name;
    private String password;
    private String fio;
    private String locked;
    private Date created;

//    @JsonBackReference
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsersDto() {
    }
    public UsersDto(Long id, String mail, String name, String password, String fio) {
        this.id = id;
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.fio = fio;
    }
}

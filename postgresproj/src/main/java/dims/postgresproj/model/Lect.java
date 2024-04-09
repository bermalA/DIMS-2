package dims.postgresproj.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lect")
public class Lect {
    @Id
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "credit")
    private int credit;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}

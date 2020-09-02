package carry.repository;

import java.sql.Blob;
import java.sql.Date;

public class Cat {
    private Long id;
    private Double weight;
    private String name;
    private Boolean adopted;
    private String description;
    private Date birthTime;

    public Date getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdopted(Boolean adopted) {
        this.adopted = adopted;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public Boolean getAdopted() {
        return adopted;
    }

    public String getDescription() {
        return description;
    }
}

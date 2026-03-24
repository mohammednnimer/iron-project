package org.gs.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "cust")
public class Cust {

    @Id
    @Column(name = "reference", length = 30, nullable = false)
    private String reference;

    @Column(name = "description", length = 500, nullable = true)
    private String description;

    @Column(name = "tel", length = 50, nullable = true)
    private String tel;


    public Cust() {}

    public Cust(String reference, String description, String tel) {
        this.reference = reference;
        this.description = description;
        this.tel = tel;
    }


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }



}

package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "itemunits_tbl")
public class ItemunitsTbl {
    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_description", length = 50)
    private String txtDescription;

    public String getTxtKey() {
        return txtKey;
    }

    public void setTxtKey(String txtKey) {
        this.txtKey = txtKey;
    }

    public String getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(String txtDescription) {
        this.txtDescription = txtDescription;
    }

}
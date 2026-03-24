package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "documents_tbl")
public class DocumentsTbl {

    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_hdrkey", length = 60)
    private String txtHdrkey;


    @Column(name = "txt_filename", length = 300)
    private String txtFilename;


    @Column(name = "txt_description", length = 100)
    private String txtDescription;

    @Column(name = "img_image")
    private byte[] imgImage;

    @Column(name = "dat_creationdate")
    private Instant datCreationdate;

    public String getTxtKey() {
        return txtKey;
    }

    public void setTxtKey(String txtKey) {
        this.txtKey = txtKey;
    }

    public String getTxtHdrkey() {
        return txtHdrkey;
    }

    public void setTxtHdrkey(String txtHdrkey) {
        this.txtHdrkey = txtHdrkey;
    }

    public String getTxtFilename() {
        return txtFilename;
    }

    public void setTxtFilename(String txtFilename) {
        this.txtFilename = txtFilename;
    }

    public String getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(String txtDescription) {
        this.txtDescription = txtDescription;
    }

    public byte[] getImgImage() {
        return imgImage;
    }

    public void setImgImage(byte[] imgImage) {
        this.imgImage = imgImage;
    }

    public Instant getDatCreationdate() {
        return datCreationdate;
    }

    public void setDatCreationdate(Instant datCreationdate) {
        this.datCreationdate = datCreationdate;
    }

}
package org.gs.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;


public class DocumentDto {


    private String txtFilename;

    private String txtDescription;

    private byte[] imgImage;

    private String txtHdr;

    public String getTxtHdr() {
        return txtHdr;
    }

    public void setTxtHdr(String txtHdr) {
        this.txtHdr = txtHdr;
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


}
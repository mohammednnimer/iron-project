package org.gs.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Arrays;

@Entity
@Table(name = "ironshapes_tbl")
public class IronshapesTbl {

    @Id
    @Column(name = "TXT_KEY", length = 60)  // uppercase column names
    private String txtKey;

    @Column(name = "TXT_DESCRIPTION", length = 100)
    private String txtDescription;

    @Column(name = "IMG_IMAGE")
    private byte[] imgImage;


    @Column(name = "INT_SIDES", precision = 5, scale = 0)
    private BigDecimal intSides;

    @Column(name = "TXT_IRONKEY", length = 60)
    private String txtIronkey;

    @Column(name = "TXT_REFERENCE", length = 60)
    private String txtReference;

     public String getTxtKey() { return txtKey; }
    public void setTxtKey(String txtKey) { this.txtKey = txtKey; }

    public String getTxtDescription() { return txtDescription; }
    public void setTxtDescription(String txtDescription) { this.txtDescription = txtDescription; }

    public byte[] getImgImage() { return imgImage; }
    public void setImgImage(byte[] imgImage) { this.imgImage = imgImage; }

    public BigDecimal getIntSides() { return intSides; }
    public void setIntSides(BigDecimal intSides) { this.intSides = intSides; }

    public String getTxtIronkey() { return txtIronkey; }
    public void setTxtIronkey(String txtIronkey) { this.txtIronkey = txtIronkey; }

    public String getTxtReference() { return txtReference; }
    public void setTxtReference(String txtReference) { this.txtReference = txtReference; }

    @Override
    public String toString() {
        return "IronshapesTbl{" +
                "txtKey='" + txtKey + '\'' +
                ", txtDescription='" + txtDescription + '\'' +
                ", imgImage=" + Arrays.toString(imgImage) +
                ", intSides=" + intSides +
                ", txtIronkey='" + txtIronkey + '\'' +
                ", txtReference='" + txtReference + '\'' +
                '}';
    }
}


//package org.gs.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//
//@Entity
//    @Table(name = "ironshapes_tbl")
//    public class IronshapesTbl {
//        @Id
//        @Column(name = "txt_key", length = 60)
//        private String txtKey;
//
//    @Column(name = "txt_description", length = 100)
//    private String txtDescription;
//
//    @Column(name = "img_image")
//    private byte[] imgImage;
//
//    @Column(name = "int_sides", precision = 5)
//    private BigDecimal intSides;
//
//    @Column(name = "txt_ironkey", length = 60)
//    private String txtIronkey;
//
//    @Column(name = "txt_reference", length = 60)
//    private String txtReference;
//
//    public String getTxtKey() {
//        return txtKey;
//    }
//    public void setTxtKey(String txtKey) {
//        this.txtKey = txtKey;
//    }
//    public String getTxtDescription() {
//        return txtDescription;
//    }
//    public void setTxtDescription(String txtDescription) {
//        this.txtDescription = txtDescription;
//    }
//    public byte[] getImgImage() {
//        return imgImage;
//    }
//    public void setImgImage(byte[] imgImage) {
//        this.imgImage = imgImage;
//    }
//    public BigDecimal getIntSides() {
//        return intSides;
//    }
//    public void setIntSides(BigDecimal intSides) {
//        this.intSides = intSides;
//    }
//    public String getTxtIronkey() {
//        return txtIronkey;
//    }
//    public void setTxtIronkey(String txtIronkey) {
//        this.txtIronkey = txtIronkey;
//    }
//    public String getTxtReference() {
//        return txtReference;
//    }
//    public void setTxtReference(String txtReference) {
//        this.txtReference = txtReference;
//    }
//
//    @Override
//    public String toString() {
//        return "IronshapesTbl{" +
//                "txtKey='" + txtKey + '\'' +
//                ", txtDescription='" + txtDescription + '\'' +
//                ", imgImage=" + Arrays.toString(imgImage) +
//                ", intSides=" + intSides +
//                ", txtIronkey='" + txtIronkey + '\'' +
//                ", txtReference='" + txtReference + '\'' +
//                '}';
//    }
//}


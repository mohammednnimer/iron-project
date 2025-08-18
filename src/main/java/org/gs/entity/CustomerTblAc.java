package org.gs.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "customer_tbl_ac")
public class CustomerTblAc {




    @Column(name = "txt_acccode", length = 15)
    private String txtAcccode;

    @Column(name = "txt_namea", length = 250)
    private String txtNamea;

    @Column(name = "txt_namee", length = 250)
    private String txtNamee;

    @Column(name = "txt_vatno", length = 20)
    private String txtVatno;

    @Column(name = "txt_title", length = 10)
    private String txtTitle;

    @Column(name = "txt_addressa", length = 100)
    private String txtAddressa;

    @Column(name = "txt_addresse", length = 100)
    private String txtAddresse;

    @Column(name = "txt_citya", length = 20)
    private String txtCitya;

    @Column(name = "txt_citye", length = 20)
    private String txtCitye;

    @Column(name = "txt_countrya", length = 20)
    private String txtCountrya;

    @Column(name = "txt_countrye", length = 20)
    private String txtCountrye;

    @Column(name = "txt_managera", length = 20)
    private String txtManagera;

    @Column(name = "txt_managere", length = 20)
    private String txtManagere;

    @Column(name = "txt_tel1", length = 100)
    private String txtTel1;

    @Column(name = "txt_tel2", length = 20)
    private String txtTel2;

    @Column(name = "txt_fax", length = 15)
    private String txtFax;

    @Column(name = "txt_celltel", length = 20)
    private String txtCelltel;

    @Column(name = "txt_email", length = 20)
    private String txtEmail;

    @Column(name = "txt_url", length = 20)
    private String txtUrl;

    @Column(name = "txt_comment", length = 100)
    private String txtComment;

    @Column(name = "dbl_discountrate", precision = 5)
    private BigDecimal dblDiscountrate;

    @Column(name = "txt_rank", length = 1)
    private String txtRank;

    @Column(name = "txt_group", length = 1)
    private String txtGroup;

    @Column(name = "int_status", length = 1)
    private String intStatus;

    @Column(name = "txt_salesmancode", length = 15)
    private String txtSalesmancode;

    @Column(name = "txt_advertisercode", length = 15)
    private String txtAdvertisercode;

    @Column(name = "txt_areacode", length = 15)
    private String txtAreacode;

    @Column(name = "txt_categorycode", length = 100)
    private String txtCategorycode;

    @Id
    @Column(name = "txt_cscode", length = 15)
    private String txtCscode;

    @Column(name = "int_rowid", precision = 5)
    private BigDecimal intRowid;

    @Column(name = "txt_refercode", length = 15)
    private String txtRefercode;

    @Column(name = "int_type")
    private Integer intType;

    @Column(name = "int_csstatus")
    private Integer intCsstatus;

    @Column(name = "bol_allowglacctransaction")
    private Integer bolAllowglacctransaction;

    @Column(name = "txt_collectorcode", length = 20)
    private String txtCollectorcode;

    @Column(name = "dbl_maxcreditamt", precision = 5)
    private BigDecimal dblMaxcreditamt;

    @Column(name = "dbl_maxcreditday", precision = 5)
    private BigDecimal dblMaxcreditday;

    @Column(name = "dbl_banklgamt", precision = 5)
    private BigDecimal dblBanklgamt;

    @Column(name = "dat_banklgstartdate")
    private LocalDate datBanklgstartdate;

    @Column(name = "dat_banklgenddate")
    private LocalDate datBanklgenddate;

    @Column(name = "bol_legalcase")
    private Integer bolLegalcase;

    @Column(name = "dbl_lattercreditamount", precision = 5)
    private BigDecimal dblLattercreditamount;

    @Column(name = "txt_creditapplications", length = 300)
    private String txtCreditapplications;

    @Column(name = "txt_passportcopy", length = 300)
    private String txtPassportcopy;

    @Column(name = "dbl_maxdebitamt", precision = 5)
    private BigDecimal dblMaxdebitamt;

    @Column(name = "int_maxnouncollectcheque")
    private Integer intMaxnouncollectcheque;

    @Column(name = "dbl_maxuncollectchequeamt", precision = 5)
    private BigDecimal dblMaxuncollectchequeamt;

    @Column(name = "txt_cardno", length = 100)
    private String txtCardno;

    @Column(name = "dat_creationdate")
    private LocalDate datCreationdate;

    @Column(name = "int_sortreference", precision = 5)
    private BigDecimal intSortreference;

    public String getTxtAcccode() {
        return txtAcccode;
    }

    public void setTxtAcccode(String txtAcccode) {
        this.txtAcccode = txtAcccode;
    }

    public String getTxtNamea() {
        return txtNamea;
    }

    public void setTxtNamea(String txtNamea) {
        this.txtNamea = txtNamea;
    }

    public String getTxtNamee() {
        return txtNamee;
    }

    public void setTxtNamee(String txtNamee) {
        this.txtNamee = txtNamee;
    }

    public String getTxtVatno() {
        return txtVatno;
    }

    public void setTxtVatno(String txtVatno) {
        this.txtVatno = txtVatno;
    }

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public String getTxtAddressa() {
        return txtAddressa;
    }

    public void setTxtAddressa(String txtAddressa) {
        this.txtAddressa = txtAddressa;
    }

    public String getTxtAddresse() {
        return txtAddresse;
    }

    public void setTxtAddresse(String txtAddresse) {
        this.txtAddresse = txtAddresse;
    }

    public String getTxtCitya() {
        return txtCitya;
    }

    public void setTxtCitya(String txtCitya) {
        this.txtCitya = txtCitya;
    }

    public String getTxtCitye() {
        return txtCitye;
    }

    public void setTxtCitye(String txtCitye) {
        this.txtCitye = txtCitye;
    }

    public String getTxtCountrya() {
        return txtCountrya;
    }

    public void setTxtCountrya(String txtCountrya) {
        this.txtCountrya = txtCountrya;
    }

    public String getTxtCountrye() {
        return txtCountrye;
    }

    public void setTxtCountrye(String txtCountrye) {
        this.txtCountrye = txtCountrye;
    }

    public String getTxtManagera() {
        return txtManagera;
    }

    public void setTxtManagera(String txtManagera) {
        this.txtManagera = txtManagera;
    }

    public String getTxtManagere() {
        return txtManagere;
    }

    public void setTxtManagere(String txtManagere) {
        this.txtManagere = txtManagere;
    }

    public String getTxtTel1() {
        return txtTel1;
    }

    public void setTxtTel1(String txtTel1) {
        this.txtTel1 = txtTel1;
    }

    public String getTxtTel2() {
        return txtTel2;
    }

    public void setTxtTel2(String txtTel2) {
        this.txtTel2 = txtTel2;
    }

    public String getTxtFax() {
        return txtFax;
    }

    public void setTxtFax(String txtFax) {
        this.txtFax = txtFax;
    }

    public String getTxtCelltel() {
        return txtCelltel;
    }

    public void setTxtCelltel(String txtCelltel) {
        this.txtCelltel = txtCelltel;
    }

    public String getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

    public String getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(String txtUrl) {
        this.txtUrl = txtUrl;
    }

    public String getTxtComment() {
        return txtComment;
    }

    public void setTxtComment(String txtComment) {
        this.txtComment = txtComment;
    }

    public BigDecimal getDblDiscountrate() {
        return dblDiscountrate;
    }

    public void setDblDiscountrate(BigDecimal dblDiscountrate) {
        this.dblDiscountrate = dblDiscountrate;
    }

    public String getTxtRank() {
        return txtRank;
    }

    public void setTxtRank(String txtRank) {
        this.txtRank = txtRank;
    }

    public String getTxtGroup() {
        return txtGroup;
    }

    public void setTxtGroup(String txtGroup) {
        this.txtGroup = txtGroup;
    }

    public String getIntStatus() {
        return intStatus;
    }

    public void setIntStatus(String intStatus) {
        this.intStatus = intStatus;
    }

    public String getTxtSalesmancode() {
        return txtSalesmancode;
    }

    public void setTxtSalesmancode(String txtSalesmancode) {
        this.txtSalesmancode = txtSalesmancode;
    }

    public String getTxtAdvertisercode() {
        return txtAdvertisercode;
    }

    public void setTxtAdvertisercode(String txtAdvertisercode) {
        this.txtAdvertisercode = txtAdvertisercode;
    }

    public String getTxtAreacode() {
        return txtAreacode;
    }

    public void setTxtAreacode(String txtAreacode) {
        this.txtAreacode = txtAreacode;
    }

    public String getTxtCategorycode() {
        return txtCategorycode;
    }

    public void setTxtCategorycode(String txtCategorycode) {
        this.txtCategorycode = txtCategorycode;
    }

    public String getTxtCscode() {
        return txtCscode;
    }

    public void setTxtCscode(String txtCscode) {
        this.txtCscode = txtCscode;
    }

    public BigDecimal getIntRowid() {
        return intRowid;
    }

    public void setIntRowid(BigDecimal intRowid) {
        this.intRowid = intRowid;
    }

    public String getTxtRefercode() {
        return txtRefercode;
    }

    public void setTxtRefercode(String txtRefercode) {
        this.txtRefercode = txtRefercode;
    }

    public Integer getIntType() {
        return intType;
    }

    public void setIntType(Integer intType) {
        this.intType = intType;
    }

    public Integer getIntCsstatus() {
        return intCsstatus;
    }

    public void setIntCsstatus(Integer intCsstatus) {
        this.intCsstatus = intCsstatus;
    }

    public Integer getBolAllowglacctransaction() {
        return bolAllowglacctransaction;
    }

    public void setBolAllowglacctransaction(Integer bolAllowglacctransaction) {
        this.bolAllowglacctransaction = bolAllowglacctransaction;
    }

    public String getTxtCollectorcode() {
        return txtCollectorcode;
    }

    public void setTxtCollectorcode(String txtCollectorcode) {
        this.txtCollectorcode = txtCollectorcode;
    }

    public BigDecimal getDblMaxcreditamt() {
        return dblMaxcreditamt;
    }

    public void setDblMaxcreditamt(BigDecimal dblMaxcreditamt) {
        this.dblMaxcreditamt = dblMaxcreditamt;
    }

    public BigDecimal getDblMaxcreditday() {
        return dblMaxcreditday;
    }

    public void setDblMaxcreditday(BigDecimal dblMaxcreditday) {
        this.dblMaxcreditday = dblMaxcreditday;
    }

    public BigDecimal getDblBanklgamt() {
        return dblBanklgamt;
    }

    public void setDblBanklgamt(BigDecimal dblBanklgamt) {
        this.dblBanklgamt = dblBanklgamt;
    }

    public LocalDate getDatBanklgstartdate() {
        return datBanklgstartdate;
    }

    public void setDatBanklgstartdate(LocalDate datBanklgstartdate) {
        this.datBanklgstartdate = datBanklgstartdate;
    }

    public LocalDate getDatBanklgenddate() {
        return datBanklgenddate;
    }

    public void setDatBanklgenddate(LocalDate datBanklgenddate) {
        this.datBanklgenddate = datBanklgenddate;
    }

    public Integer getBolLegalcase() {
        return bolLegalcase;
    }

    public void setBolLegalcase(Integer bolLegalcase) {
        this.bolLegalcase = bolLegalcase;
    }

    public BigDecimal getDblLattercreditamount() {
        return dblLattercreditamount;
    }

    public void setDblLattercreditamount(BigDecimal dblLattercreditamount) {
        this.dblLattercreditamount = dblLattercreditamount;
    }

    public String getTxtCreditapplications() {
        return txtCreditapplications;
    }

    public void setTxtCreditapplications(String txtCreditapplications) {
        this.txtCreditapplications = txtCreditapplications;
    }

    public String getTxtPassportcopy() {
        return txtPassportcopy;
    }

    public void setTxtPassportcopy(String txtPassportcopy) {
        this.txtPassportcopy = txtPassportcopy;
    }

    public BigDecimal getDblMaxdebitamt() {
        return dblMaxdebitamt;
    }

    public void setDblMaxdebitamt(BigDecimal dblMaxdebitamt) {
        this.dblMaxdebitamt = dblMaxdebitamt;
    }

    public Integer getIntMaxnouncollectcheque() {
        return intMaxnouncollectcheque;
    }

    public void setIntMaxnouncollectcheque(Integer intMaxnouncollectcheque) {
        this.intMaxnouncollectcheque = intMaxnouncollectcheque;
    }

    public BigDecimal getDblMaxuncollectchequeamt() {
        return dblMaxuncollectchequeamt;
    }

    public void setDblMaxuncollectchequeamt(BigDecimal dblMaxuncollectchequeamt) {
        this.dblMaxuncollectchequeamt = dblMaxuncollectchequeamt;
    }

    public String getTxtCardno() {
        return txtCardno;
    }

    public void setTxtCardno(String txtCardno) {
        this.txtCardno = txtCardno;
    }

    public LocalDate getDatCreationdate() {
        return datCreationdate;
    }

    public void setDatCreationdate(LocalDate datCreationdate) {
        this.datCreationdate = datCreationdate;
    }

    public BigDecimal getIntSortreference() {
        return intSortreference;
    }

    public void setIntSortreference(BigDecimal intSortreference) {
        this.intSortreference = intSortreference;
    }


}
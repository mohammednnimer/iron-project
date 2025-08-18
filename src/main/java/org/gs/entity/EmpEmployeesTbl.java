package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "emp_employees_tbl")
public class EmpEmployeesTbl {
    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_name", length = 200)
    private String txtName;

    @Column(name = "dat_ofbirth", length = 30)
    private String datOfbirth;

    @Column(name = "txt_clocknum", length = 30)
    private String txtClocknum;

    @Column(name = "int_type")
    private Integer intType;

    @Column(name = "dbl_salary", precision = 10, scale = 3)
    private BigDecimal dblSalary;

    @Column(name = "int_dependents")
    private Integer intDependents;

    @Column(name = "int_universitystudents")
    private Integer intUniversitystudents;

    @Column(name = "dbl_hoursperday", precision = 5)
    private BigDecimal dblHoursperday;

    @Column(name = "bol_wifeworks")
    private Integer bolWifeworks;

    @Column(name = "txt_id", length = 30)
    private String txtId;

    @Column(name = "dbl_starthour1", precision = 10, scale = 2)
    private BigDecimal dblStarthour1;

    @Column(name = "dbl_endhour1", precision = 10, scale = 2)
    private BigDecimal dblEndhour1;

    @Column(name = "dbl_endhour", precision = 10, scale = 2)
    private BigDecimal dblEndhour;

    @Column(name = "dbl_starthour", precision = 10, scale = 2)
    private BigDecimal dblStarthour;

    public String getTxtKey() {
        return txtKey;
    }

    public void setTxtKey(String txtKey) {
        this.txtKey = txtKey;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getDatOfbirth() {
        return datOfbirth;
    }

    public void setDatOfbirth(String datOfbirth) {
        this.datOfbirth = datOfbirth;
    }

    public String getTxtClocknum() {
        return txtClocknum;
    }

    public void setTxtClocknum(String txtClocknum) {
        this.txtClocknum = txtClocknum;
    }

    public Integer getIntType() {
        return intType;
    }

    public void setIntType(Integer intType) {
        this.intType = intType;
    }

    public BigDecimal getDblSalary() {
        return dblSalary;
    }

    public void setDblSalary(BigDecimal dblSalary) {
        this.dblSalary = dblSalary;
    }

    public Integer getIntDependents() {
        return intDependents;
    }

    public void setIntDependents(Integer intDependents) {
        this.intDependents = intDependents;
    }

    public Integer getIntUniversitystudents() {
        return intUniversitystudents;
    }

    public void setIntUniversitystudents(Integer intUniversitystudents) {
        this.intUniversitystudents = intUniversitystudents;
    }

    public BigDecimal getDblHoursperday() {
        return dblHoursperday;
    }

    public void setDblHoursperday(BigDecimal dblHoursperday) {
        this.dblHoursperday = dblHoursperday;
    }

    public Integer getBolWifeworks() {
        return bolWifeworks;
    }

    public void setBolWifeworks(Integer bolWifeworks) {
        this.bolWifeworks = bolWifeworks;
    }

    public String getTxtId() {
        return txtId;
    }

    public void setTxtId(String txtId) {
        this.txtId = txtId;
    }

    public BigDecimal getDblStarthour1() {
        return dblStarthour1;
    }

    public void setDblStarthour1(BigDecimal dblStarthour1) {
        this.dblStarthour1 = dblStarthour1;
    }

    public BigDecimal getDblEndhour1() {
        return dblEndhour1;
    }

    public void setDblEndhour1(BigDecimal dblEndhour1) {
        this.dblEndhour1 = dblEndhour1;
    }

    public BigDecimal getDblEndhour() {
        return dblEndhour;
    }

    public void setDblEndhour(BigDecimal dblEndhour) {
        this.dblEndhour = dblEndhour;
    }

    public BigDecimal getDblStarthour() {
        return dblStarthour;
    }

    public void setDblStarthour(BigDecimal dblStarthour) {
        this.dblStarthour = dblStarthour;
    }

}
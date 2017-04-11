/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="applicant")
public class Applicant implements Serializable{
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="applicant_id")
    private Long applicantId;
 
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="profession_id")
    private Profession profession;
 
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="applicant")
    private List<ApplicantResult> applicantResultList;
 
    @Column(name="first_name")
    private String firstName;
 
    @Column(name="last_name")
    private String lastName;
 
    @Column(name="middle_name")
    private String middleName;
 
    @Column(name="entrance_year")
    private Integer entranceYear;
 
    public Long getApplicantId() {
        return applicantId;
    }
 
    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }
 
    public List<ApplicantResult> getApplicantResultList() {
        return applicantResultList;
    }
 
    public void setApplicantResultList(List<ApplicantResult> applicantResultList) {
        this.applicantResultList = applicantResultList;
    }
 
    public Integer getEntranceYear() {
        return entranceYear;
    }
 
    public void setEntranceYear(Integer entranceYear) {
        this.entranceYear = entranceYear;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getMiddleName() {
        return middleName;
    }
 
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
 
    public Profession getProfession() {
        return profession;
    }
 
    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    
}
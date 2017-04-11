/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "applicant_result")
public class ApplicantResult implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_result_id")
    private Long applicantResultId;
 
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
 
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;
 
    @Column(name = "mark")
    private Integer mark;
 
    public Applicant getApplicant() {
        return applicant;
    }
 
    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
 
    public Long getApplicantResultId() {
        return applicantResultId;
    }
 
    public void setApplicantResultId(Long applicantResultId) {
        this.applicantResultId = applicantResultId;
    }
 
    public Integer getMark() {
        return mark;
    }
 
    public void setMark(Integer mark) {
        this.mark = mark;
    }
 
    public Subject getSubject() {
        return subject;
    }
 
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
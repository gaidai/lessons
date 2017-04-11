
package students.entity;


import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
 
@Entity
@Table(name = "subject")
public class Subject implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;
 
    @Column(name = "subject_name")
    private String subjectName;
 
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "SPECIALITY_SUBJECT",
    joinColumns = @JoinColumn(name = "SUBJECT_ID"),
    inverseJoinColumns = @JoinColumn(name = "PROFESSION_ID"))
    private Set<Profession> professionList;
 
    public Set<Profession> getProfessionList() {
        
        return professionList;
    }
 
    public void setProfessionList(Set<Profession> professionList) {
        this.professionList = professionList;
    }
 
    public Long getSubjectId() {
        return subjectId;
    }
 
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
 
    public String getSubjectName() {
        return subjectName;
    }
 
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

   
}
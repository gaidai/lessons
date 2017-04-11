package students.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
 
@Entity
@Table(name = "profession")
public class Profession implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profession_id")
    private Long professionId;
 
    @Column(name = "profession_name")
    private String professionName;
 
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "SPECIALITY_SUBJECT",
    joinColumns = @JoinColumn(name = "PROFESSION_ID"),
    inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID"))
    private Set<Subject> subjectList = new HashSet<Subject>();
 
    public Long getProfessionId() {
        return professionId;
    }
 
  
    public String getProfessionName() {
        return professionName;
    }
 
    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }
 
    public Set<Subject> getSubjectList() {
        return subjectList;
    }
 
    public void setSubjectList(Set<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public void setProfessionId(long aLong) {
        this.professionId=aLong ;
         //To change body of generated methods, choose Tools | Templates.
    }

    
}

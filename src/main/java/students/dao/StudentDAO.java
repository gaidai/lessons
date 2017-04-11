
package students.dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import students.entity.Applicant;
import students.entity.Profession;
import students.entity.Subject;
import students.utils.HibernateUtil;
 
public class StudentDAO {
 
    public Long addApplicant(Applicant applicant) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long result = (Long) session.save(applicant);
        session.getTransaction().commit();
        return result;
    }
 
    public void updateApplicant(Applicant applicant) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(applicant);
        session.getTransaction().commit();
    }
 
    public Applicant getApplicant(Long applicantId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Applicant result = (Applicant) session.load(Applicant.class, applicantId);
        // Насильная инициализация списка. Не очень хорошая практика так делать
        Hibernate.initialize(result.getApplicantResultList());
        session.getTransaction().commit();
        return result;
    }
 
    public List<Applicant> findApplicant() {
        // Если поменять первую строку на вторую, то исключение о неинициализированной коллекции
        // в классе Main уйдет.
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Applicant> result = session.createQuery("from Applicant order by lastName, firstName").list();
        // Насильная инициализация списка. Не очень хорошая практика так делать
        for (Applicant a : result) {
            Hibernate.initialize(a.getProfession());
        }
        session.getTransaction().commit();
        return result;
    }
 
    public Long addProfession(Profession profession) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long result = (Long) session.save(profession);
        session.getTransaction().commit();
        return result;
    }
 
    public void updateProfession(Profession profession) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(profession);
        session.getTransaction().commit();
    }
 
    public Profession getProfession(Long professionId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Profession result = (Profession) session.load(Profession.class, professionId);
        // Насильная инициализация списка. Не очень хорошая практика так делать
        Hibernate.initialize(result.getSubjectList());
        session.getTransaction().commit();
        return result;
    }
 
    public List<Profession> findProfession() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Profession> result = session.createQuery("from Profession order by professionName").list();
        // Насильная инициализация списка. Не очень хорошая практика так делать
        for (Profession a : result) {
            Hibernate.initialize(a.getSubjectList());
        }
        session.getTransaction().commit();
        return result;
    }
 
    public Long addSubject(Subject subject) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long result = (Long) session.save(subject);
        session.getTransaction().commit();
        return result;
    }
 
    public void updateSubject(Subject subject) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(subject);
        session.getTransaction().commit();
    }
 
    public Subject getSubject(Long subjectId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Subject result = (Subject) session.load(Subject.class, subjectId);
        // Насильная инициализация списка. Не очень хорошая практика так делать
        Hibernate.initialize(result.getProfessionList());
        session.getTransaction().commit();
        return result;
    }
 
    public List<Subject> findSubject() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Subject> result = session.createQuery("from Subject order by subjectName").list();
        // Насильная инициализация списка. Не очень хорошая практика так делать
        for (Subject a : result) {
            Hibernate.initialize(a.getProfessionList());
        }
        session.getTransaction().commit();
        return result;
    }
}
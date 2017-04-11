package students;

import students.entity.Profession;
import java.util.List;
import students.dao.StudentDAO;
import students.entity.Applicant;
import students.entity.Subject;
import students.utils.HibernateUtil;
 
public class Main {
 
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
 
        
 
        System.out.println("List of SUBJECTS");
        System.out.println("----------------");
        List<Subject> sbList = dao.findSubject();
        // В списке вы увидите, что предметы пока не привязаны к профессиям - количество = 0
        for (Subject a : sbList) {
            System.out.println(a.getSubjectId() + ":" + a.getSubjectName() +
                    ". Number of profession:" + a.getProfessionList().size());
        }
 
        // Теперь добавим профессии
        Profession profession = new Profession();
        profession.setProfessionName("Tester");
        // Список предметов, которые надо сдавать для этой профессии
        // Обратите внимание, что в классе Profession мы создаем пустой список
        // чтобы не было NullPointerException
        profession.getSubjectList().add(sbList.get(0));
        profession.getSubjectList().add(sbList.get(2));
        dao.addProfession(profession);
        profession = new Profession();
        profession.setProfessionName("Racer");
        profession.getSubjectList().add(sbList.get(1));
        profession.getSubjectList().add(sbList.get(2));
        profession = new Profession();
        profession.setProfessionName("UFOlog");
        profession.getSubjectList().add(sbList.get(1));
        profession.getSubjectList().add(sbList.get(2));
        // Получим профессию по ID и добавим еще один предмет для сдачи
        Long id = dao.addProfession(profession);
        profession = dao.getProfession(id);
        profession.getSubjectList().add(sbList.get(0));
        dao.updateProfession(profession);
 
        // Смотрим список профессий
        System.out.println();
        System.out.println("List of PROFESSIONS");
        System.out.println("-------------------");
        List<Profession> prList = dao.findProfession();
        for (Profession a : prList) {
            System.out.println(a.getProfessionId() + ":" + a.getProfessionName());
        }
 
        System.out.println();
        System.out.println("List of SUBJECTS");
        System.out.println("----------------");
        sbList = dao.findSubject();
        // В списке вы увидите, что предметы теперь привязаны к профессиям - количество > 0
        for (Subject a : sbList) {
            System.out.println(a.getSubjectId() + ":" + a.getSubjectName() +
                    ". Number of profession:" + a.getProfessionList().size());
        }
 
        // А теперь создадим новых абитуриентов
        Applicant applicant = new Applicant();
        applicant.setFirstName("Donny");
        applicant.setMiddleName("M");
        applicant.setLastName("brasko");
        // Задаем профессию
        applicant.setProfession(prList.get(0));
        applicant.setEntranceYear(2009);
        dao.addApplicant(applicant);
        applicant = new Applicant();
        applicant.setFirstName("Tony");
        applicant.setMiddleName("H");
        applicant.setLastName("Soprano");
        // Задаем профессию
        applicant.setProfession(prList.get(1));
        applicant.setEntranceYear(2008);
        dao.addApplicant(applicant);
        applicant = new Applicant();
        applicant.setFirstName("Ralf");
        applicant.setMiddleName("J");
        applicant.setLastName("Sifaretto");
        // Задаем профессию
        applicant.setProfession(prList.get(1));
        applicant.setEntranceYear(2007);
        dao.addApplicant(applicant);
 
        System.out.println();
        System.out.println("List of APPLICANTS");
        System.out.println("------------------");
        List<Applicant> apList = dao.findApplicant();
        for (Applicant a : apList) {
            System.out.println(a.getFirstName() + ":" + a.getLastName() + " - " + a.getProfession().getProfessionName());
        // Если убрать комментарий, то получим сообщене об ошибке - коллекция не инициализирована
        // Но еще можно посмотреть комментарий в StudentDAO (метод findApplicant()).
        //System.out.println(a.getProfession().getSubjectList().size());
        }
        HibernateUtil.closeSessionFactory();
    }
}
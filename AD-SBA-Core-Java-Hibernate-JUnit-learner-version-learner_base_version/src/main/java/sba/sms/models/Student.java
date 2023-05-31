package sba.sms.models;

import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id // gives email the primary key
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "Fk_student_email"),
            inverseJoinColumns = @JoinColumn(name = "courses_id"),
            inverseForeignKey = @ForeignKey(name = "Fk_courses_id")
    )

    private List<Course> courses;

    public Student() {};

    public Student(String email, String name, String password, List<Course> courses) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.courses = courses;
    }
    // - all args constructor

    public Student(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;	}

    public String getEmail() { return email; }

    @Override
    public int hashCode() {
        return Objects.hash(courses, email, name, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        return Objects.equals(courses, other.courses) && Objects.equals(email, other.email)
                && Objects.equals(name, other.name) && Objects.equals(password, other.password);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student [email=" + email + ", name=" + name + ", password=" + password + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> Courses) {
        this.courses = Courses;
    }

}


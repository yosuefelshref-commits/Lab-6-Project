public class Certificate {
    private static int nextId = 1;
    private final int  certificateId;
    private Student student;
    private Course course;

    public Certificate(Student student, Course course) {
        this.certificateId = nextId++;
        this.student = student;
        this.course = course;
    }


    public Student getStudent() {return student;}
    public Course getCourse() {return course;}
    public int getCertificateId() {return certificateId;}
}

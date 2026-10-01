package SchoolSystem;

class Teacher extends Person{
    private String subject;

    public Teacher(){
        subject = "No subject";
    }

    public Teacher(String subject){
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

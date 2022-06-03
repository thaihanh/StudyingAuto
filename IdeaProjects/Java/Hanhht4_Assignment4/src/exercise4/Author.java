package exercise4;

public class Author {
    private String name;
    private String email;
    private boolean isMale;

    //get & set

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getGender() {
        return isMale;
    }

    //constructor
    public Author(String name, String email, boolean isMale) {
        this.name = name;
        this.email = email;
        this.isMale = isMale;
    }

    private String displayGender(){
        return this.isMale ? "m" : "f";
    }

    @Override
    public String toString() {
        return this.name + " (" + this.displayGender() + ") " + "at " + this.email;
    }
}

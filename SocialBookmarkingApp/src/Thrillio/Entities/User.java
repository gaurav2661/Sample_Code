package Thrillio.Entities;

public class User {
    private long Id;
    private String Email;
    private String Password;

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", first_Name='" + first_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                ", Gender=" + Gender +
                ", user_Type='" + user_Type + '\'' +
                '}';
    }

    private String first_Name;
    private String last_Name;
    private int Gender;
    private String user_Type;


    // creating getters and setter for these private fields


    public long getID() {
        return Id;
    }

    public void setID(long ID) {
        this.Id = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String EMAIL) {
        this.Email = EMAIL;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String FIRST_NAME) {
        this.first_Name = FIRST_NAME;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String PASSWORD) {
        this.Password = PASSWORD;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String LAST_NAME) {
        this.last_Name = LAST_NAME;
    }

    public void setGender(int GENDER) {
        this.Gender = GENDER;
    }

    public int getGender() {
        return Gender;
    }

    public String getUser_Type() {
        return user_Type;
    }

    public void setUser_Type(String USER_TYPE) {
        this.user_Type = USER_TYPE;
    }

}

package entities;

public class User {

    public static final String  LOGIN = "login";
    public static final String  ID  = "id";
    public static final String  TYPE = "type";

    //For tests using JasonObject
    private String login;
    private int id;

    public String getLogin(){
        return login;
    }
    public int getId(){
        return id;
    }

}

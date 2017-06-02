package crescendo.com.crescendoapp;

/**
 * Created by Brandon on 5/18/2017.
 */

public class User {
    private String username;
    private String password;
    private int userID;

    public User(String username, String password)
    {
        userID = -1;
        this.username = username;
        this.password = password;
    }

    public User(int userID, String username, String password)
    {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String username)
    {
        this.password = password;
    }
    public int GetUserID() {return userID;}
    public void setUserID(int userID){this.userID = userID;}
}

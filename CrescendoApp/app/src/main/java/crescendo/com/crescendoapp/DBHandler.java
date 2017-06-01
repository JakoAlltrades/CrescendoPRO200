package crescendo.com.crescendoapp;

import com.intuit.quickbase.util.QuickBaseClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * Created by jprirm on 5/25/2017.
 */

public class DBHandler {
    QuickBaseClient QBClient;
    HashMap<String, String> tableNames = new HashMap<String, String>();

    public DBHandler() {
        QBClient = new QuickBaseClient("Jpriemo1234@gmail.com", "Crescendo1", "https://johnpriem.quickbase.com/db/");
        tableNames.put("Users", "bms24ytdy");
        tableNames.put("Recordings", "bms24ytgg");
        tableNames.put("Pitches", "bmtmx5ca8");
        //QBClient.setAppToken("duzpt2fcvsybbgkrkup4bjurh8b");
        //AddUserToDB();
        //GetsUserByID(1);
       // SignIn("Jack", "Priem");
    }

    public boolean CreateUser(String userName, String password)
    {
        boolean userCreated = false;
        if(!UserNameAlreadyUsed(userName)) {
            HashMap<String, String> User = new HashMap<String, String>();
            User.put("UserID", "1");//create a varible that gets the current id for the table (last id plus one);
            User.put("UserName", userName);
            User.put("UserPassword", password);
            try {
                QBClient.addRecord("bms24ytdy", User);
                userCreated = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userCreated;
    }

    private boolean UserNameAlreadyUsed(String userName)
    {
        boolean userNameUsed = false;
        try {
            Vector v = QBClient.doQuery(tableNames.get("Users"), "{7.EX.'" + userName + "'}", "a", "", "");
            if(v.size() > 0)
            {
                userNameUsed = true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return userNameUsed;
    }



    public User GetsUserByID(int id)
    {
        User user = null;
        try {
            //String tableID = QBClient.findDbByName("CrescendoDB");
            //Log.i("Table:", tableID);
            Vector v = QBClient.doQuery(tableNames.get("Users"), "{'0'.EX." + id + "}","a", "", "");
            //QBClient.doQuery("bms24ytdy", "{'0'.EX." + id + "}","UserID.UserName.UserPassword", "", "");
            Map<String, String> o = (Map<String, String>) v.get(0);
            Set<Map.Entry<String, String>> set = o.entrySet();
            String uName = null, uPassword = null;
            int userID;
            for(Map.Entry<String, String> e: set)
            {
                if(e.getKey().equals("UserID"))
                {
                   userID = Integer.parseInt(e.getValue());
                }
                if(e.getKey().equals("UserName"))
                {
                    uName = e.getValue();
                }
                if(e.getKey().equals("UserPassword"))
                {
                    uPassword =  e.getValue();
                }
            }
            user = new User(uName,uPassword);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return user;
    }

    public boolean SignIn(String userName, String password)
    {
        boolean userLoggedIn = false;
        try {
            Vector user = QBClient.doQuery(tableNames.get("Users"), "{7.EX.'" +userName+ "'}", "a","","");
            if(user.size() <= 1 && user.size() > 0)
            {
                Map<String, String> map = (Map<String, String>) user.get(0);
                for(Map.Entry<String,String> entry : map.entrySet())
                {
                    if(entry.getKey().equals("UserPassword"))
                    {
                        if(entry.getValue().equals(password))
                        {
                            userLoggedIn = true;
                        }
                        else
                        {
                            //invalid password
                        }
                    }
                }
            }
            else {
                //more than one user found
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLoggedIn;
    }



}

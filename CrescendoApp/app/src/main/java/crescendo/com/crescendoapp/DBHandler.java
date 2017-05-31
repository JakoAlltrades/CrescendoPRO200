package crescendo.com.crescendoapp;

import com.intuit.quickbase.util.QuickBaseClient;

import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * Created by jprirm on 5/25/2017.
 */

public class DBHandler {
    QuickBaseClient QBClient;

    public DBHandler() {
        QBClient = new QuickBaseClient("Jpriemo1234@gmail.com", "Crescendo1", "https://johnpriem.quickbase.com/db/");
        //QBClient.setAppToken("duzpt2fcvsybbgkrkup4bjurh8b");
        GetsUserByID(1);
    }

    public User GetsUserByID(int id)
    {
        User user = null;
        try {
            //String tableID = QBClient.findDbByName("CrescendoDB");
            //Log.i("Table:", tableID);
            Vector v = QBClient.doQuery("bms24ytdy", "{'0'.EX." + id + "}","a", "", "");
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


}

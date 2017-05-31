package crescendo.com.crescendoapp;

import com.intuit.quickbase.api.QuickBase;
import com.intuit.quickbase.api.QuickBaseAuthenticator;
import com.intuit.quickbase.api.QuickBaseConnection;
import com.intuit.quickbase.util.QuickBaseClient;

import java.util.Vector;

/**
 * Created by jprirm on 5/25/2017.
 */

public class DBHandler {
    QuickBaseConnection QBC;
    QuickBase QB;
    QuickBaseAuthenticator QBA;
    QuickBaseClient QBClient;

    public DBHandler() {

        //QBClient = new QuickBaseClient("Jpriemo1234@gmail.com", "Crescendo1", "https://johnpriem.quickbase.com/db/");
        QBClient = new QuickBaseClient("Jpriemo1234@gmail.com", "Crescendo1", "https://johnpriem.quickbase.com/db/");
        QBClient.setAppToken("duzpt2fcvsybbgkrkup4bjurh8b");
        GetsUserByID(1);
    }

    public void GetsUserByID(int id)
    {
        try {
            //String tableID = QBClient.findDbByName("CrescendoDB");
            //Log.i("Table:", tableID);
            Vector v = QBClient.doQuery("bms24ytdy", "{'0'.EX." + id + "}","0.1.2.3", "", "");
            //QBClient.doQuery("bms24ytdy", "{'0'.EX." + id + "}","UserID.UserName.UserPassword", "", "");
            Object o = v.get(0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}

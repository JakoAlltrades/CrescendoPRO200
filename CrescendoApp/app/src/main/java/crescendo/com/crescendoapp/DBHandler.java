package crescendo.com.crescendoapp;

import android.util.Log;

import com.intuit.quickbase.api.QuickBase;
import com.intuit.quickbase.api.QuickBaseAuthenticator;
import com.intuit.quickbase.api.QuickBaseConnection;
import com.intuit.quickbase.util.QuickBaseClient;

/**
 * Created by jprirm on 5/25/2017.
 */

public class DBHandler {
    QuickBaseConnection QBC;
    QuickBase QB;
    QuickBaseAuthenticator QBA;
    QuickBaseClient QBClient;

    public DBHandler() {

        QBClient = new QuickBaseClient("Jpriemo1234@gmail.com", "Crescendo1", "https://johnpriem.quickbase.com/db/bms24ys95");
        QBClient.setAppToken("bms24ys95");
        GetsUserByID(1);
    }

    public void GetsUserByID(int id)
    {
        try {
            String tableID = QBClient.findDbByName("CrescendoDB");
            Log.i("Table:", tableID);
            QBClient.doQuery("bms24ytdy", "{'0'.Ex.'" + id + "'}","UserID UserName UserPassword", "", "");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}

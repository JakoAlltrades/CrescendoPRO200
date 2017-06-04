package crescendo.com.crescendoapp;

import android.content.Context;

import com.intuit.quickbase.util.FileAttachment;
import com.intuit.quickbase.util.QuickBaseClient;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * Created by jprirm on 5/25/2017.
 */

public class DBHandler {
    Context c;
    QuickBaseClient QBClient;
    HashMap<String, String> tableNames = new HashMap<String, String>();
    int curID;

    public DBHandler(Context context) {
        c = context;
        QBClient = new QuickBaseClient("Jpriemo1234@gmail.com", "Crescendo1", "https://johnpriem.quickbase.com/db/");
        tableNames.put("Users", "bms24ytdy");
        tableNames.put("Recordings", "bms24ytgg");
        tableNames.put("Pitches", "bmtmx5ca8");
        CreateRecording(0, "image2030.PNG", new File(context.getExternalFilesDir("downloads"), "image2030.PNG"));
        //GrabPitch(8);
        //GrabPitches();
        //GrabRecords(0);
        //GrabRecord(7);
        //setCurID("Users");
        //QBClient.setAppToken("duzpt2fcvsybbgkrkup4bjurh8b");
        //AddUserToDB();
        //GetsUserByID(1);
       // SignIn("Jack", "Priem");
    }

    public Pitch GrabPitch(int PitchID)
    {
        Pitch pitch = null;
        try{
            Vector v= QBClient.doQuery(tableNames.get("Pitches"), "{'0'.EX." + PitchID +"}", "a", "", "");
            if(v.size() == 1)
            {
                Map<String,String> pitchRecord = (Map<String,String>) v.get(0);
                pitch = new Pitch(-1, "", "");
                for(Map.Entry<String,String> entry: pitchRecord.entrySet())
                {
                    if(entry.getKey().equals("PitchID"))
                    {
                        pitch.setPitchID(Integer.parseInt(entry.getValue()));
                    }
                    if(entry.getKey().equals("PitchName"))
                    {
                        pitch.setPitchName(entry.getValue());
                    }
                    if(entry.getKey().equals("Pitch"))
                    {
                        pitch.setPitchURL(entry.getValue());
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return pitch;
    }

    public ArrayList<Pitch> GrabPitches()
    {
        ArrayList<Pitch> pitches = new ArrayList<Pitch>();
        try{
            Vector pitchesCollection = QBClient.doQuery(tableNames.get("Pitches"), "{'0'.GTE.0}", "a","","");
            ArrayList<Integer> pitchIDs = new ArrayList<>();
            ArrayList<String> pitchName = new ArrayList<>();
            ArrayList<String> pitchURL = new ArrayList<>();
            for(int j = 0; j < pitchesCollection.size(); j++)
            {
                Map<String, String> map = (Map) pitchesCollection.get(j);
                for(Map.Entry<String, String> entry: map.entrySet())
                {
                    if(entry.getKey().equals("PitchID"))
                    {
                        pitchIDs.add(Integer.parseInt(entry.getValue()));
                    }
                    if(entry.getKey().equals("PitchName"))
                    {
                        pitchName.add(entry.getValue());
                    }
                    if(entry.getKey().equals("Pitch"))
                    {
                        pitchURL.add(entry.getValue());
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return pitches;
    }

    public boolean CreateRecording(int userID, String fileName, File file)
    {
        setCurID("Recordings");
        boolean recordingCreated = false;
        HashMap record = new HashMap<>();
        try{
            byte[] fileBytes;
            RandomAccessFile f = new RandomAccessFile(file, "r");//possibly reading phone directory
            fileBytes = new byte[(int) f.length()];
            f.readFully(fileBytes);

            FileAttachment fileAttachment = new FileAttachment(fileName,  fileBytes);
            record.put("RecordingID",curID + "");
            record.put("UserID", userID + "");
            record.put("RecordingTitle", fileName);
            record.put("Recording",fileAttachment);
            QBClient.addRecord(tableNames.get("Recordings"), record);
            recordingCreated = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return recordingCreated;
    }


    public boolean CreateUser(String userName, String password)
    {
        setCurID("Users");
        boolean userCreated = false;
        if(!UserNameAlreadyUsed(userName)) {
            HashMap<String, String> User = new HashMap<String, String>();
            User.put("UserID",  curID + "");//create a varible that gets the current id for the table (last id plus one);
            User.put("UserName", userName);
            User.put("UserPassword", password);
            try {
                QBClient.addRecord(tableNames.get("Users"), User);
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

    public int GetUserIDByUserName(String userName)
    {
        int userID = -1;
        try {
            Vector v = QBClient.doQuery(tableNames.get("Users"), "{7.EX.'" + userName + "'}", "a", "", "");
            Map<String, String> record = (Map) v.get(0);
            for(Map.Entry<String, String> entry: record.entrySet())
            {
                if(entry.getKey().equals("UserID"))
                {
                    userID = Integer.parseInt(entry.getValue());
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return userID;
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

    private void setCurID(String tableName)
    {
        curID = 0;
        try{
            Vector v = QBClient.doQuery(tableNames.get(tableName), "{'0'.GTE.'0'}", "6", "", "");
            for(int j = 0; j < v.size(); j++)
            {
                Map<String,String> map = (Map<String,String>) v.get(j);
                for(Map.Entry<String,String> entry: map.entrySet())
                {
                    int tempID = Integer.parseInt(entry.getValue());
                    if(tempID > curID)
                    {
                        curID = tempID;
                    }
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        curID+= 1;
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

    public ArrayList<Recording> GrabRecords(int userID)
    {
        ArrayList<Recording> recordings = null;
        try{
            Vector record = QBClient.doQuery(tableNames.get("Recordings"), "{7.EX." + userID + "}", "a", "", "");
            ArrayList<String> recordTitles = new ArrayList<>();
            ArrayList<String> recordIDs = new ArrayList<>();
            for(int j = 0; j < record.size(); j++)
            {
                Map<String, String> map = (Map<String, String>) record.get(j);
                for(Map.Entry<String,String> entry: map.entrySet())
                {
                    if(entry.getKey().equals("RecordingID"))
                    {
                        recordIDs.add(entry.getValue());
                    }
                    if(entry.getKey().equals("RecordingTitle"))
                    {
                        recordTitles.add(entry.getValue());
                    }
                }
            }
            recordings = new ArrayList<Recording>();
            for(int j = 0; j < recordIDs.size(); j++)
            {
                recordings.add(new Recording(recordTitles.get(j), Integer.parseInt(recordIDs.get(j))));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return recordings;
    }

    public byte[] GrabRecord(int recordID) {
        byte[] b= null;
        try {
            Vector record = QBClient.doQuery(tableNames.get("Recordings"),"{'6'.EX."+recordID+"}" , "a", "", "");
            Map<String, String> map;
            String recordingFileandURL = null, recordingTitle = null;
            map = (Map)record.get(0);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equals("Recording")) {
                    recordingFileandURL = entry.getValue();
                }
                if (entry.getKey().equals("RecordingTitle")) {
                    recordingTitle = entry.getValue();
                }
            }
            FileAttachment fileAttachment = new FileAttachment(recordingTitle, recordingFileandURL);
            recordingFileandURL = recordingFileandURL.replace(recordingTitle + ".mp3", "");
            recordingFileandURL = recordingFileandURL.replace("<url>", "");
            recordingFileandURL = recordingFileandURL.replace("</url>", "");
            b = QBClient.getFile(recordingFileandURL);
            //DownloadFileFromURL downloadFileFromURL = new DownloadFileFromURL();
            //b = fileAttachment.getContents();
            //downloadFileFromURL.execute(recordingFileandURL + recordingTitle + ".mp3");
            //downloadFileFromURL.downloadFile(recordingFileandURL + recordingTitle + ".mp3", recordingTitle + ".mp3", c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
}

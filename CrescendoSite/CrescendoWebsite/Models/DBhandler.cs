using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Intuit.QuickBase.Client;
using Intuit.QuickBase.Core;
using System.IO;

namespace CrescendoWebsite.Models
{
    public class DBhandler
    {
        IQClient client;
        IQApplication application;
        IQTable table;

        Dictionary<String, String> tableNames = new Dictionary<String, String> { { "Users", "bms24ytdy" }, { "Recordings", "bms24ytgg" }, { "Pitches", "bmtmx5ca8" } };

        private int curUserID;//handles the current UserID for the database
        public DBhandler()
        {
            client = QuickBase.Login("Jpriemo1234@gmail.com", "Crescendo1", "johnpriem.quickbase.com");
            application = client.Connect("bms24ys95", "duzpt2fcvsybbgkrkup4bjurh8b");
            table = application.GetTable(GetTableID("Users"));
            setCurUserID();
            //GetRecording();
            /*Pulls all users and prints their information
            foreach(IQRecord record in table.Records)
            {
                Console.WriteLine(record[0] + "- " + record[1] + ":" + record[2]);
            }*/

            //CreateUser("Jack", "Priem");
        }

        private string GetTableID(string TableName)
        {
            return tableNames.Where(x => x.Key == TableName).Select(x => x.Value).SingleOrDefault();
        }

        public bool CreateUser(String userName, String password)
        {
            //check the passwords before calling method
            table.Query();
            bool userCreated = false;
            IQRecord tempUser = table.Records.Where(x => x[1] == userName).SingleOrDefault();
            if (tempUser == null)
            {
                tempUser = table.NewRecord();
                tempUser[0] = curUserID.ToString();
                tempUser[1] = userName;
                tempUser[2] = password;
                table.Records.Add(tempUser);
                table.AcceptChanges();
                userCreated = true;
            }
            else
            {
                //Error username exists
            }
            return userCreated;
        }

        public bool SignIn(String userName, String password)
        {
            table.Query();
            bool userLoggedIn = false;
            IQRecord prevUser = table.Records.Where(x => x[1] == userName).SingleOrDefault();
            if (prevUser != null)
            {
                if (prevUser[2] == password)
                {
                    userLoggedIn = true;
                }
                else
                {
                    //User found wrong password
                }
            }
            else
            {
                //User not found, make sure that person entered their name correctly
            }
            return userLoggedIn;
        }

        public void GetRecording(int userID, int RecordingID)
        {
            table = application.GetTable(GetTableID("Recordings"));
            table.Query();
            IQRecord recording = table.Records.Where(x => x[1] == 0.ToString()).SingleOrDefault();
            //recording.DownloadFile("Recording", HttpContext.Current.Server.MapPath("/DataHolding/"), 1);
            //FileStream fs = File.Create(HttpContext.Current.Server.MapPath("/DataHolding/") + recording[3]);
        }
        //1
        private void IncrementCurUserID()
        {
            curUserID++;
        }

        private void setCurUserID()
        {
            table.Query();
            string lastID = "0";
            if (table.Records.Count > 0)
            { 
                lastID = table.Records.OrderByDescending(x => x[0]).Select(x => x[0]).First();
                table.Records.OrderBy(x => x[0]);
            }
            if(Int32.TryParse(lastID, out curUserID))
            {
                IncrementCurUserID();
                //Console.WriteLine("Current ID set to: " + curUserID);
            }
        }
    }
}
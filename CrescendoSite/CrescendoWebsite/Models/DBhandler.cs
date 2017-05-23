using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Intuit.QuickBase.Client;
using Intuit.QuickBase.Core;

namespace CrescendoWebsite.Models
{
    public class DBhandler
    {
        public DBhandler()
        {
            IQClient client = QuickBase.Login("Jpriemo1234@gmail.com", "Crescendo1", "johnpriem.quickbase.com");
            IQApplication application = client.Connect("bms24ys95", "duzpt2fcvsybbgkrkup4bjurh8b");
            IQTable table =  application.GetTable("bms24ytdy");

            foreach(var record in table.Records)
            {
                Console.WriteLine(record[0]);
            }
        }
    }
}
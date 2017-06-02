using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CrescendoWebsite.Models
{
    public class Recording
    {
        public int recordID { get; set; }
        public string RecordingName { get; set; }
        public double RecordingLength { get; set; }

        public Recording(int recordingID, string recordingName)
        {
            RecordingName = recordingName;
            recordID = recordingID;
        }
    }
}
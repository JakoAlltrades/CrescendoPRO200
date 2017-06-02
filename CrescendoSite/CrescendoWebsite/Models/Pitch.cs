using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CrescendoWebsite.Models
{
    public class Pitch
    {
        public int PitchID { get; set; }
        public string PitchName { get; set; }
        public string PitchFileName { get; set; }

        public Pitch(int PitchID, string PitchName, string PitchFileName)
        {
            this.PitchID = PitchID;
            this.PitchName = PitchName;
            this.PitchFileName = PitchFileName;
        }
    }
}
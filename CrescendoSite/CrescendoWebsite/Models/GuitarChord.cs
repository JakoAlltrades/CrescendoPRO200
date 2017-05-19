using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CrescendoWebsite.Models
{
    public class GuitarChord
    {
        public string ChordName { get; set; } // ie c Major
        public int[] stringPositions { get; set; } // maybe an int-int representation, or char-int. string first, then fret i.e. 1(string) 2(fret) or E2
        // could also represent this as 6 integers, the fret for each string in the chord, such as 0, 3, 2, 0, 1, 0 which would be a c major chord

        public int GetDisplayRange()
        {
            // this will get the number of frets needed to be displayed, for a c major, a minimum of 3 frets need to be shown, frets 1 - 3
            throw new NotImplementedException();
        }


    }
}
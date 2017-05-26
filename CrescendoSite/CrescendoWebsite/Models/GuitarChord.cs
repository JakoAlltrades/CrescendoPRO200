using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CrescendoWebsite.Models
{
    public class GuitarChord
    {
        public string ChordName { get; set; } // ie c Major
        public int[] StringPositions { get; set; } // maybe an int-int representation, or char-int. string first, then fret i.e. 1(string) 2(fret) or E2
        // could also represent this as 6 integers, the fret for each string in the chord, such as 0, 3, 2, 0, 1, 0 which would be a c major chord

        public GuitarChord(string chordName, int[] stringPos)
        {
            ChordName = chordName;
            StringPositions = stringPos;
        }

        public int GetDisplayRange()
        {
            // this will get the number of frets needed to be displayed, for a c major, a minimum of 3 frets need to be shown, frets 1 - 3
            List<int> strings = StringPositions.ToList();
            int min = strings.Min();
            int max = strings.Max();
            int range = (min - max) + 1;
            return range;
        }

        public string GetTabForm()
        {
            string tab = "\n";

            tab += ChordName + "\n";

            foreach (int j in StringPositions)
            {
                tab += "-" + j + "-\n";
            }

            return tab;
        }

        public static List<GuitarChord> GetBasicChords()
        {
            List<GuitarChord> chords = new List<GuitarChord>();
            chords.Add(new GuitarChord("C", new int[] { 0, 3, 2, 0, 1, 0 }));
            chords.Add(new GuitarChord("A", new int[] { 0, 0, 1, 2, 3, 0 }));
            chords.Add(new GuitarChord("G", new int[] { 2, 1, 0, 0, 0, 3 }));
            chords.Add(new GuitarChord("E", new int[] { 0, 2, 3, 1, 0, 0 }));
            chords.Add(new GuitarChord("D", new int[] { 0, 0, 0, 1, 3, 2 }));
            chords.Add(new GuitarChord("Am", new int[] { 0, 0, 2, 3, 1, 0 }));
            chords.Add(new GuitarChord("Em", new int[] { 0, 2, 3, 0, 0, 0 }));
            chords.Add(new GuitarChord("Dm", new int[] { 0, 0, 0, 2, 3, 1 }));

            return chords;
        }
    }
}
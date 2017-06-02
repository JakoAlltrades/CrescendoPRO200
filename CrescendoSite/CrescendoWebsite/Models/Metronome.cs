using System;
using System.Collections.Generic;
using System.Linq;
using System.Media;
using System.Web;
using System.Web.UI;

namespace CrescendoWebsite.Models
{
    public class Metronome
    {
        public int BeatsPerMin { get; set; }
        private const int minuteMilTime = 60000;
        public SoundPlayer Player { get; set; }

        public Metronome(SoundPlayer player, int bpm)
        {
            BeatsPerMin = bpm;
            Player = player;
            player.Load();
        }
        public int GetInterval()
        {
            return (minuteMilTime / BeatsPerMin);
        }
        public void MetronomeTick(object sender, EventArgs e)
        {
            Player.Play();
        }
    }
}
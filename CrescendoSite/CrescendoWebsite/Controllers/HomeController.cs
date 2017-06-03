using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using CrescendoWebsite.Models;


namespace CrescendoWebsite.Controllers
{
    public class HomeController : Controller
    {
        DBhandler db = new DBhandler();
        static List<GuitarChord> chords = GuitarChord.GetBasicChords();

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Login()
        {
            return View();
        }
        [HttpPost]
        public ActionResult Login(User u)
        {
            ViewResult vr = View();
            bool isUser = db.SignIn(u.UserName, u.UserPassword);
            if (isUser)
            {
                vr = View("UserHome", u);
            }
            return vr;
        }

        public ActionResult NewUser()
        {
            return View();
        }
        [HttpPost]
        public ActionResult NewUser(User u)
        {
            ViewResult vr = View();
            bool createSucces = db.CreateUser(u.UserName, u.UserPassword);
            if (createSucces)
            {
                vr = View("UserHome", u);
            }
            return vr;
        }

        public ActionResult UserHome(User u)
        {
            ViewResult vr = View("Index");
            if (u != null)
            {
                vr = View(u);
            }
            return vr;
        }

        public ActionResult UserData(User u)
        {
            ViewResult vr = View("Index");
            if (u != null)
            {
               int userid =  db.GetUserIDByUserName(u.UserName);
                ViewBag.Recordings = db.GrabRecordings(userid);
                vr = View(u);
            }
            return vr;
        }

        public ActionResult Recordings(User u) // this should take a list<Recording> instead? or maybe user just has a list of Recordings?
        {
            ViewResult vr = View("Index");
            if (u != null)
            {
                //ViewBag.recordings = DBhandler.GetRecordings(u);
                vr = View(u);
            }
            return vr;
        }

        public ActionResult Chords(User u)
        {
            ViewResult vr = View("Index");

            if (u != null)
            {
                ViewBag.chords = chords;
                vr = View(u);
            }
            return vr;
        }
    }
}
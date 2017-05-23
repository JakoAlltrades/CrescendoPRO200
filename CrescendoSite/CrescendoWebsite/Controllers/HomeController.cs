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
            ViewResult vr = null;
            vr = View("UserHome", u);
            return vr;
        }

        public ActionResult NewUser()
        {
            return View();
        }
        [HttpPost]
        public ActionResult NewUser(User u)
        {
            ViewResult vr = null;
            vr = View("UserHome", u);
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
                vr = View(u);
            }
            return vr;
        }

        public ActionResult Recordings(User u) // this should take a list<Recording> instead? or maybe user just has a list of Recordings?
        {
            ViewResult vr = View("Index");
            if (u != null)
            {
                vr = View(u);
            }
            return vr;
        }
    }
}
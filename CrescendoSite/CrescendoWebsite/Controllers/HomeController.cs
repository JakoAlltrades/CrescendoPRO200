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
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }        
    }
}
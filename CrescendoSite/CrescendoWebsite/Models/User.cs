﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CrescendoWebsite.Models
{
    public class User
    {
        public int? UserID { get; private set; } 
        public string UserName { get; set; }
        public string UserPassword { get; set; }
        public User()
        {
            UserID = null;
            UserName = null;
            UserPassword = null;
        }

        public User(string userName, string userPassword)
        {
            UserID = null;
            UserName = userName;
            UserPassword = userPassword;
        }

        public User(int userID, string userName, string userPassword)
        {
            UserID = userID;
            UserName = userName;
            UserPassword = userPassword;
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Services.JavaMail;



/**
 *
 * @author Eya
 */
public class MailerService {
    public void replyMail(String mail ,String Username , String subject, String Description) {
        String from = "trippytravel9@gmail.com";
        String pass = "trippy2022";
        String[] to = {"" + mail}; // list of recipient email addresses
        //subject = "test";
        String body = Description;
        JavaMail serv = new JavaMail();
        serv.sendFromGMail(from,pass,to,subject,body);
    }
}

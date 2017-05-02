package org.launchcode.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

/**
 * Created by carlylanglois on 5/1/17.
 */
@Controller
//@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody

    public String index(HttpServletRequest request) {

        String userName = request.getParameter("name");

        if (userName == null) {
            userName = "World";
        }

        return "Hello " + userName;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" +
                "<input type='text' name='name'/>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";

        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {

        String userName = request.getParameter("name");

        return "Hello " + userName;

    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {

        return "Hello " + name;

    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }

    @RequestMapping(value = "helloMessage", method = RequestMethod.GET)
    @ResponseBody
    public String helloLanguageForm() {

        String html = "<form method='post'>" +
                        "<input type='text' name='name'/>" +
                        "<select name='language'>" +
                            "<option>English</option>" +
                            "<option>Japanese</option>" +
                            "<option>French</option>" +
                            "<option>Spanish</option>" +
                            "<option>German</option>" +
                        "</select>" +
                        "<input type='submit' name='Greet me!'/>" +
                    "</form>";

        return html;
    }

    public static String createMessage(String name, String lang){

        if (lang.equals("English")){
            return "Hello " + name;
        } else if (lang.equals("Japanese")){
            return "Konichiwa " + name;
        } else if (lang.equals("French")){
            return "Bonjour " + name;
        } else if (lang.equals("Spanish")){
            return "Hola " + name;
        } else {
            return "Hallo " + name;
        }
    }


    @RequestMapping(value = "helloMessage", method = RequestMethod.POST)
    @ResponseBody
    public String helloLanguagePost(HttpServletRequest request) {

        String name = request.getParameter("name");
        String lang = request.getParameter("language");

        return createMessage(name, lang);



    }
}

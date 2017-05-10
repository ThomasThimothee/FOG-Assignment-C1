package presentation.utility;

import business.Customer;
import business.Order;
import java.util.List;


/**
 *
 * @author mathiasjepsen
 */
public class RenderUtils {
    
    public String createNavBar(String[] navBarItems) {
        String  s = "";
                s += "<nav class=\"navbar navbar-default\" role=\"navigation\">";
                s +=    "<div class=\"container\">";
                s +=        "<div class=\"navbar-header\">";
                s +=            "<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">";
                s +=                "<span class=\"sr-only\">Toggle navigation</span>";
                s +=                "<span class=\"icon-bar\"></span>";
                s +=                "<span class=\"icon-bar\"></span>";
                s +=                "<span class=\"icon-bar\"></span>";
                s +=            "</button>";
                s +=            "<a class=\"navbar-brand\" href=\"index.html\">Johannes Fog</a>";
                s +=        "</div>";
                s +=        "<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">";
                s +=            "<ul class=\"nav navbar-nav\">";
                                    for (String str : navBarItems) {
                                        String[] items = str.trim().split("\\s*,\\s*");
                                        if (items.length > 2) {
                s +=                        "<li class=\"dropdown\">";
                s +=                            "<a href=\"javascript:void(0)\" class=\"dropbtn\">" + items[0] + "</a>";
                s +=                            "<div class=\"dropdown-content\">";
                                                for (int i = 1; i <= items.length - 2; i += 2) {
                s +=                                "<a href=\"" + items[i + 1] + "\">"+ items[i] + "</a>";
                                                }
                s +=                            "</div>";
                s +=                        "</li>";
                                        } else {
                s +=                        "<li>";
                s +=                            "<a href=\"" + items[1] + "\">" + items[0] + "</a>";
                s +=                        "</li>";
                                        }
                                    }
                s +=            "</ul>";
                s +=        "</div>";
                s +=    "</div>";
                s += "</nav>";
        return s;
    }
    
    public String createFormRows(String[] values) {
        String  s = "";
                for (String str : values) {
                    String[] words = {};
                    boolean isMultipleWords = false;
        s +=        "<div class=\"form-group\">";
        s +=            "<div class=\"col-xs-offset-2 col-xs-8\">";
                            for (int i = 0; i < str.length() - 1; i++) {
                                if (Character.isUpperCase(str.charAt(i))) {
                                    words = str.split("(?=\\p{Upper})");
                                    isMultipleWords = true;
                                    break;
                                }
                            }
                            if (isMultipleWords) {
        s +=                    "<input class=\"form-control\" type=\"text\" id=\"" + str.substring(0, 1).toUpperCase() + str.substring(1) + "\" name=\"" + str + "\" placeholder=\"";
                                String placeholder = "";
                                for (int i = 0; i < words.length; i++) {
                                    placeholder += words[i].substring(0, 1).toUpperCase() + words[i].substring(1) + " ";                
                                }
                                String result = placeholder.trim();
        s +=                    result;            
        s +=                    "\" />";
                            } else {
        s +=                    "<input class=\"form-control\" type=\"text\" id=\"" + str.substring(0, 1).toUpperCase() + str.substring(1) + "\" name=\"" + str.toLowerCase() + "\" placeholder=\"" + str.substring(0, 1).toUpperCase() + str.substring(1) + "\" />";
                            } 
        s +=            "</div>";
        s +=        "</div>";
                }
        return s;
    }

    
    public String createFormRows(Customer customer) {
        String  s = "";
                        String[] fieldNames = {"email", "password", "firstName", "lastName", "address", "phone"};
                        String[] fieldValues = {customer.getEmail(), customer.getPassword(), customer.getFirstName(), customer.getLastName(), customer.getAddress(), customer.getPhone()};
                        for (int i = 0; i < fieldNames.length; i++) {
                s +=        "<div class=\"form-group\">";
                s +=            "<div class=\"col-xs-offset-2 col-xs-8\">";
                s +=                "<h5>";
                s +=                fieldNames[i].substring(0, 1) + fieldNames[i].substring(1);
                s +=                "</h5>";
                s +=                "<input class=\"form-control\" type=\"text\" id=\"" + fieldNames[i].substring(0, 1).toUpperCase() + fieldNames[i].substring(1) + "\" name=\"" + fieldNames[i] + "\" value=\"" + fieldValues[i] + "\" />";
                s +=            "</div>";
                s +=        "</div>";
                        }
        return s;
    }

}

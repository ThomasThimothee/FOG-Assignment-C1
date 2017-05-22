package presentation.utility;

import business.Customer;
import business.Order;
import java.util.ArrayList;
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
    
    public String createCarousel() {
        String  s =  "";
                s += "<div class=\"container\">";
                s += "<div class=\"row\">";
                s += "<div class=\"col-xs-offset-2 col-xs-8 text-center\">";
                s +=    "<div class=\"box\">";
                s +=        "<div id=\"carousel-example-generic\" class=\"carousel slide\">";
                s +=            "<!-- Indicators -->";
                s +=            "<ol class=\"carousel-indicators hidden-xs\">";
                s +=                "<li data-target=\"#carousel-example-generic\" data-slide-to=\"0\" class=\"active\"></li>";
                s +=                "<li data-target=\"#carousel-example-generic\" data-slide-to=\"1\"></li>";
                s +=            "</ol>";
                s +=
                s +=            "<!-- Wrapper for slides -->";
                s +=            "<div class=\"carousel-inner\">";
                s +=                "<div class=\"item active\">";
                s +=                    "<a href=\"flatOrder.jsp\"><img class=\"img-responsive img-full\" src=\"img/flatCarport.jpg\" alt=\"\"></a>";
                s +=                "</div>";
                s +=                "<div class=\"item\">";
                s +=                    "<a href=\"pointyOrder.jsp\"><img class=\"img-responsive img-full\" src=\"img/pointyCarport.jpg\" alt=\"\"></a>";
                s +=                "</div>";
                s +=            "</div>";

                s +=            "<!-- Controls -->";
                s +=            "<a class=\"left carousel-control\" href=\"#carousel-example-generic\" data-slide=\"prev\">";
                s +=                "<span class=\"icon-prev\"></span>";
                s +=            "</a>";
                s +=            "<a class=\"right carousel-control\" href=\"#carousel-example-generic\" data-slide=\"next\">";
                s +=                "<span class=\"icon-next\"></span>";
                s +=            "</a>";
                s +=         "</div>";
                s +=      "</div>";
                s +=    "</div>";
                s +=  "</div>";
                s +=  "</div>";
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
    
    public String createCustomerFormRows(Customer customer) {
        String  s = "";
                        String[] fieldNames = {"email", "password", "firstName", 
                                               "lastName", "address", "phone"};
                        String[] fieldValues = {customer.getEmail(), customer.getPassword(), 
                                                customer.getFirstName(), customer.getLastName(), 
                                                customer.getAddress(), customer.getPhone()};
                        for (int i = 0; i < fieldNames.length; i++) {
                s +=        "<div class=\"form-group\">";
                s +=            "<div class=\"col-xs-offset-2 col-xs-8\">";
                s +=                "<h5>";
                s +=                    fieldNames[i].substring(0, 1) + fieldNames[i].substring(1);
                s +=                "</h5>";
                s +=                "<input class=\"form-control\" type=\"text\" id=\"" + 
                                    fieldNames[i].substring(0, 1).toUpperCase() + fieldNames[i].substring(1) + 
                                    "\" name=\"" + fieldNames[i] + "\" value=\"" + fieldValues[i] + "\" />";
                s +=            "</div>";
                s +=        "</div>";
                        }
        return s;
    }
    
    
    public String createEmployeeOverviewTable(List<Order> orders) {
        String  s = "";
        for (Order order : orders) {
            ArrayList<String> orderFields = order.createEmployeeVariableArray(order);
            s += "<tr>";
                for (String field : orderFields) {
            s +=    "<td>" + field + "</td>";
                }
            s += "</tr>";
        }
        return s;
    }
    
    public String createCustomerOverviewTable(List<Order> orders) {
        String  s = "";
        for (Order order : orders) {
            ArrayList<String> orderFields = order.createCustomerVariableArray(order);
            s += "<tr>";
                for (String field : orderFields) {
            s +=    "<td>" + field + "</td>";
                }
            s += "</tr>";
        }
        return s;
    }
    
    public String createDimensionsSelection(ArrayList<int[]> values, String[] names) {
        int columnSpacing = 12 / names.length;
        String  s = "";
                    for (int i = 0; i < names.length; i++) {
                s +=    "<div class=\"col-xs-" + columnSpacing + "\">";
                        String[] words = names[i].trim().split("\\s*,\\s*");
                s +=    "<h5>";
                        for (String word : words) {
                s +=        word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
                        }
                s =     s.trim();
                s +=    "</h5>";
                s +=        "<select class=\"form-control\" name=\"" + names[i] + "\">";
                                for (int value : values.get(i)) {
                s +=                "<option>" + value + "</option>";
                                }
                s +=        "</select>";
                s +=    "</div>";
                    }
        return s;
    }
}

package business.utility;

/**
 *
 * @author mathiasjepsen
 */
public class RenderUtils {
    
    public String createNavBar(String[] navBarItems) {
        String s = "";
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
                                    s += "<li class=\"dropdown\">";
                                    s +=    "<a href=\"javascript:void(0)\" class=\"dropbtn\">" + items[0] + "</a>";
                                    s +=    "<div class=\"dropdown-content\">";
                                                for (int i = 1; i <= items.length - 2; i += 2) {
                                    s +=            "<a href=\"" + items[i + 1] + "\">"+ items[i] + "</a>";
                                                }
                                    s +=    "</div>";
                                    s += "</li>";
                                } else {
                                    s += "<li>";
                                    s +=    "<a href=\"" + items[1] + "\">" + items[0] + "</a>";
                                    s += "</li>";
                                }
                            }
        s +=            "</ul>";
        s +=        "</div>";
        s +=    "</div>";
        s += "</nav>";
        return s;
    }
    
}

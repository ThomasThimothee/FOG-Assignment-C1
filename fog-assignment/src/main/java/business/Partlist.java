package business;

import business.parts.Part;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathiasjepsen
 */
public class Partlist {
    private List<Part> partList;

    public Partlist() {
        this.partList = new ArrayList<>();
    }

    public List<Part> getPartList() {
        return partList;
    }

    public void setPartList(List<Part> partList) {
        this.partList = partList;
    }

    
    
}

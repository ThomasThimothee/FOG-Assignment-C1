package business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathiasjepsen
 */
public class Partlist {
    
    private final List<Wood> woodParts;
    private final List<Screw> screwParts;

    public Partlist() {
        this.woodParts = new ArrayList<>();
        this.screwParts = new ArrayList<>();
    }

    public List<Wood> getWoodParts() {
        return woodParts;
    }

    public List<Screw> getScrewParts() {
        return screwParts;
    }
    
}

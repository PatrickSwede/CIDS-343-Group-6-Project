package Props;

import java.util.ArrayList;

public interface Inventory {


    public ArrayList<ActiveProp> getActiveProps();

    public ArrayList<PassiveProp> getPassiveProps();

    public void setActiveProps(ArrayList<ActiveProp> activeProps);

    public void setPassiveProps(ArrayList<PassiveProp> passiveProps);
}

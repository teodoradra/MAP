package Model.Value;

import Model.Type.BoolType;
import Model.Type.Type;

public class BoolValue implements Value {
    private boolean val;
    public BoolValue(boolean v){val = v;}

    public boolean getVal() {return val;}
    public String toString()
    {
        return "Value: " + val;
    }
    public Type getType() { return new BoolType();}

}

package Model.Value;

import Model.Type.RefType;
import Model.Type.Type;

public class RefValue implements Value {
    private int address;
    private Type locationType;

    public RefValue(int add, Type lT){
        address = add;
        locationType = lT;
    }

    @Override
    public String toString(){
        return "( "+ address + " , " + locationType + " )";
    }
    int getAddr() {return address;}

    public void setAddress(int newAdd){ address = newAdd;}

    public Type getType() { return new RefType(locationType);}

    public int getAddress() {
        return address;
    }


    public Type getLocationType() {
        return locationType;
    }

}

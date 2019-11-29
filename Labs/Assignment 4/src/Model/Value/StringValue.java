package Model.Value;

import Model.Type.IntType;
import Model.Type.StringType;
import Model.Type.Type;

public class StringValue implements Value {
    private String value;

    public StringValue(String val){value=val;};

    public String getVal() {return value;}

    @Override
    public String toString()
    {
        return "Value: " + value;
    }

    public Type getType() { return new StringType();}
}

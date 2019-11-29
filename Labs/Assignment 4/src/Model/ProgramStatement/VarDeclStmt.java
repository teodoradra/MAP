package Model.ProgramStatement;

import Controller.PrgState;
import Model.Type.*;
import Model.Value.Value;

public class VarDeclStmt implements IStmt {
    private String name;
    private Type type;

    public VarDeclStmt(String n, Type t){
        name = n;
        type = t;
    }

    @Override
    public PrgState execute(PrgState state) {
//        if (type.equals(new IntType())) {
//            Value v = type.defaultValue();
//            state.getSymbolTable().add(name, v);
//        }
//        if (type.equals(new BoolType())) {
//            Value v = type.defaultValue();
//            state.getSymbolTable().add(name, v);
//        }
//        if (type.equals(new StringType())) {
//            Value v = type.defaultValue();
//            state.getSymbolTable().add(name, v);
//        }
//        if (type.equals(new RefType(new IntType()))) {
//            Value v = type.defaultValue();
//            state.getSymbolTable().add(name, v);
//        }
//        if (type.equals(new RefType(new RefType(new IntType())))) {
//            Value v = type.defaultValue();
//            state.getSymbolTable().add(name, v);
//        }
        Value v = type.defaultValue();
        state.getSymbolTable().add(name, v);


        return null;
    }

    public String toString()
    {
        return type.toString() + "  " + name;
    }
}

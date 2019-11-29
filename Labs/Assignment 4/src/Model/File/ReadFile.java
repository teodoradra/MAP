package Model.File;

import Controller.PrgState;
import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.Expressions.Exp;
import Model.MyException;
import Model.ProgramStatement.IStmt;
import Model.Type.IntType;
import Model.Type.StringType;
import Model.Value.IntValue;
import Model.Value.StringValue;
import Model.Value.Value;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile implements IStmt {
    private Exp var;
    private String var_name;

    public ReadFile(Exp var, String var_name) {
        this.var = var;
        this.var_name = var_name;
    }

    @Override
    public String toString() {
        return "readFile("+var.toString() +", "+ var_name +")";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> symbolTable = state.getSymbolTable();
        MyIDictionary<String, BufferedReader> fileTable = state.getFileTable();
        HeapI<Integer,Value> heap = state.getHeap();

        Value uniq = var.eval(symbolTable,heap);
        if(!uniq.getType().equals(new StringType()))
            throw new MyException("Var not a string");

        StringValue file = (StringValue) uniq;
        BufferedReader b = fileTable.get(file.getVal());

        if (b==null)
            throw new MyException("there is no entry for this key!");

        if(!symbolTable.get(var_name).getType().equals(new IntType()))
            throw new MyException("Var_name not a int");

        if (symbolTable.get(var_name)==null)
            throw new MyException("Variable does not exist!\n");

        String line;
        try{
            assert false;
            line = b.readLine();
        } catch (IOException e) {
            throw new MyException("cannot read from this file!!\\n ");
        }
        IntValue val;
        if(line==null)
            val = new IntValue(0);
        else
            try{
                val =new IntValue(Integer.parseInt(line)) ;
            }
            catch (NumberFormatException e){
                val = new IntValue(0);
            }
        symbolTable.add(var_name,val);

        return null;
    }
}

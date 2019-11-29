package Model.ProgramStatement;

import Controller.PrgState;
import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIStack;
import Model.Expressions.Exp;
import Model.MyException;
import Model.Value.IntValue;
import Model.Value.Value;

import java.io.FileNotFoundException;

public class WhileStmt implements IStmt {
    private Exp expression;
    private IStmt statement;

    public WhileStmt(Exp expression, IStmt statement){
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public String toString() {
        return "while( " + expression.toString() + "){\n    " + statement.toString() + "\n}";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, FileNotFoundException {
        MyIDictionary<String, Value> symbolTable = state.getSymbolTable();
        HeapI<Integer, Value> heapTable = state.getHeap();
        Value expressionResult;

        expressionResult = expression.eval(symbolTable, heapTable);
        IntValue val = (IntValue) expressionResult;
        if(val.getVal()!= 0){
            MyIStack<IStmt> stack = state.getExecutionStack();

            stack.push(this);
            state.setExecutionStack((MyIStack<IStmt>) stack);
            statement.execute(state);
        }

        return null;
    }
}

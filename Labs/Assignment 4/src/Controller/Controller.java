package Controller;

import Model.DataStructures.*;
import Model.MyException;
import Model.ProgramStatement.IStmt;
import Model.Value.RefValue;
import Model.Value.Value;
import Repository.RepoI;
import jdk.nashorn.internal.ir.CallNode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {
    private RepoI repository;

    public Controller(RepoI r){ repository = r;}

    private void oneStepExecution(PrgState state) throws MyException, FileNotFoundException {
        MyIStack<IStmt> stk = state.getExecutionStack();
        if (stk.isEmpty()) throw new MyException("Program state is empty!");
        IStmt crtStmt = stk.pop();
        crtStmt.execute(state);
    }

    public void allStep() throws IOException, MyException {
        PrgState prg = repository.getCrtPrg();

        while (!prg.getExecutionStack().isEmpty()){
            oneStepExecution(prg);
            HeapI<Integer,Value> heap = prg.getHeap();
            MyIDictionary<String,Value> sym =prg.getSymbolTable();
            setHeapContent(unsafeGarbageCollector(getAddrFromSymTable(prg.getSymbolTable().getDictVal()),heap.getHeap()),prg);
            //prg.setHeap(unsafeGarbageCollector(getAddrFromSymTable(prg.getSymbolTable().getDictVal()),heap.getHeap()));

            repository.logPrgStateExec();
        }
        MyIList<Value> out = prg.getOutputList();
        System.out.println("\n\n");
        System.out.println(out.toString());
        System.out.println("\n\n");
    }

    public void addProgState(PrgState p){
        repository.addToRepo(p);
    }

    private Map<Integer, Value> unsafeGarbageCollector(List<Integer> symTableAddr, Map<Integer, Value> heap){
        return heap.entrySet().stream().filter(e->symTableAddr.contains(e.getKey())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    private void setHeapContent(Map<Integer, Value> newHeap, PrgState state){
        HeapI<Integer,Value> heap = state.getHeap();
        heap.setHeapContent(newHeap);
    }
    private List<Integer> getAddrFromSymTable(Collection<Value> symTableValues) {
        return symTableValues.stream()
                .filter(v -> v instanceof RefValue)
                .map(v -> {
                    RefValue v1 = (RefValue) v;
                    return v1.getAddress();
                })
                .collect(Collectors.toList());
    }
}

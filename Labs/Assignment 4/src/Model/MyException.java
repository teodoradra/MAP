package Model;

public class MyException extends Exception {
    private String msg;

    public MyException(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }
}

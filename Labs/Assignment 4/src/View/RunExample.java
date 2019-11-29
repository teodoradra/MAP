package View;

import Controller.Controller;
import Model.MyException;

import java.io.IOException;

public class RunExample extends Command {
    private Controller controller;
    RunExample(String key, String desc, Controller ctrl){ super(key,desc); controller = ctrl;}

    @Override
    public void execute(){
        try{
            controller.allStep();
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
    }
}

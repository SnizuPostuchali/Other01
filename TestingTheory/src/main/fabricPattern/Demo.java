package main.fabricPattern;

import main.fabricPattern.factory.Dialog;
import main.fabricPattern.factory.HtmlDialog;
import main.fabricPattern.factory.WindowsDialog;

public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure(){
        if(System.getProperty("os.name").equals("Windows 10")){
            System.out.println("windows");
            dialog = new WindowsDialog();
        } else {
            System.out.println("html");
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogic(){
        System.out.println("business");
        dialog.renderWindow();
    }
}

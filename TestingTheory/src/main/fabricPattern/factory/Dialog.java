package main.fabricPattern.factory;

import main.fabricPattern.buttons.Button;

public abstract class Dialog {
    public void renderWindow(){
        System.out.println("render windows");
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();

}

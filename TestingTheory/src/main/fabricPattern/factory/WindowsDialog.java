package main.fabricPattern.factory;

import main.fabricPattern.buttons.Button;
import main.fabricPattern.buttons.WindowsButton;

public class WindowsDialog extends Dialog{
    @Override
    public Button createButton() {
        System.out.println("windows button create");
        return new WindowsButton();
    }
}

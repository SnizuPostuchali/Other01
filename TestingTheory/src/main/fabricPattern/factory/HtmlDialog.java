package main.fabricPattern.factory;

import main.fabricPattern.buttons.Button;
import main.fabricPattern.buttons.HtmlButton;

public class HtmlDialog extends Dialog{
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}

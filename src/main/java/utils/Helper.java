package utils;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class Helper {

    public static void showWarningDialog(String msg){
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Warning");
        dialog.setContentText(msg);
        ButtonType buttonType = new ButtonType("OK");
        dialog.getDialogPane().getButtonTypes().add(buttonType);
        dialog.showAndWait();
    }
}

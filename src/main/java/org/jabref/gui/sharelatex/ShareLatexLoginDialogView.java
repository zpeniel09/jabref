package org.jabref.gui.sharelatex;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import org.jabref.gui.DialogService;
import org.jabref.gui.FXDialog;
import org.jabref.gui.Globals;
import org.jabref.gui.util.BaseDialog;
import org.jabref.logic.l10n.Localization;
import org.jabref.logic.sharelatex.ShareLatexManager;
import org.jabref.logic.sharelatex.SharelatexConnectionProperties;

public class ShareLatexLoginDialogView extends BaseDialog<Void> {

    @FXML private TextField tbAddress;
    @FXML private TextField tbUsername;
    @FXML private PasswordField tbPassword;
    @FXML private Button btnLogin;
    @Inject private ShareLatexManager manager;
    @Inject private DialogService dialogService;

    private SharelatexConnectionProperties props;
    private ShareLatexLoginDialogViewModel viewModel;

    public ShareLatexLoginDialogView() {

    }

    @FXML
    private void initialize() {
        viewModel = new ShareLatexLoginDialogViewModel();
    }

    @FXML
    private void closeDialog() {
    }

    @FXML
    private void signIn() {
        btnLogin.setText(Localization.lang("Logging in..."));
        try {
            String result = manager.login(tbAddress.getText(), tbUsername.getText(), tbPassword.getText());
            if (result.contains("incorrect")) {
                FXDialog dlg = new FXDialog(AlertType.ERROR);
                dlg.setContentText("Your email or password is incorrect. Please try again");
                dlg.showAndWait();
            } else {
                // TODO: Wait until pdf + injection stuff gets merged

                props = new SharelatexConnectionProperties(Globals.prefs.getShareLatexPreferences());

                props.setUrl(tbAddress.getText());
                props.setUser(tbUsername.getText());
                props.setPassword(tbPassword.getText());

                manager.setConnectionProperties(props);

                ShareLatexProjectDialogView dlgprojects = new ShareLatexProjectDialogView();
                dlgprojects.show();
                closeDialog();

            }
        } catch (Exception e) {
            dialogService.showErrorDialogAndWait(e);
        }

    }
    /*
        FXDialog sharelatexProjectDialog = new FXDialog(AlertType.INFORMATION, "Sharelatex Project Dialog");
        sharelatexProjectDialog.setDialogPane((DialogPane) this.getView());
        sharelatexProjectDialog.setResizable(true);
        sharelatexProjectDialog.show();
        */

}

package org.jabref.gui.actions;

import org.jabref.gui.DialogService;
import org.jabref.gui.sharelatex.ShareLatexLoginDialogView;

public class SynchronizeWithShareLatexAction extends SimpleCommand {

    private DialogService dialogService;

    public SynchronizeWithShareLatexAction(DialogService dialogService) {
        super();
        this.dialogService = dialogService;
    }

    @Override
    public void execute() {
        dialogService.showCustomDialogAndWait(
                new ShareLatexLoginDialogView());
    }
}

package shu.casedb.client.application.wintools;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;

/**
 * Created by er22317 on 15.01.2019.
 */
public class ApproveDialog extends MaterialWindow {

    public ApproveDialog(String text) {
        setWidth("20%");
        setFocus(true);
        setTitle("Подтверждение");
        MaterialPanel materialPanel = new MaterialPanel();
        MaterialLabel textLabel = new MaterialLabel();
        textLabel.setText(text);
        textLabel.setTextAlign(TextAlign.CENTER);
        textLabel.setMarginTop(20);
//		textLabel.setFocus(true);
//		MaterialTextBox materialTextBox = new MaterialTextBox();
//		materialTextBox.setFocus(true);
//		materialTextBox.setVisible(false);

        MaterialButton approveButton = new MaterialButton();
        approveButton.setTitle("Подтвердить");
        approveButton.setWaves(WavesType.LIGHT);
        approveButton.setType(ButtonType.FLOATING);
        approveButton.setCircle(true);
        approveButton.setIconType(IconType.CHECK_CIRCLE);
        approveButton.setBackgroundColor(Color.GREEN);
        approveButton.setMargin(10);
//		approveButton.setFocus(true);
        approveButton.addClickHandler(event -> {
            processApprove();
            close();
        });

        MaterialButton cancelButton = new MaterialButton("Отмена");
        cancelButton.setTitle("Отмена");
        cancelButton.setWaves(WavesType.LIGHT);
        cancelButton.setType(ButtonType.FLOATING);
        cancelButton.setCircle(true);
        cancelButton.setIconType(IconType.CANCEL);
        cancelButton.setBackgroundColor(Color.RED);
        cancelButton.setMargin(10);
        cancelButton.addClickHandler(event -> {
            close();
        });

        MaterialLabel butLabel = new MaterialLabel();
        butLabel.setTextAlign(TextAlign.CENTER);
        butLabel.add(approveButton);
        butLabel.add(cancelButton);
        materialPanel.add(textLabel);
//		materialPanel.add(materialTextBox);
        materialPanel.add(butLabel);
        add(materialPanel);

        addKeyDownHandler(new KeyDownHandler(){
            @Override
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ESCAPE) {
                    close();
                }
            } });


        open();
    }

    public void processApprove(){};
}


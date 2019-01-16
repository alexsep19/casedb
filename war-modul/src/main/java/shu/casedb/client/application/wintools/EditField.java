package shu.casedb.client.application.wintools;

import gwt.material.design.client.ui.MaterialTextBox;

/**
 * Created by er22317 on 15.01.2019.
 */
public class EditField<T> {
    private MaterialTextBox materialTextBox = new MaterialTextBox();

    public EditField() {
    }

    public void setField(T model){};

    public void getField(T model){};

    public Object getFieldValue(){return getMaterialTextBox().getValue();};
    public void setFieldValue(String value){getMaterialTextBox().setValue(value);};
    public void setFocusField(){getMaterialTextBox().setFocus(true);};

    public MaterialTextBox getMaterialTextBox() {
        return materialTextBox;
    }

    public void setMaterialTextBox(MaterialTextBox materialTextBox) {
        this.materialTextBox = materialTextBox;
    }

}

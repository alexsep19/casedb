package shu.casedb.client.application.wintools;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.FieldType;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.table.cell.Column;
import gwt.material.design.client.ui.table.cell.TextColumn;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by er22317 on 15.01.2019.
 */
public class EditWindow<T> extends MaterialWindow {
    MaterialPanel materialPanel = new MaterialPanel();
    MaterialRow materialRow = new MaterialRow();
    MaterialRow materialRowButton = new MaterialRow();
    List<EditField<T>> editFields = new ArrayList<EditField<T>>();
    String allFieldWidth;
    T model;
    WindowType windowType;

    public EditWindow(String maxWidth, String fieldWidth) {
        this.allFieldWidth = fieldWidth;
        setOverlay(true);
        materialRow.setMarginLeft(10);
        materialRow.setMarginBottom(0);
        materialPanel.add(new ButtonRow(new ClickHandler(){
            @Override
            public void onClick(ClickEvent event) {
                saveModel(getValues(), new MethodCallback<List<T>>(){
                            @Override
                            public void onFailure(Method method, Throwable throwable) {
                                Window.alert("Load failure" + throwable);
                                close();
                            }
                            @Override
                            public void onSuccess(Method method, List<T> loadPage) {
                                fillTable(loadPage);
                                close();
                            }
                        }
                );
            } },
                new ClickHandler(){
                    @Override
                    public void onClick(ClickEvent event) {
                        close();
                    }
                }));
        materialPanel.add(materialRow);
        add(materialPanel);

        setMaxWidth(maxWidth);
        addKeyDownHandler(new KeyDownHandler(){
            @Override
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ESCAPE) {
                    close();
                }
            } });
    }

    public void addField(Column column, EditField<T> editField, int maxLength){
        if (column instanceof TextColumn){
            editField.getMaterialTextBox().setFieldType(FieldType.FILLED);
            editField.getMaterialTextBox().setLabel(column.getName());
            editField.getMaterialTextBox().setMaxWidth(allFieldWidth);
            editField.getMaterialTextBox().setGrid("s12");
            if (maxLength > 0)
                editField.getMaterialTextBox().setMaxLength(maxLength);
            materialRow.add(editField.getMaterialTextBox());
            editFields.add(editField);
        }
    }

    public void setValues(T model){
        this.model = model;
        for(EditField<T> editField : editFields){
            editField.setField(model);
        }
    }

    public T getValues(){
        for(EditField<T> editField : editFields){
            editField.getField(model);
        }
        return model;
    }

    public void saveModel(T model, MethodCallback<List<T>> asyncCallback){}
    public void fillTable(List<T> loadPage){}

    public WindowType getWindowType() {
        return windowType;
    }

    public void setWindowType(WindowType windowType) {
        this.windowType = windowType;
        setTitle(windowType.getTitle());
    }

    public enum WindowType{
        EDIT("Редактировать"), ADD("Создать");
        private final String title;

        private WindowType(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}

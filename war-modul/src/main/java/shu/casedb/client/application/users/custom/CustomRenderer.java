package shu.casedb.client.application.users.custom;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import gwt.material.design.client.constants.CheckBoxType;
import gwt.material.design.client.data.BaseRenderer;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.table.TableData;

public class CustomRenderer<T> extends BaseRenderer<T> {

    @Override
    public TableData drawSelectionCell() {
        TableData td = new TableData();
        td.setId("col0");
        MaterialCheckBox checkBox = new MaterialCheckBox(td.getElement());
        checkBox.setType(CheckBoxType.FILLED);
        return td;
    }
}

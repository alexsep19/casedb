package shu.casedb.client.application.users.custom;

import gwt.material.design.client.data.DataView;
import gwt.material.design.client.data.component.RowComponent;
import gwt.material.design.client.data.factory.RowComponentFactory;
import shu.casedb.client.dto.RolesDto;

/**
 * Created by er22317 on 27.12.2018.
 */
public class RolesRowFactory extends RowComponentFactory<RolesDto> {

    @Override
    public RowComponent<RolesDto> generate(DataView dataView, RolesDto model) {
        // We won't change the way it loads the RowComponent
        return super.generate(dataView, model);
    }

    @Override
    public String getCategory(RolesDto model) {
        // We want to override the standard category retrieval
        // This is where we can define a models category.
        // This is useful when we don't want to pollute our
        // object models with the interface HasDataCategory.
        return model.getCode();
    }
}

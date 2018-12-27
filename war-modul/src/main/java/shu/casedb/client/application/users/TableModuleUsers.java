package shu.casedb.client.application.users;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TableModuleUsers extends AbstractPresenterModule {
	    @Override
	    protected void configure() {
	        bindPresenter(TablePresenterUsers.class, TablePresenterUsers.MyView.class, TableViewUsers.class, TablePresenterUsers.MyProxy.class);
	    }
}

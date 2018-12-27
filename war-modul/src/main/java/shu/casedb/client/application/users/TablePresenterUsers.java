package shu.casedb.client.application.users;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import shu.casedb.client.application.ApplicationPresenter;
import shu.casedb.client.event.SetPageTitleEvent;
import shu.casedb.client.place.NameTokens;

public class TablePresenterUsers extends Presenter<TablePresenterUsers.MyView, TablePresenterUsers.MyProxy> {
    public interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.users)
    public interface MyProxy extends ProxyPlace<TablePresenterUsers> {
    }

    @Inject
    TablePresenterUsers(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire(NameTokens.users, this);
    }
}

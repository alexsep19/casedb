package shu.casedb.client.application.users;

import java.util.Comparator;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.constants.HideOn;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.data.component.RowComponent;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.table.MaterialDataTable;
import gwt.material.design.client.ui.table.cell.TextColumn;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import shu.casedb.client.application.users.custom.CustomRenderer;
import shu.casedb.client.application.users.custom.PersonRowFactory;
import shu.casedb.client.dto.UsersDto;
import shu.casedb.client.rest.UserRestClient;

public class TableViewUsers extends ViewImpl implements TablePresenterUsers.MyView {

		public interface Binder extends UiBinder<Widget, TableViewUsers> {
	    }
	    UserRestClient userRestClient = GWT.create(UserRestClient.class);

		@UiField
	    MaterialDataTable<UsersDto> tableUsers;
    
//		EditWindow<Users> editWindow = new EditWindow<Users>("560px", "180px"){
//		   @Override
//		   public void saveModel(Person person, AsyncCallback<List<Person>> asyncCallback){
//			   svc.savePerson( person, asyncCallback);
//		   }
//		   public void fillTable(List<Person> loadPage){
//			   table.setRowData(0, loadPage);
//		   }
//		};
		
	    @Inject
		TableViewUsers(Binder uiBinder) {
	        initWidget(uiBinder.createAndBindUi(this));

			tableUsers.setRowFactory(new PersonRowFactory());
			tableUsers.setRenderer(new CustomRenderer<>());

			tableUsers.getTableTitle().setText("Таблица без страниц");
	        
	        TextColumn tcName = new TextColumn<UsersDto>() {
	            @Override
	            public Comparator<? super RowComponent<UsersDto>> sortComparator() {
	                return (o1, o2) -> o1.getData().getName().compareToIgnoreCase(o2.getData().getName());
	            }
	            @Override
	            public String getValue(UsersDto object) {
	                return object.getName();
	            }
	        };
			tableUsers.addColumn( tcName, "Name");
//	        editWindow.addField( tcFirstName, new EditField<Person>(){
//	        	@Override
//	        	public void setField(Person model){
//	        		setFocusField();
//	        		setFieldValue(model.getFirstName());
//	        	};
//	        	@Override
//	        	public void getField(Person model){
//	        		model.setFirstName((String)getFieldValue());
//	        	}
//	        }, 20);
	        
	        TextColumn tcFio = new TextColumn<UsersDto>() {
	            @Override
	            public Comparator<? super RowComponent<UsersDto>> sortComparator() {
	                return (o1, o2) -> o1.getData().getFio().compareToIgnoreCase(o2.getData().getFio());
	            }
	            @Override
	            public String getValue(UsersDto object) {
	                return object.getFio();
	            }
	        };
			tableUsers.addColumn( tcFio, "ФИО");
//	        editWindow.addField( tcLastName, new EditField<Person>(){
//	        	@Override
//	        	public void setField(Person model){
//	        		setFieldValue(model.getLastName());
//	        	};
//	        	@Override
//	        	public void getField(Person model){
//	        		model.setLastName((String)getFieldValue());
//	        	}
//	        }, 20);

	        TextColumn tcId = new TextColumn<UsersDto>() {
	            @Override
	            public boolean numeric() {
	                return true;
	            }
	            @Override
	            public HideOn hideOn() {
	                return HideOn.HIDE_ON_MED_DOWN;
	            }
	            @Override
	            public Comparator<? super RowComponent<UsersDto>> sortComparator() {
	                return (o1, o2) -> o1.getData().getId().compareTo(o2.getData().getId());
	            }
	            @Override
	            public String getValue(UsersDto object) {
	                return object.getId().toString();
	            }
	        };
			tableUsers.addColumn( tcId, "id");
//	        editWindow.addField( tcPhone, new EditField<Person>(){
//	        	@Override
//	        	public void setField(Person model){
//	        		setFieldValue(model.getPhone());
//	        	}
//	        	@Override
//	        	public void getField(Person model){
//	        		model.setPhone((String)getFieldValue());
//	        	}
//	        }, 20);
	        
//	        table.setVisibleRange(0, 10);
	        refreshTable();

			tableUsers.addColumnSortHandler(event -> {
	            GWT.log("Sorted: " + event.getSortContext().getSortDir() + ", columnIndex: " + event.getColumnIndex());
				tableUsers.getView().refresh();
	        });

			tableUsers.addRowDoubleClickHandler(event -> {
	            Window.alert("Row Double Clicked: " + event.getModel().getId());
//	            editWindow.setTitle("Редактировать");
//	            editWindow.setValues(event.getModel());
//	            editWindow.open();
	        });
	        
	        Panel panel = tableUsers.getScaffolding().getToolPanel();
	        MaterialIcon addIcon = new MaterialIcon(IconType.ADD);
	        addIcon.setWaves(WavesType.LIGHT);
	        addIcon.setCircle(true);
//	        addIcon.addClickHandler(event ->{
//	        	editWindow.setTitle("Создать");
//	        	editWindow.setValues(new Person(0,"","","",""));
//	        	editWindow.open();
//	        });
	        
	        MaterialIcon delIcon = new MaterialIcon(IconType.DELETE);
	        delIcon.setWaves(WavesType.LIGHT);
	        delIcon.setCircle(true);
	        delIcon.addClickHandler(event ->{
	        	if (tableUsers.getSelectedRowModels(true).size() != 1) {
	        		MaterialToast.fireToast("Необходимо выбрать 1 запись");
//	        		Window.alert("Необходимо выбрать 1 запись");
	        		return;
	        	}
//	        	ApproveDialog approveDialog = new ApproveDialog("Удалить запись?"){
//	        		@Override
//	        		public void processApprove(){
//		        		svc.delPerson( table.getSelectedRowModels(true).get(0), new AsyncCallback<List<Person>>(){
//		        			@Override
//		        			public void onFailure(Throwable exception) {
//		        				Window.alert("Load failure" + exception);
//		        			}
//		        			@Override
//		        			public void onSuccess(List<Person> loadPage) {
//					    	table.setRowData(0, loadPage);
//		        			}
//		        		});
//	        		};
//	        	};
	        });
	        panel.add(addIcon);
	        panel.add(delIcon);
	    }
	    
	    private void refreshTable(){
			userRestClient.getList(new MethodCallback<List<UsersDto>>(){
				@Override
				public void onFailure(Method method, Throwable throwable) {
				    Window.alert("Load failure = " + throwable + "; "+throwable.getMessage());
				}
				@Override
				public void onSuccess(Method method, List<UsersDto> users) {
					tableUsers.setRowData(0, users);
				}
			});

//			svc.getPersons(new AsyncCallback<List<Users>>(){
//			@Override
//			public void onFailure(Throwable exception) {
//				Window.alert("Load failure" + exception);
//			}
//			@Override
//			public void onSuccess(List<Users> loadPage) {
//		    	table.setRowData(0, loadPage);
//			}
//		});
	    }

}

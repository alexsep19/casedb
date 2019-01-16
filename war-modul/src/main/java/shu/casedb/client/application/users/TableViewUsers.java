package shu.casedb.client.application.users;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import shu.casedb.client.application.users.custom.RolesRowFactory;
import shu.casedb.client.application.users.custom.CustomRenderer;
import shu.casedb.client.application.users.custom.UsersRowFactory;
import shu.casedb.client.application.wintools.ApproveDialog;
import shu.casedb.client.application.wintools.EditField;
import shu.casedb.client.application.wintools.EditWindow;
import shu.casedb.client.dto.RolesDto;
import shu.casedb.client.dto.UsersDto;
import shu.casedb.client.rest.RoleRestClient;
import shu.casedb.client.rest.UserRestClient;

import javax.management.relation.Role;

public class TableViewUsers extends ViewImpl implements TablePresenterUsers.MyView {

		public interface Binder extends UiBinder<Widget, TableViewUsers> {
	    }
	    UserRestClient userRestClient = GWT.create(UserRestClient.class);
        RoleRestClient roleRestClient = GWT.create(RoleRestClient.class);

		@UiField
	    MaterialDataTable<UsersDto> tableUsers;
	    @UiField
		MaterialDataTable<RolesDto> tableRoles;

		private static Logger rootLogger = Logger.getLogger("TableViewUsers");

		EditWindow<UsersDto> editWindow = new EditWindow<UsersDto>("560px", "180px"){
		    @Override
		    public void saveModel(UsersDto usersDto, MethodCallback<List<UsersDto>> methodCallback){
                if (getWindowType().equals(WindowType.EDIT))
                    userRestClient.edit(usersDto, methodCallback);
                else
                    userRestClient.add(usersDto, methodCallback);
		    }
		    public void fillTable(List<UsersDto> loadPage){
                tableUsers.setRowData(0, loadPage);
		    }
		};
		
	    @Inject
		TableViewUsers(Binder uiBinder) {
			initWidget(uiBinder.createAndBindUi(this));

//			rootLogger.log(Level.INFO, "Started");
			MakeUsersTable();
			MakeRolesTable();
		}

		void MakeRolesTable(){
			tableRoles.setRowFactory(new RolesRowFactory());
			tableRoles.setRenderer(new CustomRenderer<>());
			tableRoles.getTableTitle().setText("Роли");
			TextColumn tcId = new TextColumn<RolesDto>() {
				@Override
				public boolean numeric() {
					return true;
				}
				@Override
				public HideOn hideOn() {
					return HideOn.HIDE_ON_MED_DOWN;
				}
				@Override
				public Comparator<? super RowComponent<RolesDto>> sortComparator() {
					return (o1, o2) -> o1.getData().getId().compareTo(o2.getData().getId());
				}
				@Override
				public String getValue(RolesDto object) {
					return object.getId().toString();
				}
			};
			tableRoles.addColumn( tcId, "id");

			TextColumn tcCode = new TextColumn<RolesDto>() {
				@Override
				public Comparator<? super RowComponent<RolesDto>> sortComparator() {
					return (o1, o2) -> o1.getData().getCode().compareToIgnoreCase(o2.getData().getCode());
				}
				@Override
				public String getValue(RolesDto object) {
					return object.getCode();
				}
			};
			tableRoles.addColumn( tcCode, "Name");

            refreshRolesTable();
		}

		void MakeUsersTable(){

			tableUsers.setRowFactory(new UsersRowFactory());
			tableUsers.setRenderer(new CustomRenderer<>());
			tableUsers.getTableTitle().setText("Пользователи");

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
	        editWindow.addField( tcName, new EditField<UsersDto>(){
	        	@Override
	        	public void setField(UsersDto model){
	        		setFocusField();
	        		setFieldValue(model.getName());
	        	};
	        	@Override
	        	public void getField(UsersDto model){
	        		model.setName((String)getFieldValue());
	        	}
	        }, 20);
	        
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
	        editWindow.addField( tcFio, new EditField<UsersDto>(){
	        	@Override
	        	public void setField(UsersDto model){
	        		setFieldValue(model.getFio());
	        	};
	        	@Override
	        	public void getField(UsersDto model){
	        		model.setFio((String)getFieldValue());
	        	}
	        }, 20);

//	        table.setVisibleRange(0, 10);

			tableUsers.addColumnSortHandler(event -> {
	            GWT.log("Sorted: " + event.getSortContext().getSortDir() + ", columnIndex: " + event.getColumnIndex());
				tableUsers.getView().refresh();
	        });

			tableUsers.addRowDoubleClickHandler(event -> {
//	            Window.alert("Row Double Clicked: " + event.getModel().getId());
//	            editWindow.setTitle("Редактировать");
                editWindow.setWindowType(EditWindow.WindowType.EDIT);
	            editWindow.setValues(event.getModel());
	            editWindow.open();
	        });
	        
	        Panel panel = tableUsers.getScaffolding().getToolPanel();
	        MaterialIcon addIcon = new MaterialIcon(IconType.ADD);
	        addIcon.setWaves(WavesType.LIGHT);
	        addIcon.setCircle(true);
	        addIcon.addClickHandler(event ->{
                editWindow.setWindowType(EditWindow.WindowType.ADD);
//	        	editWindow.setTitle("Создать");
	        	editWindow.setValues(new UsersDto(0l,"","","",""));
	        	editWindow.open();
	        });
	        
	        MaterialIcon delIcon = new MaterialIcon(IconType.DELETE);
	        delIcon.setWaves(WavesType.LIGHT);
	        delIcon.setCircle(true);
	        delIcon.addClickHandler(event ->{
	        	if (tableUsers.getSelectedRowModels(true).size() != 1) {
	        		MaterialToast.fireToast("Необходимо выбрать 1 запись");
//	        		Window.alert("Необходимо выбрать 1 запись");
	        		return;
	        	}
	        ApproveDialog approveDialog = new ApproveDialog("Удалить запись?"){
	        	@Override
	        	public void processApprove(){
                    userRestClient.delete( tableUsers.getSelectedRowModels(true).get(0), new MethodCallback<List<UsersDto>>(){
                        @Override
                        public void onFailure(Method method, Throwable throwable) {
                            Window.alert("Load failure" + throwable);
                        }

                        @Override
                        public void onSuccess(Method method, List<UsersDto> usersDtos) {
                            tableUsers.setRowData(0, usersDtos);
                        }
		       		});
	        		};
	        	};
	        });
	        panel.add(addIcon);
	        panel.add(delIcon);
			refreshUsersTable();
	    }

	private void refreshRolesTable(){
		roleRestClient.getList(new MethodCallback<List<RolesDto>>(){
			@Override
			public void onFailure(Method method, Throwable throwable) {
				Window.alert("Load failure = " + throwable + "; "+throwable.getMessage());
			}
			@Override
			public void onSuccess(Method method, List<RolesDto> roles) {
			    tableRoles.setRowData(0, roles);
			}
		});

	}


	private void refreshUsersTable(){
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

	}

}

package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

/**
 * Created by hanaria on 4/19/17.
 */
public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }
    /**
     * method должен обратиться к модели и инициировать загрузку пользователей. Далее обновляет представление UsersView
     */
    public void onShowAllUsers() {
        //обратиться к модели и инициировать загрузку юзеров
        model.loadUsers();
        //Вью сама не умеет себя обновлять. Это делает Контроллер. Пойди в контроллер и добавь обновление данных во Вью. Напомню, данные хранятся в Моделе
        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        // Не забудь, что данные, полученные с сервера, необходимо положить в ModelData.(in MainModel.java { modelData.setUsers(users)})
        // А потом обновить view.
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long id){
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }
    public void onUserChange(String name, long id, int level){
        model.changeUserData(name, id, level);
        usersView.refresh(model.getModelData());
    }

}

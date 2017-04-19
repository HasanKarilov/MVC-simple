package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.UsersView;

/**
 * Created by hanaria on 4/19/17.
 */
public class Controller {
    private Model model;
    private UsersView usersView;

    public void setModel(Model model) {
        this.model = model;
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

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

}

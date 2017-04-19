package com.javarush.task.task36.task3608.model;

/**
 * Created by hanaria on 4/19/17.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    public void loadDeletedUsers();
    public void loadUserById(long userId);

}

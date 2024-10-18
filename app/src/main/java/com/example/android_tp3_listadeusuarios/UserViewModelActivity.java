package com.example.android_tp3_listadeusuarios;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserViewModelActivity extends ViewModel {

    private List<Usuario> userList = new ArrayList<>();

    public List<Usuario> getUserList() {
        return userList;
    }

    public void agregarUsuario(Usuario usuario) {
        userList.add(usuario);
    }
}
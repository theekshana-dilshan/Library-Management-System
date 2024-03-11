package org.example.dao.custom.impl;

import org.example.dao.custom.UserDAO;
import org.example.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDAO {
    @Override
    public boolean add(User entity) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean isExists(String id) {
        return false;
    }

    @Override
    public User search(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}

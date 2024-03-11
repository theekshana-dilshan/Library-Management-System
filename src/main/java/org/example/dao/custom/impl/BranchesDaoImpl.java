package org.example.dao.custom.impl;

import org.example.dao.custom.BranchesDAO;
import org.example.entity.Branches;

import java.util.List;

public class BranchesDaoImpl implements BranchesDAO {
    @Override
    public boolean add(Branches entity) {
        return false;
    }

    @Override
    public List<Branches> getAll() {
        return null;
    }

    @Override
    public boolean update(Branches entity) {
        return false;
    }

    @Override
    public boolean isExists(String id) {
        return false;
    }

    @Override
    public Branches search(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}

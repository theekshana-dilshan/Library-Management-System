package org.example.bo.custom.impl;

import org.example.bo.custom.BranchesBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.BranchesDAO;
import org.example.dto.BranchesDTO;
import org.example.entity.Branches;

import java.util.ArrayList;
import java.util.List;

public class BranchesBoImpl implements BranchesBO {
    private BranchesDAO branchesDAO= (BranchesDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BRANCHES);
    @Override
    public boolean addBranch(BranchesDTO dto) {
        return branchesDAO.add(new Branches(dto.getCode(),dto.getLocation(),dto.getContactNumber(),dto.getStatus()));
    }

    @Override
    public List<BranchesDTO> getAllBranch() {
        List<Branches> all = branchesDAO.getAll();
        List<BranchesDTO> allBranch = new ArrayList<>();

        for (Branches branch: all) {
            allBranch.add(new BranchesDTO(branch.getCode(),branch.getLocation(),branch.getContactNumber(),branch.getStatus()));
        }

        return allBranch;
    }

    @Override
    public boolean updateBranch(BranchesDTO dto) {
        return branchesDAO.update(new Branches(dto.getCode(),dto.getLocation(),dto.getContactNumber(),dto.getStatus()));
    }

    @Override
    public boolean isExistBranch(String id) {
        return branchesDAO.isExists(id);
    }

    @Override
    public BranchesDTO searchBranch(String id) {
        Branches search = branchesDAO.search(id);
        BranchesDTO branchDto = new BranchesDTO(search.getCode(),search.getLocation(),search.getContactNumber(),search.getStatus());
        return branchDto;
    }

    @Override
    public boolean deleteBranch(String id) {
        return branchesDAO.delete(id);
    }
}

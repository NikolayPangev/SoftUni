package org.example.mobilelele.service.init;

import jakarta.annotation.PostConstruct;
import org.example.mobilelele.service.role.UserRoleService;

public class DataBaseInitServiceImpl implements DataBaseInitService {

    private final UserRoleService roleService;


    public DataBaseInitServiceImpl(UserRoleService roleService) {
        this.roleService = roleService;
    }

    @PostConstruct
    public void postConstruct() {
        dbInit();
    }

    @Override
    public void dbInit() {
        if (isDbInit()) {
            this.roleService.dbInit();
        }
    }

    @Override
    public boolean isDbInit() {
        return this.roleService.isDbInit();
    }

}

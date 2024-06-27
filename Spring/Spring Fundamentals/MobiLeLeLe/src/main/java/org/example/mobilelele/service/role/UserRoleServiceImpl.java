package org.example.mobilelele.service.role;

import org.example.mobilelele.repository.RoleRepository;
import org.example.mobilelele.service.init.DataBaseInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService, DataBaseInitService {

    private final RoleRepository roleRepository;

    @Autowired
    public UserRoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInit() {
        return this.roleRepository.count() > 0;
    }
}

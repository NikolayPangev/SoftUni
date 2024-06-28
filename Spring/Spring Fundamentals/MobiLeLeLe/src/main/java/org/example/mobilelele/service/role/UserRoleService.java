package org.example.mobilelele.service.role;

import org.example.mobilelele.model.dtoS.view.UserRoleViewDto;
import org.example.mobilelele.service.init.DataBaseInitService;

import java.util.List;

public interface UserRoleService extends DataBaseInitService {

    List<UserRoleViewDto> getAll();

}

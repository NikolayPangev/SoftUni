package org.example.mobilelele.service.init;

import org.springframework.stereotype.Service;

@Service
public interface DataBaseInitService {

    void dbInit();

    boolean isDbInit();

}

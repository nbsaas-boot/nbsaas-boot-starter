package com.nbsaas.boot.security.api;

import java.util.List;

public interface AuthorizationApi {

    List<String> loadRoles();


    List<String> loadPermissions();

}

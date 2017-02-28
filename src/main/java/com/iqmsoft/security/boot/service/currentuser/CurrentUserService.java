package com.iqmsoft.security.boot.service.currentuser;

import com.iqmsoft.security.boot.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}

package com.hotaru.core.access;

import java.util.Collection;

public abstract class AccessRightBase {

    private Collection<String> allowedUrlList;

    public AccessRightBase(Collection<String> allowedUrlList) {
        this.allowedUrlList = allowedUrlList;
    }

    public Collection<String> getAllowedUrlList() {
        return allowedUrlList;
    }
}

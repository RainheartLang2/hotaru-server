package com.hotaru.core.database;

public interface Archivable {
    boolean isDeleted();
    void setDeleted(boolean deleted);
}

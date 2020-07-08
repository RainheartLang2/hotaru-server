package com.hotaru.core.util.container;

import java.util.List;

public class CustomContainer<Type> {
    private List<Type> list;

    public CustomContainer(List<Type> list) {
        this.list = list;
    }

    public List<Type> getList() {
        return list;
    }

    public void setList(List<Type> list) {
        this.list = list;
    }
}

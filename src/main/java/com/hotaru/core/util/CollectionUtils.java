package com.hotaru.core.util;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

    public static <Type> List<Type> fillArray(int size, Type sample) {
        List<Type> result = new ArrayList<>();
        for (int i = 0; i < size; i ++) {
            result.add(sample);
        }
        return  result;
    }
}

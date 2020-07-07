package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.CounterAgent;

public class CounterAgentResource extends ArchivableResourceBase<CounterAgent> {
    private static CounterAgentResource INSTANCE = new CounterAgentResource();

    public static CounterAgentResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CounterAgentResource();
        }
        return INSTANCE;
    }
}

package com.hotaru.rpc.counterAgent;

import com.hotaru.database.entities.CounterAgent;
import com.hotaru.database.resources.CounterAgentResource;

import java.util.List;

public class CounterAgentService {
    public List<CounterAgent> getAll() {
        return CounterAgentResource.getInstance().getAllNotDeleted();
    }

    public int add(CounterAgent agent) {
        CounterAgentResource.getInstance().saveOrUpdate(agent);
        return agent.getId();
    }

    public void update(CounterAgent agent) {
        CounterAgentResource.getInstance().saveOrUpdate(agent);
    }

    public void delete(int id) {
        CounterAgentResource.getInstance().markDeleted(id);
    }
}

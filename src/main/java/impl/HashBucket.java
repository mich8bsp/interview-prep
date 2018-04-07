package impl;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashBucket {
    private int hash;
    private List<Map.Entry> entriesList = new LinkedList<>();

    public void addNode(Object key, Object value) {
        entriesList.add(new AbstractMap.SimpleEntry<>(key, value));
    }

    public Map.Entry getNode(Object key){
        return entriesList.stream()
                .filter(x->key.equals(x.getKey()))
                .findFirst()
                .orElse(null);
    }

    public Map.Entry getNodeByValue(Object value){
        return entriesList.stream()
                .filter(x->value.equals(x.getValue()))
                .findFirst()
                .orElse(null);
    }

    public List<Map.Entry> getEntriesList(){
        return entriesList;
    }
}

package org.csystem.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StringMap<V> implements IStringMap<V> {
    private final Map<String, V> m_stringMap =  new HashMap<>();

    private static void throwIfKeyNullOrEmpty(String key)
    {
        if (key == null || key.isBlank())
            throw new IllegalArgumentException("key cannot be null or empty");
    }

    @Override
    public int count()
    {
        return m_stringMap.size();
    }

    @Override
    public boolean addElement(String key, V value)
    {
        throwIfKeyNullOrEmpty(key);

        var result = m_stringMap.containsKey(key);

        m_stringMap.put(key, value);

        return result;
    }

    @Override
    public boolean removeElement(String key)
    {
        throwIfKeyNullOrEmpty(key);

        var result = m_stringMap.containsKey(key);

        m_stringMap.remove(key);

        return result;
    }

    @Override
    public Optional<V> getValue(String key)
    {
        throwIfKeyNullOrEmpty(key);

        return m_stringMap.containsKey(key) ? Optional.of(m_stringMap.get(key)) : Optional.empty();
    }

    @Override
    public V getValue(String key, V defaultValue)
    {
        throwIfKeyNullOrEmpty(key);

        return m_stringMap.getOrDefault(key, defaultValue);
    }
}
package me.exerosis.jager.engine.core.utilites.configuration;

import org.bukkit.configuration.ConfigurationSection;

/**
 * Created by Exerosis.
 */
public interface Configuration {

    default Configuration getSection(Object key){
        return new ConfigurationMap((ConfigurationSection) get(key));
    }

    default int getInt(Object key){
        return (int) get(key);
    }

    default String getString(Object key){
        return (String) get(key);
    }

    @SuppressWarnings("unchecked")
    default <T> T get(Object key, Class<T> type){
        return type.cast(key);
    }

    Object get(Object key);
}

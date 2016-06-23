package me.exerosis.jager.engine.core.utilites.configuration;

import org.bukkit.configuration.ConfigurationSection;

/**
 * Created by Exerosis.
 */
public class ConfigurationMap implements Configuration {
    private ConfigurationSection section;

    public ConfigurationMap(ConfigurationSection section) {
        this.section = section;
    }

    @Override
    public Object get(Object key) {
        return section.get(key.toString());
    }
}

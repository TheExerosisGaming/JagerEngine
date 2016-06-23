package me.exerosis.jager.engine.core.utilites.configuration;

import me.exerosis.jager.engine.core.utilites.StreamUtilities;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Exerosis.
 */
public class OnlineConfiguration implements Configuration {
    private URL url;
    private YamlConfiguration config;

    public OnlineConfiguration(String address) throws IOException {
        this(new URL(address));
    }

    public OnlineConfiguration(URL url) throws IOException {
        this.url = url;
        reloadConfig();
    }


    @Override
    public Object get(Object key) {
        return config.get(key.toString());
    }

    @Override
    public String toString() {
        return url.toExternalForm();
    }


    public void setURL(String address) throws IOException {
        setURL(new URL(address));
    }

    public void setURL(URL url) throws IOException {
        this.url = url;
        reloadConfig();
    }

    public URL getURL() {
        return url;
    }

    public void reloadConfig() throws IOException {
        config = YamlConfiguration.loadConfiguration(StreamUtilities.readFromURL(url));
    }
}
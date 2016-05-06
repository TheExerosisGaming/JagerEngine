package me.exerosis.jager.engine.implementation.components.worlds;

import me.exerosis.jager.engine.core.utilites.FileUtilities;
import me.exerosis.jager.engine.implementation.components.ListenerComponent;
import me.exerosis.jager.engine.implementation.components.logger.LoggerComponent;
import me.exerosis.jager.engine.implementation.components.scheduler.SchedulerComponent;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldLoadEvent;

import java.io.*;

/**
 * Created by Exerosis.
 */
public class WorldComponent extends ListenerComponent {
    private final LoggerComponent logger;
    private final SchedulerComponent schedulerComponent;
    private final File worldFile;
    private String kickMessage;
    private File backupFile;

    public WorldComponent(LoggerComponent logger, SchedulerComponent schedulerComponent, File worldFile, String kickMessage) {
        this.logger = logger;
        this.schedulerComponent = schedulerComponent;
        this.worldFile = worldFile;
        this.kickMessage = kickMessage;
        backupFile = new File(worldFile.getPath() + "/backup.tmp");
    }


    public void load() {
        System.out.println("[WorldComponent]Trying to load world.");

        if (!worldFile.getPath().startsWith(Bukkit.getWorldContainer().getParent()))
            System.err.println("[WorldComponent]Failed to load world! '" + worldFile.getPath() + "' is not in the server folder.");
        if (!worldFile.exists())
            System.err.println("[WorldComponent]Failed to load world! No such file or directory: '" + worldFile.getPath() + "'.");
        if (!worldFile.isDirectory())
            System.err.println("[WorldComponent]Failed to load world! Could not find world at '" + worldFile.getPath() + "'.");

        File worldData = new File(worldFile.getPath() + "/level.dat");

        if (!worldData.exists())
            System.err.println("[WorldComponent]Failed to load world! Could not find expected 'level.dat' in directory '" + worldFile.getPath() + "'.");

        WorldCreator worldCreator = new WorldCreator("");
        worldCreator.type(WorldType.FLAT);
        Bukkit.createWorld(worldCreator);

        System.out.println("[WorldComponent]WorldComponent can be loaded. Loading world.");
    }

    @EventHandler
    public void onWorldLoadEvent(WorldLoadEvent event){
        if(event.getWorld().getWorldFolder().equals(worldFile))
            onLoad();
    }

    public void backup() {
        try {
            backupFile = File.createTempFile("backup", ".tmp", worldFile);
            FileUtilities.createZip(worldFile, backupFile);
            onBackup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void revert() {
        if (!backupFile.isFile())
            return;
        try {
            FileUtils.deleteDirectory(worldFile);
            FileUtilities.unzip(backupFile, worldFile);
            onRevert();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unload() {
        System.out.println("[WorldComponent]Trying to unload world!");
        World world = Bukkit.getWorld(worldFile.getName());

        if (world == null)
            return;

        //Remove players
        for (Player player : world.getPlayers())
            player.kickPlayer(kickMessage);

        //Wait 1 second before unloading the world
        schedulerComponent.registerTask(() -> {
            if (!Bukkit.unloadWorld(world, false))
                throw new RuntimeException("[WorldComponent]Unable to unload world, please fix the problem!");
            onUnload();
        }, 20D);
    }

    protected void onUnload(){

    }

    protected void onLoad(){

    }

    protected void onRevert(){

    }

    protected void onBackup(){

    }
}

package me.vreaz.manager;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
 
import java.io.File;
import java.io.IOException;

public class ConfigManager {
 
    private static File file;
    private static FileConfiguration File;
 
    //Finds or generates the custom config file
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Everything").getDataFolder(), "config.yml");
 
        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                //owww
            }
        }
        File = YamlConfiguration.loadConfiguration(file);
    }
 
    public static FileConfiguration get(){
        return File;
    }
 
    public static void save(){
        try{
            File.save(file);
        }catch (IOException e){
            System.out.println("Couldn't save file");
        }
    }
 
    public static void reload(){
        File = YamlConfiguration.loadConfiguration(file);
    }
 
}
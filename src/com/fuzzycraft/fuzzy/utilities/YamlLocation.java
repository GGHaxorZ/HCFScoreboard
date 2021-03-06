package com.fuzzycraft.fuzzy.utilities;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * 
 * @author FuzzyStatic (fuzzy@fuzzycraft.com)
 *
 */

public class YamlLocation {

	private FileConfiguration config;
	private String key;
	private static String world = "";
	private static double x, y, z;
	private static float yaw, pitch;
	private final Map<String, Object> map = new HashMap<String, Object>();
	
	/**
	 * Location parameters from location.
	 * @param location
	 */
    public YamlLocation(FileConfiguration config, String key) {
    	this.config = config;
    	this.key = key;
    }
		
	/**
	 * Extracts location from the YAML in the form of a map.
	 * @param config
	 * @param ymlKey
	 * @return
	 */
	public Map<String, Object> getLocationMap() {
		map.put("world", this.config.get(this.key + ".world"));
	    map.put("x", this.config.get(this.key + ".x"));
		map.put("y", this.config.get(this.key + ".y"));
	  	map.put("z", this.config.get(this.key + ".z"));
	  	map.put("yaw", this.config.get(this.key + ".yaw"));
	   	map.put("pitch", this.config.get(this.key + ".pitch"));
		return map;
	}
	
	/**
	 * Sets location to the YAML configuration. Will still need to be received and saved after using.
	 * @param map
	 * @param config
	 * @param ymlKey
	 */
	public void setLocation(Map<String, Object> map) {
		this.config.set(this.key + ".world", map.get("world"));
		this.config.set(this.key + ".x", map.get("x"));
		this.config.set(this.key + ".y", map.get("y"));
		this.config.set(this.key + ".z", map.get("z"));
		this.config.set(this.key + ".yaw", map.get("yaw"));
		this.config.set(this.key + ".pitch", map.get("pitch"));
	}
	
	/**
	 * Sets blank location to the YAML
	 * @param config
	 * @param ymlKey
	 */
	public void setBlankLocation() {
		this.config.set(this.key + ".world", world);
		this.config.set(this.key + ".x", x);
		this.config.set(this.key + ".y", y);
		this.config.set(this.key + ".z", z);
		this.config.set(this.key + ".yaw", Float.floatToIntBits(yaw));
		this.config.set(this.key + ".pitch", Float.floatToIntBits(pitch));
	}
}
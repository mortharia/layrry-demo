

package layrry.demo.rest.api.internal;

import org.moditect.layrry.platform.PluginDescriptor;
import org.moditect.layrry.platform.PluginLifecycleListener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Plugins listener to dynamically register installed plugins as ModuleLayers.
 */
public class DemoPluginLifecycleListener implements PluginLifecycleListener {


    /**
     * All registered plugins moduleLayers with one plugin per moduleLayer.
     * Each plugin is identified by its name and is managed in one ModuleLayer.
     */
    private static Map<String, ModuleLayer> moduleLayers = new ConcurrentHashMap<>();

    @Override
    public void pluginAdded(PluginDescriptor plugin) {
        moduleLayers.put(plugin.getName(), plugin.getModuleLayer());
    }

    @Override
    public void pluginRemoved(PluginDescriptor plugin) {
        moduleLayers.remove(plugin.getName());
    }

    /**
     * Get all installed plugins moduleLayers.
     *
     * @return : the registered moduleLayers
     */
    public static Map<String, ModuleLayer> getModuleLayers() {
        return moduleLayers;
    }
}

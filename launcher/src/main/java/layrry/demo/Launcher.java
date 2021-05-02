

package layrry.demo;

import org.moditect.layrry.Layers;
import org.moditect.layrry.config.LayersConfig;
import org.moditect.layrry.config.yaml.YamlLayersConfigParser;
import org.moditect.layrry.internal.LayersFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * launcher class.
 */
public class Launcher {

    /**
     * The logging parameter.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

    /**
     * The main function that will launch the application. It uses layrry layers configuration file to handle the
     *  Rest endpoint and the installed data  plugins.
     *
     * @param args arguments of the application
     */
    public static void main(String[] args) {

        InputStream layerConfig = Launcher.class.getClassLoader().getResourceAsStream("layers.yml");

        Path rootDir = Paths.get(".").toAbsolutePath();
        LayersConfig config =
                null;
        try {
            config = new YamlLayersConfigParser().parse(layerConfig);
        } catch (IOException e) {
            LOGGER.error("Configuration file could not be parsed", e);
            System.exit(1);
        }
        Layers layers = new LayersFactory().createLayers(config, rootDir);

        layers.run(config.getMain().getModule() + "/" + config.getMain().getClazz(), args);
    }
}

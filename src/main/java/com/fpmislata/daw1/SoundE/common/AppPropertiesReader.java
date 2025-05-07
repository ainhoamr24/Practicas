package com.fpmislata.daw1.SoundE.common;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



@Log4j2
public class AppPropertiesReader {
    private static final Properties properties = new Properties();

    static {
        loadProperties("application.properties");

        String activeProfile = getProperty("spring.profiles.active");
        if(activeProfile != null) {
            log.info("Perfil activo: " + activeProfile);
            loadProperties("application-"+activeProfile+".properties");
        } else {
            log.warn("No se ha especificado ningún perfil");
        }
    }

    private static void loadProperties(String filename) {
        try(InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)) {
            if(input == null)
                return;

            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}

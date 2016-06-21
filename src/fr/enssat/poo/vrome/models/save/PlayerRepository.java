package fr.enssat.poo.vrome.models.save;

import fr.enssat.poo.vrome.models.Player;
import fr.enssat.poo.vrome.models.exceptions.PlayerLoadingException;
import fr.enssat.poo.vrome.utilities.Logger;
import fr.enssat.poo.vrome.utilities.SystemOutLogger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mnantel on 21/06/16.
 */
public class PlayerRepository {

    /**
     * Prefix that will be added to all player files.
     */
    public static final String PERSISTANCE_FILE_PLAYER_PREFIX = "";
    private static final Logger LOGGER = new SystemOutLogger(PlayerRepository.class);
    /**
     * Default path to save the players.
     */
    @SuppressWarnings("null")
    public static String DEFAULT_FOLDER_PATH;

    static {
        try {
            DEFAULT_FOLDER_PATH = new File(".").getCanonicalPath();
            LOGGER.info("Path for loading and saving players is set to: " + DEFAULT_FOLDER_PATH);
        } catch (IOException e) {
            LOGGER.info("PlayerRepository can't load directory. Save/loads would not be available !");
            e.printStackTrace();
        }
    }

    //=======
    // CREATE
    //=======

    /**
     * @param player you want to save
     * @throws IOException
     */
    private static void save(final Player player, final String outputFileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DEFAULT_FOLDER_PATH + PERSISTANCE_FILE_PLAYER_PREFIX + player.getName()));) {
            outputStream.writeObject(player);
        }
    }

    /**
     * Save the player using the default folder path.
     *
     * @param player you want to save
     * @throws IOException
     */
    public static void save(final Player player) throws IOException {
        save(player, player.getName());
        LOGGER.debug("A level has been successfully saved.");
    }

    //==============
    // GET / GET ALL
    //==============

    /**
     * Load an existing level from the file name.
     *
     * @param fileName
     * @return the level
     * @throws PlayerLoadingException if an error occurs while loading the level
     */
    public static Player load(final String fileName) throws PlayerLoadingException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DEFAULT_FOLDER_PATH + PERSISTANCE_FILE_PLAYER_PREFIX + fileName))) {
            Player level = (Player) inputStream.readObject();
            if (level != null) {
                LOGGER.debug("A level has been successfully loaded.");
                return level;
            } else {
                throw new Exception(); // The type of the exception is not important here. It will be catched in the current method.
            }
        } catch (Exception e) {
            throw new PlayerLoadingException("Can not load a level at '" + DEFAULT_FOLDER_PATH + PERSISTANCE_FILE_PLAYER_PREFIX + fileName);
        }
    }

    /**
     * Get the list of all existing players.
     *
     * @param directoryPath where to search for levels
     * @return a list of names
     */
    private static List<String> getAllExistingFileNames(final String directoryPath) {
        List<String> fileNames = new ArrayList<>();
        for (File element : new File(directoryPath).listFiles()) {
            if (element.isFile() && element.getName().startsWith(PERSISTANCE_FILE_PLAYER_PREFIX)) {
                String prettyName = element.getName().replace(PERSISTANCE_FILE_PLAYER_PREFIX, "");
                fileNames.add(prettyName);
                LOGGER.debug("A level has been found -> '" + element.getName() + "'");
            }
            // Don't do it recursively (ignore potential sub-directories).
        }
        return fileNames;
    }

    /**
     * @return the list of all existing levels names at the default save path.
     */
    public static List<String> getAllExistingLevelFileNames() {
        return getAllExistingFileNames(DEFAULT_FOLDER_PATH);
    }

    //=======
    // DELETE
    //=======

    /**
     * Delete an existing level.
     *
     * @param fileName
     * @throws IOException
     */
    public static void delete(final String fileName) throws IOException {
        Files.deleteIfExists(Paths.get(DEFAULT_FOLDER_PATH + PERSISTANCE_FILE_PLAYER_PREFIX + fileName)); // don't fail on unexisting file.
    }

}


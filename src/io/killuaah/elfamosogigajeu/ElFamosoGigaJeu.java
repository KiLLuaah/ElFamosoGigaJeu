package io.killuaah.elfamosogigajeu;

import io.killuaah.elfamosogigajeu.event.*;
import io.killuaah.elfamosogigajeu.event.events.KeyboardEvent;
import io.killuaah.elfamosogigajeu.event.events.MouseEvent;
import io.killuaah.elfamosogigajeu.listeners.KeyListener;
import io.killuaah.elfamosogigajeu.listeners.MouseListener;
import io.killuaah.elfamosogigajeu.utils.Logger;
import io.killuaah.elfamosogigajeu.utils.U;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.awt.*;
import java.io.File;

/**
 * Classe créée le 16/12/2017.
 */

public class ElFamosoGigaJeu {

    private static final String   GAME_NAME = "El Famoso Giga Jeu",
                                  GAME_VERSION = "1.0-DEV",
                                  GAME_DEVELOPPER = "ElFamosoKilluaah";

    public static ElFamosoGigaJeu GAME_INSTANCE;
    private static KeyListener    KEY_LISTENER;
    private static MouseListener  MOUSE_LISTENER;
    private static final Logger   LOGGER = new Logger();
    private static int            FPS_CAP = 120,
                                  WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 500,
                                  HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 200;
    public static boolean IS_SUPERUSER;

    static {
        String os_name = System.getProperties().getProperty("os.name").split(" ")[0].toLowerCase();
        if(os_name.equalsIgnoreCase("mac")) os_name += "osx";
        U.print("OS: " + os_name);
        System.setProperty("org.lwjgl.librarypath", new File("native/"+os_name).getAbsolutePath());
        System.setProperty("java.library.path", new File("native/"+os_name).getAbsolutePath());
    }

    public ElFamosoGigaJeu() {
        EventManager.register(this);
    }

    public static void main(String[] args) {
        long startMS = System.currentTimeMillis();
        U.print("Starting the game...");
        Runtime.getRuntime().addShutdownHook(new Thread(()-> stop()));
        startGame();
        U.print("Game started in " + (System.currentTimeMillis() - startMS) + " ms.");

        /*
         * The Game Loop
         */
        while (!Display.isCloseRequested()) {
            Display.update();
            Display.sync(FPS_CAP);
        }
        Keyboard.destroy();
        Display.destroy();
    }

    private static void startGame() {

        try {
            U.print("MAC Adress: " + U.getMAC());
            String hwid = U.getMAC();
            ElFamosoGigaJeu.IS_SUPERUSER = hwid.equals("54-2A-A2-90-3F-F3");
            ElFamosoGigaJeu.GAME_INSTANCE = new ElFamosoGigaJeu();
            U.print(Boolean.toString(ElFamosoGigaJeu.IS_SUPERUSER));
            Display.setTitle(ElFamosoGigaJeu.GAME_NAME + " " + ElFamosoGigaJeu.GAME_VERSION);
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();

            //Trying the KeyListener
            ElFamosoGigaJeu.KEY_LISTENER = new KeyListener();
            ElFamosoGigaJeu.KEY_LISTENER.start();

            ElFamosoGigaJeu.MOUSE_LISTENER = new MouseListener();
            ElFamosoGigaJeu.MOUSE_LISTENER.start();
        }
        catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    private static void stop() {
        long startMS = System.currentTimeMillis();
        U.print("Stopping the game...");

        ElFamosoGigaJeu.KEY_LISTENER.stop();

        U.print("Game stopped in " + (System.currentTimeMillis() - startMS) + " ms.");

    }

    public static String getGameName() {
        return GAME_NAME;
    }

    public static String getGameVersion() {
        return GAME_VERSION;
    }

    public static String getGameDevelopper() {
        return GAME_DEVELOPPER;
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    public static KeyListener getKeyListener() {
        return KEY_LISTENER;
    }

    public static ElFamosoGigaJeu getGameInstance() {
        return GAME_INSTANCE;
    }

    public static MouseListener getMouseListener() {
        return MOUSE_LISTENER;
    }

    public static int getFpsCap() {
        return FPS_CAP;
    }

    public static boolean isSuperuser() {
        return IS_SUPERUSER;
    }

    @EventHandler
    public void onKey(KeyboardEvent keyboardEvent) {
        U.print("Key pressed: " + keyboardEvent.getKeyName(), false);
    }

    @EventHandler
    public void onMouse(MouseEvent mouseEvent) {
        U.print("Mouse state: " + mouseEvent.getX() + " " + mouseEvent.getY() + " " + mouseEvent.getMouseButton());
    }
}

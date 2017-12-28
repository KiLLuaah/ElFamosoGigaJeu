package io.killuaah.elfamosogigajeu.listeners;

import io.killuaah.elfamosogigajeu.event.events.KeyboardEvent;
import io.killuaah.elfamosogigajeu.utils.U;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

/**
 * Classe créée le 16/12/2017.
 */
public class KeyListener extends Thread {

    public KeyListener() {
        U.print("Initializing the key listener");
        try {
            Keyboard.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!Display.isCloseRequested()) {
                if (Keyboard.next()) {
                    int key = Keyboard.getEventKey();
                    KeyboardEvent keyboardEvent = new KeyboardEvent(key, Keyboard.getKeyName(key));
                    keyboardEvent.call();
                }
            }
        }
        catch (Exception e) {
            U.print("Key listener closed.");
        }
        Keyboard.destroy();
    }
}

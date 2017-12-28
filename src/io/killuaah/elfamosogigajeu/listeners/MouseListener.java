package io.killuaah.elfamosogigajeu.listeners;

import io.killuaah.elfamosogigajeu.event.events.MouseEvent;
import io.killuaah.elfamosogigajeu.utils.U;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

/**
 * Classe créée le 22/12/2017.
 */
public class MouseListener extends Thread {

    public MouseListener() {
        U.print("Initializing the mouse listener");
        try {
            Mouse.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        try {
            while (!Display.isCloseRequested()) {
                if (Mouse.next()) {
                    int x = Mouse.getEventX();
                    int y = Mouse.getEventY();
                    int mouseButton = Mouse.getEventButton();
                    MouseEvent mouseEvent = new MouseEvent(x, y, mouseButton);
                    mouseEvent.call();
                }
            }
        }
        catch (Exception e) {
            U.print("Mouse listener closed.");
        }
    }
}

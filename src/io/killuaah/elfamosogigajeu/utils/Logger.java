package io.killuaah.elfamosogigajeu.utils;


import java.io.*;

/**
 * Classe créée le 09/12/2017.
 */
public class Logger {
    private File logFolder = new File("./logs");
    private File logFile;
    private BufferedWriter bufferedWriter;

    public Logger() {
        boolean mkdir = this.init();
    }

    private boolean init() {
         boolean mkdir = logFolder.mkdir();
        this.logFile = new File("./logs/log " + U.getDate() + "(" + System.currentTimeMillis() / 1000000 + ").txt");
        try {
            this.bufferedWriter = new BufferedWriter(new FileWriter(this.logFile));
            this.logFile.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return mkdir;
    }

    public void addToWriteQueue(String str) {
        try {
            if (str.length() == 0) return;
            this.bufferedWriter.write(str + "\n");
            this.bufferedWriter.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

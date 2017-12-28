package io.killuaah.elfamosogigajeu.utils;

import io.killuaah.elfamosogigajeu.ElFamosoGigaJeu;

import java.awt.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe créée le 16/12/2017.
 */
public class U {

    public static void print(String message) {
        System.out.println(">> " + message);
        ElFamosoGigaJeu.getLogger().addToWriteQueue(">> " + message);
    }

    public static void print(String message, boolean write) {
        System.out.println(">> " + message);
        if (write) ElFamosoGigaJeu.getLogger().addToWriteQueue(">> " + message);
    }


    public static String concat(String[] table, int start, int end) {
        String returned = "";
        for (int i = start; i < end; i++) {
            returned += table[i];
        }
        return returned;
    }

    public static void print(String message, int times) {
        for (int i = 0; i < times; i++) {
            print(message);
        }
    }

    public static Color toColor(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
            return (dateWithoutTime.getDay() + "-" + dateWithoutTime.getMonth() + "-" + dateWithoutTime.getYear());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMAC() {
        try {
            InetAddress ip;
            ip = InetAddress.getLocalHost();

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();
        }
        catch (Exception e) {
            return "";
        }
    }


}

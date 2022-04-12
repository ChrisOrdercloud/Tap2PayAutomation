package com.qa.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
public class AwsUtils {
    public static void setEmulatorTime() {

        try {
            Process rc = Runtime.getRuntime().exec("adb shell date 070415492022.00 ; pm broadcast -a android.intent.action.TIME_SET");
            System.out.println("command execution done");
            System.out.println("Test time set");
            InputStream is = rc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() > 0) {
                    line += br.readLine();
                    System.out.println("line: " + line);
                    if (line.contains("Command Output we can check")) {
                        System.out.println(" Emulator time set");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
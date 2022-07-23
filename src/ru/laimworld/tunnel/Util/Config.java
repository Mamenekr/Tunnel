package ru.laimworld.tunnel.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Config {
    String ip;
    String token;
    int serverPort;
    int remotePort;
    File file;
    public Config(String src) {
        try {
            file = new File(src);
            if(!file.exists()) {
                file.createNewFile();
                System.out.println("Creating new config.yml file....");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer = getDefaultConfig(writer);
                writer.flush();
                writer.close();
            } else {}
            loadConfig(new BufferedReader(new FileReader(file)));
            System.out.println("File config.yml loaded!");
        } catch (Exception ex) {
            System.out.println("File config.yml error: " + ex);
        }
    }
    private void loadConfig(BufferedReader reader) {
        try {
            while (reader.ready()) {
                String[] par = reader.readLine().split(":");
                if(par.length < 2 || par.length > 2) {
                    System.out.println("The configuration was loaded incorrectly!");}
                setConfigData(par[0], par[1]);
            }
        } catch (Exception ex) {
            System.out.println("loadConfig error: " + ex);
        }
    }
    void setConfigData(String parameter, String meaning) {
        meaning = meaning.replace(" ", "");
        switch (parameter) {
            case "ip":
                this.ip = meaning;
                break;
            case "token":
                this.token = meaning;
                break;
            case "serverPort":
                this.serverPort = Integer.valueOf(meaning);
                break;
            case "remotePort":
                this.remotePort = Integer.valueOf(meaning);
                break;
            default:
                break;
        }
    }
    BufferedWriter getDefaultConfig(BufferedWriter writer) {
        try {
            writer.write("ip: 0.0.0.0");
            writer.newLine();
            writer.write("serverPort: 25565");
            writer.newLine();
            writer.write("remotePort: 25566");
            writer.newLine();
            writer.write("token: 7b96d69551b35abe10e9c58498d8b9fc69dfd8fea4b7d5a066c0a5f3c544b51b");
        } catch (Exception ex) {
            System.out.println("Error unable to load default config: " + ex);
        }
        return writer;
    }
    public String getIP() { return this.ip; }
    public String getToken() { return this.token; }
    public int getServerPort() { return this.serverPort; }
    public int getRemotePort() { return this.remotePort; }
}

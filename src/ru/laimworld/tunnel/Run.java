package ru.laimworld.tunnel;

import ru.laimworld.tunnel.Util.Cmd;
import ru.laimworld.tunnel.Util.Config;

public class Run {
    Config config;
    public static void main(String[] args) {
        Run run = new Run();
        run.Start();
    }
    public void Start() {
        (new Thread((Runnable) new Cmd())).start();
        config = new Config("./config.yml");
    }
}

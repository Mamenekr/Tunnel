package ru.laimworld.tunnel;

import com.sun.jdi.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import ru.laimworld.tunnel.Util.Config;

public class Server implements Runnable{
    Config config;
    @Override
    public void run() {
        config = new Config("./config.yml");
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.bind(config.getIP(), config.getServerPort());
        bootstrap.option(ChannelOption.TCP_FASTOPEN_CONNECT, true);
    }
}

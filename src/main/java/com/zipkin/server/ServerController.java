package com.zipkin.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by esha on 25/05/18.
 */

@Controller
public class ServerController {

    //@Value("${spring.application.name}")
    private String appName = "zipkin-server";

    @GetMapping("/rest/v1/servers")
    @ResponseBody
    public String getServerDetail() throws UnknownHostException {
        System.out.println("Request recived to get server detail. ");

        InetAddress localhost = InetAddress.getLocalHost();

        StringBuilder sb = new StringBuilder("Server Information ");
        sb.append("\n")
                .append("Application: ").append(appName).append("\n")
                .append("IP Address: ").append(localhost.getHostAddress()).append("\n")
                .append(", Total Memory: ").append(Runtime.getRuntime().totalMemory() / 1024).append("M").append("\n")
                .append(", Free Memory: ").append(Runtime.getRuntime().freeMemory() / 1024).append("M").append("\n")
                .append(", Total Processor: ").append(Runtime.getRuntime().availableProcessors());

        return sb.toString();
    }
}

package com.example.demo;

import com.google.gson.Gson;
import com.indico.IndicoClient;
import com.indico.IndicoConfig;
import com.indico.IndicoKtorClient;
import com.indico.entity.Submission;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class App {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("config.properties"));

        IndicoConfig config = new IndicoConfig.Builder()
                .host(properties.getProperty("host"))
                .apiToken(properties.getProperty("indicoToken"))
                .build();

        try (IndicoClient client = new IndicoKtorClient(config)) {
            List<Submission> submissions = client.listSubmissions().query();
            for (Submission submission : submissions) {
                System.out.println(new Gson().toJson(submission));
            }
        }
    }
}
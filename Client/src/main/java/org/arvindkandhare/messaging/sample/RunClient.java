package org.arvindkandhare.messaging.sample;

import org.arvindkandhare.messaging.client.producer.MessagingProducer;

import javax.net.ssl.SSLException;

/**
 * Created by kandha on 9/25/16.
 */
public class RunClient {
    public static void main(String[] args) {
        try {
            MessagingProducer producer = new MessagingProducer<Integer,Integer>("localhost",8080);
        } catch (SSLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

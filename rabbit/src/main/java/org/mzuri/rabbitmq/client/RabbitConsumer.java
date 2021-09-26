package org.mzuri.rabbitmq.client;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RabbitConsumer {

    private static Logger logger = LoggerFactory.getLogger(RabbitConsumer.class);

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

//        AMQP.Queue.DeclareOk ok = channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        AMQP.Queue.DeclareOk ok = channel.queueDeclare();

        logger.info("Send queue declare, result {}", ok);

        logger.info(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            AMQP.BasicProperties properties = delivery.getProperties();
            String message = new String(delivery.getBody(), "UTF-8");
            logger.info(" [x] Received '" + message + "'");
            logger.info(properties.toString());
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}

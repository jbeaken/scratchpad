package org.mzuri.rabbitmq.client;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RabbitTopicConsumer {

    private static final String EXCHANGE_NAME = "bookings";

    private static Logger logger = LoggerFactory.getLogger(RabbitTopicConsumer.class);

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("109.109.239.50");
        factory.setUsername("jack");
        factory.setPassword("jack");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic", true);

        String queueName = channel.queueDeclare().getQueue();

        logger.info("QueueName : " + queueName);

        channel.queueBind(queueName, EXCHANGE_NAME, "booking.complete");
        channel.queueBind(queueName, EXCHANGE_NAME, "home.*");



        logger.info(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

            String message = new String(delivery.getBody(), "UTF-8");

            logger.info(" [x] Envelope {}", delivery.getEnvelope());
            logger.info(" [x] Message {}", message);
            logger.info(" [x] Properties {}", delivery.getProperties());
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });

    }
}

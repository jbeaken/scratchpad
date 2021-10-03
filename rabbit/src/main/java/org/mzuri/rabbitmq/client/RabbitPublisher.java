package org.mzuri.rabbitmq.client;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RabbitPublisher {

        private final static String QUEUE_NAME = "hello";

    private static Logger logger = LoggerFactory.getLogger(RabbitPublisher.class);

        public static void main(String[] argv) throws Exception {
            ConnectionFactory factory = new ConnectionFactory();

            factory.setHost("localhost");

            try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
                AMQP.Queue.DeclareOk ok = channel.queueDeclare();
//                AMQP.Queue.DeclareOk ok = channel.queueDeclare(QUEUE_NAME, false, false, false, null);

                logger.debug("Send queue declare, result {}", ok);
                logger.info("Send queue declare, result {}", ok);

                String message = "Hello World!";

                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

                logger.info(" [x] Sent '" + message + "'");
            }
        }
}

package de.larmic.rabbitmq.ampq

import org.slf4j.LoggerFactory
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RabbitReceiver {

    private val log = LoggerFactory.getLogger(this::class.java)

    @RabbitListener(queues = ["\${larmic.amqp.inbound.queue-name}"])
    fun receiveMessage(message: Message) {
        log.info("[RABBIT] Received message $message''")
    }

}
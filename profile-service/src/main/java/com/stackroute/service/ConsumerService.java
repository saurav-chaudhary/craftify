package com.stackroute.service;
import com.stackroute.model.ProjectDto;
import com.stackroute.model.User;
import com.stackroute.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService implements RabbitListenerConfigurer {

    @Autowired
    ProjectRepository projectRepository;
    private static Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(ProjectDto projectDto){
        logger.info("Project is: "+projectDto);
        projectRepository.save(projectDto);
    }


    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}


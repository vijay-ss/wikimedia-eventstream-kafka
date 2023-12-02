package com.mycompany.springboot;

import com.mycompany.springboot.enitity.WikimediaData;
import com.mycompany.springboot.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "wikimedia_event", groupId = "myGroup")
    public void consume(String eventMessage) {

        LOGGER.info("Message received: {}", eventMessage);

        try {
            WikimediaData wikimediaData = new WikimediaData();
            wikimediaData.setWikiEventData(eventMessage);
            dataRepository.save(wikimediaData);
        }
        catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}

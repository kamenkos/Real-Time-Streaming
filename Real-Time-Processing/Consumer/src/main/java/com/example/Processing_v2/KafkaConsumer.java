package com.example.Processing_v2;


import com.example.Processing_v2.entity.WikimediaData;
import com.example.Processing_v2.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
     private WikimediaDataRepository dataRepository;

    public KafkaConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void setDataRepository(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "Wikimedia-recentchange",groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Message received -> %s",eventMessage));


        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        dataRepository.save(wikimediaData);
    }
}

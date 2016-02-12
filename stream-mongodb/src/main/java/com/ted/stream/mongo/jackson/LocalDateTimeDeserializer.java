package com.ted.stream.mongo.jackson;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException, JsonProcessingException {
        ZoneId zoneId = ZoneId.systemDefault(); 
        long epoch = arg0.getLongValue();
        Instant ofEpochSecond = Instant.ofEpochSecond(epoch);
        return LocalDateTime.ofInstant(ofEpochSecond, zoneId);
    }

}

package com.damon.kafka.controller;

import com.damon.kafka.model.Student;
import com.damon.kafka.service.KafkaService;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private static Logger log = Logger.getLogger(KafkaController.class.getClass());
    @Autowired
    private KafkaService kafkaService;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.sss");
    private Random ageRandom = new Random(20L);
    private Random genderRandom = new Random(30L);
    private Random scoreRandom = new Random(50L);

    public KafkaController() {
    }

    @RequestMapping({"kafka"})
    public String SendMessage() {
        String namePre = "DamonTest-";
        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setAge(this.ageRandom.nextInt(20));
        student.setGender(this.genderRandom.nextBoolean() ? "Boy" : "Girl");
        student.setName(namePre + this.dateFormat.format(new Date()));
        student.setScore(this.scoreRandom.nextInt(50) + 50);
        String value = (new Gson()).toJson(student);
        log.info(value);
        this.kafkaService.SendMessage("student", value);
        return value;
    }
}
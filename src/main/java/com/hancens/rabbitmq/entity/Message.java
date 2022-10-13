package com.hancens.rabbitmq.entity;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;


@Data
public class Message implements Serializable {
    private String id;

    private int delay;

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", delay=" + delay +
                '}';
    }
}

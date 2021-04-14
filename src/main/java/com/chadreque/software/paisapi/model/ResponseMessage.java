package com.chadreque.software.paisapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
public class ResponseMessage {

    @Getter
    @Setter
    private Date time;

    @Getter
    @Setter
    private int status;

    @Getter
    @Setter
    private String statusDescription;

    @Getter
    @Setter
    private String message;
}

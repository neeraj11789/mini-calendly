package com.calendly.mini.response;

import com.calendly.mini.utils.ResponseCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = -8102153237286255690L;

    private ResponseCode code;
    private T payload;
}
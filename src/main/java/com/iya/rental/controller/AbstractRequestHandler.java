package com.iya.rental.controller;

import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import com.iya.rental.dto.result.ResultVO;


public abstract class AbstractRequestHandler {

    private static final Logger log = LoggerFactory.getLogger(AbstractRequestHandler.class);

    public ResponseEntity<ResultVO> getResult() {
        ResponseEntity<ResultVO> response = null;
        ResultVO result = new ResultVO();
        String msg = processMessage();
        HttpStatus status = processStatus();
        try {

            Object obj = processRequest();
            if (obj != null) {
                result.setStatus(status.value());
                result.setMessage(msg);
                result.setResults(obj);
                response = ResponseEntity.status(status).body(result);
            }else {
                result.setStatus(status.value());
                result.setMessage(msg);
                result.setResults(null);
                response = ResponseEntity.status(status).body(result);
            }
        } catch (Exception e) {
//            result.setStatus(e.getStatus().value());
            result.setMessage(msg);
            result.setResults(e.getMessage());

            log.error("ERROR", e);
        }
        return response;
    }


    public abstract Object processRequest();
    public abstract String processMessage();
    public abstract HttpStatus processStatus();
}
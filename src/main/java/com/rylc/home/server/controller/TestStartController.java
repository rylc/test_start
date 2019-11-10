package com.rylc.home.server.controller;

import com.alibaba.fastjson.JSON;
import com.rylc.home.server.dto.TestStartRequestDTO;
import com.rylc.home.server.dto.TestStartResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/realData")
public class TestStartController {
    private static final int UNKNOWN_ERR_RET_CODE = -1;
    private static final int SUCCESS_RET_CODE = 0;
    private static final int BLANK_FIELD_RET_CODE = 1;
    private static final int MALFORMED_TIME_RET_CODE = 2;

    @Autowired
    ValidatorFactory validatorFactory;

    @RequestMapping(value = "start", method = {RequestMethod.POST})
    public String start(@RequestBody TestStartRequestDTO request) {
        try {
            Set<ConstraintViolation<TestStartRequestDTO>> validateSet = validatorFactory.getValidator().validate(request);
            if (! CollectionUtils.isEmpty(validateSet)) {
                return JSON.toJSONString(new TestStartResponseDTO(BLANK_FIELD_RET_CODE,
                        "has blank field: " + validateSet.stream().map(c -> c.getPropertyPath() + "->" + c.getMessage()).collect(Collectors.toList())
                        , new Random().nextInt()));
            }

            try {
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(request.getTime());
            } catch (Exception e) {
                return JSON.toJSONString(new TestStartResponseDTO(MALFORMED_TIME_RET_CODE, "malformed time format", new Random().nextInt()));
            }

            return JSON.toJSONString(new TestStartResponseDTO(SUCCESS_RET_CODE, "success", new Random().nextInt()));
        } catch (Exception e) {
            return JSON.toJSONString(new TestStartResponseDTO(UNKNOWN_ERR_RET_CODE, e.getMessage(), new Random().nextInt()));
        }
    }
}

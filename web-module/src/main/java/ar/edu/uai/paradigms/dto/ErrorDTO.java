package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jloscalzo on 30/07/16.
 */
public class ErrorDTO implements DTO<Integer> {
    @Override
    @JsonIgnore
    public Integer getId() {
        return null;
    }

    @JsonProperty("messageErrors")
    public List<String> messageErrors;

    public ErrorDTO() {
        messageErrors = new ArrayList();
    }
}

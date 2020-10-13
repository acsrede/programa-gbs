package com.gbs.crud.domain.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsePrograma {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome;

}

package org.satwik.quizapp.Model;

import lombok.Data;

@Data
public class Response
{
    private Integer id;
    private String response;

    public Response(Integer id, String response) {
        this.id = id;
        this.response = response;
    }
}

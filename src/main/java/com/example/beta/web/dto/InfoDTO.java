package com.example.beta.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

public class InfoDTO {

    private interface id {
        int getId();
    }

    private interface value{
        int getValue();
    }

    private interface raining {
        Boolean getRaining();
    }

    //DTO info
    public enum Request{;
        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        public static class Home implements id, value, raining {
            int id;
            int value;
            Boolean raining;
        }
    }

}

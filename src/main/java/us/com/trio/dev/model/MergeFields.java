package us.com.trio.dev.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MergeFields {
   @JsonProperty("FNAME")
   private String fname;
   @JsonProperty("LNAME")
   private String lname;
}

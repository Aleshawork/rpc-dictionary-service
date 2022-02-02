package com.example.orm.dto;


import java.util.ArrayList;
import java.util.List;

public class DtoFields {
   private List<DtoField> fields = new ArrayList<>();



   public List<DtoField> getFields() {
      return fields;
   }

   public void setFields(List<DtoField> fields) {
      this.fields = fields;
   }


}

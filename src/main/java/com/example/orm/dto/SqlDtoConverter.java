package com.example.orm.dto;

import org.hibernate.jpa.spi.TupleBuilderTransformer;

import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class SqlDtoConverter {

    public static DtoFields toDto(Tuple tuple, List<String> alias){
        DtoFields fields = new DtoFields();
        fields.setFields(
                tuple.getElements().stream()
                        .map(tupleElement -> convert(tuple,tupleElement))
                        .collect(Collectors.toList())
        );
        List<DtoField> collect = fields.getFields().stream()
                .map(el -> {
                    int position = fields.getFields().indexOf(el);
                    el.setAlias(alias.get(position));
                    return el;
                })
                .collect(Collectors.toList());
        fields.setFields(collect);


        return fields;
    }

    public static DtoField convert(Tuple tuple,TupleElement tupleElement){
        TupleBuilderTransformer.HqlTupleElementImpl hqlTupleElement = (TupleBuilderTransformer.HqlTupleElementImpl) tupleElement;
        return new DtoField(null,tuple.get(tupleElement));
    }
}

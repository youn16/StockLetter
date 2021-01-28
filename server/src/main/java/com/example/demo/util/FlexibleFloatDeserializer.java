package com.example.demo.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

// String 형태를 Float으로 replace하는 Deserializer

public class FlexibleFloatDeserializer extends JsonDeserializer<Float>{
	   @Override
	    public Float deserialize(JsonParser parser, DeserializationContext context)
	            throws IOException {
	        String floatString = parser.getText();
	        if (floatString.contains(",")) {
	            floatString = floatString.replace(",", "");
	        }
	        return Float.valueOf(floatString);
	    }
}

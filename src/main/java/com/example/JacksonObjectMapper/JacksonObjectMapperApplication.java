package com.example.JacksonObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JacksonObjectMapperApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(JacksonObjectMapperApplication.class, args);

        //Java Object to JASON
		ObjectMapper objectMapper = new ObjectMapper();
		Car car = new Car("Renault","Black");
		objectMapper.writeValue(new File("target/car.json"),car);
		String carJasonReturnValue= objectMapper.writeValueAsString(car);
		System.out.println("return value in json " +carJasonReturnValue);

		String carAsString = objectMapper.writeValueAsString(car);
		System.out.println(carAsString);

		//JASON to Java Object

		String json="{ \"type\" : \"BMW\", \"colour\" : \"Black\" }";
		Car car1 = objectMapper.readValue(json, Car.class);
		System.out.println("return value in String "+car1);

		// Read json file value from target file path
		Car car2 = objectMapper.readValue(new File("target/car.json"), Car.class);
		System.out.println("read value from json file in target" + car2);

        //JSON to Jackson JsonNode

		JsonNode jsonNode = objectMapper.readTree(json);
		String colour= jsonNode.get("colour").asText(json);
		System.out.println("Colour from String json is : "+ colour);

		String json1="{ \"type\" : \"Audi\", \"colour\" : \"White\" }";
		JsonNode jsonNode1 =objectMapper.readTree(json1);
		String result= jsonNode1.get("type").asText();
		System.out.println("Type from String json1 is: "+ result);

		//Creating a Java List From a JSON Array String
		String jsonCarArray =  "[{ \"colour\" : \"Black\", \"type\" : \"BMW\" }, { \"colour\" : \"Red\", \"type\" : \"FIAT\" }]";
		List<Car> carArrayList = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>() {});
		System.out.println("json car array list:" +carArrayList);

		String jsonCarArray2 = "[{ \"colour\" : \"yellow\", \"type\" : \"sedan\" }, { \"colour\" : \"orange\", \"type\" : \"hatchback\" }]";
        List<Car> carList = objectMapper.readValue(jsonCarArray2, new
				TypeReference<List<Car>>() {});
		System.out.println("json car array list2 :" + carList);


		//Creating Java Map From JSON String
		String json3="{ \"type\" : \"Maruti\", \"colour\" : \"mettalic\" }";
		Map<String,Object> map =objectMapper.readValue(json3, new TypeReference<Map<String, Object>>() {
		});
		System.out.println("Json3 car map "+ map);
	}

}

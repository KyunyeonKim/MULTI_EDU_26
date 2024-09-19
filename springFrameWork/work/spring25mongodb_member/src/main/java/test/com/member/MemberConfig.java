package test.com.member;

import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class MemberConfig {

	@Bean
	public MongoDatabase mogoDatabase() {
		log.info("Create Bean MongoDatabase....");
		MongoClient client = new MongoClient("localhost",27017);
		
		return client.getDatabase("multi");
	}
	
	@Bean
	public MongoCollection<Document> member(){
		log.info("Create Bean member....");
		
		return mogoDatabase().getCollection("member");
	}
	
}

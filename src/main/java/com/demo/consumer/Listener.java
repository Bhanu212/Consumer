package com.demo.consumer;




import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.demo.service.AppService;





public class Listener {

	@Autowired
	AppService appService;

	@KafkaListener(id = "id1", topics = "userInfo")
	public void listenPartition1(ConsumerRecord<?, ?> record) throws JSONException{
		String msgData=record.value().toString();
		appService.saveUserInfo(new JSONObject(msgData));
		System.out.println("userInfo data="+msgData);
	}
	@KafkaListener(id = "id2", topics = "email")
	public void listenPartition2(ConsumerRecord<?, ?> record) throws JSONException {
		String msgData=record.value().toString();
		appService.saveEmail(new JSONObject(msgData));
		System.out.println("email data="+msgData);
	}


	



}

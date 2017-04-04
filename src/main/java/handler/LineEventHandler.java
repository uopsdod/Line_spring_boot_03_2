package handler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import util.Util;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;


@LineMessageHandler
public class LineEventHandler{
	
    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        System.out.println("event: " + event);
        Util.getFileLogger().info("handleTextMessageEvent() called - event: " + event);
        return new TextMessage(event.getMessage().getText());
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
        Util.getFileLogger().info("handleDefaultMessageEvent() called - event: " + event);
    }
    
//    reference: http://kikutaro777.hatenablog.com/entry/2017/01/16/230122
//    @EventMapping
//    public Message handleStickerMessage(MessageEvent<StickerMessageContent> event) {
//        return new TextMessage("�K�Ϥw�ǰe");
//    }
//        
//    @EventMapping
//    public Message handleImageMessage(MessageEvent<ImageMessageContent> event) {
//        return new TextMessage("�Ϥ��w�ǰe");
//    }
//        
//    @EventMapping
//    public Message handleVideoMessage(MessageEvent<VideoMessageContent> event) {
//        return new TextMessage("�v���w�ǰe");
//    }
//        
//    @EventMapping
//    public Message handleAudioMessage(MessageEvent<AudioMessageContent> event) {
//        return new TextMessage("���ɤw�ǰe");
//    }
//
//    @EventMapping
//    public Message handleFollowEvent(FollowEvent event) {
//        return new TextMessage("�w�l�ܥ��s��");
//    }    
    
}
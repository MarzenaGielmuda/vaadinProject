package com.example.vaadin.demo;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.web.client.RestTemplate;

import java.nio.Buffer;

@SpringUI
public class ExampleVaadinUI extends UI {

    public VerticalLayout rootLayout;

    public ExampleVaadinUI(){
        rootLayout = new VerticalLayout();
        setContent(rootLayout);
    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TextField tf = new TextField("Enter Your name");
        Button button = new Button("Action");

        button.addClickListener(x -> Notification.show((tf.getValue())));
        rootLayout.addComponents(tf, button);
        Button button2= new Button("Call rest service", event -> callRestService());

        rootLayout.addComponents(button2);
        setContent(rootLayout);

    }


    private void callRestService(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:9092/rest", String.class);
        Notification.show(result);
    }
}

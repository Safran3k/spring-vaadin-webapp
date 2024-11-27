package com.example.vaadinwebapp.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@Route("")
public class LoginView extends VerticalLayout {
    public LoginView() {
        TextField username = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        Button loginButton = new Button("Login");

        Div message = new Div();

        loginButton.addClickListener(event -> {
            if ("user".equals(username.getValue()) && "password".equals(password.getValue())) {
                message.setText("Login successful!");
            } else {
                message.setText("Invalid credentials!");
            }
        });

        add(username, password, loginButton, message);
    }
}

package com.example.vaadinwebapp.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class LoginView extends VerticalLayout {
    public LoginView() {
        TextField username = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        Button loginButton = new Button("Login");

        Div message = new Div();

        loginButton.addClickListener(event -> {
            if ("user".equals(username.getValue()) && "password".equals(password.getValue())) {
                UI.getCurrent().getSession().setAttribute("username", username.getValue());
                getUI().ifPresent(ui -> ui.navigate("welcome"));
            } else {
                message.setText("Invalid credentials!");
            }
        });

        add(username, password, loginButton, message);
    }
}

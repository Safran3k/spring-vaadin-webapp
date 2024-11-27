package com.example.vaadinwebapp.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("welcome")
public class WelcomeView extends VerticalLayout {

    public WelcomeView() {
        String username = (String) UI.getCurrent().getSession().getAttribute("username");

        Div welcomeMessage = new Div();
        welcomeMessage.setText("Welcome, " + (username != null ? username : "Guest") + "!");

        Button logoutButton = new Button("Logout", event -> {
            UI.getCurrent().getSession().setAttribute("username", null);
            getUI().ifPresent(ui -> ui.navigate(""));
        });

        add(welcomeMessage, logoutButton);
    }
}

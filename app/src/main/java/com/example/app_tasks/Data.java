package com.example.app_tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import kotlin.jvm.internal.markers.KMutableList;

public class Data {
    public static List<Tach> listTach = new ArrayList<>(
            List.of(
                    new Tach("football","jouer un match de foot avec mais amies dans le grand terrin de marackech ",Etat.Urgent,"25-10"),
                    new Tach("codage","jouer un match de foot avec mais amies dans le grand terrin de marackech ",Etat.EnCours,"25-10"),
                    new Tach("liveCoding","jouer un match de foot avec mais amies dans le grand terrin de marackech ",Etat.simple,"25-10"),
                    new Tach("vouyage","jouer un match de foot avec mais amies dans le grand terrin de marackech ",Etat.Moyenne,"25-10"),
                    new Tach("golf","jouer un match de foot avec mais amies dans le grand terrin de marackech ",Etat.Urgent,"25-10"),
                    new Tach("tenis","jouer un match de foot avec mais amies dans le grand terrin de marackech ",Etat.Moyenne,"25-10"),
                    new Tach("atenis","jouer un match de foot avec mais amies dans le grand terrin de marackech ",Etat.simple,"25-10")
            )
    );


}

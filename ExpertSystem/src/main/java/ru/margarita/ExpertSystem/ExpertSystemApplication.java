package ru.margarita.ExpertSystem;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpertSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpertSystemApplication.class, args);
	}

	// в табличке "карма" enum сохранены как тип данных text, это правильно?
	// private Karma.Operation operation; - в KarmaDTO - это правильно?


	//где нужно писать метод, который парсит телефон (номер телефона, который мы получаем в Person)? в сервисе?
	//  - (util - static class)
	// допустим, нам нужно найти все сообщения у одного человека, где должен быть метод?
	// В MessageService?
	// создать еще роли для людей - пользователь, (автор темы), division_admin, super_admin
	// как в топиках сделать иерархию



}

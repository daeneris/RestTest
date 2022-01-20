package ru.margarita.ExpertSystem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.margarita.ExpertSystem.domain.Topic;
import ru.margarita.ExpertSystem.repository.TopicRepo;
import java.util.Optional;


@Service
@AllArgsConstructor
public class TopicService {
    private final TopicRepo topicRepo;

    public Topic create(Topic topic) {
        return topicRepo.save(topic);
        }

    public Topic getById(int id) {
        return topicRepo.findById((long)id).get();
    }

    public Iterable<Topic> getAll(){
        return topicRepo.findAll();
    }

    // здесь нужно что-то возвращать??
    public void update (@org.jetbrains.annotations.NotNull Topic topic) {
        Topic topicToUpdate = topicRepo.findById((long) topic.getId()).get();
        topicRepo.save(topicToUpdate);
    }

    public void delete (Topic topic) {
        topicRepo.delete(topic);
    }


    // Division - если создавать/обновлять может только "главный админ", то нужно ли делать метод создать?
    // как хранить сообщения у людей? как их связывать с сущностью message?
    // создать еще роль для человека - пользователь, division_admin, super_admin

    // как в топиках сделать иерархию - reddit
    // сущности людей - роль
    // many-to-many топики-роли пользователей. id, user id, topic id, role/status

}

package com.example.orm.service.impl;

import com.example.orm.JpaRepository;
import com.example.orm.model.Message;
import com.example.orm.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {


    private final JpaRepository repository;

    public MessageServiceImpl(JpaRepository repository) {
        this.repository = repository;
    }


    @Override
    public void saveMassage(String text) {
        Message message = new Message();
        message.setText(text);
        message.setDate(Calendar.getInstance().getTime());
        repository.save(message);
    }

    public List<Message> findAll(){
       return  repository.executeRequest(r-> (r.createQuery("select m from Message m",Message.class).getResultList()));
    }

    @Override
    public List<Message> findAllByDate(String date) {
        return null;
    }

    @Override
    public List<Message> findByText(String text) {
        return null;
    }

    @Override
    public List<Message> findAllByUserName(String name) {
        return repository.executeRequest(r->
                (r.createQuery("select m from Message m where m.user.name=:name",Message.class)
                  .setParameter("name",name)
                  .getResultList()

        ));
    }
}

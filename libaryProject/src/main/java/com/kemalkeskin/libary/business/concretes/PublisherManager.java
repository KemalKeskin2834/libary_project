package com.kemalkeskin.libary.business.concretes;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.libary.business.abstracts.PublisherService;
import com.kemalkeskin.libary.business.Dtos.request.PublisherRequest;
import com.kemalkeskin.libary.business.Dtos.response.PublisherResponse;
import com.kemalkeskin.libary.business.mapper.PublisherMapper;
import com.kemalkeskin.libary.business.rules.PublisherBusinessRules;
import com.kemalkeskin.libary.repository.PublisherRepository;
import com.kemalkeskin.libary.entity.Publisher;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class PublisherManager implements PublisherService {

    private PublisherRepository publisherRepository;

    private PublisherBusinessRules publisherBusinessRules;

    @Override
    public List<PublisherResponse> listPublisher() {

        return publisherRepository.findAll().stream().map(PublisherMapper::toListPublisherResponse).collect(Collectors.toList());

    }

    @Override
    public PublisherResponse getById(int id) {
        this.publisherBusinessRules.avaliableId(id);
        return publisherRepository.findById(id).map(PublisherMapper::toPublisherResponse).get();
    }




    @Override
    public void add(PublisherRequest publisherRequest) {
        this.publisherBusinessRules.repeatPublisherName(publisherRequest.getName());
        Publisher publisher=new Publisher();
        publisher.setName(publisherRequest.getName());
        publisherRepository.save(publisher);

    }

    @Override
    public void update(int id, PublisherRequest publisherRequest) {
        this.publisherBusinessRules.avaliableId(id);
        this.publisherBusinessRules.repeatPublisherName(publisherRequest.getName());
        Optional<Publisher>optional=publisherRepository.findById(id);

        Publisher publisher=optional.get();
        publisher.setName(publisherRequest.getName());
        publisherRepository.save(publisher);



    }

    @Override
    public void delete(int id) {
        this.publisherBusinessRules.avaliableId(id);
        this.publisherRepository.deleteById(id);

    }

    @Override
    public Publisher giveMeId(int id) {

        this.publisherBusinessRules.avaliableId(id);
        return  publisherRepository.findById(id).orElse(null);
    }
}

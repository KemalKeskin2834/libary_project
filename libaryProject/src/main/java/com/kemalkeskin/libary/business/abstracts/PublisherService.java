package com.kemalkeskin.libary.business.abstracts;

import com.kemalkeskin.libary.business.Dtos.request.PublisherRequest;
import com.kemalkeskin.libary.business.Dtos.response.PublisherResponse;
import com.kemalkeskin.libary.entity.Publisher;

import java.util.List;

public interface PublisherService {

    List<PublisherResponse> listPublisher();

    PublisherResponse getById(int id);

    void add(PublisherRequest publisherRequest);

    void update(int id, PublisherRequest publisherRequest);

    void delete(int id);

    Publisher giveMeId(int id);
}

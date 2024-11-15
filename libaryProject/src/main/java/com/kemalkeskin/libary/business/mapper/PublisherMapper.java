package com.kemalkeskin.libary.business.mapper;

import com.kemalkeskin.libary.business.Dtos.response.PublisherResponse;
import com.kemalkeskin.libary.entity.Publisher;

public class PublisherMapper {

    public static PublisherResponse toListPublisherResponse(Publisher publisher) {
        PublisherResponse publisherResponse=new  PublisherResponse();
        publisherResponse.setId(publisher.getId());
        publisherResponse.setName(publisher.getName());
        return publisherResponse;
    }

    public static PublisherResponse toPublisherResponse(Publisher publisher) {
        PublisherResponse publisherResponse=new  PublisherResponse();
        publisherResponse.setId(publisher.getId());
        publisherResponse.setName(publisher.getName());
        return publisherResponse;
    }
}

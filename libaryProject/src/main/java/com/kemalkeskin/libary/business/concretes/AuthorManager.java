package com.kemalkeskin.libary.business.concretes;
import com.kemalkeskin.libary.business.Dtos.request.AuthorRequest;
import com.kemalkeskin.libary.business.Dtos.response.AuthorResponse;
import com.kemalkeskin.libary.business.abstracts.AuthorService;
import com.kemalkeskin.libary.business.mapper.AuthorMapper;
import com.kemalkeskin.libary.business.rules.AuthorBusinessRules;
import com.kemalkeskin.libary.entity.Author;
import com.kemalkeskin.libary.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorManager implements AuthorService {

    private AuthorRepository authorRepository;

    private AuthorBusinessRules authorBusinessRules;

    @Override
    public List<AuthorResponse> listAuthors() {

        return authorRepository.findAll().stream().map(AuthorMapper::toAuthorListResponse).collect(Collectors.toList());
    }

    @Override
    public AuthorResponse getById(int id) {

        this.authorBusinessRules.avaliableId(id);
        return authorRepository.findById(id).map(AuthorMapper::toAuthorResponse).get();

    }

    @Override
    public void add(AuthorRequest createAuthorRequest) {

        this.authorBusinessRules.repeatAuthorName(createAuthorRequest.getName());
        Author author=new Author();
        author.setName(createAuthorRequest.getName());
        this.authorRepository.save(author);

    }

    @Override
    public void update(int id,AuthorRequest updateAuthorRequest) {


        this.authorBusinessRules.avaliableId(id);
        this.authorBusinessRules.repeatAuthorName(updateAuthorRequest.getName());
        Optional<Author> author=authorRepository.findById(id);
        Author authorUpdate=author.get();
        authorUpdate.setName(updateAuthorRequest.getName());
        AuthorMapper.toAuthorResponse(authorRepository.save(authorUpdate));


    }

    @Override
    public void delete(int id) {
        this.authorBusinessRules.avaliableId(id);
        this.authorRepository.deleteById(id);

    }

    @Override
    public Author giveMeId(int id) {
        this.authorBusinessRules.avaliableId(id);
        return authorRepository.findById(id).orElse(null);
    }
}

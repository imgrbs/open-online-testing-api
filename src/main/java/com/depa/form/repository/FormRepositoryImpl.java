package com.depa.form.repository;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.form.Form;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FormRepositoryImpl implements FormRepository {
    public static final String COLLECTION_NAME = "forms";

    @Autowired
    @Setter(AccessLevel.PROTECTED)
    private MongoTemplate mongoTemplate;

    @Override
    public <S extends Form> S save(S s) {
        return null;
    }

    @Override
    public <S extends Form> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Form> findById(String id) {
        FormDTO formDTO = mongoTemplate.findById(id, FormDTO.class, "forms");
        Form form = new Form(formDTO);
        return Optional.of(form);
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Form> findAll() {
        List<FormDTO> formDTOList = mongoTemplate.findAll(FormDTO.class, COLLECTION_NAME);
        List<Form> forms = new ArrayList<>();
        formDTOList.forEach(formDTO -> forms.add(new Form(formDTO)));
        return forms;
    }

    @Override
    public Iterable<Form> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Form form) {

    }

    @Override
    public void deleteAll(Iterable<? extends Form> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Form> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Form> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Form> S insert(S s) {
        return null;
    }

    @Override
    public <S extends Form> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends Form> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Form> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Form> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Form> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Form> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Form> boolean exists(Example<S> example) {
        return false;
    }
}

package com.depa.form.repository;

import com.depa.form.dto.ExamDTO;
import com.depa.form.model.exam.Exam;
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
public class ExamRepositoryImpl implements ExamRepository {
    public static final String COLLECTION_NAME = "forms";

    @Autowired
    @Setter(AccessLevel.PROTECTED)
    private MongoTemplate mongoTemplate;

    @Override
    public <S extends Exam> S save(S s) {
        return mongoTemplate.save(s);
    }

    @Override
    public <S extends Exam> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Exam> findById(String id) {
        ExamDTO examDTO = mongoTemplate.findById(id, ExamDTO.class, COLLECTION_NAME);
        Exam exam = new Exam(examDTO);
        return Optional.of(exam);
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Exam> findAll() {
        List<ExamDTO> examDTOList = mongoTemplate.findAll(ExamDTO.class, COLLECTION_NAME);
        List<Exam> exams = new ArrayList<>();
        examDTOList.forEach(formDTO -> exams.add(new Exam(formDTO)));
        return exams;
    }

    @Override
    public Iterable<Exam> findAllById(Iterable<String> iterable) {
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
    public void delete(Exam exam) {

    }

    @Override
    public void deleteAll(Iterable<? extends Exam> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Exam> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Exam> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Exam> S insert(S s) {
        return null;
    }

    @Override
    public <S extends Exam> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends Exam> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Exam> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Exam> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Exam> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Exam> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Exam> boolean exists(Example<S> example) {
        return false;
    }
}

package ru.itis.springapp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import ru.itis.springapp.models.Song;

import java.util.List;
import java.util.Optional;

@Component
public class SongRepositoryImpl implements SongRepository {

    private RowMapper<Song> songRowMapper = (row, rowNumber) -> Song.builder()
            .id(row.getLong("id"))
            .name(row.getString("name"))
            .url(row.getString("url"))
            .build();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Song> findAllByPrefix(String prefix) {
        final String SQL_FIND_WITH_SUBSTRING = "select * from song where lower(name) like '%' || lower(?) || '%'";
        return jdbcTemplate.query(SQL_FIND_WITH_SUBSTRING, songRowMapper, prefix);
    }

    public List<Song> findAll() {
        return null;
    }

    public List<Song> findAll(Sort sort) {
        return null;
    }

    public Page<Song> findAll(Pageable pageable) {
        return null;
    }

    public List<Song> findAllById(Iterable<Long> iterable) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(Long aLong) {

    }

    public void delete(Song song) {

    }

    public void deleteAll(Iterable<? extends Song> iterable) {

    }

    public void deleteAll() {

    }

    public <S extends Song> S save(S s) {
        return null;
    }

    public <S extends Song> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    public Optional<Song> findById(Long aLong) {
        return Optional.empty();
    }

    public boolean existsById(Long aLong) {
        return false;
    }

    public void flush() {

    }

    public <S extends Song> S saveAndFlush(S s) {
        return null;
    }

    public void deleteInBatch(Iterable<Song> iterable) {

    }

    public void deleteAllInBatch() {

    }

    public Song getOne(Long aLong) {
        return null;
    }

    public <S extends Song> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    public <S extends Song> List<S> findAll(Example<S> example) {
        return null;
    }

    public <S extends Song> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    public <S extends Song> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    public <S extends Song> long count(Example<S> example) {
        return 0;
    }

    public <S extends Song> boolean exists(Example<S> example) {
        return false;
    }
}

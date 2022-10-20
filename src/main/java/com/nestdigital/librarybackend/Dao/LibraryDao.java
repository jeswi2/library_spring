package com.nestdigital.librarybackend.Dao;

import com.nestdigital.librarybackend.Model.LibraryModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibraryDao extends CrudRepository<LibraryModel,Integer> {
    @Modifying
    @Query(value = "DELETE FROM `libraries` WHERE `id`=:id",nativeQuery = true)
    void deleteBookById(Integer id);

    @Query(value = "SELECT `id`, `authorname`, `bookname`, `booktype`, `issuedate` FROM `libraries` WHERE `bookname` = :bookname",nativeQuery = true)
    List<LibraryModel> searchlibrary(String bookname);

}

